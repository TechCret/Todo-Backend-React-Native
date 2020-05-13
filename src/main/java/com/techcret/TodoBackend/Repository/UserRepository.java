package com.techcret.TodoBackend.Repository;

import com.techcret.TodoBackend.model.security.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User,String> {

    Optional<User> findByPhoneNumberOrUsername(String phoneNumber, String emailAddress);

    Optional<User> findByUniqueId(String uniqueId);

}
