package com.draw.canvas.core;

import com.draw.canvas.cmd.CanvasInstructionsBucketFill;
import com.draw.canvas.cmd.CanvasInstructionsLine;
import com.draw.canvas.cmd.CanvasInstructionsRectangle;
import com.draw.canvas.exception.DrawCanvasException;
import com.draw.canvas.util.CanvasCostant;

public class Canvas {

	public boolean isCanvasInitialized = true;
	private int width;
	private int height;
	private String matrix[][];
	
	public Canvas(int w, int h, String matrix[][]) throws DrawCanvasException {
		validateMinMaxCannvas(w, h);
		this.width = w;
		this.height = h;
		this.matrix = matrix;
	}

	public Canvas(int w, int h) throws DrawCanvasException {
		validateMinMaxCannvas(w, h);
		width = w;
		height = h;
		matrix = new String[height][width];
		resetMatrix();
	}
	
	private void validateMinMaxCannvas(int width, int height) throws DrawCanvasException {
		if (width > 200 || height > 50) {
			throw new DrawCanvasException(CanvasCostant.ERROR_CREATE_MINMAX_CANVAS);
		}
	}

	public void clearCanvas() {
		resetMatrix();
	}
	
	private void resetMatrix() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				matrix[i][j] = " ";
			}
		}
	}
	
	public void printCanvas() {
		// first row ----------
		for (int j = 0; j < width + 2; j++) {
			System.out.print("-");
		}
		System.out.println();

		// the body of the canvas | **** |
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width + 2; j++) {
				if (j == 0 || j == width + 1) {
					System.out.print("|");
				} else {
					System.out.print(matrix[i][j - 1]);
				}
			}
			System.out.println();
		}

		// footer --------
		for (int j = 0; j < width + 2; j++) {
			System.out.print("-");
		}
		System.out.println("\n");
	}

	/**
	 * Insert a Line in the canvas. </br>
	 * 1. Validate the input </br>
	 * 2. Insert the line </br>
	 * 
	 * @param cmd Command containing x1, y1, x2, y2 for inserting new line.
	 * @throws DrawCanvasException
	 */
	public void insertLine(CanvasInstructionsLine cmd) throws DrawCanvasException {

		validateInputNewLine(cmd);

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				// horizontal line from X1 to X2 (shift +1 to match user input)
				if ((j + 1) >= cmd.getX1() && (j + 1) <= cmd.getX2() && (i + 1) == cmd.getY1()) {
					matrix[i][j] = CanvasCostant.PIXEL;
				}
				// vertical line from Y1 to Y2 (shift +1 to match user input)
				if ((i + 1) >= cmd.getY1() && (i + 1) <= cmd.getY2() && (j + 1) == cmd.getX1()) {
					matrix[i][j] = CanvasCostant.PIXEL;
				}
			}
		}
	}

	private void validateInputNewLine(CanvasInstructionsLine cmd) throws DrawCanvasException {
		if (cmd.getX1() > cmd.getX2() || cmd.getY1() > cmd.getY2()) {
			throw new DrawCanvasException("The coordinates must be congruent: (x1 < x2 && y1 < y2)");
		}

		// if Y1!=Y2 than X1 must be equal to X2 => case of vertical line
		// if X1!=X2 than Y1 must be equal to Y2 => case of horizontal line
		// X1=X2 and Y1=Y2 => case of a line with a single point (single '*')
		if (!((cmd.getX1() == cmd.getX2() && cmd.getY1() != cmd.getY2()) || (cmd.getY1() == cmd.getY2() && cmd.getX1() != cmd.getX2()))
				&& !(cmd.getX1() == cmd.getX2() && cmd.getY1() == cmd.getY2())) {
			throw new DrawCanvasException("You can draw only horizontal lines: (x1==x2 || y1 == y2)");
		}

		if (cmd.getX1() <= 0 || cmd.getX2() > getWidth() || cmd.getY1() <= 0 || cmd.getY2() > getHeight()) {
			throw new DrawCanvasException("The coordinates must be inside the canvas: (x > 0 && x <= " + width + ") && (y > 0 && y <= " + height + ")");
		}
	}

	/**
	 * Insert a Rectangle in the canvas. </br>
	 * 1. Validate the input </br>
	 * 2. Insert the Rectangle </br>
	 * 
	 * @param cmd Command containing x1, y1, x2, y2 for inserting a rectangle, whose upper left corner is (x1,y1) 
	 * 			  and lower right corner is (x2,y2)
	 * @throws DrawCanvasException
	 */
	public void insertRectangle(CanvasInstructionsRectangle cmd) throws DrawCanvasException {

		validateInputRectangle(cmd);

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				// horizontal line from X1 to X2 (shift +1 to match user input)
				// in case we are in the first row(Y1) or in the second row(Y2)
				if ((j + 1) >= cmd.getX1() && (j + 1) <= cmd.getX2() && ((i + 1) == cmd.getY1() || (i + 1) == cmd.getY2())) {
					matrix[i][j] = CanvasCostant.PIXEL;
				}

				// vertical line from Y1 to Y2 (shift +1 to match user input)
				// where we are in the first column(X1) or second column(X2)
				if ((i + 1) >= cmd.getY1() && (i + 1) <= cmd.getY2() && ((j + 1) == cmd.getX1() || (j + 1) == cmd.getX2())) {
					matrix[i][j] = CanvasCostant.PIXEL;
				}
			}
		}
	}

	private void validateInputRectangle(CanvasInstructionsRectangle cmd) throws DrawCanvasException {
		if (cmd.getX1() > cmd.getX2() || cmd.getY1() > cmd.getY2()) {
			throw new DrawCanvasException("The coordinates must be congruent: (x1 < x2 && y1 < y2)");
		}

		if (cmd.getX1() <= 0 || cmd.getX2() > getWidth() || cmd.getY1() <= 0 || cmd.getY2() > getHeight()) {
			throw new DrawCanvasException("The coordinates must be inside the canvas: (x > 0 && x <=" + width + ") && (y > 0 && y <= " + height + ")");
		}
	}

	/**
	 * Fill the area connected to the coordinate passed as parameter.
	 * 
	 * @param cmd
	 *            Command containing the "pixel" (x, y) where to start for "filling the bucket"
	 * @throws DrawCanvasException
	 */
	public void fillBucket(CanvasInstructionsBucketFill cmd) throws DrawCanvasException {
		validateInputFillBucket(cmd);

		fillSinglePixelAndExpand(cmd.getX() - 1, cmd.getY() - 1, cmd.getColor());
	}

	/**
	 * The strategy to fill the area is the following: 1. Insert the "pixel" in the current coordinate. 2. Do the same with 4
	 * coordinates adjacent to the actual; call recursively the method. 3. Stop when finding borders or a coordinate already
	 * "painted" with 'x' or 'color'
	 * 
	 * @param x coordinate x
	 * @param y coordinate y
	 * @param color color to use for painting the area. Can be any single character as String
	 * @throws DrawCanvasException
	 */
	private void fillSinglePixelAndExpand(int x, int y, String color) throws DrawCanvasException {
		// Stops when finds borders
		if (x < 0 || x >= width || y < 0 || y >= height) {
			return;
		}
		// stops where find other pixel inserted
		if (matrix[y][x].equals(CanvasCostant.PIXEL) || matrix[y][x].equals(color)) {
			return;
		}

		matrix[y][x] = color;
		// printStatusCanvas();

		fillSinglePixelAndExpand(x + 1, y, color);
		fillSinglePixelAndExpand(x, y + 1, color);
		fillSinglePixelAndExpand(x - 1, y, color);
		fillSinglePixelAndExpand(x, y - 1, color);
	}

	private void validateInputFillBucket(CanvasInstructionsBucketFill cmd) throws DrawCanvasException {
		if (cmd.getX() <= 0 || cmd.getX() > getWidth() || cmd.getY() <= 0 || cmd.getY() > getHeight()) {
			throw new DrawCanvasException("The coordinates must be inside the canvas: (x > 0 && x <= " + width + ") && (y > 0 && y <= " + height + ")");
		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public String[][] getMatrix() {
		return matrix;
	}

	public void setCanvasInitialized(boolean canvasInitialized) {
		this.isCanvasInitialized = canvasInitialized;
	}

	public boolean isCanvasInitialized() {
		return isCanvasInitialized;
	}

	public String toString() {
		String res = "";
		// first row ----------
		for (int j = 0; j < width + 2; j++) {
			res = res + "-";
		}
		res = res + "\n";

		// the body of the canvas | **** |
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width + 2; j++) {
				if (j == 0 || j == width + 1) {
					res = res + "|";
				} else {
					res = res + matrix[i][j - 1];
				}
			}
			res = res + "\n";
		}

		// footer --------
		for (int j = 0; j < width + 2; j++) {
			res = res + "-";
		}
		return res;
	}

}