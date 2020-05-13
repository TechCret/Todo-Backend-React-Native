package com.techcret.TodoBackend.Repository;

import com.techcret.TodoBackend.model.security.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role,String> {

    Optional<Role> findByName(String name);

    Integer countByName(String name);

}
