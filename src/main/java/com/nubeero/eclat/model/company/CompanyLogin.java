package com.nubeero.eclat.model.company;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class CompanyLogin {
    private String companyEmailAddress;
    private String password;
}
