package com.nubeero.eclat.dto;

import com.nubeero.eclat.model.eclatUser.EmploymentHistory;
import com.nubeero.eclat.model.eclatUser.WorkExperience;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UpdateUserDto {
    private Long userId;
    private String country;
    private List<WorkExperience> workExperience;
    private String linkedin;
    private String personalWebsite;
    private String jobDescription;
    private List <EmploymentHistory> employmentHistory;

}
