# Introduction
There are 3 classes in **n00blib** that you absolutely have to know about to make a game using **n00blib**. The 3 classes are `Game`, `GameSystem`, and `Object`...

<code><h2>Game</h2></code>
The `Game` class, also called a Game Object, is a n00blib class that is (in most cases) created and dealt with by the main class of your n00blib project. It initializes and runs your game.

<code><h2>GameSystem</h2></code>
The `GameSystem` class, also called a Game System, is a **n00blib** class that is basically a event listener/handler for your game. If you are familiar with the [**GameMaker Series**](https://www.yoyogames.com/gamemaker), think of the Game System in n00blib as a system object that has all the events like Game Start, Step, Draw, and etc. and directly executes all other objects' methods-except it does not have `x` or `y` or `vspeed` or any of that. If you are familiar with Java2D game programming, the `Game System` is like the `JPanel`, that manages all objects of the game; if you are familiar with `JOGL` game programming, the `Game System` is like a simplified version of the `GLEventListener`.

<code><h2>Object</h2></code>
The `Object` class is a n00blib class that every ingame object (the player, the enemy, the blocks, the whatever...) `extends`. They calculate their movement deltas and collision, and move accordingly.

So. Are you ready to dive into the details? Click [here](https://maiorexminor.github.io/n00blib/#/Basics/Intro_to_game_objects) when you are.
