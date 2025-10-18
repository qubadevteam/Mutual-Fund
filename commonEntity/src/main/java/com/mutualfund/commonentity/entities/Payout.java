package com.mutualfund.commonentity.entities;

import com.mutualfund.commonentity.abstracts.BaseEntity;
import com.mutualfund.commonentity.enums.WinType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payout extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "payout_id")
    private Long payoutId;

    private Integer reference1;
    private Integer reference2;
    private Integer paidAmount;

    @Enumerated(EnumType.STRING)
    private WinType winType;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Members member;
}
