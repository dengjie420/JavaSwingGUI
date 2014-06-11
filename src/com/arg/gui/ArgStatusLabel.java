package com.arg.gui;

import java.awt.Font;

import javax.swing.JLabel;

/**
 * 自定义状态栏标签
 * 
 * @author dengjie
 * 
 */
@SuppressWarnings("serial")
public class ArgStatusLabel extends JLabel {

	public static final Font FONT_12_BOLD = new Font("Calibri", Font.BOLD, 12);
	public static final Font FONT_14_BOLD = new Font("Calibri", Font.BOLD, 14);
	public static final Font FONT_16_BOLD = new Font("Calibri", Font.BOLD, 16);
	public static final Font FONT_18_BOLD = new Font("Calibri", Font.BOLD, 18);

	/**
	 * 初始化自定义标签
	 */
	public ArgStatusLabel() {
		this.setFont(FONT_14_BOLD);
	}

}
