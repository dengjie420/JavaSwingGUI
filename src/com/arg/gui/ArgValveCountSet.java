package com.arg.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 水阀个数设置窗体
 * 
 * 边框布局
 * 
 * @author dengjie
 * 
 */
public class ArgValveCountSet {
	private static JFrame frame = null;
	private static int x = 0;
	private static int y = 0;

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
		argLbl.setText("请选择绘制的水阀数量：");
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
		argLbl.setText("个水阀");
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
				int maxNum = Integer.parseInt(num);
				if (!num.equals("0")) {
					frame.setVisible(false);
					for (int i = 0; i < maxNum; i++) {
						ArgJLabelValve valve = null;
						switch (i) {
						case 0:
							valve = new ArgJLabelValve(x - 30, y,
									"sources/d.png");
							break;
						case 1:
							valve = new ArgJLabelValve(x, y - 30,
									"sources/d.png");
							break;
						case 2:
							valve = new ArgJLabelValve(x + 30, y,
									"sources/d.png");
							break;
						case 3:
							valve = new ArgJLabelValve(x, y + 50,
									"sources/d.png");
							break;
						default:
							break;
						}
						valve.setText((i + 1) + "");
						// 添加监听节点控件事件
						ArgNodeControlMove.getInstance(
								DrawMap.bgCenter.getWidth(),
								DrawMap.bgCenter.getHeight())
								.listenControlsMove(valve,
										ArgNodeControlMove.VALVE);
						DrawMap.bgCenter.add(valve);
						DrawMap.bgCenter.repaint();
					}
				}
			}
		});
		panel = new JPanel();
		panel.add(btn);
		pane.add(btn, BorderLayout.PAGE_END);
	}

	/**
	 * 实例化一个JPanel，通过它的ContentPane加载布局逻辑内容
	 * 
	 * @param component
	 */
	public static void createAndShowGUI(JComponent component) {
		// 获取节点的坐标和宽高
		ArgJLabelNode node = (ArgJLabelNode) component;
		x = node.getX();
		y = node.getY();

		if (frame == null) {
			frame = new JFrame("水阀数设置");
		}
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setAlwaysOnTop(true);
		addComponentsToPane(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);
	}
}
