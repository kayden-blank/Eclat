package com.nubeero.eclat.model.company;


import lombok.Data;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data

public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)


    private long id;
    private String fullName;
    private String companyName;
    private String companyEmailAddress;
    private String phoneNumber;
    private String password;




}
