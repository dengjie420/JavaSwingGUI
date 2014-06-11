package com.arg.gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 自定义消息框
 * 
 * @author dengjie
 * 
 */
public class ArgMessageBox{

	public ArgMessageBox(JFrame frame,String content, String info) {
		JOptionPane.showMessageDialog(frame,content, info,
				JOptionPane.DEFAULT_OPTION);
	}

}
