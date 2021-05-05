package com.draw.canvas.cmd;

import com.draw.canvas.core.Canvas;
import com.draw.canvas.exception.DrawCanvasException;
import com.draw.canvas.util.CanvasCostant;

import static com.draw.canvas.util.CanvasCostant.CMD_QUITE;

/**
 * Command used for quite the canvas.
 */
public class CanvasInstructionsQuite extends CanvasInstructions {
	
	private Canvas canvas;
	
	private CanvasInstructionsQuite() {
		name = CMD_QUITE;
	}
	
	public CanvasInstructionsQuite(Canvas canvas) {
		this();
		this.canvas = canvas;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void execute() throws DrawCanvasException {
		throw new DrawCanvasException(CanvasCostant.ERROR_QUITING_DRAW_CANVAS);
	}
	
	@Override
	public Canvas getCanvas() {
		return canvas;
	}

}