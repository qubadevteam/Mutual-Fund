package com.mutualfund.commonentity.entities;

import com.mutualfund.commonentity.abstracts.BaseEntity;
import com.mutualfund.commonentity.enums.Status;
import com.mutualfund.commonentity.enums.TenderStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tenders extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "tenderId")
    private Long tenderId;

    private Integer amount;

    @Enumerated(EnumType.STRING)
    private TenderStatus tenderStatus;

    @ManyToOne
    @JoinColumn(name = "memberId", nullable = false)
    private Members member;

    @ManyToOne
    @JoinColumn(name = "societyId", nullable = false)
    private Society society;
}
