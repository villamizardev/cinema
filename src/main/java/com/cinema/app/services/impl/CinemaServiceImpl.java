package com.cinema.app.services.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.app.entities.Cinema;
import com.cinema.app.repositories.ICinemaRepository;
import com.cinema.app.services.ICinemaService;
import com.cinema.app.utils.response.CinemaResponse;

@Service
public class CinemaServiceImpl implements ICinemaService {
	@Autowired
	ICinemaRepository cinemaRepository;

	@Override
	public CinemaResponse getCinema(Long id) {
		CinemaResponse cinemaResponse = new CinemaResponse();

		try {
			if (cinemaRepository.existsById(id)) {
				List<Cinema> cinemaList = new ArrayList<Cinema>();
				Cinema cinema = cinemaRepository.findById(id).get();
				cinemaList.add(cinema);
				cinemaResponse.setCinemaList(cinemaList);
				cinemaResponse.setStatus(true);
				cinemaResponse.setMessage(CinemaResponse.GET_CINEMA_FOUND);
			} else {
				cinemaResponse.setStatus(false);
				cinemaResponse.setMessage(CinemaResponse.GET_CINEMA_NOT_EXISTS);
			}
		} catch (Exception e) {
			cinemaResponse.setStatus(false);
			cinemaResponse.setMessage(CinemaResponse.GET_CINEMA_ERROR);
		}

		return cinemaResponse;
	}

	@Override
	public CinemaResponse getAllCinemas() {
		CinemaResponse cinemaResponse = new CinemaResponse();
		List<Cinema> cinemaList = cinemaRepository.findAll();

		if (!cinemaList.isEmpty()) {
			cinemaResponse.setStatus(true);
			cinemaResponse.setMessage(CinemaResponse.GET_CINEMA_FOUND);
			cinemaResponse.setCinemaList(cinemaList);
		} else {
			cinemaResponse.setStatus(false);
			cinemaResponse.setMessage(CinemaResponse.GET_CINEMA_NOT_EXISTS);
		}

		return cinemaResponse;
	}

	@Override
	public CinemaResponse createCinema(Cinema cinema) throws SQLException {
		CinemaResponse cinemaResponse = new CinemaResponse();
		List<Cinema> cinemaList = new ArrayList<Cinema>();

		cinemaRepository.save(cinema);
		cinemaList.add(cinema);
		cinemaResponse.setStatus(true);
		cinemaResponse.setMessage(CinemaResponse.POST_CINEMA_CREATED);
		cinemaResponse.setCinemaList(cinemaList);

		return cinemaResponse;
	}

	@Override
	public CinemaResponse updateCinema(Cinema cinema) {
		CinemaResponse cinemaResponse = new CinemaResponse();

		if (cinemaRepository.existsById(cinema.getId())) {
			cinemaRepository.save(cinema);
			List<Cinema> cinemaList = new ArrayList<Cinema>();
			cinemaList.add(cinema);
			cinemaResponse.setStatus(true);
			cinemaResponse.setMessage(CinemaResponse.UPDATE_CINEMA_UPDATED);
			cinemaResponse.setCinemaList(cinemaList);
		} else {
			cinemaResponse.setStatus(true);
			cinemaResponse.setMessage(CinemaResponse.UPDATE_CINEMA_NOT_EXISTS);
		}
		return cinemaResponse;
	}

	@Override
	public CinemaResponse deleteCinema(Long id) {
		CinemaResponse cinemaResponse = new CinemaResponse();

		if (cinemaRepository.existsById(id)) {
			cinemaRepository.deleteById(id);
			cinemaResponse.setStatus(true);
			cinemaResponse.setMessage(CinemaResponse.DELETE_CINEMA_DELETED);
		} else {
			cinemaResponse.setStatus(true);
			cinemaResponse.setMessage(CinemaResponse.DELETE_CINEMA_NOT_EXISTS);
		}
		return cinemaResponse;
	}

}
