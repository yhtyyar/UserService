package com.example.UserService.rest;

import com.example.UserService.dto.UserDto;
import com.example.UserService.model.User;
import com.example.UserService.service.impl.UserServiceImpl;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserRestControllerV1 {


    private final UserServiceImpl userService;

    @PostMapping
    @PreAuthorize("hasAuthority('users:write')")
    public ResponseEntity<?> create(@RequestBody @NonNull UserDto userDto) {
        log.info("Inside create method in UserRestControllerV1 {}", userDto.toEntity());
        User user = userService.create(userDto.toEntity());
        return new ResponseEntity<>(UserDto.fromEntity(user), HttpStatus.CREATED);
    }


    @PutMapping
    @PreAuthorize("hasAuthority('users:write')")
    public ResponseEntity<?> update(@RequestBody @NonNull UserDto userDto) {
        log.info("Inside update method in UserRestControllerV1 {}", userDto.toEntity());
        User user = userService.update(userDto.toEntity());
        return new ResponseEntity<>(UserDto.fromEntity(user), HttpStatus.OK);
    }


    @GetMapping
    @PreAuthorize("hasAuthority('users:read')")
    public ResponseEntity<?> getAll() {
        log.info("Inside getAll method in UserRestControllerV1");
        List<User> userList = userService.getAll();

        if (CollectionUtils.isEmpty(userList)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<UserDto> dtoList = userList.stream().map(UserDto::fromEntity).collect(Collectors.toList());
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('users:read')")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        log.info("Inside getById method in UserRestControllerV1 {}", id);
        User user = userService.getById(id);
        return new ResponseEntity<>(UserDto.fromEntity(user), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('users:write')")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        log.info("Inside deleteById method in UserRestControllerV1 {}", id);
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
