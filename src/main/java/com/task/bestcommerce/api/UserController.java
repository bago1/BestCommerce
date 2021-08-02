package com.task.bestcommerce.api;

import com.task.bestcommerce.dto.UserDto;

import com.task.bestcommerce.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //todo ACCEPTANCE CRITERIA 1.2
    //todo ACCEPTANCE CRITERIA 2
    @PostMapping("/signup")
    public ResponseEntity<Object> createUser(@RequestBody UserDto userDto) {
        String password = userDto.getPassword();

        //PASSAY library somehow didnot worked on gradle, this is why manual validation implemented :(
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







