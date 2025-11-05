package com.mutualfund.commonentity.dtos;

import com.mutualfund.commonentity.entities.Users;
import com.mutualfund.commonentity.enums.Status;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsersDto implements Serializable {

    private Long userId;
    private String fullName;
    private String contactNumber;
    private String profileImg;
    private Integer creditScore;
    private Status status;


    public static Users toEntity(UsersDto dto) {
        return Users.builder()
                .fullName(dto.getFullName())
                .contactNumber(dto.getContactNumber())
                .profileImg(dto.getProfileImg())
                .creditScore(dto.getCreditScore())
                .status(Status.ACTIVE)
                .build();

    }

    public static UsersDto toDto(Users users) {
        return UsersDto.builder()
                .userId(users.getUserId())
                .fullName(users.getFullName())
                .contactNumber(users.getContactNumber())
                .profileImg(users.getProfileImg())
                .creditScore(users.getCreditScore())
                .status(users.getStatus())
                .build();
    }

}
