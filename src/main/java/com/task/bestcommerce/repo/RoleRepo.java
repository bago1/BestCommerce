package com.task.bestcommerce.repo;

import com.task.bestcommerce.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role,Integer> {
    Role findByName(String name);

}
