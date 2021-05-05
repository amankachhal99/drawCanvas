package com.draw.canvas;

import com.draw.canvas.cmd.factory.CanvasInstructionsFactory;
import com.draw.canvas.cmd.factory.CanvasInstructionsFactoryImpl;
import com.draw.canvas.core.Canvas;
import com.draw.canvas.exception.DrawCanvasException;
import com.draw.canvas.util.CanvasCostant;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

public abstract class CanvasInstructionsTest {
	
	protected static final transient Log logger = LogFactory.getLog(CanvasInstructionsTest.class);
	protected Canvas canvas;
	protected int width = 20;
	protected int height = 4;
	protected CanvasInstructionsFactory commandFactory;

	@Before
	public void setUp() {
		commandFactory = new CanvasInstructionsFactoryImpl();
		try {
			canvas = new Canvas(width, height);
		} catch (DrawCanvasException e) {
			logger.error("Exception initializing Canvas: " + e.getMessage(), e);
		}
	}

	@After
	public void drillDown() {
		canvas.printCanvas();
		canvas.clearCanvas();
	}

	/**
	 * Counts the 'pixels' present in the canvas and compare it with the expected value.
	 */
	protected void assertExpected(Canvas canvas, String pixels, int expected) throws DrawCanvasException {
		String mat[][] = canvas.getMatrix();
		int found = 0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				// count all the 'x' (or 'o') present in the matrix.
				if (mat[i][j].equals(pixels)) {
					found++;
				}
			}
		}

		assertEquals(expected, found);
	}
	
	protected void assertExpected(Canvas canvas, int expected) throws DrawCanvasException {
		assertExpected(canvas, CanvasCostant.PIXEL, expected);
	}
	
}
