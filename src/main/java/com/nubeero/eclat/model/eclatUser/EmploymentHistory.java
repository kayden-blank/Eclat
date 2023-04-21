package com.nubeero.eclat.model.eclatUser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class EmploymentHistory {
    private String role;
    private String industry;
    private String company;
    private String jobType;
    private String startDate;
    private String endDate;
}
