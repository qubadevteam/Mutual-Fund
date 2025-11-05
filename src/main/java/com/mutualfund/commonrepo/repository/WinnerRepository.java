package com.mutualfund.commonrepo.repository;

import com.mutualfund.commonentity.entities.Winners;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WinnerRepository extends JpaRepository<Winners, Long> {

}
