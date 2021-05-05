package com.draw.canvas.cmd;

import com.draw.canvas.core.Canvas;
import com.draw.canvas.exception.DrawCanvasException;

/**
 * Each command must extends this class so must provide at least the name, canvas status, and execute method.
 */
public abstract class CanvasInstructions {
	
	protected String name;
	
	public abstract String getName();

	public abstract void execute() throws DrawCanvasException;
	
	public abstract Canvas getCanvas();
	
}
