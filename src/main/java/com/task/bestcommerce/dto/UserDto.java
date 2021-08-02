package com.task.bestcommerce.dto;

import com.task.bestcommerce.models.Merchant;
import com.task.bestcommerce.models.Role;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Collection;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDto {
    Long id;
    String username;
    String password;
    Collection<Role> role = new ArrayList<>();
    Merchant merchant;
}
