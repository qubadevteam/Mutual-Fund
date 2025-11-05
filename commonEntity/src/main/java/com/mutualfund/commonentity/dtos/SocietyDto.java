package com.mutualfund.commonentity.dtos;

import com.mutualfund.commonentity.entities.Owners;
import com.mutualfund.commonentity.entities.Society;
import com.mutualfund.commonentity.enums.SocietyStatus;
import com.mutualfund.commonentity.enums.Status;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SocietyDto implements Serializable {

    private Long societyId;

    private Long ownerId;
    private String ownerName; // optional, for API responses

    private String societyName;
    private String address;
    private String description;

    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime drawTime;

    private Integer totalAmount;
    private Integer totalMember;
    private Integer monthlyInstallment;
    private Integer currentMonth;
    private Integer totalMonth;

    private SocietyStatus societyStatus;

    // Convert DTO to Entity
    public static Society toEntity(SocietyDto dto,Owners owners) {
        return Society.builder()
                .owner(owners)
                .societyName(dto.getSocietyName())
                .address(dto.getAddress())
                .description(dto.getDescription())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .drawTime(dto.getDrawTime())
                .totalAmount(dto.getTotalAmount())
                .totalMember(dto.getTotalMember())
                .monthlyInstallment(dto.getMonthlyInstallment())
                .currentMonth(dto.getCurrentMonth())
                .totalMonth(dto.getTotalMonth())
                .societyStatus(SocietyStatus.CREATED)
                .build();
    }

    // Convert Entity to DTO
    public static SocietyDto toDto(Society society) {
        return SocietyDto.builder()
                .societyId(society.getSocietyId())
                .ownerId(society.getOwner().getOwnerId())
                .ownerName(society.getOwner().getUser().getFullName())
                .societyName(society.getSocietyName())
                .address(society.getAddress())
                .description(society.getDescription())
                .startDate(society.getStartDate())
                .endDate(society.getEndDate())
                .drawTime(society.getDrawTime())
                .totalAmount(society.getTotalAmount())
                .totalMember(society.getTotalMember())
                .monthlyInstallment(society.getMonthlyInstallment())
                .currentMonth(society.getCurrentMonth())
                .totalMonth(society.getTotalMonth())
                .societyStatus(society.getSocietyStatus())
                .build();
    }
}
