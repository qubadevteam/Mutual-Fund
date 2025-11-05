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
//    @Column(name = "winnerId")
    private Long winnerId;

    private LocalDate winDate;

    @Enumerated(EnumType.STRING)
    private WinType winType;

    @ManyToOne
    @JoinColumn(name = "societyId", nullable = false)
    private Society society;

    @ManyToOne
    @JoinColumn(name = "memberId", nullable = false)
    private Members member;
}
