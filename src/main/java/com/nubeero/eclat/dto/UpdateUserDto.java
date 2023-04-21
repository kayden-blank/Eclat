package com.nubeero.eclat.dto;

import com.nubeero.eclat.model.eclatUser.EmploymentHistory;
import com.nubeero.eclat.model.eclatUser.WorkExperience;
import lombok.Data;

@Data
public class UpdateUserDto {
    private Long userId;
    private String country;
    private WorkExperience workExperience;
    private String linkedin;
    private String personalWebsite;
    private String jobDescription;
    private EmploymentHistory employmentHistory;

}
