package com.nubeero.eclat.service;


import com.nubeero.eclat.dto.SignUpCompanyDto;
import com.nubeero.eclat.exception.EclatException;
import com.nubeero.eclat.model.company.Company;
import com.nubeero.eclat.repository.CompanyRepository;
import com.nubeero.eclat.response.ResponseBodyObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class CompanyServiceImplementation {
    @Autowired
    CompanyRepository companyRepository;



    public ResponseBodyObject createUser(SignUpCompanyDto signUpCompanyDto) throws EclatException{
        Company company = new Company();
            company.setCompanyName(signUpCompanyDto.getCompanyName());
            company.setPassword(signUpCompanyDto.getPassword());
            company.setCompanyEmailAddress(signUpCompanyDto.getCompanyEmailAddress());
            company.setPhoneNumber(signUpCompanyDto.getPhoneNumber());
            company.setFullName(signUpCompanyDto.getFullName());
            companyRepository.save(company);
            return response();
    }



    private ResponseBodyObject response() throws EclatException {
        ResponseBodyObject responseBodyObject = new ResponseBodyObject();
        responseBodyObject.setTimeStamp(LocalDateTime.now());
        responseBodyObject.setMessage("Eclat user created successfully");
        responseBodyObject.setSuccess(true);
        responseBodyObject.setStatus("success");
        return responseBodyObject;
    }

}
