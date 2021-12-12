package es.ucm.tp1.control.exceptions;


public class InvalidPositionException extends CommandExecuteException {
	public InvalidPositionException() { super(); }
	  public InvalidPositionException(String message) { super(message); }
	  public InvalidPositionException(String message, Throwable cause) { super(message, cause); }
	  public InvalidPositionException(Throwable cause) { super(cause); }}
