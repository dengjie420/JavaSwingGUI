package com.arg.gui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 自定义横向水管
 * 
 * @author dengjie
 * 
 */
@SuppressWarnings("serial")
public class ArgJLabelAcross extends JLabel {
	public ArgJLabelAcross(int x, int y, String path) {
		super();
		// TODO Auto-generated constructor stub
		this.setBounds(x, y, 116, 9);
		this.setIcon(new ImageIcon(path));
	}
}
