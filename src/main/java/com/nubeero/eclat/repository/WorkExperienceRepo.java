package com.nubeero.eclat.repository;

import com.nubeero.eclat.model.eclatUser.WorkExperience;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkExperienceRepo extends CrudRepository<WorkExperience,Long> {
}
