package es.ucm.tp1.control.exceptions;

public class NotEnoughCoinsException extends CommandExecuteException{
	public NotEnoughCoinsException() { super(); }
	  public NotEnoughCoinsException(String message) { super(message); }
}
