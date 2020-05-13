package com.techcret.TodoBackend.model.security;

import com.techcret.TodoBackend.Repository.UserRoleRepository;
import com.techcret.TodoBackend.enums.Enums;
import com.techcret.TodoBackend.service.BeanUtilService;
import com.techcret.TodoBackend.util.AppUtil;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Document(collection = "users")
@Data
public abstract class User {

    @Id
    private String id;
    @Indexed(unique = true, direction = IndexDirection.DESCENDING)
    @Email(message = "Please Provide Your Email Address")
    private String username;
    @Indexed(sparse = true, direction = IndexDirection.DESCENDING)
    private String phoneNumber;
    private String password;
    private boolean enabled;
    private Enums.Status status = Enums.Status.CURRENT;
    private String uniqueId = AppUtil.generateRandomUniqueString();
    @CreatedDate
    private LocalDateTime dateCreated;
    @LastModifiedDate
    private LocalDateTime lastUpdated;
    private LocalDateTime currentDate;

    public List<Role> getRoles() {
        UserRoleRepository userRoleRepository = BeanUtilService.getBean(UserRoleRepository.class);
        Iterable<UserRole> userRoleIterable = userRoleRepository.findAllByUser(this);
        List<UserRole> userRoleList = new ArrayList<>();
        userRoleIterable.forEach(userRoleList::add);
        return userRoleList.stream().map(UserRole::getRole).collect(Collectors.toList());
    }

}
