package com.nubeero.eclat.repository;

import com.nubeero.eclat.model.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository <Company, Long> {

    boolean existsByEmail(String companyEmailAddress);
    Optional<Company> findByEmail(String email);
}
