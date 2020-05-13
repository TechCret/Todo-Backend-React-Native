package com.techcret.TodoBackend.controller.auth;

import com.techcret.TodoBackend.commandObject.security.LoginCO;
import com.techcret.TodoBackend.security.JwtTokenProvider;
import com.techcret.TodoBackend.valueObject.security.JwtAuthenticationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @PostMapping("/api/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginCO loginCO) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginCO.getUsername(), loginCO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        List<String> roleList = authentication.getAuthorities().stream().map(r -> r.getAuthority()).collect(Collectors.toList());
        String jwtToken = jwtTokenProvider.generateToken(authentication);
        String uniqueId = jwtTokenProvider.getUserIdFromJWT(jwtToken);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwtToken, roleList, uniqueId));
    }

}
