# Introduction to Game Systems

In this tutorial, you will learn what a Game System is, and how to create it.

## What is a Game System?
A Game System is a **n00blib** class that is basically a event listener/handler for your game. If you are familiar with the [**GameMaker Series**](https://www.yoyogames.com/gamemaker), think of the Game System in n00blib as a system object that has all the events like Game Start, Step, Draw, and etc. and directly executes all other objects' methods-except it does not have `x` or `y` or `vspeed` or any of that. If you are familiar with Java2D game programming, the `Game System` is like the `JPanel`, that manages all objects of the game; if you are familiar with `JOGL` game programming, the `Game System` is like a simplified version of the `GLEventListener`.

## How do I create a Game System?
First, you need to create a class that will `extends` the `com.n00blib.general.GameSystem` class.

	import com.n00blib.general.GameSystem;

	public class MyGameSystem extends GameSystem {

	}

Simple enough. Then, we go back to the main class (or whatever class that initializes your Game Object) and, before `launch()`, insert `setGameSystem(new YOUR_GAME_SYSTEM_CLASS_NAME())`.

	import com.n00blib.general.Game;

	public class MyGame {
		public static void main(String[] args) {
			Game game = new Game();
			game.setGameSystem(new MyGameSystem());
			game.launch();
		}
	}

There. Now, launch your game. You should, if you followed all the steps correctly, see a blank, black window. Wait what? That's even lamer then the white window with blue text! We will learn how to add stuff to your black window next time.
