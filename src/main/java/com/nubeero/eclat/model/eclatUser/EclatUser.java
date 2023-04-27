package com.nubeero.eclat.model.eclatUser;




import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class EclatUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private WorkExperience workExperience;
    private String linkedin;
    private String personalWebsite;
    private String jobDescription;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private EmploymentHistory employmentHistory;

}

