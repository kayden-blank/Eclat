package com.nubeero.eclat.repository;

import com.nubeero.eclat.model.job.Job;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends CrudRepository<Job, Long> {
}
