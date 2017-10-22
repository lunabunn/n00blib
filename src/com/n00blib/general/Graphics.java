package com.n00blib.general;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;

public class Graphics {
	GL2 gl;
	GameMaster master;
	
	public Graphics(GL2 gl, GameMaster master) {
		this.gl = gl;
		this.master = master;
	}
	
	public GL getGL() {
		return gl.getGL();
	}
	
	public GL2 getGL2() {
		return gl;
	}
	
	public void drawString(int x, int y, String string) {
		String[] strings = string.split("\n");
		int height = (int) master.renderer.getBounds("THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG").getHeight();
		master.renderer.beginRendering(master.drawable.getSurfaceWidth(), master.drawable.getSurfaceHeight());
		for (int i=0; i<strings.length; i++) {
			master.renderer.draw(strings[i], x, master.drawable.getSurfaceHeight() - y - (height*(i+1)) - 5*i);
		}
		master.renderer.endRendering();
	}
	
	public void drawRect(int x1, int y1, int x2, int y2) {
		gl.glBegin(GL2.GL_QUADS);
		gl.glVertex2i(x1, y1);
		gl.glVertex2i(x2, y1);
		gl.glVertex2i(x2, y2);
		gl.glVertex2i(x1, y2);
		gl.glEnd();
	}
	
	public void drawRect(double x1, double y1, double x2, double y2) {
		gl.glBegin(GL2.GL_QUADS);
		gl.glVertex2d(x1, y1);
		gl.glVertex2d(x2, y1);
		gl.glVertex2d(x2, y2);
		gl.glVertex2d(x1, y2);
		gl.glEnd();
	}
	
	public void setColor(float r, float g, float b, float a) {
		master.renderer.setColor(r, g, b, a);
		master.drawable.getGL().getGL2().glColor4f(r, g, b, a);
	}
}
