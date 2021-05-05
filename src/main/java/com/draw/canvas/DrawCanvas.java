package com.draw.canvas;

import static com.draw.canvas.util.CanvasCostant.CMD_HELP;

import java.io.Closeable;
import java.util.Scanner;

import com.draw.canvas.util.CanvasCostant;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.draw.canvas.cmd.CanvasInstructions;
import com.draw.canvas.cmd.factory.CanvasInstructionsFactory;
import com.draw.canvas.cmd.factory.CanvasInstructionsFactoryImpl;
import com.draw.canvas.core.Canvas;
import com.draw.canvas.exception.DrawCanvasException;

/**
 * Main class for starting the application. Tests the application in an interactive mode.
 */
public class DrawCanvas {

    protected static final transient Log logger = LogFactory.getLog(DrawCanvas.class);
    private Scanner scanner;
    private CanvasInstructionsFactory canvasInstructionsFactory;
    private CanvasInstructions canvasInstructions;

    public DrawCanvas(){
        canvasInstructionsFactory = new CanvasInstructionsFactoryImpl();
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        DrawCanvas drawCanvas = new DrawCanvas();
        drawCanvas.run();
    }

    private void run() {
        boolean isExit = false;
        Canvas canvas = null;
        do {
            try {
                System.out.print("Insert command: ");
                String line = scanner.nextLine();
                canvasInstructions = canvasInstructionsFactory.buildCommand(line, canvas);
                canvasInstructions.execute();
                canvas = canvasInstructions.getCanvas();
                if (canvas != null)
                    canvas.printCanvas();
            } catch (DrawCanvasException e) {
                if(e.getMessage() != null && e.getMessage().equalsIgnoreCase(CanvasCostant.ERROR_QUITING_DRAW_CANVAS)){
                    isExit = true;
                    System.out.println("Thank you for trying out Canvas App! Bye...");
                } else {
                    logger.error("DrawCanvasException: " + e.getMessage(), e);
                    System.out.println("Canvas Exception: " + e.getMessage());
                    System.out.println("Insert '" + CMD_HELP + "' for Help.\n");
                }
            } catch (Exception e) {
                logger.error("General Exception: " + e.getMessage(), e);
                System.out.println("General Exception: " + e.getMessage());
                System.out.println("Insert '" + CMD_HELP + "' for Help.\n");
            }
        } while (!isExit);

        closeResource(scanner);
    }

    /**
     * Close the Scanner
     */
    private static void closeResource(Closeable sc) {
        try {
            sc.close();
        } catch (Exception e) {
            logger.error("Error closing the console: " + e.getMessage(), e);
            System.out.println("Cannot close the console! e: " + e.getMessage());
        }
    }

}
