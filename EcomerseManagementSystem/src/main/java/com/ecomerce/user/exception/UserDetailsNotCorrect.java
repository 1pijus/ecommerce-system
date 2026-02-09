package com.ecomerce.user.exception;

public class UserDetailsNotCorrect extends RuntimeException {
	public UserDetailsNotCorrect(String message) {
		super(message);
	}
}
