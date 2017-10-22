/*
 * n00blib
 * A simple, lightweight Java game library built by a n00b, for a n00b.
 * 
 * https://github.com/maiorexminor/n00blib
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */

package com.n00blib.general;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.SwingUtilities;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.util.awt.TextRenderer;

public class GameMaster implements GLEventListener, KeyListener, MouseListener, MouseWheelListener, MouseMotionListener {
	
	public GameSystem system;
	public int fps;
	
	public FPSAnimator animator;
	
	public TextRenderer renderer;
	
	public GLAutoDrawable drawable;
	
	public int mouseX = 0, mouseY = 0;
	
	public GameMaster(GameSystem system, int fps) {
		this.system = system;
		system.master = this;
		this.fps = fps;
	}
	
	@Override
	public void init(GLAutoDrawable drawable) {
		animator = new FPSAnimator(drawable, fps);
		animator.start();
		renderer = new TextRenderer(new Font(Font.SANS_SERIF, Font.PLAIN, 16), true, true, null, true);
		renderer.setColor(0, 0, 0, 1);
		
		drawable.getGL().getGL2().glOrtho(0, drawable.getSurfaceWidth(), drawable.getSurfaceHeight(), 0, 1, -1);
		
		system.gameStart();
	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void display(GLAutoDrawable drawable) {
		system.update();
		this.drawable = drawable;
		GL2 gl = drawable.getGL().getGL2();
		gl.glClearColor(0, 0, 0, 1);
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
		gl.glClear(GL2.GL_DEPTH_BUFFER_BIT);
		system.draw(new Graphics(gl, this));
		
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			system.mouseLeftPressed();
		}
		
		if (SwingUtilities.isMiddleMouseButton(e)) {
			system.mouseMiddlePressed();
		}
		
		if (SwingUtilities.isRightMouseButton(e)) {
			system.mouseRightPressed();
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			system.mouseLeftReleased();
		}
		
		if (SwingUtilities.isMiddleMouseButton(e)) {
			system.mouseMiddleReleased();
		}
		
		if (SwingUtilities.isRightMouseButton(e)) {
			system.mouseRightReleased();
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		system.keyPressed(e.getKeyCode());
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		system.keyReleased(e.getKeyCode());
		
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		for (int i=0; i<Math.abs(e.getWheelRotation()); i++) {
			if (e.getWheelRotation() > 0) {system.mouseWheelDown();}
			else if (e.getWheelRotation() < 0) {system.mouseWheelUp();}
		}
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		
	}

}
