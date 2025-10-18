package com.mutualfund.commonentity.entities;

import com.mutualfund.commonentity.abstracts.BaseEntity;
import com.mutualfund.commonentity.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Members extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "member_id")
    private Long memberId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "society_id", nullable = false)
    private Society society;

    private Integer receivedAmount;
    private Integer totalPaidAmount;
    private LocalDateTime joinedAt;

    @Enumerated(EnumType.STRING)
    private Status status;

    // Relations
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Payout> payouts;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Payment> payments;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Tenders> tenders;

}
