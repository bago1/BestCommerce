package com.task.bestcommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class BestcommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BestcommerceApplication.class, args);
    }


    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    CommandLineRunner run(UserService userService, MerchantService merchantService) {
//
//        return args -> {
//            userService.saveRole(new Role(null, "ADMIN"));
//            userService.saveRole(new Role(null, "MERCHANT"));
//            userService.saveRole(new Role(null, "USER"));
//
//            userService.saveUser(new User(null, "ulvi443", "ulvi443", new ArrayList<>(),null));
//            userService.saveUser(new User(null, "bago443", "bago443", new ArrayList<>(),null));
//
//            merchantService.saveMerchant(new MerchantDto(null,"s","s","s","s"));
//            userService.addRoleToUser("ulvi443", "MERCHANT");
//            userService.addRoleToUser("bago443", "USER");
//
//        };
//    }
}
