package com.galvanize.springbootmavendockerized.entities;

import com.galvanize.springbootmavendockerized.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}