package com.nubeero.eclat.model.eclatUser;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String firstname;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String englishProficiency;
    private String skill;
    private Integer yearOfExperience;
    private String password;
    private String country;
    private WorkExperience workExperience;
    private String linkedin;
    private String personalWebsite;
    private String jobDescription;
    private EmploymentHistory employmentHistory;

}
