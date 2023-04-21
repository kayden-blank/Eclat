package com.nubeero.eclat.service;

import com.nubeero.eclat.dto.TalentRequestDto;
import com.nubeero.eclat.exception.EclatException;
import com.nubeero.eclat.model.job.TalentRequest;
import com.nubeero.eclat.response.ResponseBodyObject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TalentRequestService {

  ResponseBodyObject createTalent(TalentRequestDto dto) throws EclatException;

  List<TalentRequest> findAll() throws EclatException;
}
