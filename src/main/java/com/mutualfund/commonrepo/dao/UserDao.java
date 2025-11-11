package com.mutualfund.commonrepo.dao;

import com.mutualfund.commonentity.entities.Users;
import com.mutualfund.commonentity.enums.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public class UserDao {


    private final MasterDao masterDao;

    public UserDao(MasterDao masterDao) {
        this.masterDao = masterDao;
    }

    public Optional<Users> findUserById(Long userId) {
        return masterDao.getUsersRepo().findById(userId);
    }

    public Users saveUser(Users users) {
        return masterDao.getUsersRepo().save(users);
    }

    public Optional<Users> findByIdAndStatus(long userId, Status status) {
        return masterDao.getUsersRepo().findByUserIdAndStatus(userId, status);
    }

    public Page<Users> findAllByStatus(Status status, Pageable pageable){
        return masterDao.getUsersRepo().findAllByStatus(status, pageable);
    }

    public Optional<Users> findByContactNumberAndStatus(String mobile, Status status){
        return masterDao.getUsersRepo().findByContactNumberAndStatus(mobile, status);
    }

    public Page<Users> searchUsers(String keyword, Status status, Pageable pageable) {
        return masterDao.getUsersRepo().searchUsers(keyword, status, pageable);
    }
}
