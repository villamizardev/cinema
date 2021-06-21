package com.cinema.app.utils.response;

import java.util.List;

import com.cinema.app.entities.Cinema;

public class CinemaResponse {
	public static final String GET_CINEMA_FOUND = "Cinema found";
	public static final String GET_CINEMA_CREATED = "Cinema created";
	public static final String GET_CINEMA_ERROR = "Cinema could not be found";
	public static final String GET_CINEMA_NOT_EXISTS = "Cinema does not exist";
	
	public static final String POST_CINEMA_CREATED = "Cinema created";
	public static final String POST_CINEMA_EXISTS = "Cinema already exists";
	public static final String POST_CINEMA_ERROR = "Cinema could not be created";
	
	public static final String UPDATE_CINEMA_UPDATED = "Cinema updated";
	public static final String UPDATE_CINEMA_NOT_EXISTS = "Cinema does not exist";
	public static final String UPDATE_CINEMA_ERROR = "Cinema could not be updated";
	
	public static final String DELETE_CINEMA_DELETED = "Cinema deleted";
	public static final String DELETE_CINEMA_ERROR = "Cinema could not be deleted";
	public static final String DELETE_CINEMA_NOT_EXISTS = "Cinema does not exist";

	private Boolean status;
	private String message;
	private List<Cinema> cinemaList;

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Cinema> getCinemaList() {
		return cinemaList;
	}

	public void setCinemaList(List<Cinema> cinemaList) {
		this.cinemaList = cinemaList;
	}

}
