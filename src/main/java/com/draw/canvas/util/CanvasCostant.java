package com.draw.canvas.util;

/**
 * Constants used by the application
 */
public class CanvasCostant {

	public final static String CMD_CREATE_CANVAS = "C";
	public final static String CMD_LINE      = "L";
	public final static String CMD_RECTANGLE = "R";
	public final static String CMD_FILL      = "B";
	public final static String CMD_QUITE     = "Q";
	public final static String CMD_HELP      = "H";
	public final static String CMD_CLEAR      = "X";
	public final static String PIXEL = "x";

	public final static String ERROR_CREATE_NEW_CANVAS = "First create a new Canvas using 'C' command.";
	public final static String ERROR_CREATE_MINMAX_CANVAS = "Dimension for new canvas must be maximum: 200 x 50.";
	public final static String ERROR_QUITING_DRAW_CANVAS = "Quiting the game!";
	public final static String ERROR_CANVAS_WH_NUMBER_ONLY = "Weight and Height must be numbers! Example: 'C 40 20'";
	public final static String ERROR_LINE_PARAM_NUMBER_ONLY = "Coordinates must be numbers! Example: 'L 1 1 9 1'";
	public final static String ERROR_RACT_PARAM_NUMBER_ONLY = "Coordinates must be numbers! Example: 'R 1 1 9 4'";
	public final static String ERROR_FILL_PARAM_NUMBER_ONLY = "Coordinates must be numbers! Example: 'B 2 3 c'";
	public final static String ERROR_LINE_PARAM = "Wrong Parameters! For drawing a line try 'L x1 y1 x2 y2',  example: 'L 1 2 6 2'";
	public final static String ERROR_RACT_PARAM = "Wrong Parameters! For drawing a Rectangle try 'R x1 y1 x2 y2',  example: 'R 1 1 6 3'";
	public final static String ERROR_FILL_PARAM = "Wrong Parameters! For filling an area try 'B x1 y1 color',  example: 'B 2 3 c'";
	public final static String ERROR_COL_PARAM = "Wrong Parameters! Color must be a single character. Example: 'B 2 3 c'";
	public final static String ERROR_WRONG_INSTRUCTION = "Wrong command! Try one of the following: C w h; L x1 y1 x2 y2; R x1 y1 x2 y2; B x y c or Q for quit.";
	public final static String ERROR_WRONG_CREATE = "Wrong Parameters! For creating new canvas try 'C w h',  example: 'C 40 20'";
	public final static String ERROR_INSTRUCTION_NOT_FOUND = "Command not found! The line must start with letter: 'C', 'L', 'R, 'B' or 'Q' for exit.";

	public final static String HELP_TEXT = "************ OPTIONS *************" + "\n" +
			"C w h - Create a new canvas of width w and height h." + "\n" +
			"L x1 y1 x2 y2 - Create a new line from (x1,y1) to (x2,y2)." + "\n" +
			"R x1 y1 x2 y2 - Create a new rectangle, whose upper left corner is (x1,y1) and lower right corner is (x2,y2)." + "\n" +
			"B x y c - Fill the area connected to (x,y) with 'color' c." + "\n" +
			"X - Clear the canvas." + "\n" +
			"H - Help." + "\n" +
			"Q - Quit the program." + "\n" +
			"**********************************" + "\n";

}
