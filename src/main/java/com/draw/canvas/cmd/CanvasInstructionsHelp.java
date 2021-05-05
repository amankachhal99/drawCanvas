package com.draw.canvas.cmd;

import com.draw.canvas.core.Canvas;
import com.draw.canvas.exception.DrawCanvasException;
import com.draw.canvas.util.CanvasCostant;

import static com.draw.canvas.util.CanvasCostant.CMD_HELP;

/**
 * Help command
 */
public class CanvasInstructionsHelp extends CanvasInstructions {
	
	private Canvas canvas;

	private CanvasInstructionsHelp() {
		name = CMD_HELP;
	}
	public CanvasInstructionsHelp(Canvas canvas) {
		this();
		this.canvas = canvas;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void execute() throws DrawCanvasException {
		printHelp();
	}
	
	@Override
	public Canvas getCanvas() {
		return canvas;
	}
	
	private void printHelp() {
		System.out.println(CanvasCostant.HELP_TEXT);
	}

}
