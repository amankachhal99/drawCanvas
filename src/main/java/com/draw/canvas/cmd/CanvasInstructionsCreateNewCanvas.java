package com.draw.canvas.cmd;

import com.draw.canvas.core.Canvas;
import com.draw.canvas.exception.DrawCanvasException;

import static com.draw.canvas.util.CanvasCostant.CMD_CREATE_CANVAS;

/**
 * Command used by the canvas for creating a new Canvas
 */
public class CanvasInstructionsCreateNewCanvas extends CanvasInstructions {
	
	private int weight;
	private int height;
	private Canvas canvas;
	
	private CanvasInstructionsCreateNewCanvas() {
		name = CMD_CREATE_CANVAS;
	}
	
	public CanvasInstructionsCreateNewCanvas(int w, int h) {
		this();
		weight = w;
		height = h;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void execute() throws DrawCanvasException {
		canvas = new Canvas(weight, height);		
	}
	
	@Override
	public Canvas getCanvas() {
		return canvas;
	}

	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
}
