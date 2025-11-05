package com.mutualfund.commonrepo.repository;

import com.mutualfund.commonentity.entities.Payout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayoutRepository extends JpaRepository<Payout, Long> {

}
