package com.task.bestcommerce.api;

import com.task.bestcommerce.dto.UserDto;

import com.task.bestcommerce.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;




    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity
                .ok()
                .body(userService.getAllUsers());
    }

    @PostMapping("/signup")
    public ResponseEntity<Object> createUser(@RequestBody UserDto userDto) {
        String password = userDto.getPassword();
        if (password.length() < 6) {
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .body("Password should be 6 or more alphanumeric characters");
        }
        userService.saveUser(userDto);
        return  ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userDto);
    }


}







