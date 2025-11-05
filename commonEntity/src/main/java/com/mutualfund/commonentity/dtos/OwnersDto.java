package com.mutualfund.commonentity.dtos;

import com.mutualfund.commonentity.entities.Owners;
import com.mutualfund.commonentity.entities.Users;
import com.mutualfund.commonentity.enums.Status;
import lombok.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OwnersDto implements Serializable {

    private Long ownerId;
    private Long userId;
    private String userName;
    private String address;
    private Status status;

    // Convert DTO to Entity
    public static Owners toEntity(OwnersDto dto, Users users) {
        return Owners.builder()
                .user(users)
                .address(dto.getAddress())
                .status(Status.ACTIVE)
                .build();
    }

    // Convert Entity to DTO
    public static OwnersDto toDto(Owners owners) {
        return OwnersDto.builder()
                .ownerId(owners.getOwnerId())
                .userId(owners.getUser().getUserId())
                .userName(owners.getUser().getFullName())
                .address(owners.getAddress())
                .status(owners.getStatus())
                .build();
    }
}
