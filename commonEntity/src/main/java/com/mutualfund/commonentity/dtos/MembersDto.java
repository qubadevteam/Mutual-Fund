package com.mutualfund.commonentity.dtos;

import com.mutualfund.commonentity.entities.Members;
import com.mutualfund.commonentity.entities.Society;
import com.mutualfund.commonentity.entities.Users;
import com.mutualfund.commonentity.enums.Status;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MembersDto implements Serializable {

    private Long memberId;

    private Long userId;
    private String userName; // optional for API responses

    private Long societyId;
    private String societyName; // optional for API responses

    private Integer receivedAmount;
    private Integer totalPaidAmount;
    private LocalDateTime joinedAt;

    private Status status;

    // Convert DTO to Entity
    public static Members toEntity(MembersDto dto, Users users, Society society) {
        return Members.builder()
                .memberId(dto.getMemberId())
                .user(users)
                .society(society)
                .receivedAmount(dto.getReceivedAmount())
                .totalPaidAmount(dto.getTotalPaidAmount())
                .joinedAt(dto.getJoinedAt())
                .status(Status.ACTIVE)
                .build();
    }

    // Convert Entity to DTO
    public static MembersDto toDto(Members members) {
        return MembersDto.builder()
                .memberId(members.getMemberId())
                .userId(members.getUser().getUserId())
                .userName(members.getUser().getFullName())
                .societyId(members.getSociety().getSocietyId())
                .societyName(members.getSociety().getSocietyName())
                .receivedAmount(members.getReceivedAmount())
                .totalPaidAmount(members.getTotalPaidAmount())
                .joinedAt(members.getJoinedAt())
                .status(members.getStatus())
                .build();
    }
}
