package com.techcret.TodoBackend.bootStrap.security;

import com.techcret.TodoBackend.Repository.AdminRepository;
import com.techcret.TodoBackend.Repository.RoleRepository;
import com.techcret.TodoBackend.Repository.UserRoleRepository;
import com.techcret.TodoBackend.model.admin.Admin;
import com.techcret.TodoBackend.model.security.Role;
import com.techcret.TodoBackend.model.security.UserRole;
import com.techcret.TodoBackend.util.SecurityConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class SecurityBootstrap {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void createData() {
        createRole();
        createSuperAdmin();
    }

    private void createSuperAdmin() {

        List<String> adminEmailAddressList = Arrays.asList("Qwe", "deepak@techcret.com");
        for (String emailAddress : adminEmailAddressList) {
            log.info("Bootstraping SuperAdmin code for Email Address => {}", emailAddress);
            if (!adminRepository.existsByUsername(emailAddress)) {
                Admin superAdmin = new Admin();
                superAdmin.setUsername(emailAddress);
                superAdmin.setPassword(passwordEncoder.encode("123"));
                if (emailAddress.equals(adminEmailAddressList.get(0))) {
                    superAdmin.setFirstName("Deepak");
                    superAdmin.setLastName("jha");
                } else if (emailAddress.equals(adminEmailAddressList.get(1))) {
                    superAdmin.setFirstName("Nakul Ashish");
                    superAdmin.setLastName("Pant");
                }
                superAdmin.setEnabled(Boolean.TRUE);
                adminRepository.save(superAdmin);
                UserRole userRole = new UserRole(superAdmin, roleRepository.findByName(SecurityConstant.ROLE_ADMIN).get());
                userRoleRepository.save(userRole);
            }
        }
    }

    private void createRole() {
        List<String> roleList = Arrays.asList(SecurityConstant.ROLE_ADMIN, SecurityConstant.ROLE_EMPLOYEE, SecurityConstant.ROLE_INTERN);
        for (String roleName : roleList) {
            if (roleRepository.countByName(roleName) == 0) {
                roleRepository.save(new Role(roleName));
            }
        }
    }

}
