package com.cinema.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.app.entities.BranchOffice;

public interface IBranchOfficeRepository extends JpaRepository<BranchOffice, Long> {

}
