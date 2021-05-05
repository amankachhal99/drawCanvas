package com.draw.canvas.cmd;

import com.draw.canvas.core.Canvas;
import com.draw.canvas.exception.DrawCanvasException;
import com.draw.canvas.util.CanvasCostant;

import static com.draw.canvas.util.CanvasCostant.*;

public class CanvasInstructionsClearCanvas extends CanvasInstructions {
	
	private Canvas canvas;
	
	private CanvasInstructionsClearCanvas() {
		name = CMD_CLEAR;
	}
	public CanvasInstructionsClearCanvas(Canvas canvas) {
		this();
		this.canvas = canvas;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void execute() throws DrawCanvasException {
		if(canvas == null){
			throw new DrawCanvasException(CanvasCostant.ERROR_CREATE_NEW_CANVAS);
		}
		canvas.clearCanvas();
	}
	
	@Override
	public Canvas getCanvas() {
		return canvas;
	}
}
