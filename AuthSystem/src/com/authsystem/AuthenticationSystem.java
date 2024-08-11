package com.authsystem;

public class AuthenticationSystem {
	public static void main(String[] args) {
        
        AuthHandler passwordHandler = new PasswordAuthHandler();
        AuthHandler otpHandler = new OtpAuthHandler();
        AuthHandler biometricHandler = new BiometricAuthHandler();
        
        
        passwordHandler.setNext(otpHandler);
        otpHandler.setNext(biometricHandler);
        
        
        authenticateUser(passwordHandler, "123456"); 
        authenticateUser(passwordHandler, "biometricData"); 
        authenticateUser(passwordHandler, "password123");
    }

    private static void authenticateUser(AuthHandler handler, String credential) {
        if (handler.authenticate(credential)) {
            System.out.println("Authentication successful.");
        } else {
            System.out.println("Authentication failed.");
        }
    }

}
