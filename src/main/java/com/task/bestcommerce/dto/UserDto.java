package com.task.bestcommerce.dto;

import com.task.bestcommerce.models.Merchant;
import com.task.bestcommerce.models.Role;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private Collection<Role> role = new ArrayList<>();
    private Merchant merchant;
}
