package com.draw.canvas.cmd.factory;

import com.draw.canvas.cmd.*;
import com.draw.canvas.core.Canvas;
import com.draw.canvas.exception.DrawCanvasException;

import static com.draw.canvas.util.CanvasCostant.*;

/**
 * Factory implementation for creating Command objects.
 */
public class CanvasInstructionsFactoryImpl implements CanvasInstructionsFactory {
	 
	@Override 
	public CanvasInstructions buildCommand(String line, Canvas canvas) throws DrawCanvasException {
		CanvasInstructions cmd = null;
		line = line.trim();
		String sp[] = line.split("\\s+");//one or more space
		if (sp.length == 0) {
			throw new DrawCanvasException(ERROR_WRONG_INSTRUCTION);
		}
		switch (sp[0].toUpperCase())
		{
			case  CMD_CREATE_CANVAS:
				cmd = createCanvasObj(sp);
				break;
			case  CMD_LINE:
				cmd = createLineObj(sp, canvas);
				break;
			case  CMD_RECTANGLE:
				cmd = createRectangleObj(sp, canvas);
				break;
			case  CMD_FILL:
				cmd = createFillObj(sp, canvas);
				break;
			case  CMD_QUITE:
				cmd = new CanvasInstructionsQuite(canvas);
				break;
			case  CMD_HELP:
				cmd = new CanvasInstructionsHelp(canvas);
				break;
			case  CMD_CLEAR:
				cmd = new CanvasInstructionsClearCanvas(canvas);
				break;
			default:
				throw new DrawCanvasException(ERROR_INSTRUCTION_NOT_FOUND);
		}
		return cmd;
	}
	private CanvasInstructions createCanvasObj(String sp[]) throws DrawCanvasException {
		// C w h
		CanvasInstructions cmd = null;
		if (sp.length != 3) {
			throw new DrawCanvasException(ERROR_WRONG_CREATE);
		} else {
			try {
				int w = Integer.parseInt(sp[1]);
				int h = Integer.parseInt(sp[2]);
				return new CanvasInstructionsCreateNewCanvas(w, h);
			} catch (Exception e) {
				throw new DrawCanvasException(ERROR_CANVAS_WH_NUMBER_ONLY);
			}
		}
	}
	private CanvasInstructions createLineObj(String sp[], Canvas canvas) throws DrawCanvasException {
		// L x1 y1 x2 y2
		if (sp.length != 5) {
			throw new DrawCanvasException(ERROR_LINE_PARAM);
		} else {
			try {
				int x1 = Integer.parseInt(sp[1]);
				int y1 = Integer.parseInt(sp[2]);
				int x2 = Integer.parseInt(sp[3]);
				int y2 = Integer.parseInt(sp[4]);
				return new CanvasInstructionsLine(x1, y1, x2, y2, canvas);
			} catch (Exception e) {
				throw new DrawCanvasException(ERROR_LINE_PARAM_NUMBER_ONLY);
			}
		}
	}
	private CanvasInstructions createRectangleObj(String sp[], Canvas canvas) throws DrawCanvasException{
		// R x1 y1 x2 y2
		CanvasInstructions cmd = null;
		if (sp.length != 5) {
			throw new DrawCanvasException(ERROR_RACT_PARAM);
		} else {
			try {
				int x1 = Integer.parseInt(sp[1]);
				int y1 = Integer.parseInt(sp[2]);
				int x2 = Integer.parseInt(sp[3]);
				int y2 = Integer.parseInt(sp[4]);
				return new CanvasInstructionsRectangle(x1, y1, x2, y2, canvas);
			} catch (Exception e) {
				throw new DrawCanvasException(ERROR_RACT_PARAM_NUMBER_ONLY);
			}
		}
	}
	private CanvasInstructions createFillObj(String sp[], Canvas canvas) throws DrawCanvasException {
		// B x y c
		if (sp.length != 4) {
			throw new DrawCanvasException(ERROR_FILL_PARAM);
		} else {
			int x = -1;
			int y = -1;
			try{
				x = Integer.parseInt(sp[1]);
				y = Integer.parseInt(sp[2]);
			} catch (Exception e) {
				throw new DrawCanvasException(ERROR_FILL_PARAM_NUMBER_ONLY);
			}

			String color = sp[3];
			if(color.length() > 1){
				throw new DrawCanvasException(ERROR_COL_PARAM);
			}
			return new CanvasInstructionsBucketFill(x, y, color, canvas);
		}
	}
}
