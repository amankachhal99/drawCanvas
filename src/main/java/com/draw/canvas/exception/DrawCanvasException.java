package com.draw.canvas.exception;

/**
 * General Canvas Exception. All application exceptions extends this class.
 */
public class DrawCanvasException extends Exception{

	private static final long serialVersionUID = -8629000422659650854L;

	public DrawCanvasException(String message){
		super(message);
	}
	
	public DrawCanvasException(String message, Throwable e){
		super(message,e);
	}
}
