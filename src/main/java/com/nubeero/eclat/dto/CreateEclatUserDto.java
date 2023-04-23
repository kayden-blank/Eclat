package com.nubeero.eclat.dto;

import lombok.Data;

@Data
public class CreateEclatUserDto {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String englishProficiency;
    private String skill;
    private int yearOfExperience;
    private String password;
}
