package com.example.BookMyShowBackend.Repository;

import com.example.BookMyShowBackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
