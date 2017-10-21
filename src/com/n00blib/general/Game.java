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

import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;

import javax.swing.JFrame;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;

public class Game {
	public String title = "Game Engine 1.0";
	public int width = 640;
	public int height = 480;
	public int fps = 60;
	public GameSystem system = null; // For instances of customized classes that override GameSystem
	
	public GLCanvas initGamePane(GameMaster master, int width, int height) {
		GLProfile profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities capabilities = new GLCapabilities(profile);
		GLCanvas canvas = new GLCanvas(capabilities);
		canvas.setSize(width, height);
		canvas.addGLEventListener((GLEventListener) master);
		canvas.addKeyListener((KeyListener) master);
		canvas.addMouseListener((MouseListener) master);
		canvas.addMouseWheelListener((MouseWheelListener) master);
		canvas.addMouseMotionListener((MouseMotionListener) master);
		canvas.setFocusable(true);
		canvas.requestFocus();
		
		return canvas;
	}
	
	public void initGameWindow(GLCanvas canvas) {
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(canvas);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public void setGameSystem(GameSystem system) {
		this.system = system;
	}
	
	public void setSize(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public void setSize(Dimension d) {
		this.width = (int) d.getWidth();
		this.height = (int) d.getHeight();
	}
	
	public void setFPS(int fps) {
		this.fps = fps;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void launch() {
		GameSystem system;
		
		if (this.system == null) {system = new GameSystem.Demo();}
		else {system = this.system;}
		
		GLCanvas gamePane = initGamePane(new GameMaster(system, fps), width, height);
		initGameWindow(gamePane);
	}
}
