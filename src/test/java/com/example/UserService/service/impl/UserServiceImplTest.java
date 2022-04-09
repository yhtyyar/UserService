package com.example.UserService.service.impl;

import com.example.UserService.model.Role;
import com.example.UserService.model.User;
import com.example.UserService.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    private UserServiceImpl underTest;

    private static final String EMAIL = "test@mail.com";
    private static final String PASSWORD = "test";
    private static final String FIRST_NAME = "Roman";
    private static final String LAST_NAME = "Sergeyev";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        underTest = new UserServiceImpl(userRepository);
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

        underTest.create(user);

        ArgumentCaptor<User> userArgumentCaptor =
                ArgumentCaptor.forClass(User.class);
        verify(userRepository).save(userArgumentCaptor.capture());

        User capturedUser = userArgumentCaptor.getValue();

        assertThat(capturedUser.getEmail()).isEqualTo(user.getEmail());
        assertThat(capturedUser.getFirstName()).isEqualTo(user.getFirstName());
        assertThat(capturedUser.getLastName()).isEqualTo(user.getLastName());
        assertThat(capturedUser.getRole()).isEqualTo(user.getRole());
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

        underTest.update(user);

        ArgumentCaptor<User> userArgumentCaptor =
                ArgumentCaptor.forClass(User.class);
        verify(userRepository).save(userArgumentCaptor.capture());

        User capturedUser = userArgumentCaptor.getValue();

        assertThat(capturedUser.getEmail()).isEqualTo(user.getEmail());
        assertThat(capturedUser.getFirstName()).isEqualTo(user.getFirstName());
        assertThat(capturedUser.getLastName()).isEqualTo(user.getLastName());
        assertThat(capturedUser.getRole()).isEqualTo(user.getRole());
    }

    @Test
    public void getByIdTest() {
        underTest.getById(1L);
        verify(userRepository, Mockito.times(1)).getById(1L);
    }

    @Test
    public void deleteById() {
        underTest.deleteById(2L);
        verify(userRepository, Mockito.times(1)).deleteById(2L);
    }

    @Test
    public void getAllTest() {
        underTest.getAll();
        verify(userRepository).findAll();
    }
}
