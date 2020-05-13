package com.techcret.TodoBackend.commandObject.todo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@NoArgsConstructor
public class TodoCO {

    private String title;
    private String description;
    private String employeeUniqueId;
    private String todoDate;
    private String todoTime;

    public TodoCO(String title, String description, String employeeUniqueId, String todoDate, String todoTime) {
        this.title = title;
        this.description = description;
        this.employeeUniqueId = employeeUniqueId;
        this.todoDate = todoDate;
        this.todoTime = todoTime;
    }

}