package utils;

public class ScrabbleException extends RuntimeException
{

	/* ------------------------------------------------ *
	 * ----------------- Constructors ----------------- *
	 * ------------------------------------------------ */
	
	public ScrabbleException()
	{
		super();
	}
	
	public ScrabbleException(CharSequence msg)
	{
		super(msg.toString());
	}
	
	public ScrabbleException(CharSequence msg, Throwable cause)
	{
		super((msg == null) ? null : msg.toString(), cause);
	}
}