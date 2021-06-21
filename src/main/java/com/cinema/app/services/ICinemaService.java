package com.cinema.app.services;

import java.sql.SQLException;

import com.cinema.app.entities.Cinema;
import com.cinema.app.utils.response.CinemaResponse;

public interface ICinemaService {
	
	CinemaResponse getCinema(Long id);
	
	CinemaResponse getAllCinemas();
	
	CinemaResponse createCinema(Cinema cinema) throws SQLException;

	CinemaResponse updateCinema(Cinema cinema);

	CinemaResponse deleteCinema(Long id);
}
