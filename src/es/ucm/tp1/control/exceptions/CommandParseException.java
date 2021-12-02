package es.ucm.tp1.control.exceptions;

public class CommandParseException extends GameException{
	public CommandParseException() { super(); }
	  public CommandParseException(String message) { super(message); }
	  public CommandParseException(String message, Throwable cause) { super(message, cause); }
	  public CommandParseException(Throwable cause) { super(cause); }
}
