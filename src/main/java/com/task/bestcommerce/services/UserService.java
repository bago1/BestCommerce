package com.task.bestcommerce.services;

import com.task.bestcommerce.dto.UserDto;
import com.task.bestcommerce.mappers.UserMapper;
import com.task.bestcommerce.models.User;
import com.task.bestcommerce.models.Role;
import com.task.bestcommerce.repo.UserRepo;
import com.task.bestcommerce.repo.RoleRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;



    public List<UserDto> getAllUsers() {
        log.info("Fetching all users");
        List<UserDto> userDtoList= userMapper.entityListToDtoList(userRepo.findAll());

        return userDtoList;
    }

    public void saveUser(UserDto userDto) {
        log.info("Saving new user {} to database", userDto.getUsername());
        User user = userMapper.dtoToEntity(userDto);
        Role roleUser = roleRepo.findByName("MERCHANT");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);

        user.setRole(userRoles);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        userRepo.save(user);






    }


}
