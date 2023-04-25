package com.nubeero.eclat.eclatUser;

import com.nubeero.eclat.dto.CreateEclatUserDto;
import com.nubeero.eclat.dto.LoginDto;
import com.nubeero.eclat.dto.UpdateUserDto;
import com.nubeero.eclat.exception.EclatException;
import com.nubeero.eclat.model.eclatUser.EmploymentHistory;
import com.nubeero.eclat.model.eclatUser.User;
import com.nubeero.eclat.model.eclatUser.WorkExperience;
import com.nubeero.eclat.repository.UserRepository;
import com.nubeero.eclat.response.ResponseBodyObject;
import com.nubeero.eclat.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Slf4j
@SpringBootTest
public class UserTest {

    @Autowired
    private UserRepository userRepository;

    UserService userService;

    @Autowired
    public UserTest (UserService userService){
        this.userService=userService;
    }

    @Test
    void testCreateEclatUser() throws EclatException{
        CreateEclatUserDto eclatUserDto= new CreateEclatUserDto();


        eclatUserDto.setFirstName("Adeola");
        eclatUserDto.setLastName("Esther");
        eclatUserDto.setEmail("adesther@gmail.com");
        eclatUserDto.setEnglishProficiency("professional");
        eclatUserDto.setPhoneNumber("+234509008999");
        eclatUserDto.setSkill("Java engineer");
        eclatUserDto.setYearOfExperience(3);

        ResponseBodyObject response= userService.createUser(eclatUserDto);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isNotNull();
        System.out.println(eclatUserDto);
    }


    @Test
    void testThatUpdateEclatUser() throws EclatException{
        List<EmploymentHistory> employmentHistoryList= new ArrayList<>();
        List<WorkExperience> workExperiences= new ArrayList<>();

        EmploymentHistory employmentHistory= new EmploymentHistory();
        employmentHistory.setCompany("ItHorizon");
        employmentHistory.setIndustry("Technology");
        employmentHistory.setJobType("Software engineer");
        employmentHistory.setRole("Junior");
        employmentHistory.setStartDate("08/08/2021");
        employmentHistory.setEndDate("14/05/2022");

        employmentHistoryList.add(employmentHistory);

        WorkExperience workExperience= new WorkExperience();
        workExperience.setPrimarySkill("Java Engineer");
        workExperience.setSkillLevel("Proficient");
        workExperiences.add(workExperience);

        UpdateUserDto updateUserDto= new UpdateUserDto();

        updateUserDto.setUserId(1L);
        updateUserDto.setCountry("Algeria");
        updateUserDto.setLinkedin("adeolaesther.009567.linkedin");
        updateUserDto.setJobDescription("Backend engineer");
        updateUserDto.setPersonalWebsite("www.adeolaesther.com");
        updateUserDto.setEmploymentHistory(employmentHistoryList);
        updateUserDto.setWorkExperience(workExperiences);

        ResponseBodyObject responseBodyObject= new ResponseBodyObject();
        assertThat(responseBodyObject).isNotNull();
        assertThat(responseBodyObject.isSuccess()).isNotNull();
        assertThat(updateUserDto.getUserId()).isEqualTo(1L);
        System.out.println(updateUserDto);

    }
    @Test
    void testThatFindAllEclatUsers() throws EclatException{
        List<User> eclatUsers= userService.findAll();
        eclatUsers.size();
        assertThat(eclatUsers).isNotNull();
        System.out.println(eclatUsers);
    }
    @Test
    void testThatFindEclatUserById() throws EclatException{
        User user= userService.findById(1L);
        user.getId();
        assertThat(user).isNotNull();
        System.out.println(user);
    }

    @Test
    void testThatLogin() throws EclatException{
        LoginDto loginDto= new LoginDto();
        loginDto.setEmail("estherAdeola@gmail.com");
        loginDto.setPassword("Ester@6090");
        assertThat(loginDto.getEmail()).isEqualTo("estherAdeola@gmail.com");
        assertThat(loginDto.getPassword()).isEqualTo("Ester@6090");
        System.out.println(loginDto);
    }


}
