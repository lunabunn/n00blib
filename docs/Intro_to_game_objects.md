# Introduction to Game Objects

## What is a Game Object?
A Game Object is a n00blib class that is (in most cases) created and dealt with by the main class of your n00blib project. It initializes and runs your game.

## How do I create a Game Object?
First, you need to create a class that will create the Game Object. I will call it `MyGame`-it will be the main class of my program.

	public class MyGame {
		public static void main(String[] args) {

		}
	}

Then we can create a Game Object. First import `com.n00blib.general.Game`...

	import com.n00blib.general.Game;

	public class MyGame {
		public static void main(String[] args) {

		}
	}

Then create a Game Object.

	import com.n00blib.general.Game;

	public class MyGame {
		public static void main(String[] args) {
			Game game = new Game();
		}
	}

Once you have created a Game Object, you can tell it to launch your game by calling `Game.launch()`.

	import com.n00blib.general.Game;

	public class MyGame {
		public static void main(String[] args) {
			Game game = new Game();
			game.launch();
		}
	}

Now compile your program. It should display a window, if you followed all the steps correctly.
