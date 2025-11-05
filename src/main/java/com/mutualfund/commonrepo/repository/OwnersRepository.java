package com.mutualfund.commonrepo.repository;

import com.mutualfund.commonentity.entities.Owners;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnersRepository extends JpaRepository<Owners, Long> {

}
