package com.nubeero.eclat.service;

import com.nubeero.eclat.dto.TalentRequestDto;
import com.nubeero.eclat.exception.EclatException;
import com.nubeero.eclat.model.job.TalentRequest;
import com.nubeero.eclat.repository.TalentRequestRepository;
import com.nubeero.eclat.response.ResponseBodyObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class TalentRequestServiceImpl implements TalentRequestService {

    @Autowired
    TalentRequestRepository talentRequestRepository;


    @Override
    public ResponseBodyObject createTalent(TalentRequestDto dto) throws EclatException {
        TalentRequest talentRequest = new TalentRequest();
        talentRequest.setRecruiter(dto.getRecruiter());
        talentRequest.setCompany(dto.getCompany());
        talentRequest.setJobRole(dto.getJobRole());
        talentRequest.setLocation(dto.getLocation());
        talentRequest.setSkill(dto.getSkill());
        talentRequest.setStatus(dto.getStatus());
        talentRequestRepository.save(talentRequest);


        return response();
    }

    private ResponseBodyObject response() {
        ResponseBodyObject response= new ResponseBodyObject();
        response.setTimeStamp(LocalDateTime.now());
        response.setMessage("talent request created ");
        response.setSuccess(true);
        response.setStatus("success");
        return response;
    }

    @Override
    public List<TalentRequest> findAll() throws EclatException{
        return (List<TalentRequest>) talentRequestRepository.findAll();
    }
}
