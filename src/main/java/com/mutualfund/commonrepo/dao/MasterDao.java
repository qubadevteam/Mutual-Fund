package com.mutualfund.commonrepo.dao;

import com.mutualfund.commonrepo.repository.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class MasterDao {

    @Autowired
    private SocietyRepository societyRepo;

    @Autowired
    private MemberRepository memberRepo;

    @Autowired
    private UsersRepository usersRepo;

    @Autowired
    private WinnerRepository winnerRepo;

    @Autowired
    private PaymentRepository paymentRepo;

    @Autowired
    private OwnersRepository ownersRepo;

    @Autowired
    private TendersRepository tendersRepo;

    @Autowired
    private PayoutRepository payoutRepo;
}
