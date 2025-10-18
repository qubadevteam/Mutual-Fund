package com.mutualfund.commonentity.entities;

import com.mutualfund.commonentity.abstracts.BaseEntity;
import com.mutualfund.commonentity.enums.Status;
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
//    @Column(name = "tender_id")
    private Long tenderId;

    private Integer amount;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Members member;

    @ManyToOne
    @JoinColumn(name = "society_id", nullable = false)
    private Society society;
}
