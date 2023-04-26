package com.nubeero.eclat.repository;

import com.nubeero.eclat.model.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository <Company, Long> {
}
