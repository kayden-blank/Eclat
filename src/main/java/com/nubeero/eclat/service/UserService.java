package com.nubeero.eclat.service;

import com.nubeero.eclat.dto.CreateEclatUserDto;
import com.nubeero.eclat.dto.LoginDto;
import com.nubeero.eclat.dto.UpdateUserDto;
import com.nubeero.eclat.exception.EclatException;
import com.nubeero.eclat.model.eclatUser.EclatUser;
import com.nubeero.eclat.response.ResponseBodyObject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
ResponseBodyObject createUser(CreateEclatUserDto dto) throws EclatException;

ResponseBodyObject updateUser(UpdateUserDto dto) throws EclatException;
List<EclatUser> findAll() throws EclatException;

EclatUser findById (Long id) throws EclatException;

boolean findByEmail(String userEmail) throws EclatException;

EclatUser login(LoginDto loginDto) throws EclatException;
}
