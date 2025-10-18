package com.mutualfund.commonentity.entities;

import com.mutualfund.commonentity.abstracts.BaseEntity;
import com.mutualfund.commonentity.enums.Status;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Owners extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "owner_id")
    private Long ownerId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @Lob
    private String address;

    @Enumerated(EnumType.STRING)
    private Status status;
}
