package com.nubeero.eclat.repository;

import com.nubeero.eclat.model.eclatUser.EmploymentHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmploymentHistoryRepo extends CrudRepository<EmploymentHistory,Long> {
}
