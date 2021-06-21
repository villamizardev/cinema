package com.cinema.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.app.entities.Cinema;

public interface ICinemaRepository extends JpaRepository<Cinema, Long> {

}
