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
import static java.lang.Math.min;

import com.n00blib.general.GameSystem;

public abstract class GravityObject extends Object {
	public double gravity;
	
	public GravityObject(double x, double y, double depth, boolean solid, double gravity, GameSystem system) {
		super(x, y, depth, solid, system);
		this.gravity = gravity;
		
	}
	
	@Override
	public void update() {
		Object other = null;
		
		boolean processingFall = true, processingDx = true;
		
		for (int i=0; i<objects.size(); i++) {
			other = objects.get(i);
			if (other == this || !(other.solid)) {continue;}

			if (doesCollide(x, y-1+dy, other) && y > other.y) {
				dy = gravity;
				break;
			}
		}
		
		for (int i=0; i<objects.size(); i++) {
			other = objects.get(i);
			
			if (other == this || !(other.solid)) {continue;}
			
			if (processingFall) {
				if (doesCollide(x, y+1+dy, other) && y < other.y) {
					y = other.y + other.box.getY() - (box.getY() + box.getHeight());
					dy = 0;
					processingFall = false;
				}
			}
			
			if (processingDx) {
				if (doesCollide(x+dx, y, other)) {
					processingDx = false;
					
					if (dx > 0) {
						x = (other.x + other.box.getX()) - (box.getX() + box.getWidth());
					} else {
						x = (other.x + other.box.getX() + other.box.getWidth()) - (box.getX());
					}
					
					dx = 0;
				}
			}
		}
		
		if (processingFall) {			
			dy = min(dy + gravity, 30);
		}
		
		x += dx;
		y += dy;
	}

}
