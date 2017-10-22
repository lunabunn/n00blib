# Customizing Game Objects
We know how to make a Game Object. But when you launch a Game Object without customizing it, all you'll see is a lame window with text.

![Lame!](/Basics/gameobject_default.png)

## So how do I customize my Game Object?

There are many methods that let you customize the looks of your game window :

`Game.setSize(int w, int h)`  
Sets the size of the Game Window to `int w*int h`.

`Game.setSize(Dimension d)`  
Sets the size of the Game Window to the size of `Dimension d`

`Game.setTitle(String title)`  
Sets the title of the Game Window to `String title`.

`Game.setFPS(int fps)`  
Sets the FPS of the Game Object to `int fps`.

...but none of these methods actually deal with the actual **content** of the game. What actually deals with the actual content of the game is...

`Game.setGameSystem(GameSystem system)`  
Sets the `Game System` of the Game Object.

What? Game System? What is that? We will learn about that next.
