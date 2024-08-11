package com.authsystem;

public class PasswordAuthHandler implements AuthHandler {
	private AuthHandler nextHandler;

    
    public void setNext(AuthHandler handler) {
        this.nextHandler = handler;
    }

    
    public boolean authenticate(String credential) {
        if (credential.equals("password123")) { 
            System.out.println("Password authentication successful.");
            return true;
        } else if (nextHandler != null) {
            return nextHandler.authenticate(credential);
        }
        return false;
    }
	

}
