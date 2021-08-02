package com.task.bestcommerce.security;

import com.task.bestcommerce.models.User;
import com.task.bestcommerce.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@RequiredArgsConstructor
@Slf4j
@Component
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("username-----: {}", username);

        User user = userRepo.findByUsername(username);
        if (user == null) {
            log.error("user NOT found in database: {}", user);

            throw new UsernameNotFoundException("user not found in database");
        } else {
            log.info("user found in database: {}", user);
        }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRole().forEach(role -> {
                    authorities.add(new SimpleGrantedAuthority(role.getName()));
                }
        );

        return new org.springframework.security.core.userdetails
                .User(user.getUsername(), user.getPassword(), authorities);
    }

}
