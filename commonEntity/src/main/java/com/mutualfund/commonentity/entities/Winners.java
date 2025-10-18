package com.mutualfund.commonentity.entities;

import com.mutualfund.commonentity.abstracts.BaseEntity;
import com.mutualfund.commonentity.enums.WinType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Winners extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "winner_id")
    private Long winnerId;

    private LocalDate winDate;

    @Enumerated(EnumType.STRING)
    private WinType winType;

    @ManyToOne
    @JoinColumn(name = "society_id", nullable = false)
    private Society society;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Members member;
}
