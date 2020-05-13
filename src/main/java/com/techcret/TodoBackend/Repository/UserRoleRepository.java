package com.techcret.TodoBackend.Repository;

import com.techcret.TodoBackend.model.security.Role;
import com.techcret.TodoBackend.model.security.User;
import com.techcret.TodoBackend.model.security.UserRole;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRoleRepository extends MongoRepository<UserRole,String> {

    Iterable<UserRole> findAllByUser(User user);

    Iterable<UserRole> findAllByRole(Role role);

}
