package com.binaryconverter.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.binaryconverter.logic.BinaryConverterAppLogic;

public class BinaryConverterAppGui implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JTextField IOField = new JTextField();
	JButton convertButton = new JButton();
	JButton clearButton = new JButton();
	BinaryConverterAppLogic logic = new BinaryConverterAppLogic();
	
	GridBagConstraints gridConstraint = new GridBagConstraints();
	
	public BinaryConverterAppGui() {
		addFrame();
		frame.setVisible(true);
	}
	
	public void addFrame() {
		// set basic attribute for main frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Simple Binary Converter");
		frame.setSize(350, 350);
		
		// add main panel to main frame
		addPanel();
		frame.add(panel);
	}
	
	public void addPanel() {
		// set basic attribute for main panel
		 panel.setLayout(new GridBagLayout());
		 panel.setBounds(150, 100, 150, 150);
		 gridConstraint.insets = new Insets(4, 4, 4, 4);
		 
		 //add component to panel
		 addComponent();
		 gridConstraint.gridx = 0;
		 gridConstraint.gridy = 0;
		 panel.add(IOField, gridConstraint);
		 
		 gridConstraint.gridx = 0;
		 gridConstraint.gridy = 1;
		 panel.add(convertButton, gridConstraint);
		 
		 gridConstraint.gridx = 0;
		 gridConstraint.gridy = 2;
		 panel.add(clearButton, gridConstraint);
	}
	
	private void addComponent() {
		// add text field component
		IOField.setText("");
		IOField.setHorizontalAlignment(SwingConstants.RIGHT);
		IOField.setPreferredSize(new Dimension(200, 50)); // Menentukan ukuran

		
		// add IO button component
		convertButton.setText("Convert");
		convertButton.setHorizontalAlignment(SwingConstants.CENTER);
		
		// add clear button
		clearButton.setText("Clear");
		clearButton.setHorizontalAlignment(SwingConstants.CENTER);		
		
		// add action listener for button component
		convertButton.addActionListener(this);
		clearButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    JButton source = (JButton) (e.getSource());
	    if (source == convertButton) {
	        try {
	            int decimal = Integer.parseInt(IOField.getText());
	            logic.setDecimalValue(decimal);
	            IOField.setText(logic.getBinaryRepresentation());
	        } catch (NumberFormatException ex) {
	        	System.out.println("Error : input invalid");
	            IOField.setText("Invalid input");
		    	logic.clearBinary();
	        }
	    } else if (source == clearButton) {
	    	logic.clearBinary();
	        IOField.setText("");
	    }
	}

}
