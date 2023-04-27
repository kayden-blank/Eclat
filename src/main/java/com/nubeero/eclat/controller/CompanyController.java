package com.nubeero.eclat.controller;


import com.nubeero.eclat.dto.CompanyLoginDto;
import com.nubeero.eclat.dto.CreateEclatUserDto;
import com.nubeero.eclat.dto.LoginDto;
import com.nubeero.eclat.dto.SignUpCompanyDto;
import com.nubeero.eclat.exception.EclatException;
import com.nubeero.eclat.model.company.Company;
import com.nubeero.eclat.model.eclatUser.EclatUser;
import com.nubeero.eclat.response.ResponseBodyObject;
import com.nubeero.eclat.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("api/Eclat/company")
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @PostMapping("signUp")
    public ResponseEntity<ResponseBodyObject> createUser(@RequestBody SignUpCompanyDto signUpCompanyDto) throws EclatException {
        companyService.createUser(signUpCompanyDto);
        ResponseBodyObject response = companyService.createUser(signUpCompanyDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody CompanyLoginDto dto) throws EclatException{
        companyService.login(dto);
        ResponseBodyObject response= new ResponseBodyObject();
        response.setSuccess(true);
        response.setTimeStamp(LocalDateTime.now());
        response.setMessage("login successful");
        response.setStatus("success");
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAllCompany() throws EclatException{
        List<Company> company= companyService.findAll();
        return new ResponseEntity<>(company, HttpStatus.OK);
    }


    @GetMapping("{userId}")
    public ResponseEntity<Company> findById(@PathVariable @RequestParam Long userId) throws EclatException {
        if (userId == null) {
            throw new EclatException("user Id cannot be null");
        } else {
            Company company= companyService.findById(userId);
            return new ResponseEntity<>( company,HttpStatus.OK);
        }

    }

}
