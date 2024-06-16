package com.project.DASBackend.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Booking_Sample")
@Data
@Builder
public class BookingSample {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Sample_Id")
    private Integer sampleId;

    @Column(name = "Status", nullable = false)
    private Integer status;

    @Column(name = "IsDiamond", nullable = false)
    private Integer isDiamond;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Size", nullable = false)
    private Float size;

    @Column(name = "Price", nullable = false)
    private Float price;

    @ManyToOne
    @JoinColumn(name = "Diamond_Id", nullable = false)
    private AssessmentPaper assessmentPaper;

    @ManyToOne
    @JoinColumn(name = "Booking_Id", nullable = false)
    private AssessmentBooking assessmentBooking;

    @ManyToOne
    @JoinColumn(name = "Account_Id", nullable = false)
    private Account account;

    @ManyToOne
    @JoinColumn(name = "SealId", nullable = false)
    private Seal seal;
}
