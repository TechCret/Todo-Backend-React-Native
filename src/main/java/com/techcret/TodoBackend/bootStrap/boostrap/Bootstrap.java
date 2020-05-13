package com.techcret.TodoBackend.bootStrap.boostrap;

import com.techcret.TodoBackend.bootStrap.security.SecurityBootstrap;
import com.techcret.TodoBackend.bootStrap.todo.TodoBootstrap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class Bootstrap implements InitializingBean {

    @Autowired
    private SecurityBootstrap securityBootstrap;
    @Autowired
    private TodoBootstrap todoBootstrap;

    @Override
    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        securityBootstrap.createData();
        todoBootstrap.createTodo();
    }

}
