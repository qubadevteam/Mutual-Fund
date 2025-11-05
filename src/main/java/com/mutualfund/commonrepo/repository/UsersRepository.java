package com.mutualfund.commonrepo.repository;

import com.mutualfund.commonentity.entities.Users;
import com.mutualfund.commonentity.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByContactNumberAndStatus(String mobile, Status status);
}
