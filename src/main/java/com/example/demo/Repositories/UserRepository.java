package com.example.demo.Repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Core.Entities.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    User findByEmail(String email);
}
