package com.techcret.TodoBackend.bootStrap.todo;

import com.techcret.TodoBackend.Repository.todo.TodoRepository;
import com.techcret.TodoBackend.commandObject.todo.TodoCO;
import com.techcret.TodoBackend.service.todo.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TodoBootstrap {

    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private TodoService todoService;

    public void createTodo() {
        List<TodoCO> todoList = new ArrayList<>();
        todoList.add(new TodoCO("Test", "Maths Test", "184588745454548", "20/04/2020", "04:05"));
        todoList.add(new TodoCO("Dinner", "Dinner at 9pm", "9977755435454", "06/04/2020", "05:08"));
        todoList.stream().filter(todoCO -> !todoRepository.existsByTitleAndDescription(todoCO.getTitle(), todoCO.getDescription())).forEach(todoService::create);
    }

}
