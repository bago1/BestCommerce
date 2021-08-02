package com.task.bestcommerce.models;


import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

    private String username;
    private String password;


    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @ToString.Exclude
    private Collection<Role> role = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "merchant_id", referencedColumnName = "id")

    private Merchant merchant;

}
