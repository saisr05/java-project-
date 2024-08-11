package com.authsystem;

public class OtpAuthHandler implements AuthHandler {
	private AuthHandler nextHandler;

    
    public void setNext(AuthHandler handler) {
        this.nextHandler = handler;
    }

    
    public boolean authenticate(String credential) {
        if (credential.equals("123456")) { 
            System.out.println("OTP authentication successful.");
            return true;
        } else if (nextHandler != null) {
            return nextHandler.authenticate(credential);
        }
        return false;
    }

}
