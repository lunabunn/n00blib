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

package com.n00blib.util;

import static java.lang.Math.*;

import java.util.ArrayList;

public class Math {
	public static int clamp(int x1, int x2, int x3) {
		ArrayList<Integer> args = new ArrayList<Integer>();
		args.add(x1);
		args.add(x2);
		args.add(x3);
		args.remove(max(max(x1, x2), x3));
		args.remove(min(min(x1, x2), x3));
		
		return args.get(0);
	}

	public static double clamp(double x1, double x2, double x3) {
		ArrayList<Double> args = new ArrayList<Double>();
		args.add(x1);
		args.add(x2);
		args.add(x3);
		args.remove(max(max(x1, x2), x3));
		args.remove(min(min(x1, x2), x3));
		
		return args.get(0);
	}
	
	public static int pointDistance(int x1, int y1, int x2, int y2) {
		return (int) (sqrt(pow(max(x1, x2) - max(x1, x2),2) + pow(max(y1, y2) - max(y1, y2),2)));
	}
	
	public static double pointDistance(double x1, double y1, double x2, double y2) {
		return sqrt(pow(max(x1, x2) - min(x1, x2),2) + pow(max(y1, y2) - min(y1, y2),2));
	}
}
