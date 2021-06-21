package com.cinema.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.app.entities.Cinema;
import com.cinema.app.services.ICinemaService;
import com.cinema.app.utils.response.CinemaResponse;

@RestController
public class CinemaController {
	
	@Autowired
	ICinemaService cinemaService;
	
	@GetMapping("/cinema/{id}")
	public ResponseEntity<CinemaResponse> getCinema(@PathVariable Long id){
		CinemaResponse cinemaResponse = new CinemaResponse();
		
		try {
			cinemaResponse = cinemaService.getCinema(id);
			return ResponseEntity.ok().body(cinemaResponse);
		} catch (Exception e) {
			cinemaResponse.setStatus(false);
			cinemaResponse.setMessage(CinemaResponse.GET_CINEMA_ERROR);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(cinemaResponse);
		}
	}
	
	@GetMapping("/cinema")
	public ResponseEntity<CinemaResponse> getAllCinemas(){
		CinemaResponse cinemaResponse = new CinemaResponse();
		
		try {
			cinemaResponse = cinemaService.getAllCinemas();
			return ResponseEntity.ok().body(cinemaResponse);
		} catch (Exception e) {
			cinemaResponse.setStatus(false);
			cinemaResponse.setMessage(CinemaResponse.GET_CINEMA_ERROR);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(cinemaResponse);
		}
	}
	
	@PostMapping("/cinema")
	public ResponseEntity<CinemaResponse> postCinema(@RequestBody Cinema cinema){
		CinemaResponse cinemaResponse = new CinemaResponse();
		try {
			cinemaResponse = cinemaService.createCinema(cinema);
			return ResponseEntity.status(HttpStatus.OK).body(cinemaResponse);
		} catch (Exception e) {
			cinemaResponse.setStatus(false);
			cinemaResponse.setMessage(CinemaResponse.POST_CINEMA_ERROR);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(cinemaResponse); 
		}
	}
	
	@DeleteMapping("/cinema/{id}")
	public ResponseEntity<CinemaResponse> deleteCinema(@PathVariable Long id){
		CinemaResponse cinemaResponse = new CinemaResponse();
		
		try {
			cinemaResponse = cinemaService.deleteCinema(id);
			return ResponseEntity.ok().body(cinemaResponse);
		} catch (Exception e) {
			cinemaResponse.setStatus(false);
			cinemaResponse.setMessage(CinemaResponse.DELETE_CINEMA_ERROR);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(cinemaResponse);
		}
	}
	
	@PutMapping("/cinema")
	public ResponseEntity<CinemaResponse> updateCinema(@RequestBody Cinema cinema){
		CinemaResponse cinemaResponse = new CinemaResponse();
		try {
			cinemaResponse = cinemaService.updateCinema(cinema);
			return ResponseEntity.status(HttpStatus.OK).body(cinemaResponse);
		} catch (Exception e) {
			cinemaResponse.setStatus(false);
			cinemaResponse.setMessage(CinemaResponse.UPDATE_CINEMA_ERROR);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(cinemaResponse); 
		}
	}
}
