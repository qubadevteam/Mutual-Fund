package com.mutualfund.commonrepo.repository;

import com.mutualfund.commonentity.entities.Users;
import com.mutualfund.commonentity.enums.Status;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByUserIdAndStatus(Long userId, Status status);

    Page<Users> findAllByStatus(Status status, Pageable pageable);

    Optional<Users> findByContactNumberAndStatus(String mobile, Status status);

    // Search user by name or contact number (case-insensitive)
    @Query("SELECT u FROM Users u WHERE " +
            "(LOWER(u.fullName) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(u.contactNumber) LIKE LOWER(CONCAT('%', :keyword, '%'))) " +
            "AND u.status = :status")
    Page<Users> searchUsers(@Param("keyword") String keyword,
                            @Param("status") Status status,
                            Pageable pageable);
}
