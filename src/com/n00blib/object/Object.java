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

package com.n00blib.object;


import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import com.n00blib.general.GameMaster;
import com.n00blib.general.GameSystem;
import com.n00blib.general.Graphics;

public abstract class Object {
	public double x, y, dx, dy, depth;
	public boolean solid;
	public Rectangle2D.Double box;
	public static ArrayList<Object> objects = new ArrayList<Object>();
	public GameSystem system;
	public GameMaster master;
	
	public Object(double x, double y, double depth, boolean solid, GameSystem system) {
		this.x = x;
		this.y = y;
		this.depth = depth;
		this.solid = solid;
		
		this.system = system;
		this.master = system.master;
		
		dx = 0;
		dy = 0;
		
		objects.add(this);
	}
	
	public void setMask(double x, double y, double w, double h) {
		box = new Rectangle2D.Double(x, y, w, h);
	}
	
	public boolean doesCollide(double x, double y, Object other) {
		Rectangle2D.Double r1 = new Rectangle2D.Double(x + box.getX(), y + box.getY(), box.getWidth(), box.getHeight());
		Rectangle2D.Double r2 = new Rectangle2D.Double(other.x + other.box.getX(), other.y + other.box.getY(), other.box.getWidth(), other.box.getHeight());
		
		return r1.intersects(r2);
	}
	
	public static void render(Graphics g) {
		for (int i=0; i<objects.size(); i++) {
			((Object) objects.get(i)).draw(g);
		}
	}
	
	public void update() {
		for (int i=0; i<objects.size(); i++) {
			Object other = objects.get(i);
			
			if (other == this || other.solid == false) {continue;}
			
			if (doesCollide(x + dx, y, other)) {
				if (dx > 0) {
					x = (other.x + other.box.getX()) - (box.getX() + box.getWidth());
				} else {
					x = (other.x + other.box.getX() + other.box.getWidth()) - (box.getX());
				}
				
				dx = 0;
			}
			
			if (doesCollide(x, y + dy, other)) {
				if (dy > 0) {
					y = (other.y + other.box.getY()) - (box.getY() + box.getHeight());
				} else {
					y = (other.y + other.box.getY() + other.box.getHeight()) - (box.getY());
				}
				
				dy = 0;
			}
		}
		
		x += dx;
		y += dy;
	}
	
	public static void tick() {
		for (int i=0; i<objects.size(); i++) {
			((Object) objects.get(i)).update();
		}
	}
	
	public abstract void draw(Graphics g);
}
