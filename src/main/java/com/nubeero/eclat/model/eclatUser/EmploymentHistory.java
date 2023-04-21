package com.nubeero.eclat.model.eclatUser;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
public class EmploymentHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String role;
    private String industry;
    private String company;
    private String jobType;
    private String startDate;
    private String endDate;
}
