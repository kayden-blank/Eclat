package com.nubeero.eclat.service;

import com.nubeero.eclat.dto.CreateEclatUserDto;
import com.nubeero.eclat.dto.UpdateUserDto;
import com.nubeero.eclat.model.eclatUser.User;
import com.nubeero.eclat.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;


    @Override
    public void createUser(CreateEclatUserDto dto) {
        User user = new User();
        user.setFirstname(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setEmail(dto.getEmail());
        user.setEnglishProficiency(dto.getEnglishProficiency());
        user.setYearOfExperience(dto.getYearOfExperience());
        user.setPassword(dto.getPassword());
        userRepository.save(user);

    }

    @Override
    public void updateUser(UpdateUserDto dto) {
        User user= new User();
        userRepository.findById(dto.getUserId());
        if (dto.getUserId() != null) {
            user.setId(dto.getUserId());
            user.setCountry(dto.getCountry());
            user.setWorkExperience(dto.getWorkExperience());
            user.setLinkedin(dto.getLinkedin());
            user.setPersonalWebsite(dto.getPersonalWebsite());
            user.setJobDescription(dto.getJobDescription());
            user.setEmploymentHistory(dto.getEmploymentHistory());
            userRepository.save(user);
        }

    }

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

}
