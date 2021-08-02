package com.task.bestcommerce.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.task.bestcommerce.types.PaymentTypes;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", updatable = false, nullable = false)
//    private Long id;





    private String username;
    private String password;


    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @ToString.Exclude
    private Collection<Role> role = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "merchant_id", referencedColumnName = "id")

    private Merchant merchant;

}
