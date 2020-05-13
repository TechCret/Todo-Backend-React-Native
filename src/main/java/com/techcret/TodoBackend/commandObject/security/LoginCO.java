package com.techcret.TodoBackend.commandObject.security;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginCO {

    private String username;
    private String password;

}
