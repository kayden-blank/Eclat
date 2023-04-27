package com.nubeero.eclat.service;

import com.nubeero.eclat.dto.CreateEclatUserDto;
import com.nubeero.eclat.dto.LoginDto;
import com.nubeero.eclat.dto.UpdateUserDto;
import com.nubeero.eclat.exception.EclatException;
import com.nubeero.eclat.model.eclatUser.EmploymentHistory;
import com.nubeero.eclat.model.eclatUser.EclatUser;
import com.nubeero.eclat.model.eclatUser.WorkExperience;
import com.nubeero.eclat.repository.UserRepository;
import com.nubeero.eclat.response.ResponseBodyObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    private EclatUser getUserById(Long userId) throws EclatException {
        return userRepository.findById(userId).orElseThrow(() ->
                new EclatException("UserId not Found"));
    }

    @Override
    public ResponseBodyObject createUser(CreateEclatUserDto dto) throws EclatException {
        EclatUser user = new EclatUser();
        user.setFirstname(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setEmail(dto.getEmail());
        user.setEnglishProficiency(dto.getEnglishProficiency());
        user.setYearOfExperience(dto.getYearOfExperience());
        user.setPassword(dto.getPassword());
        user.setSkill(dto.getSkill());
        userRepository.save(user);

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
    public ResponseBodyObject updateUser(UpdateUserDto dto) throws EclatException {
        EclatUser user = getUserById((dto.getUserId()));
        if (dto.getUserId() != null) {

            dto.getEmploymentHistory().stream().forEach(employmentHistory -> buildEmploymentHistory(user, employmentHistory));

            dto.getWorkExperience().stream().forEach(workExperience -> buildWorkExperience(user, workExperience));
        }

        user.setCountry(dto.getCountry());
        user.setLinkedin(dto.getLinkedin());
        user.setPersonalWebsite(dto.getPersonalWebsite());
        user.setJobDescription(dto.getJobDescription());
        var savedUpdatedUser = userRepository.save(user);

        return userUpdateResponse(savedUpdatedUser);

    }

    private static void buildWorkExperience(EclatUser user, WorkExperience workExperience) {
        user.setWorkExperience(workExperience);
    }

    private static void buildEmploymentHistory(EclatUser user, EmploymentHistory employmentHistory) {
        user.setEmploymentHistory(employmentHistory);
    }


    private ResponseBodyObject userUpdateResponse(EclatUser savedUser) throws EclatException {
        ResponseBodyObject responseBodyObject = new ResponseBodyObject();
        responseBodyObject.setTimeStamp(LocalDateTime.now());
        responseBodyObject.setMessage("Updated successfully");
        responseBodyObject.setSuccess(true);
        responseBodyObject.setStatus("success");
        return responseBodyObject;


    }

    @Override
    public List<EclatUser> findAll() throws EclatException {
        return (List<EclatUser>) userRepository.findAll();
    }

    @Override
    public EclatUser findById(Long id) throws EclatException {
        return userRepository.findById(id).orElseThrow(() ->
                new EclatException("This user does not exist"));
    }

    @Override
    public boolean findByEmail(String userEmail) {
        return userRepository.existsByEmail(userEmail);
    }

    @Override
    public EclatUser login(LoginDto loginDto) throws EclatException {
        EclatUser user = new EclatUser();
        if (userRepository.existsByEmail(loginDto.getEmail())) {
            user.setEmail(loginDto.getEmail());
            user.setPassword(loginDto.getPassword());
            userRepository.save(user);
        } else {
            throw new EclatException("User does not exist sign up to get started");
        }
        return user;

    }

}
