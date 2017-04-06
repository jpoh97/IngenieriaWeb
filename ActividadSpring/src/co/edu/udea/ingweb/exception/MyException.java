package co.edu.udea.ingweb.exception;

import org.apache.log4j.Logger;

/**
 * 
 *Clase desde la cual maneja todas las excepciones
 *
 * @author jpoh97
 * @since 1.8
 * @version 1.0 
 *
 */

public class MyException extends Exception {
	
	Logger mLog = Logger.getLogger(this.getClass());

	public MyException() {
		// TODO Auto-generated constructor stub
	}

	public MyException(String message) {
		super(message);
		mLog.error(message);
	}

	public MyException(Throwable cause) {
		super(cause);
		mLog.error(cause);
	}

	public MyException(String message, Throwable cause) {
		super(message, cause);		
		mLog.error(message, cause);
	}

	public MyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		mLog.error(message, cause);
	}

}