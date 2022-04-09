package com.example.UserService.dto;

import com.example.UserService.model.Role;
import com.example.UserService.model.User;
import lombok.Builder;
import lombok.Data;

import java.util.Objects;

@Data
@Builder
public class UserDto {


    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Role role;

    public User toEntity() {
        return User.builder()
                .id(this.id)
                .email(this.email)
                .password(this.password)
                .firstName(this.firstName)
                .lastName(this.lastName)
                .role(this.role)
                .build();
    }

    public static UserDto fromEntity(User user) {

        if (Objects.isNull(user)) {
            return null;
        }

        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .role(user.getRole())
                .build();
    }
}
