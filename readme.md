# The Challenge
You're given the task of writing a simple console version of a drawing program. In a nutshell, the program should work as follows:
1. create a new canvas
2. start drawing on the canvas by issuing various commands
3. quit

At the moment, the program should support the following commands:
- __C w h__ Should create a new canvas of width w and height h.
- __L x1 y1 x2 y2__ Should create a new line from _(x1,y1)_ to _(x2,y2)_. Currently only horizontal or vertical lines are - supported. Horizontal and vertical lines will be drawn using the 'x' character.
- __R x1 y1 x2 y2__ Should create a new rectangle, whose upper left corner is _(x1,y1)_ and lower right corner is _(x2,y2)_. Horizontal and vertical lines will be drawn using the 'x' character.
- __B x y c__ Should fill the entire area connected to (x,y) with "colour" c. The behaviour of this is the same as that of the "bucket fill" tool in paint programs.
- __Q__ Should quit the program.

###	A Working build
Using maven plugin `maven-jar-plugin` we can package our application in `canvas.jar`.
If you want to create a new jar use:
```
mvn clean install
```

A working build is present in the path `./dist`:
- `canvas.jar` -> application packaged as a jar file.
- `canvas.bat` -> easy and fast way to test the application.

Run: 
```
cd /yourpath/canvas/dist
canvas.bat
```