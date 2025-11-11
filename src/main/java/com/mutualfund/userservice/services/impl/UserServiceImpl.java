package com.mutualfund.userservice.services.impl;

import com.mutualfund.commonentity.dtos.UsersDto;
import com.mutualfund.commonentity.entities.Users;
import com.mutualfund.commonentity.enums.Status;
import com.mutualfund.commonentity.message.ErrorMessage;
import com.mutualfund.commonentity.message.SuccessMessage;
import com.mutualfund.commonentity.model.ResponseModel;
import com.mutualfund.commonrepo.dao.UserDao;
import com.mutualfund.userservice.exception.UserNotFoundException;
import com.mutualfund.userservice.services.serviceinterface.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public ResponseModel getUserById(long userId) {
        Users findUser = userDao.findByIdAndStatus(userId, Status.ACTIVE)
                .orElseThrow(() -> new UserNotFoundException(ErrorMessage.USER_NOT_FOUND));

        return ResponseModel.createResponse(
                 HttpStatus.OK,
                SuccessMessage.USER_FETCHED_SUCCESS,
                UsersDto.toDto(findUser),
                null
        );
    }

    @Override
    public ResponseModel getAllUsers(int page, int size) {

        int zeroBasedPage = (page > 0) ? page - 1 : 0;
        Pageable pageable = PageRequest.of(zeroBasedPage, size);

        Page<Users> findAllUsers = userDao.findAllByStatus(Status.ACTIVE, pageable);

        if (findAllUsers.isEmpty()) {
            throw new UserNotFoundException(ErrorMessage.USER_NOT_FOUND);
        }

        // Convert Entity -> Dto

        List<UsersDto> usersDtos = findAllUsers.getContent()
                .stream()
                .map(UsersDto :: toDto)
                .toList();

        return ResponseModel.paginationResponse(
                 HttpStatus.OK,
                 SuccessMessage.USER_FETCHED_SUCCESS,
                 usersDtos,
                 null,
                 findAllUsers.getTotalElements(),
                 findAllUsers.getNumber() + 1,
                 findAllUsers.getSize(),
                 findAllUsers.getNumberOfElements()
        );
    }

    @Override
    public ResponseModel updateUser(UsersDto usersDto) {

        Users existUser = userDao.findByIdAndStatus(usersDto.getUserId(), Status.ACTIVE)
                .orElseThrow(() -> new UserNotFoundException(ErrorMessage.USER_NOT_FOUND));

        UsersDto.updateUsersDetails(existUser, usersDto);

        // Save updated user
        Users updatedUsers = userDao.saveUser(existUser);

        return ResponseModel.createResponse(
                HttpStatus.OK,
                SuccessMessage.USER_UPDATED_SUCCESS,
                UsersDto.toDto(updatedUsers),
                null
        );
    }

    @Override
    public ResponseModel blockUser(long userId) {

        Users existUser = userDao.findUserById(userId)
                .orElseThrow(() -> new UserNotFoundException(ErrorMessage.USER_NOT_FOUND));

        if (existUser.getStatus() == Status.ACTIVE){
            existUser.setStatus(Status.INACTIVE);

            userDao.saveUser(existUser);
            return ResponseModel.createResponse(
                    HttpStatus.OK,
                    SuccessMessage.USER_BLOCKED_SUCCESS,
                    null,
                    null
            );
        } else {
            existUser.setStatus(Status.ACTIVE);

            userDao.saveUser(existUser);
            return ResponseModel.createResponse(
                    HttpStatus.OK,
                    SuccessMessage.USER_RECOVERED_SUCCESS,
                    null,
                    null
            );
        }

    }

    @Override
    public ResponseModel searchUser(String keyword, int page, int size) {

        int zeroBasedPage = (page > 0) ? page - 1 : 0;
        Pageable pageable = PageRequest.of(zeroBasedPage, size);

        Page<Users> searchUser = userDao.searchUsers(keyword, Status.ACTIVE, pageable);

        List<UsersDto> usersDtos = searchUser.getContent()
                .stream()
                .map(UsersDto::toDto)
                .toList();

        return ResponseModel.paginationResponse(
                HttpStatus.OK,
                SuccessMessage.USER_FETCHED_SUCCESS,
                usersDtos,
                null,
                searchUser.getTotalElements(),
                searchUser.getNumber() + 1,
                searchUser.getSize(),
                searchUser.getNumberOfElements()
        );

    }

}


