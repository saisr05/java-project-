package com.authsystem;

public class BiometricAuthHandler implements AuthHandler {
	private AuthHandler nextHandler;

    @Override
    public void setNext(AuthHandler handler) {
        this.nextHandler = handler;
    }

    @Override
    public boolean authenticate(String credential) {
        if (credential.equals("biometricData")) { // Simplified check
            System.out.println("Biometric authentication successful.");
            return true;
        } else if (nextHandler != null) {
            return nextHandler.authenticate(credential);
        }
        return false;
    }

}
