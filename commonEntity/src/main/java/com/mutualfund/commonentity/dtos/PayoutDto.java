package com.mutualfund.commonentity.dtos;

import com.mutualfund.commonentity.entities.Members;
import com.mutualfund.commonentity.entities.Payout;
import com.mutualfund.commonentity.enums.WinType;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PayoutDto implements Serializable {

    private Long payoutId;
    private Integer reference1;
    private Integer reference2;
    private Integer paidAmount;
    private WinType winType;

    private Long memberId;
    private String memberName; // optional, for API responses

    // Convert DTO to Entity
    public static Payout toEntity(PayoutDto dto, Members members) {
        return Payout.builder()
                .payoutId(dto.getPayoutId())
                .reference1(dto.getReference1())
                .reference2(dto.getReference2())
                .paidAmount(dto.getPaidAmount())
                .winType(dto.getWinType())
                .member(members)
                .build();
    }

    // Convert Entity to DTO
    public static PayoutDto toDto(Payout payout) {
        return PayoutDto.builder()
                .payoutId(payout.getPayoutId())
                .reference1(payout.getReference1())
                .reference2(payout.getReference2())
                .paidAmount(payout.getPaidAmount())
                .winType(payout.getWinType())
                .memberId(payout.getMember().getMemberId())
                .memberName(payout.getMember().getUser().getFullName())
                .build();
    }
}
