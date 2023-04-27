package com.nubeero.eclat.job;

import com.nubeero.eclat.dto.TalentRequestDto;
import com.nubeero.eclat.exception.EclatException;
import com.nubeero.eclat.model.job.TalentRequest;
import com.nubeero.eclat.repository.TalentRequestRepository;
import com.nubeero.eclat.response.ResponseBodyObject;
import com.nubeero.eclat.service.TalentRequestService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Slf4j
@SpringBootTest
public class TalentRequestTest {
    @Autowired
    TalentRequestRepository talentRequestRepository;
    @Autowired
    TalentRequestService talentRequestService;
    @Autowired
    public TalentRequestTest(TalentRequestService talentRequestService){
        this.talentRequestService=talentRequestService;
    }

    @Test
    void createTalentRequest() throws EclatException{
        TalentRequestDto talentRequestDto= new TalentRequestDto();
        talentRequestDto.setCompany("New heritage company");
        talentRequestDto.setRecruiter("Ceo New Heritage company");
        talentRequestDto.setSkill("Java engineer");
        talentRequestDto.setStatus("Junior");
        talentRequestDto.setJobRole("software engineer");
        talentRequestDto.setLocation("Location");
        ResponseBodyObject responseBodyObject= talentRequestService.createTalent(talentRequestDto);

        assertThat(responseBodyObject).isNotNull();
        assertThat(responseBodyObject.getMessage()).isNotNull();
        System.out.println(talentRequestDto);
    }

    @Test
    void testThatFindAllTalentRequest() throws EclatException{
        List<TalentRequest> talentRequests= talentRequestService.findAll();
        talentRequests.size();
        assertThat(talentRequests).isNotNull();
        System.out.println(talentRequests);
    }
}
