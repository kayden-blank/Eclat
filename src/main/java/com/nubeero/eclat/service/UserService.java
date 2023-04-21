package com.nubeero.eclat.service;

import com.nubeero.eclat.dto.CreateEclatUserDto;
import com.nubeero.eclat.dto.UpdateUserDto;
import com.nubeero.eclat.model.eclatUser.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
void createUser(CreateEclatUserDto dto);

void updateUser(UpdateUserDto dto);
List<User> findAll();

Optional<User> findById(Long id);
}
