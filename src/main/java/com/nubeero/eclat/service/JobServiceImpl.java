package com.nubeero.eclat.service;

import com.nubeero.eclat.dto.CreateJobDto;
import com.nubeero.eclat.model.job.Job;
import com.nubeero.eclat.repository.JobRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class JobServiceImpl implements JobService {

    @Autowired
    JobRepository jobRepository;

    @Override
    public void createJob(CreateJobDto dto) {
        Job job = new Job();
        job.setRecruiter(dto.getRecruiter());
        job.setCompany(dto.getCompany());
        job.setJobRole(dto.getJobRole());
        job.setLocation(dto.getLocation());
        job.setSkill(dto.getSkill());
        job.setStatus(dto.getStatus());
        jobRepository.save(job);

    }

    @Override
    public List<Job> findAll() {
        return (List<Job>) jobRepository.findAll();
    }
}
