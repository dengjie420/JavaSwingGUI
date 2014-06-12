package com.arg.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 节点设置界面
 * 
 * @author dengjie
 * 
 */
public class ArgZigbeeNodeSet {
	/**
	 * 提供布局逻辑
	 * 
	 * @param pane
	 */
	private static void addComponentsToPane(Container pane) {
		// top
		JPanel panel = new JPanel();
		JButton btn = new JButton();
		ArgStatusLabel argLbl = new ArgStatusLabel(ArgStatusLabel.FONT_14_BOLD);
		argLbl.setText("请选择绘制的节点数量：");
		panel.add(argLbl);
		pane.add(argLbl, BorderLayout.PAGE_START);

		// center
		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		JComboBox<String> cBox = new JComboBox<String>();
		for (int i = 0; i < 4; i++) {
			cBox.addItem((i + 1) + "");
		}
		argLbl = new ArgStatusLabel(ArgStatusLabel.FONT_14_BOLD);
		argLbl.setText("当前选中：");
		panel.add(argLbl);
		panel.add(cBox);
		argLbl = new ArgStatusLabel(ArgStatusLabel.FONT_14_BOLD);
		argLbl.setText("个节点");
		panel.add(argLbl);
		pane.add(panel, BorderLayout.CENTER);

		// foot
		btn = new JButton("确  定");
		btn.setFont(new Font("Calibri", Font.BOLD, 14));
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		panel = new JPanel();
		panel.add(btn);
		pane.add(btn, BorderLayout.PAGE_END);
	}

	/**
	 * 实例化一个JPanel，通过它的ContentPane加载布局逻辑内容
	 */
	public static void createAndShowGUI() {
		JFrame frame = new JFrame("节点数设置");
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setAlwaysOnTop(true);
		addComponentsToPane(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);
	}
}
