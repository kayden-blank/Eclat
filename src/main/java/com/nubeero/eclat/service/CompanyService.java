package com.nubeero.eclat.service;


import com.nubeero.eclat.dto.CompanyLoginDto;
import com.nubeero.eclat.dto.LoginDto;
import com.nubeero.eclat.dto.SignUpCompanyDto;
import com.nubeero.eclat.exception.EclatException;
import com.nubeero.eclat.model.company.Company;
import com.nubeero.eclat.model.eclatUser.EclatUser;
import com.nubeero.eclat.response.ResponseBodyObject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service


public interface CompanyService {

    ResponseBodyObject createUser(SignUpCompanyDto signUpCompanyDto) throws EclatException;

    List<Company> findAll() throws EclatException;

    Company findById (Long id) throws EclatException;

    boolean findByEmail(String userEmail) throws EclatException;

    Company login(CompanyLoginDto companyLoginDto) throws EclatException;
}
