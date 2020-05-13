package com.techcret.TodoBackend.controller.todo;

import com.techcret.TodoBackend.commandObject.todo.TodoCO;
import com.techcret.TodoBackend.enums.Enums;
import com.techcret.TodoBackend.service.todo.TodoService;
import com.techcret.TodoBackend.valueObject.security.ApiResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(value = "/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/{todoUniqueId}")
    public ResponseEntity<?> fetch(@PathVariable String todoUniqueId) {
        return ResponseEntity.ok(new ApiResponseVO(Enums.ResponseType.SUCCESS, "Successfully Fetched", todoService.fetch(todoUniqueId)));
    }

    @GetMapping("/")
    public ResponseEntity<?> fetchAll() {
        return ResponseEntity.ok(new ApiResponseVO(Enums.ResponseType.SUCCESS, "Successfully Fetched", todoService.fetchAll()));
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody TodoCO todoCO) {
        return ResponseEntity.ok(new ApiResponseVO(Enums.ResponseType.SUCCESS, "Successfully Create", todoService.create(todoCO)));
    }

    @DeleteMapping("/{todoUniqueId}")
    public ResponseEntity<?> delete(@PathVariable String todoUniqueId) {
        todoService.delete(todoUniqueId);
        return ResponseEntity.ok(new ApiResponseVO(Enums.ResponseType.SUCCESS, "SuccessFully Deleted", null));
    }

    @PatchMapping("/{todoUniqueId}")
    public ResponseEntity<?> update(@RequestBody TodoCO todoCO, @PathVariable String todoUniqueId) {
        return ResponseEntity.ok(new ApiResponseVO(Enums.ResponseType.SUCCESS, "SuccessFully Updated", todoService.update(todoUniqueId, todoCO)));
    }

}