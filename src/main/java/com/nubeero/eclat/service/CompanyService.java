package com.nubeero.eclat.service;


import com.nubeero.eclat.dto.SignUpCompanyDto;
import com.nubeero.eclat.exception.EclatException;
import com.nubeero.eclat.response.ResponseBodyObject;

public interface CompanyService {

    ResponseBodyObject createUser(SignUpCompanyDto signUpCompanyDto) throws EclatException;
}
