package com.draw.canvas.cmd;

import com.draw.canvas.core.Canvas;
import com.draw.canvas.exception.DrawCanvasException;
import com.draw.canvas.util.CanvasCostant;

import static com.draw.canvas.util.CanvasCostant.CMD_FILL;

/**
 * Command used by the Canvas for filling the area around a given coordinate.
 * Same as "bucket fill" tool in paint programs.
 */
public class CanvasInstructionsBucketFill extends CanvasInstructions {

	private Canvas canvas;
	private int x;
	private int y;
	private String color;
	
	private CanvasInstructionsBucketFill() {
		name = CMD_FILL;
	}
	
	public CanvasInstructionsBucketFill(int x, int y, String color, Canvas canvas) {
		this();
		this.x = x;
		this.y = y;
		this.color = color;
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
		canvas.fillBucket(this);
	}
	
	@Override
	public Canvas getCanvas() {
		return canvas;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String getColor() {
		return color;
	}
	
}