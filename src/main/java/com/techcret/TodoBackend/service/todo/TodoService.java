package com.techcret.TodoBackend.service.todo;

import com.techcret.TodoBackend.Repository.todo.TodoRepository;
import com.techcret.TodoBackend.commandObject.todo.TodoCO;
import com.techcret.TodoBackend.enums.Enums;
import com.techcret.TodoBackend.model.todo.Todo;
import com.techcret.TodoBackend.util.exceptions.TodoNotFoundException;
import com.techcret.TodoBackend.valueObject.todo.TodoVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public TodoVO update(String todoUniqueId, TodoCO todoCO) {
        Todo todo = todoRepository.findByUniqueId(todoUniqueId)
                .orElseThrow(() -> new TodoNotFoundException("No Todo Find With This TodoUniqueId" + todoUniqueId));
        todo.setDescription(todoCO.getDescription());
        todo.setTitle(todoCO.getTitle());
        todoRepository.save(todo);
        return new TodoVO(todo);
    }

    public void delete(String todoUniqueId) {
        Todo todo = todoRepository.findByUniqueId(todoUniqueId)
                .orElseThrow(() -> new TodoNotFoundException("No Todo Find With This TodoUniqueId" + todoUniqueId));
        todo.setTodoStatus(Enums.TodoStatus.COMPLETE);
        todoRepository.save(todo);
    }

    public List<TodoVO> fetchAll() {
       Sort sortByDate=Sort.by("todoDate");
        List<TodoVO> todoVOList = new ArrayList<>();
        Iterable<Todo> todoIterable = todoRepository.findAll(sortByDate);
        todoIterable.forEach(todo -> todoVOList.add(new TodoVO(todo)));
        return todoVOList;
    }

    public TodoVO create(TodoCO todoCO) {
        Todo todo = new Todo(todoCO);
        todoRepository.save(todo);
        return new TodoVO(todo);
    }

    public Todo fetch(String todoUniqueId) {
        return todoRepository.findByUniqueId(todoUniqueId)
                .orElseThrow(() -> new TodoNotFoundException("Can`t Find any Todo With This TodoUniqueId" + todoUniqueId));
    }

}