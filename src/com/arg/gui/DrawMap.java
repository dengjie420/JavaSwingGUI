package com.arg.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * 地图绘制
 * 
 * 采用边框布局
 * 
 * @author dengjie
 * 
 */
public class DrawMap {

	public static JLabel bgCenter = null;
	private static JFrame frame = null;
	private final static String VERSION = "v 1.1";
	private final static String COMPANYNAME = "旭昂物联";
	private final static String[] menus = new String[] { "文件", "控件", "帮助" };
	private final static String[][] menuItems = new String[][] {
			{ "导入节点", "保存控件", "退出" }, { "节点控件", "横向水管", "纵向水管", "首部" },
			{ "关于我们", "欢迎使用" } };
	private final static String[] toolItems = new String[] { "导入节点", "保存控件",
			"节点控件", "横向水管", "纵向水管", "首部" };

	/**
	 * 提供布局逻辑
	 * 
	 * @param pane
	 */
	public static void addComponentsToPane(Container pane) {
		// top
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		for (int i = 0; i < toolItems.length; i++) {
			final JButton tool = new JButton();
			tool.setText(toolItems[i]);
			tool.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					switch (tool.getText()) {
					case "导入节点":
						ArgParameterSet.createAndShowGUI();
						break;
					case "保存控件":
						new ArgMessageBox(frame,"正在开发中...","提示");
						break;
					case "节点控件":
						ArgZigbeeNodeSet.createAndShowGUI();
						break;
					case "横向水管":
						ArgAcrossSet.createAndShowGUI();
						break;
					case "纵向水管":
						ArgVerticalSet.createAndShowGUI();
						break;
					case "首部":
						new ArgMessageBox(frame,"正在开发中...","提示");
						break;
					default:
						break;
					}
				}

			});
			panel.add(tool);
		}
		pane.add(panel, BorderLayout.PAGE_START);

		// center
		bgCenter = new JLabel("",JLabel.CENTER);
		pane.add(bgCenter, BorderLayout.CENTER);

		// foot
		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		ArgStatusLabel argLabel = new ArgStatusLabel(
				ArgStatusLabel.FONT_14_BOLD);
		argLabel.setText("主程序版本：" + VERSION);
		panel.add(argLabel);
		argLabel = new ArgStatusLabel(ArgStatusLabel.FONT_14_BOLD);
		argLabel.setText(" |出品公司：" + COMPANYNAME);
		panel.add(argLabel);
		argLabel = new ArgStatusLabel(ArgStatusLabel.FONT_14_BOLD);
		argLabel.setText(" |当前时间：");
		panel.add(argLabel);
		ArgStatusTimeLabel argTime = new ArgStatusTimeLabel();
		panel.add(argTime);
		pane.add(panel, BorderLayout.PAGE_END);
	}

	/**
	 * 实例化一个JPanel，通过它的ContentPane加载布局逻辑内容
	 */
	public static void createAndShowGUI() {
		JMenuBar mb = new JMenuBar();
		for (int i = 0; i < menus.length; i++) {
			JMenu m = new JMenu();
			m.setText(menus[i]);
			for (int j = 0; j < menuItems[i].length; j++) {
				JMenuItem mi = new JMenuItem();
				mi.setText(menuItems[i][j]);
				m.add(mi);
			}
			mb.add(m);
		}
		frame = new JFrame("智慧农业地图绘制系统");
		frame.setJMenuBar(mb);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addComponentsToPane(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * 单独启一个UI线程
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					String lnf = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
					UIManager.setLookAndFeel(lnf);
					createAndShowGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
