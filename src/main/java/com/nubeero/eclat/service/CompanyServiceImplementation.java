package com.nubeero.eclat.service;


import com.nubeero.eclat.dto.CompanyLoginDto;
import com.nubeero.eclat.dto.LoginDto;
import com.nubeero.eclat.dto.SignUpCompanyDto;
import com.nubeero.eclat.exception.EclatException;
import com.nubeero.eclat.model.company.Company;
import com.nubeero.eclat.model.eclatUser.EclatUser;
import com.nubeero.eclat.repository.CompanyRepository;
import com.nubeero.eclat.response.ResponseBodyObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CompanyServiceImplementation implements CompanyService {
    @Autowired
    CompanyRepository companyRepository;


    private Company getUserById(Long userId) throws EclatException {
        return companyRepository.findById(userId).orElseThrow(() ->
                new EclatException("UserId not Found"));
    }


    @Override
    public ResponseBodyObject createUser(SignUpCompanyDto signUpCompanyDto) throws EclatException {
        Company company = new Company();
        company.setCompanyName(signUpCompanyDto.getCompanyName());
        company.setPassword(signUpCompanyDto.getPassword());
        company.setEmail(signUpCompanyDto.getEmail());
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

    @Override
    public List<Company> findAll() throws EclatException {
        return companyRepository.findAll();
    }

    @Override
    public Company findById(Long id) throws EclatException {
        return companyRepository.findById(id).orElseThrow(() ->
                new EclatException("This user does not exist"));
    }

    @Override
    public boolean findByEmail(String userEmail) {
        return companyRepository.existsByEmail(userEmail);
    }





//    @Override
//    public Company login(CompanyLoginDto companyLoginDto) throws EclatException{
//        Company company = new Company();
//
//        if (companyRepository.existsByEmail(companyLoginDto.getCompanyEmailAddress())) {
//            company.setEmail(companyLoginDto.getCompanyEmailAddress());
//            company.setPassword(companyLoginDto.getPassword());
//            companyRepository.save(company);
//        } else {
//            throw new EclatException("User does not exist sign up to get started");
//        }
//        return company;
//    }
@Override
public Company login(CompanyLoginDto companyLoginDto) throws EclatException {
    Optional<Company> companyOptional = companyRepository.findByEmail(companyLoginDto.getCompanyEmailAddress());
    if (companyOptional.isPresent()) {
        Company company = companyOptional.get();
        if (company.getPassword().equals(companyLoginDto.getPassword())) {
            return company;
        } else {
            throw new EclatException("Invalid password");
        }
    } else {
        throw new EclatException("User does not exist. Sign up to get started.");
    }
}


}
