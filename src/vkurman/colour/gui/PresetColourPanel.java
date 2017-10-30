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
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import vkurman.colour.enums.Colourable;
import vkurman.colour.enums.StandardisedColour;
import vkurman.colour.enums.W3C;
import vkurman.colour.enums.Web;
import vkurman.colour.enums.X11;
import vkurman.colour.enums.XKCD;

/**
 * <code>PresetColourPanel</code> have preset colours to choose from.
 *
 * <p>
 * Date : 9 Oct 2017
 *
 * @author Vassili Kurman
 * @version 1.0
 */
public class PresetColourPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7095841035963888904L;
	
	private JRadioButton btnStandard, btnW3C, btnWeb, btnX11, btnXKCD;
	private JComboBox<Colourable> cbxColours;
	private JPanel colorBoxPanel;
	private JTextField txtRed, txtGreen, txtBlue, txtHex;
	
	/**
	 * Constructor
	 */
	public PresetColourPanel() {
		createUI();
	}
	
	/**
	 * Creates UI.
	 */
	private synchronized void createUI(){
		setLayout(new BorderLayout(5, 5));
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		setBorder(BorderFactory.createTitledBorder(null, "Preset Colours", TitledBorder.LEFT, TitledBorder.TOP));
		
		ButtonGroup bg = new ButtonGroup();
		btnStandard = new JRadioButton("Standard");
		btnStandard.addActionListener(this);
		btnW3C = new JRadioButton("W3C");
		btnW3C.addActionListener(this);
		btnWeb = new JRadioButton("Web");
		btnWeb.addActionListener(this);
		btnX11 = new JRadioButton("X11");
		btnX11.addActionListener(this);
		btnXKCD = new JRadioButton("XKCD");
		btnXKCD.addActionListener(this);
		// Setting selected button
		btnStandard.setSelected(true);
		
		bg.add(btnStandard);
		bg.add(btnW3C);
		bg.add(btnWeb);
		bg.add(btnX11);
		bg.add(btnXKCD);
		
		cbxColours = new JComboBox<>(StandardisedColour.values());
		cbxColours.setSelectedIndex(0);
		cbxColours.addActionListener(this);
		
		colorBoxPanel = new JPanel();
		colorBoxPanel.setPreferredSize(new Dimension(75, 75));
		colorBoxPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		JPanel colorPanel = new JPanel(new GridLayout(4, 2));
		txtRed = new JTextField(3);
		txtGreen = new JTextField(3);
		txtBlue = new JTextField(3);
		txtHex = new JTextField(6);
		txtHex.setEditable(false);
		
		JLabel red = new JLabel("R:");
		JLabel green = new JLabel("G:");
		JLabel blue = new JLabel("B:");
		JLabel hexadecimal = new JLabel("Hex:");
		
		colorPanel.add(red);
		colorPanel.add(txtRed);
		colorPanel.add(green);
		colorPanel.add(txtGreen);
		colorPanel.add(blue);
		colorPanel.add(txtBlue);
		colorPanel.add(hexadecimal);
		colorPanel.add(txtHex);
		
		
		JPanel selectionPanel = new JPanel(new GridLayout(1, 5));
		selectionPanel.add(btnStandard);
		selectionPanel.add(btnW3C);
		selectionPanel.add(btnWeb);
		selectionPanel.add(btnX11);
		selectionPanel.add(btnXKCD);
		
		JPanel mainPanel = new JPanel(new BorderLayout(5, 5));
		mainPanel.add(cbxColours, BorderLayout.NORTH);
		mainPanel.add(colorPanel, BorderLayout.WEST);
		mainPanel.add(colorBoxPanel, BorderLayout.CENTER);
		
		add(selectionPanel, BorderLayout.NORTH);
		add(mainPanel, BorderLayout.CENTER);
		
		setValues();
	}
	
	/**
	 * Sets values to all fields.
	 */
	private synchronized void setValues() {
		txtRed.setText(Integer.toString(((Colourable)cbxColours.getSelectedItem()).getRed()));
		txtGreen.setText(Integer.toString(((Colourable)cbxColours.getSelectedItem()).getGreen()));
		txtBlue.setText(Integer.toString(((Colourable)cbxColours.getSelectedItem()).getBlue()));
		
		txtHex.setText(((Colourable)cbxColours.getSelectedItem()).getHex());
		
		colorBoxPanel.setBackground(((Colourable)cbxColours.getSelectedItem()).getColour());
	}
	
	@Override
	public synchronized void actionPerformed(ActionEvent e) {
		if(e.getSource() == cbxColours) {
			setValues();
			return;
		}
		// Clearing combo box
		cbxColours.removeAll();
		// Filling combo box with new values
		if(e.getSource() == btnStandard) {
			cbxColours.setModel(new DefaultComboBoxModel<Colourable>(StandardisedColour.values()));
		} else if(e.getSource() == btnW3C) {
			cbxColours.setModel(new DefaultComboBoxModel<Colourable>(W3C.values()));
		} else if(e.getSource() == btnWeb) {
			cbxColours.setModel(new DefaultComboBoxModel<Colourable>(Web.values()));
		} else if(e.getSource() == btnX11) {
			cbxColours.setModel(new DefaultComboBoxModel<Colourable>(X11.values()));
		} else if(e.getSource() == btnXKCD) {
			cbxColours.setModel(new DefaultComboBoxModel<Colourable>(XKCD.values()));
		}
		// Setting up selection to 1st element
		cbxColours.setSelectedIndex(0);
		// Setting values to fields
		setValues();
	}
}