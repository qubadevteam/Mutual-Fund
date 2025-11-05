package com.mutualfund.commonentity.dtos;

import com.mutualfund.commonentity.entities.Members;
import com.mutualfund.commonentity.entities.Society;
import com.mutualfund.commonentity.entities.Winners;
import com.mutualfund.commonentity.enums.WinType;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WinnersDto implements Serializable {

    private Long winnerId;
    private LocalDate winDate;
    private WinType winType;

    private Long societyId;
    private Long memberId;

    // Optional: include names if needed
    private String societyName;
    private String memberName;

    // Convert DTO to Entity
    public static Winners toEntity(WinnersDto dto, Society society, Members members) {
        return Winners.builder()
                .winDate(dto.getWinDate())
                .winType(dto.getWinType())
                .society(society)
                .member(members)
                .build();
    }

    // Convert Entity to DTO
    public static WinnersDto toDto(Winners winners) {
        return WinnersDto.builder()
                .winnerId(winners.getWinnerId())
                .winDate(winners.getWinDate())
                .winType(winners.getWinType())
                .societyId(winners.getSociety().getSocietyId())
                .societyName(winners.getSociety().getSocietyName())
                .memberId(winners.getMember().getMemberId())
                .memberName(winners.getMember().getUser().getFullName())
                .build();
    }

}
