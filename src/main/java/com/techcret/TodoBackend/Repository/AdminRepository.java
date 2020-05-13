package com.techcret.TodoBackend.Repository;

import com.techcret.TodoBackend.model.admin.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdminRepository extends MongoRepository<Admin,String> {

    Boolean existsByUsername(String emailAddress);

}
