package es.ucm.tp1.control.exceptions;

public class InputOutputRecordException extends CommandExecuteException{
	public InputOutputRecordException() { super(); }
	  public InputOutputRecordException(String message) { super(message); }
	  public InputOutputRecordException(String message, Throwable cause) { super(message, cause); }
	  public InputOutputRecordException(Throwable cause) { super(cause); }
}
