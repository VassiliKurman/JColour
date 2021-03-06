/*
 * MIT License
 * 
 * Copyright (c) 2017 Vassili Kurman
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package vkurman.colour.enums;

import java.awt.Color;

/**
 * <code>Colourable</code>
 *
 * <p>
 * Date : 10 Oct 2017
 *
 * @author Vassili Kurman
 * @version 1.0
 */
public interface Colourable {
	/**
	 * Return <code>Color</code> object for current <code>W3C</code> vkurman.colour
	 * name.
	 * 
	 * @return Color
	 */
	public Color getColour();

	/**
	 * Return int representing red.
	 * 
	 * @return int
	 */
	public int getRed();

	/**
	 * Return int representing green.
	 * 
	 * @return int
	 */
	public int getGreen();

	/**
	 * Return int representing blue.
	 * 
	 * @return int
	 */
	public int getBlue();

	/**
	 * Return String representing hexadecimal value of <code>Color</code>.
	 * 
	 * @return String
	 */
	public String getHex();
}