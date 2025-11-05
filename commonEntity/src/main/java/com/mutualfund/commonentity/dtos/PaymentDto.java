package com.mutualfund.commonentity.dtos;

import com.mutualfund.commonentity.entities.Members;
import com.mutualfund.commonentity.entities.Payment;
import com.mutualfund.commonentity.enums.PaymentStatus;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDto implements Serializable {

    private Long paymentId;

    private Long memberId;
    private String memberName; // optional, for API responses

    private LocalDateTime paymentDate;
    private String paymentMonth;
    private String landmark;

    private PaymentStatus paymentStatus;

    // Convert DTO to Entity
    public static Payment toEntity(PaymentDto dto, Members members) {
        return Payment.builder()
                .paymentId(dto.getPaymentId())
                .member(members)
                .paymentDate(dto.getPaymentDate())
                .paymentMonth(dto.getPaymentMonth())
                .landmark(dto.getLandmark())
                .paymentStatus(PaymentStatus.PENDING)
                .build();
    }

    // Convert Entity to DTO
    public static PaymentDto toDto(Payment payment) {
        return PaymentDto.builder()
                .paymentId(payment.getPaymentId())
                .memberId(payment.getMember().getMemberId())
                .memberName(payment.getMember().getUser().getFullName())
                .paymentDate(payment.getPaymentDate())
                .paymentMonth(payment.getPaymentMonth())
                .landmark(payment.getLandmark())
                .paymentStatus(payment.getPaymentStatus())
                .build();
    }
}
