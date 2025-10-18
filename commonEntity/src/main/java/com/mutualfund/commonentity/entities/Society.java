package com.mutualfund.commonentity.entities;

import com.mutualfund.commonentity.abstracts.BaseEntity;
import com.mutualfund.commonentity.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Society extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "society_id")
    private Long societyId;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private Owners owner;

    private String name;

    @Lob
    private String address;

    @Lob
    private String description;

    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime drawTime;

    private Integer totalAmount;
    private Integer totalMember;
    private Integer monthlyInstallment;
    private Integer currentMonth;
    private Integer totalMonth;

    @Enumerated(EnumType.STRING)
    private Status status;

    // Relations
    @OneToMany(mappedBy = "society", cascade = CascadeType.ALL)
    private List<Members> members;

    @OneToMany(mappedBy = "society", cascade = CascadeType.ALL)
    private List<Tenders> tenders;

    @OneToMany(mappedBy = "society", cascade = CascadeType.ALL)
    private List<Winners> winners;
}
