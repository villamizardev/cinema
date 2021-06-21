package com.cinema.app.services;

import com.cinema.app.entities.User;
import com.cinema.app.utils.response.UserResponse;

public interface IUserService {
	
	UserResponse getUser(Long id);

	UserResponse getAllUsers();

	UserResponse createUser(User user);

	UserResponse updateUser(User user);

	UserResponse deleteUser(Long id);
}
