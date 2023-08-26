package com.rorysteerprojects.cookbook.cookbook_adapter_jpa;

import com.rorysteerprojects.cookbook.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
