package com.nubeero.eclat.dto;

import lombok.Data;

@Data
public class SignUpCompanyDto {


    private String fullName;
    private String companyName;
    private String companyEmailAddress;
    private String phoneNumber;
    private String password;
}
