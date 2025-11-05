package com.mutualfund.commonrepo.repository;

import com.mutualfund.commonentity.entities.Society;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocietyRepository extends JpaRepository<Society, Long> {


}
