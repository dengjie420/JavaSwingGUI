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

	/**
	 * 
	 * @param frame：所属父窗体
	 * @param content：内容
	 * @param info：标题
	 */
	public ArgMessageBox(JFrame frame,String content, String title) {
		JOptionPane.showMessageDialog(frame,content, title,
				JOptionPane.DEFAULT_OPTION);
	}

}
