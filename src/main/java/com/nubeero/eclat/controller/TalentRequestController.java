package com.nubeero.eclat.controller;

import com.nubeero.eclat.dto.TalentRequestDto;
import com.nubeero.eclat.exception.EclatException;
import com.nubeero.eclat.model.job.TalentRequest;
import com.nubeero.eclat.response.ResponseBodyObject;
import com.nubeero.eclat.service.TalentRequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("talentRequest")
public class TalentRequestController {
    @Autowired
    TalentRequestService talentRequestService;

    @PostMapping("")
    public ResponseEntity<?> createTalent(@RequestBody TalentRequestDto dto) throws EclatException{
        talentRequestService.createTalent(dto);
        ResponseBodyObject response= talentRequestService.createTalent(dto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllTalent() throws EclatException{
        List<TalentRequest> allTalents= talentRequestService.findAll();
        return new ResponseEntity<>(allTalents,HttpStatus.OK);
    }
}
