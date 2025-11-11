package com.mutualfund.userservice.services.serviceinterface;

import com.mutualfund.commonentity.dtos.UsersDto;
import com.mutualfund.commonentity.model.ResponseModel;

public interface UserService {

    ResponseModel getUserById(long userId);
    ResponseModel getAllUsers(int page, int size);
    ResponseModel updateUser(UsersDto usersDto);
    ResponseModel blockUser(long userId);
    ResponseModel searchUser(String keyword, int page, int size);
}
