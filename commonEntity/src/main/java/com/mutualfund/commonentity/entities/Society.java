package com.mutualfund.commonentity.entities;

import com.mutualfund.commonentity.abstracts.BaseEntity;
import com.mutualfund.commonentity.enums.SocietyStatus;
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
//    @Column(name = "societyId")
    private Long societyId;

    @ManyToOne
    @JoinColumn(name = "ownerId", nullable = false)
    private Owners owner;

    private String societyName;

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
    private SocietyStatus societyStatus;

    // Relations
    @OneToMany(mappedBy = "society", cascade = CascadeType.ALL)
    private List<Members> members;

    @OneToMany(mappedBy = "society", cascade = CascadeType.ALL)
    private List<Tenders> tenders;

    @OneToMany(mappedBy = "society", cascade = CascadeType.ALL)
    private List<Winners> winners;
}
