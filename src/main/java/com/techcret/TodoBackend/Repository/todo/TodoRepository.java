package com.techcret.TodoBackend.Repository.todo;

import com.techcret.TodoBackend.model.todo.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TodoRepository extends MongoRepository<Todo, String> {

    Boolean existsByTitleAndDescription(String title, String description);

    Optional<Todo> findByUniqueId(String todoUniqueId);

}
