package com.arg.gui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 自定义纵向水管
 * 
 * @author dengjie
 * 
 */
@SuppressWarnings("serial")
public class ArgJLabelVertical extends JLabel {
	public ArgJLabelVertical(int x, int y, String path) {
		super();
		// TODO Auto-generated constructor stub
		this.setBounds(x, y, 9, 116);
		this.setIcon(new ImageIcon(path));
	}
}
