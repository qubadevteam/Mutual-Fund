package com.mutualfund.commonentity.entities;

import com.mutualfund.commonentity.abstracts.BaseEntity;
import com.mutualfund.commonentity.enums.PaymentStatus;
import com.mutualfund.commonentity.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "paymentId")
    private Long paymentId;

    @ManyToOne
    @JoinColumn(name = "memberId", nullable = false)
    private Members member;

    private LocalDateTime paymentDate;
    private String paymentMonth;
    private String landmark;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
}
