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
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;


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

	/**
	 * 提供布局逻辑
	 * 
	 * @param pane
	 */
	private static void addComponentsToPane(Container pane) {
		// top
		JPanel panel = new JPanel();
		JButton btn = new JButton("PAGE_START");
		ArgStatusLabel argLabel = new ArgStatusLabel(ArgStatusLabel.FONT_14_BOLD);
		argLabel.setText("导入节点：");
		panel.add(argLabel);
		final JButton jBtnFile = new JButton("选择...");
		jBtnFile.setBounds(130, 10, 50, 30);
		jBtnFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser jfc = new JFileChooser();
				if (jfc.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
					// 解释下这里,弹出个对话框,可以选择要上传的文件,如果选择了,就把选择的文件的绝对路径打印出来,有了绝对路径,通过JTextField的settext就能设置进去了,那个我没写
					jBtnFile.setText("已选择");
					String path = jfc.getSelectedFile().getAbsolutePath();
					System.out.println(path);
				}
			}
		});
		panel.add(jBtnFile);
		pane.add(panel, BorderLayout.PAGE_START);
		// center
		panel=new JPanel();
		panel.setBackground(Color.GRAY);
		argLabel = new ArgStatusLabel(ArgStatusLabel.FONT_14_BOLD);
		argLabel.setText("选择区域：");
		panel.add(argLabel);
		final JComboBox<String> cBox = new JComboBox<String>();
		cBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String filePath = "ArgFarmAreaName.properties";
					InputStream in = new BufferedInputStream(new FileInputStream(
							filePath));
					Properties props = new Properties();
					props.load(in);
					Enumeration<?> en = props.propertyNames();
					while (en.hasMoreElements()) {
						String key = (String) en.nextElement();
						String Property = props.getProperty(key);
						cBox.addItem(Property);
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		panel.add(cBox);
		panel.setPreferredSize(new Dimension(200, 100));
		pane.add(panel, BorderLayout.CENTER);
		// foot
		btn = new JButton("确  定");
		btn.setFont(new Font("Calibri", Font.BOLD, 14));
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 对节点路径和农场区域选择判断后，隐藏设置窗体

				frame.setVisible(false);
			}
		});
		pane.add(btn, BorderLayout.PAGE_END);
	}

	/**
	 * 实例化一个JPanel，通过它的ContentPane加载布局逻辑内容
	 */
	public static void createAndShowGUI() {
		frame = new JFrame("参数设置");
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setAlwaysOnTop(true);
		addComponentsToPane(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);
	}

}
