package com.arg.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 通用的删除控件界面
 * 
 * @author dengjie
 * 
 */
public class ArgDeleteFrameCommon {
	private static JFrame frame = null;
	private static int maxNum = 0;
	private static int startIndex = 0;

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
		argLbl.setText("请选择绘制的水管数量：");
		panel.add(argLbl);
		pane.add(argLbl, BorderLayout.PAGE_START);

		// center
		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		final JComboBox<String> cBox = new JComboBox<String>();
		// 填充下拉框
		for (int i = 0; i < 4; i++) {
			cBox.addItem((i + 1) + "");
		}
		argLbl = new ArgStatusLabel(ArgStatusLabel.FONT_14_BOLD);
		argLbl.setText("当前选中：");
		panel.add(argLbl);
		panel.add(cBox);
		argLbl = new ArgStatusLabel(ArgStatusLabel.FONT_14_BOLD);
		argLbl.setText("个水管");
		panel.add(argLbl);
		pane.add(panel, BorderLayout.CENTER);

		// foot
		btn = new JButton("确  定");
		btn.setFont(new Font("Calibri", Font.BOLD, 14));
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String num = cBox.getItemAt(cBox.getSelectedIndex());
				maxNum += Integer.parseInt(num);
				if (!num.equals("0")) {
					frame.setVisible(false);
					for (int i = startIndex; i < maxNum; i++) {
						ArgJLabelVertical vertical = new ArgJLabelVertical(
								i * 9, 0, "sources/hosev.jpg");
						// 添加监听节点控件事件
						ArgNodeControlMove.getInstance(
								DrawMap.bgCenter.getWidth(),
								DrawMap.bgCenter.getHeight())
								.listenControlsMove(vertical,
										ArgNodeControlMove.VERTICAL);
						DrawMap.bgCenter.add(vertical);
						DrawMap.bgCenter.repaint();
					}
					startIndex = maxNum;
				}
			}
		});
		panel = new JPanel();
		panel.add(btn);
		pane.add(btn, BorderLayout.PAGE_END);
	}

	/**
	 * 实例化一个JFrame
	 * 
	 * @param component
	 */
	public static void createAndShowGUI() {
		if (frame == null) {
			frame = new JFrame("控件参数设置");
		}
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setAlwaysOnTop(true);
		addComponentsToPane(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);
	}
}
