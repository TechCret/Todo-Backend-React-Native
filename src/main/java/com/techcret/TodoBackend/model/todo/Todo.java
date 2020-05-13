package com.techcret.TodoBackend.model.todo;

import com.techcret.TodoBackend.commandObject.todo.TodoCO;
import com.techcret.TodoBackend.enums.Enums;
import com.techcret.TodoBackend.util.AppUtil;
import com.techcret.TodoBackend.util.constant.AppConstant;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Document(collection = "todo")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Todo implements Serializable {

    @Id
    private String id;
    @CreatedDate
    private LocalDateTime dateCreated;
    @LastModifiedDate
    private LocalDateTime lastUpdated;
    private String uniqueId = AppUtil.generateRandomUniqueString();
    private String employeeUniqueId;
    private Enums.Status status = Enums.Status.CURRENT;
    private String title;
    private String description;
    private LocalDate todoDate;
    private String todoTime;
    private Enums.TodoStatus todoStatus = Enums.TodoStatus.INCOMPLETE;

    public Todo(TodoCO todoCO) {
        this.employeeUniqueId = todoCO.getEmployeeUniqueId();
        this.title = todoCO.getTitle();
        this.description = todoCO.getDescription();
        this.todoDate = LocalDate.parse(todoCO.getTodoDate(), DateTimeFormatter.ofPattern(AppConstant.STR_TO_DATE_FORMAT));
        this.todoTime = todoCO.getTodoTime();
    }

}
