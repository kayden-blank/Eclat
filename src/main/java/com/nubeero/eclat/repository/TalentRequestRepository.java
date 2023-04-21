package com.nubeero.eclat.repository;

import com.nubeero.eclat.model.job.TalentRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TalentRequestRepository extends CrudRepository<TalentRequest, Long> {
}
