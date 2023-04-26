package com.nubeero.eclat.controller;


import com.nubeero.eclat.dto.CreateEclatUserDto;
import com.nubeero.eclat.dto.SignUpCompanyDto;
import com.nubeero.eclat.exception.EclatException;
import com.nubeero.eclat.response.ResponseBodyObject;
import com.nubeero.eclat.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("api/Eclat/company")
public class CompanyController {
    CompanyService companyService;

    @PostMapping("signUp")
    public ResponseEntity<ResponseBodyObject> createUser(@RequestBody SignUpCompanyDto signUpCompanyDto) throws EclatException {
        companyService.createUser(signUpCompanyDto);
        ResponseBodyObject response = companyService.createUser(signUpCompanyDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }



}
