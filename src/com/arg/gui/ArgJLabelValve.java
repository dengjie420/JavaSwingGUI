package com.arg.gui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 自定义水阀控件
 * 
 * @author dengjie
 * 
 */
@SuppressWarnings("serial")
public class ArgJLabelValve extends JLabel {
	public ArgJLabelValve(int x, int y, String path) {
		super();
		// TODO Auto-generated constructor stub
		this.setBounds(x, y, 30, 30);
		this.setIcon(new ImageIcon(path));
	}

	@Override
	public void setText(String text) {
		// TODO Auto-generated method stub
		super.setText(text);
		this.setHorizontalTextPosition(JLabel.CENTER);
	}
}
