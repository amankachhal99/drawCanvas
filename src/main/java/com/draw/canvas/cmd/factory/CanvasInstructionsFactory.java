package com.draw.canvas.cmd.factory;

import com.draw.canvas.cmd.CanvasInstructions;
import com.draw.canvas.core.Canvas;
import com.draw.canvas.exception.DrawCanvasException;

/**
 * Factory for creating Command objects.
 */
public interface CanvasInstructionsFactory {
	
	/**
	 * Factory which creates Command objects starting from the string inserted as input.
	 * C w h         -  Create a new canvas of width w and height h.
	 * L x1 y1 x2 y2 - Create a new line from (x1,y1) to (x2,y2).
	 * R x1 y1 x2 y2 - Create a new rectangle, whose upper left corner is (x1,y1) and lower right corner is (x2,y2).
	 * B x y c       - Fill the entire area connected to (x,y) with "color" c.
	 * H             - Help.
	 * Q             - Quit the program.
	 * 
	 * @param line Input string to parse as command
	 * @param canvas 
	 * @return the command object created from the string input
	 * @throws DrawCanvasException If the string input cannot be converted to a command
	 */
	public CanvasInstructions buildCommand(String line, Canvas canvas) throws DrawCanvasException;
	
}
