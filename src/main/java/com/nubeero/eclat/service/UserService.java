package com.nubeero.eclat.service;

import com.nubeero.eclat.dto.CreateEclatUserDto;
import com.nubeero.eclat.dto.LoginDto;
import com.nubeero.eclat.dto.UpdateUserDto;
import com.nubeero.eclat.exception.EclatException;
import com.nubeero.eclat.model.eclatUser.User;
import com.nubeero.eclat.response.ResponseBodyObject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
ResponseBodyObject createUser(CreateEclatUserDto dto) throws EclatException;

ResponseBodyObject updateUser(UpdateUserDto dto) throws EclatException;
List<User> findAll() throws EclatException;

User findById (Long id) throws EclatException;

boolean findByEmail(String userEmail) throws EclatException;

User login(LoginDto loginDto) throws EclatException;
}
