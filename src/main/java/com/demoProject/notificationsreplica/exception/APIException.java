package com.demoProject.notificationsreplica.exception;

public class APIException extends RuntimeException {

	
private static final long serialVersionUID = 1L;
	
	private final transient Object[] args;

    public APIException(String message, Object[] args) {
        super(message);
        
        System.out.println(args);
        this.args = args;
    }

    public APIException(String message, Object[] args, Throwable throwable) {
        super(message, throwable);
        this.args = args;
    }

    public Object[] getArgs() {
        return args;
    }
	
    
    
}
