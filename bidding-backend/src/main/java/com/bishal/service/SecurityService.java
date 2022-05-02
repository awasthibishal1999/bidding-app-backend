package com.bishal.service;

import com.bishal.model.User;

public interface SecurityService {

	void autologin(String username, String password);

    boolean loginUser(String username, String password);

    User getAuthenticatedUser();
}
