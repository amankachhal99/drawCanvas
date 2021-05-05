package com.draw.canvas;

import com.draw.canvas.cmd.CanvasInstructions;
import com.draw.canvas.cmd.CanvasInstructionsBucketFill;
import com.draw.canvas.cmd.CanvasInstructionsLine;
import com.draw.canvas.cmd.CanvasInstructionsRectangle;
import com.draw.canvas.core.Canvas;
import com.draw.canvas.exception.DrawCanvasException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * In this class are traced use cases which introduced errors in the test phase.
 */
public class UseCaseTest extends CanvasInstructionsTest {

	@After
	public void drillDown() {
		canvas.clearCanvas();
	}

	@Test
	public void testHP_ParseBucketFillCommand() throws DrawCanvasException {
		String cmdLine = "B 2 3 a";
		CanvasInstructions cmd = commandFactory.buildCommand(cmdLine, canvas);

		assertNotNull(cmd);
		assertTrue(cmd instanceof CanvasInstructionsBucketFill);
	}

	@Test(expected = DrawCanvasException.class)
	public void testEX_ParseBucketFilldWrongColor() throws DrawCanvasException {
		String cmdLine = "B 2 3 add";
		commandFactory.buildCommand(cmdLine, canvas);
	}

	@Test
	public void testHP_1() throws DrawCanvasException {
		CanvasInstructionsLine l = new CanvasInstructionsLine(1, 1, 18, 1, canvas);
		int stars = (18 - 1) + 1;
		canvas.insertLine(l);
		canvas.printCanvas();
		assertExpected(canvas, stars);

		l = new CanvasInstructionsLine(3, 2, 3, 3, canvas);
		stars = stars + 2;
		canvas.insertLine(l);
		canvas.printCanvas();
		assertExpected(canvas,stars);

		CanvasInstructionsRectangle r = new CanvasInstructionsRectangle(3, 2, 8, 3, canvas);
		stars = stars + 10;
		canvas.insertRectangle(r);
		canvas.printCanvas();
		assertExpected(canvas,stars);
	}
	
	@Test(expected = DrawCanvasException.class)
	public void testEX_newCanvasExceedWidthDimmension() throws DrawCanvasException {
		canvas = new Canvas(201, 10);
	}
	@Test(expected = DrawCanvasException.class)
	public void testEX_newCanvasExceedHeightDimmension() throws DrawCanvasException {
		canvas = new Canvas(10, 51);
	}
	@Test(expected = DrawCanvasException.class)
	public void testEX_newCanvasExceedWidthDimmension_secondCostructor() throws DrawCanvasException {
		canvas = new Canvas(201, 10, new String[201][10]);
	}
	@Test(expected = DrawCanvasException.class)
	public void testEX_newCanvasExceedHeightDimmension_secondCostructor() throws DrawCanvasException {
		canvas = new Canvas(10, 51);
		canvas = new Canvas(10, 51, new String[10][51]);
	}
	
}