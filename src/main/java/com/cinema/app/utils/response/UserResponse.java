package com.cinema.app.utils.response;

import java.util.List;

import com.cinema.app.entities.User;

public class UserResponse {
	public static final String GET_USER_FOUND = "User found";
	public static final String GET_USER_CREATED = "User created";
	public static final String GET_USER_ERROR = "User could not be found";
	public static final String GET_USER_NOT_EXISTS = "User does not exist";

	public static final String POST_USER_CREATED = "User created";
	public static final String POST_USER_EXISTS = "User already exists";
	public static final String POST_USER_ERROR = "User could not be created";

	public static final String UPDATE_USER_UPDATED = "User updated";
	public static final String UPDATE_USER_NOT_EXISTS = "User does not exist";
	public static final String UPDATE_USER_ERROR = "User could not be updated";

	public static final String DELETE_USER_DELETED = "User deleted";
	public static final String DELETE_USER_ERROR = "User could not be deleted";
	public static final String DELETE_USER_NOT_EXISTS = "User does not exist";

	private Boolean status;
	private String message;
	private List<User> userList;

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

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
}
