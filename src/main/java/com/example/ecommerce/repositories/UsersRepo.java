package com.example.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.models.Users;

public interface UsersRepo extends JpaRepository<Users, Long> {

}
