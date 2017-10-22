# Game Systems 101

## Events

`Events` are triggers fired when a certain action occurs (think of Events in the [**GameMaker Series**](https://www.yoyogames.com/gamemaker)). They can be listened to by your `Game System`, and be acted to. As of **n00blib v1.11**, `Game System`s have 14 different `Event`s:

`gameStart()`  
This is pretty self explanatory, isn't it? It fires when the game starts.

`gameEnd()`  
Also pretty self explanatory. It fires when the game ends.  
!> Note that the `gameEnd()` event only fires when the **x** button is pressed closing the window. It **does not** fire when you make a custom "Exit Game" button, and call `exit(0)` from there.

`draw(GL2 gl)`  
It is triggered every frame, after update(). Use this event and only this event to draw things. Calling `super.draw(gl)` form here will call the `draw(GL2 gl)` method of all the `Object`s in game.  
?> Think of the draw event in the [**GameMaker Series**](https://www.yoyogames.com/gamemaker).

`update()`  
It is triggered every frame, before draw(GL2 gl). Use it to update game elements. Calling `super.update()` form here will call the `update()` method of all the `Object`s in game.  
?> Think of the step event in the [**GameMaker Series**](https://www.yoyogames.com/gamemaker).

`mouseWheelUp()`  
It is triggered whenever a full upwards "click" occurs on your mouse wheel.  
?> Some mouses support a smooth partial "click". In that case, only full "click"s will trigger the `mouseWheelUp()` event.

`mouseWheelDown()`  
It is triggered whenever a full downwards "click" occurs on your mouse wheel.  
?> Some mouses support a smooth partial "click". In that case, only full "click"s will trigger the `mouseWheelDown()` event.  
?> Please provide an option to change the controls if you use this as a control for your game

`mouseLeftPressed()`
It is triggered each time the left mouse button is pressed.

`mouseLeftReleased()`
It is triggered each time the left mouse button is released.

`mouseRightPressed()`
It is triggered each time the right mouse button is pressed.

`mouseRightReleased()`
It is triggered each time the right mouse button is released.

`mouseMiddlePressed()`
It is triggered each time the middle mouse button (mouse wheel) is pressed.  
?> I recommend not using this as a control in your game, or at least providing a option to change it if you do use it, because some mouses (and most mousepads) don't have the middle mouse button.

`mouseMiddleReleased()`
It is triggered each time the middle mouse button (mouse wheel) is released.  
?> I recommend not using this as a control in your game, or at least providing a option to change it if you do use it, because some mouses (and most mousepads) don't have the middle mouse button.

`keyPressed(int keyCode)`
It is triggered whenever a key is pressed.  
?> The `KeyEvent.VK_*` constants store the different key codes.

`keyReleased(int keyCode)`
It is triggered whenever a key is released.  
?> The `KeyEvent.VK_*` constants store the different key codes.

## Code Example

So those are all the events for your `Game System`. You can use them like this :

    import com.n00blib.general.GameSystem;

    public class MyGameSystem extends GameSystem {
      public void EVENT_NAME(EVENT_ARGUMENTS_IF_ANY) {
        // WHATEVER YOU WANT EVENT_NAME TO EXECUTE
      }
    }

If you are an observant person, you might've realized that I've been using the word `Object` quite often. But what are `Object`s? Let's get into those next.
