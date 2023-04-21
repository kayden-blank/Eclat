package com.nubeero.eclat.service;

import com.nubeero.eclat.dto.CreateJobDto;
import com.nubeero.eclat.model.job.Job;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JobService {

  void  createJob(CreateJobDto dto);

  List<Job> findAll();
}
