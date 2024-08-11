package com.authsystem;

public interface AuthHandler {
	void setNext(AuthHandler handler);
    boolean authenticate(String credential);
}
