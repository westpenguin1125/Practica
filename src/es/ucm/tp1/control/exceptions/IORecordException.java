package es.ucm.tp1.control.exceptions;

public class IORecordException extends CommandExecuteException{
	public IORecordException() { super(); }
	  public IORecordException(String message) { super(message); }
	  public IORecordException(String message, Throwable cause) { super(message, cause); }
	  public IORecordException(Throwable cause) { super(cause); }
}
