package com.ers.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {
	
	public static String process(HttpServletRequest request, HttpServletResponse response) {
		switch (request.getRequestURI()) {
		case "/0429ProjectOne/html/Login.do":
			return LoginController.Login(request);
		default:
			return null;
		}
	}
}
