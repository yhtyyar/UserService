package com.example.UserService.rest;

import com.example.UserService.dto.UserDto;
import com.example.UserService.model.Role;
import com.example.UserService.model.User;
import com.example.UserService.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Objects;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserRestControllerV1Test {

    @Mock
    private UserServiceImpl userService;

    private UserRestControllerV1 underTest;

    private static final String EMAIL = "test@mail.com";
    private static final String PASSWORD = "test";
    private static final String FIRST_NAME = "Roman";
    private static final String LAST_NAME = "Sergeyev";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        underTest = new UserRestControllerV1(userService);
    }

    @Test
    public void createTest() {

        User user = new User(
                EMAIL,
                PASSWORD,
                FIRST_NAME,
                LAST_NAME,
                Role.ROLE_USER
        );

        underTest.create(Objects.requireNonNull(UserDto.fromEntity(user)));

        ArgumentCaptor<User> departmentArgumentCaptor =
                ArgumentCaptor.forClass(User.class);
        verify(userService).create(departmentArgumentCaptor.capture());

        User userCaptor = departmentArgumentCaptor.getValue();

        assertThat(userCaptor.getEmail()).isEqualTo(user.getEmail());
        assertThat(userCaptor.getFirstName()).isEqualTo(user.getFirstName());
        assertThat(userCaptor.getLastName()).isEqualTo(user.getLastName());
        assertThat(userCaptor.getRole()).isEqualTo(user.getRole());
    }

    @Test
    public void updateTest() {

        User user = new User(
                EMAIL,
                PASSWORD,
                FIRST_NAME,
                LAST_NAME,
                Role.ROLE_USER
        );

        underTest.update(Objects.requireNonNull(UserDto.fromEntity(user)));

        ArgumentCaptor<User> departmentArgumentCaptor =
                ArgumentCaptor.forClass(User.class);
        verify(userService).update(departmentArgumentCaptor.capture());

        User userCaptor = departmentArgumentCaptor.getValue();

        assertThat(userCaptor.getEmail()).isEqualTo(user.getEmail());
        assertThat(userCaptor.getFirstName()).isEqualTo(user.getFirstName());
        assertThat(userCaptor.getLastName()).isEqualTo(user.getLastName());
        assertThat(userCaptor.getRole()).isEqualTo(user.getRole());
    }

    @Test
    public void getByIdTest() {
        underTest.getById(1L);
        verify(userService, Mockito.times(1)).getById(1L);
    }

    @Test
    public void getAllTest() {
        underTest.getAll();
        verify(userService).getAll();
    }

    @Test
    public void deleteById() {
        underTest.deleteById(2L);
        verify(userService, Mockito.times(1)).deleteById(2L);
    }
}
