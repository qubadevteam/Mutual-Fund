package com.mutualfund.commonrepo.repository;

import com.mutualfund.commonentity.entities.Tenders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TendersRepository extends JpaRepository<Tenders, Long> {

}
