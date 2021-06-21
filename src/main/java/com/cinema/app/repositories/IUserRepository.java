package com.cinema.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.app.entities.User;

public interface IUserRepository extends JpaRepository<User, Long> {

}
