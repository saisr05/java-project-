package singleton1;

public class Logger1 {

	    public static void main(String[] args) {
	        // Get the only object available
	        Logger logger = Logger.getInstance();

	        // Log messages
	        logger.log("Application started");
	       // logger.log("An error occurred");
	    }
	}



