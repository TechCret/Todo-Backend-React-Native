package com.techcret.TodoBackend.valueObject.todo;

import com.techcret.TodoBackend.model.todo.Todo;
import com.techcret.TodoBackend.util.constant.AppConstant;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
public class TodoVO implements Serializable {

    private String title;
    private String description;
    private String uniqueId;
    private String todoStatus;
    private String todoDate;
    private String todoTime;

    public TodoVO(Todo todo) {
        this.title = todo.getTitle();
        this.description = todo.getDescription();
        this.uniqueId = todo.getUniqueId();
        this.todoStatus = todo.getTodoStatus().name();
        this.todoDate = todo.getTodoDate().format(DateTimeFormatter.ofPattern(AppConstant.DATE_TO_STR_FORMAT));
        this.todoTime = todo.getTodoTime();
    }

}
