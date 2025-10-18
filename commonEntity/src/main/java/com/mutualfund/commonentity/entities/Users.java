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
public class Users extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "user_id")
    private Long userId;

    private String userName;

    private String contactNumber;

    private String profileImg;

    private Integer creditScore;

    @Enumerated(EnumType.STRING)
    private Status status;

    // Relations
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Members> members;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Owners> owners;

}


