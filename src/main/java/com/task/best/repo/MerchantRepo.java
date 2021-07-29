package com.task.best.repo;

import com.task.best.models.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MerchantRepo extends JpaRepository<Merchant,Integer> {
    public Optional<Merchant> findMerchantByEmail(String email);


}
