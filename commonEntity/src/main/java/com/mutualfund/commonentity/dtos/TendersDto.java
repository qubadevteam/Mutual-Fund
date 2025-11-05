package com.mutualfund.commonentity.dtos;

import com.mutualfund.commonentity.entities.Members;
import com.mutualfund.commonentity.entities.Society;
import com.mutualfund.commonentity.entities.Tenders;
import com.mutualfund.commonentity.enums.Status;
import com.mutualfund.commonentity.enums.TenderStatus;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TendersDto implements Serializable {

    private Long tenderId;
    private Integer amount;
    private TenderStatus tenderStatus;

    private Long memberId;
    private String memberName; // optional for API responses

    private Long societyId;
    private String societyName; // optional for API responses

    // Convert DTO to Entity
    public static Tenders toEntity(TendersDto dto,Members members, Society society) {
        return Tenders.builder()
                .tenderId(dto.getTenderId())
                .amount(dto.getAmount())
                .tenderStatus(TenderStatus.PENDING)
                .member(members)
                .society(society)
                .build();
    }

    // Convert Entity to DTO
    public static TendersDto toDto(Tenders tenders) {
        return TendersDto.builder()
                .tenderId(tenders.getTenderId())
                .amount(tenders.getAmount())
                .tenderStatus(tenders.getTenderStatus())
                .memberId(tenders.getMember().getMemberId())
                .memberName(tenders.getMember().getUser().getFullName())
                .societyId(tenders.getSociety().getSocietyId())
                .societyName(tenders.getSociety().getSocietyName())
                .build();
    }
}
