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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * <code>RGBPanel</code>
 *
 * <p>
 * Date : 9 Oct 2017
 *
 * @author Vassili Kurman
 * @version 1.0
 */
public class RGBPanel extends JPanel implements ActionListener, FocusListener {
	
	private static final long serialVersionUID = -7560950899617605289L;
	
	private JPanel colorBoxPanel;
	private JTextField txtRed, txtGreen, txtBlue, txtHex;
	private JButton btnConvert;
	
	public RGBPanel(){
		createUI();
	}
	
	private void createUI(){
		setLayout(new BorderLayout(5, 5));
		setBorder(BorderFactory.createTitledBorder(null, "RGB Colours", TitledBorder.LEFT, TitledBorder.TOP));
		
		colorBoxPanel = new JPanel();
		colorBoxPanel.setPreferredSize(new Dimension(75, 75));
		colorBoxPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		JPanel colorPanel = new JPanel(new GridLayout(4, 2));
		txtRed = new JTextField(Integer.toString(0), 3);
		txtRed.addFocusListener(this);
		txtGreen = new JTextField(Integer.toString(0), 3);
		txtGreen.addFocusListener(this);
		txtBlue = new JTextField(Integer.toString(0), 3);
		txtBlue.addFocusListener(this);
		txtHex = new JTextField(6);
		txtHex.setEditable(false);
		
		JLabel red = new JLabel("R:");
		JLabel green = new JLabel("G:");
		JLabel blue = new JLabel("B:");
		JLabel hexadecimal = new JLabel("Hex:");
		
		btnConvert = new JButton("Convert");
		btnConvert.addActionListener(this);
		
		colorPanel.add(red);
		colorPanel.add(txtRed);
		colorPanel.add(green);
		colorPanel.add(txtGreen);
		colorPanel.add(blue);
		colorPanel.add(txtBlue);
		colorPanel.add(hexadecimal);
		colorPanel.add(txtHex);
		
		JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		buttons.add(btnConvert);
		
		add(colorPanel, BorderLayout.LINE_START);
		add(colorBoxPanel, BorderLayout.CENTER);
		add(buttons, BorderLayout.PAGE_END);
		
		setValues();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		setValues();
	}
	
	@Override
	public void focusGained(FocusEvent e) {
		JTextField c = ((JTextField) e.getComponent());
		if(c.equals(txtRed)) txtRed.setText(null);
		else if(c.equals(txtGreen)) txtGreen.setText(null);
		else if(c.equals(txtBlue)) txtBlue.setText(null);
		txtHex.setText("");
	}
	
	@Override
	public void focusLost(FocusEvent e) {
		JTextField c = ((JTextField) e.getComponent());
		if(c.equals(txtRed) && (c.getText() == null || c.getText().equals(""))) txtRed.setText("0");
		else if(c.equals(txtGreen) && (c.getText() == null || c.getText().equals(""))) txtGreen.setText("0");
		else if(c.equals(txtBlue) && (c.getText() == null || c.getText().equals(""))) txtBlue.setText("0");
	}
	
	/**
	 * Sets values to all fields.
	 */
	private void setValues() {
		int red = 0;
		int green = 0;
		int blue = 0;
		
		if(txtRed.getText() != null && !txtRed.getText().equals("")) red = Integer.parseInt(txtRed.getText());
		if(txtGreen.getText() != null && !txtGreen.getText().equals("")) green = Integer.parseInt(txtGreen.getText());
		if(txtBlue.getText() != null && !txtBlue.getText().equals("")) blue = Integer.parseInt(txtBlue.getText());
		
		if(red >= 0 && red < 256 && green >= 0 && green < 256 && blue >= 0 && blue < 256){
			String rString = Integer.toHexString(red);
			String gString = Integer.toHexString(green);
			String bString = Integer.toHexString(blue);
			
			if(rString.length() == 1) rString = 0 + rString;
			if(gString.length() == 1) gString = 0 + gString;
			if(bString.length() == 1) bString = 0 + bString;
			
			String value = rString + gString + bString;
			txtHex.setText("#" + value);
			colorBoxPanel.setBackground(Color.decode("#" + value));
		} else {
			txtHex.setText("ERROR!");
		}
	}
}