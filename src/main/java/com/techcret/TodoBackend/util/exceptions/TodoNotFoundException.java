package com.techcret.TodoBackend.util.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TodoNotFoundException extends RuntimeException {

    public TodoNotFoundException(String message) {
        super(message);
    }
}
