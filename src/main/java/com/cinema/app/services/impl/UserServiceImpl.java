package com.cinema.app.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.app.entities.User;
import com.cinema.app.repositories.IUserRepository;
import com.cinema.app.services.IUserService;
import com.cinema.app.utils.response.UserResponse;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	IUserRepository userReposiroty;

	@Override
	public UserResponse getUser(Long id) {	
		UserResponse userResponse = new UserResponse();

		try {
			if (userReposiroty.existsById(id)) {
				List<User> userList = new ArrayList<User>();
				User user = userReposiroty.findById(id).get();
				userList.add(user);
				userResponse.setUserList(userList);
				userResponse.setStatus(true);
				userResponse.setMessage(UserResponse.GET_USER_FOUND);
			} else {
				userResponse.setStatus(false);
				userResponse.setMessage(UserResponse.GET_USER_NOT_EXISTS);
			}
		} catch (Exception e) {
			userResponse.setStatus(false);
			userResponse.setMessage(UserResponse.GET_USER_ERROR);
		}

		return userResponse;
	}

	@Override
	public UserResponse getAllUsers() {
		UserResponse userResponse = new UserResponse();
		List<User> userList = userReposiroty.findAll();

		if (!userList.isEmpty()) {
			userResponse.setStatus(true);
			userResponse.setMessage(UserResponse.GET_USER_FOUND);
			userResponse.setUserList(userList);
		} else {
			userResponse.setStatus(false);
			userResponse.setMessage(UserResponse.GET_USER_NOT_EXISTS);
		}

		return userResponse;
	}

	@Override
	public UserResponse createUser(User user) {
		UserResponse userResponse = new UserResponse();
		List<User> userList = new ArrayList<User>();

		userReposiroty.save(user);
		userList.add(user);
		userResponse.setStatus(true);
		userResponse.setMessage(UserResponse.POST_USER_CREATED);
		userResponse.setUserList(userList);

		return userResponse;
	}

	@Override
	public UserResponse updateUser(User user) {
		UserResponse userResponse = new UserResponse();

		if (userReposiroty.existsById(user.getId())) {
			userReposiroty.save(user);
			List<User> userList = new ArrayList<User>();
			userList.add(user);
			userResponse.setStatus(true);
			userResponse.setMessage(UserResponse.UPDATE_USER_UPDATED);
			userResponse.setUserList(userList);
		} else {
			userResponse.setStatus(true);
			userResponse.setMessage(UserResponse.UPDATE_USER_NOT_EXISTS);
		}
		return userResponse;
	}

	@Override
	public UserResponse deleteUser(Long id) {
		UserResponse userResponse = new UserResponse();

		if (userReposiroty.existsById(id)) {
			userReposiroty.deleteById(id);
			userResponse.setStatus(true);
			userResponse.setMessage(UserResponse.DELETE_USER_DELETED);
		} else {
			userResponse.setStatus(true);
			userResponse.setMessage(UserResponse.DELETE_USER_NOT_EXISTS);
		}
		return userResponse;
	}

}
