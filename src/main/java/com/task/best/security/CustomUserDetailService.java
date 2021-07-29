package com.task.best.security;

import com.task.best.models.Merchant;
import com.task.best.repo.MerchantRepo;
import com.task.best.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    MerchantRepo merchantRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Merchant> user = merchantRepo.findMerchantByEmail(username);

        if (user.isPresent()) {
//            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//            Arrays.asList(user.get().getRoles().split(",")).stream()
//                    .forEach(authority -> {
//                        authorities.add(new SimpleGrantedAuthority(authority));
//                    });
//            return new User(user.get().getUsername(), user.get().getPassword(), authorities);
            return new User(user.get().getUsername(), user.get().getPassword(),new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User "+ username+ " not exist");
        }
    }
}