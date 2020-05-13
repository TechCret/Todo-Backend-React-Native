package com.techcret.TodoBackend.security;

import com.techcret.TodoBackend.Repository.UserRepository;
import com.techcret.TodoBackend.model.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        User user = userRepository.findByPhoneNumberOrUsername(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username or email : " + usernameOrEmail)
                );
        return UserPrincipal.create(user);
    }

    @Transactional
    public UserDetails loadUserById(String id) {
        User user = userRepository.findByUniqueId(id).orElseThrow(
                () -> new UsernameNotFoundException("User not found with id : " + id)
        );
        return UserPrincipal.create(user);
    }

}
