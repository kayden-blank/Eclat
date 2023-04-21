package com.nubeero.eclat.repository;

import com.nubeero.eclat.model.eclatUser.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
