package com.arg.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * 参数设置GUI
 * 
 * 边框布局
 * 
 * @author dengjie
 * 
 */
public class ArgParameterSet {

	private static JFrame frame = null;
	private static String pathImage = "";

	/**
	 * 提供布局逻辑
	 * 
	 * @param pane
	 */
	private static void addComponentsToPane(Container pane) {
		// top
		JPanel panel = new JPanel();
		JButton btn = new JButton();
		ArgStatusLabel argLabel = new ArgStatusLabel(
				ArgStatusLabel.FONT_14_BOLD);
		argLabel.setText("导入节点：");
		panel.add(argLabel);
		final JButton jBtnFile = new JButton("选择...");
		jBtnFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						"xls&xlsx", "xls", "xlsx");
				JFileChooser jfc = new JFileChooser();
				jfc.setFileFilter(filter);
				if (jfc.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
					// 解释下这里,弹出个对话框,可以选择要上传的文件,如果选择了,就把选择的文件的绝对路径打印出来,有了绝对路径,通过JTextField的settext就能设置进去了,那个我没写
					jBtnFile.setText("已选择");
					String filePath = jfc.getSelectedFile().getAbsolutePath();
					System.out.println(filePath);
					// 将Excel中的编号填充到节点实体集合

				} else {
					jBtnFile.setText("选择...");
				}
			}
		});
		panel.add(jBtnFile);
		pane.add(panel, BorderLayout.PAGE_START);
		// center
		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		argLabel = new ArgStatusLabel(ArgStatusLabel.FONT_14_BOLD);
		argLabel.setText("选择区域：");
		panel.add(argLabel);
		final JComboBox<String> cBox = new JComboBox<String>();
		try {
			String farmIniPath = "ArgFarmAreaName.properties";
			InputStream in = new BufferedInputStream(new FileInputStream(
					farmIniPath));
			Properties props = new Properties();
			props.load(in);
			Enumeration<?> en = props.propertyNames();
			while (en.hasMoreElements()) {
				String key = (String) en.nextElement();
				String Property = props.getProperty(key);
				cBox.addItem(Property + "团");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		panel.add(cBox);
		argLabel = new ArgStatusLabel(ArgStatusLabel.FONT_14_BOLD);
		argLabel.setText("导入施工图：");
		panel.add(argLabel);
		final JButton img = new JButton("导入...");
		img.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						"jpg&png", "jpg", "png");
				JFileChooser jfc = new JFileChooser();
				jfc.setFileFilter(filter);
				if (jfc.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
					// 解释下这里,弹出个对话框,可以选择要上传的文件,如果选择了,就把选择的文件的绝对路径打印出来,有了绝对路径,通过JTextField的settext就能设置进去了,那个我没写
					img.setText("已导入");
					pathImage = jfc.getSelectedFile().getAbsolutePath();
					System.out.println(pathImage);
					// 将施工图导入到绘图界面

				} else {
					img.setText("导入...");
				}
			}
		});
		panel.add(img);
		final JLabel info = new JLabel();
		panel.add(info);
		panel.setPreferredSize(new Dimension(200, 100));
		pane.add(panel, BorderLayout.CENTER);
		// foot
		btn = new JButton("确  定");
		btn.setFont(new Font("Calibri", Font.BOLD, 14));
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 对节点路径和农场区域选择判断后，隐藏设置窗体
				if (jBtnFile.getText().equals("选择...")
						|| img.getText().equals("导入...")) {
					info.setText("请导入节点编号或施工图！");
					info.setFont(ArgStatusLabel.FONT_14_BOLD);
					info.setForeground(Color.RED);
				} else {
					frame.setVisible(false);
					ImageIcon icon = new ImageIcon(pathImage);
					DrawMap.bgCenter.setIcon(icon);
				}
			}
		});
		pane.add(btn, BorderLayout.PAGE_END);
	}

	/**
	 * 实例化一个JPanel，通过它的ContentPane加载布局逻辑内容
	 */
	public static void createAndShowGUI() {
		if (frame == null) {
			frame = new JFrame("参数设置");
		}
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setAlwaysOnTop(true);
		addComponentsToPane(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);
	}

}
