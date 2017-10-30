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

package vkurman.colour.gui;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * <code>ColourConverterUI</code>
 *
 * <p>
 * Date : 9 Oct 2017
 *
 * @author Vassili Kurman
 * @version 1.0
 */
public class ColourConverterUI extends JFrame {
	
	private static final long serialVersionUID = -7560950899617605289L;
	private static final String TITLE = "Colour Converter";
	
	public ColourConverterUI(){
		setTitle(TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		createUI();
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	/**
	 * Creates panels.
	 */
	private void createUI(){
		JPanel content = new JPanel(new BorderLayout(5, 5));
		content.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		setContentPane(content);
		
		add(new RGBPanel(), BorderLayout.WEST);
		add(new PresetColourPanel(), BorderLayout.EAST);
	}
}