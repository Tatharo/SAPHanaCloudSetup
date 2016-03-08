package com.tatharo.absenceapp.service.authentication;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Authenticator {
	public boolean authenticateUserRequest(HttpServletRequest request,HttpServletResponse response) throws IOException {
		if(!request.isUserInRole("Administrator")){
			response.sendError(403,"Unauthorised");
			return false;
		}
		return true;
	}
}
