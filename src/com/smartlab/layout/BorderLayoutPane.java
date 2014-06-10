package com.smartlab.layout;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * 一个BorderLayout对象将界面分成五大区域，分别用BorderLayout类的静态常量指定： 
 * 
 * -PAGE_START -PAGE_END -LINE_START -LINE_END -CENTER
 * 
 * @author dengjie
 * 
 */
public class BorderLayoutPane {

	/**
	 * 提供布局逻辑
	 * 
	 * @param pane
	 */
	public static void addComponentsToPane(Container pane) {
		JButton btn = new JButton("PAGE_START");
		pane.add(btn, BorderLayout.PAGE_START);
		btn = new JButton("CENTER");
		btn.setPreferredSize(new Dimension(200, 100));
		pane.add(btn, BorderLayout.CENTER);
		btn = new JButton("LINE_START");
		pane.add(btn, BorderLayout.LINE_START);
		btn = new JButton("PAGE_END");
		pane.add(btn, BorderLayout.PAGE_END);
		btn = new JButton("LINE_END");
		pane.add(btn, BorderLayout.LINE_END);
	}

	/**
	 * 实例化一个JPanel，通过它的ContentPane加载布局逻辑内容
	 */
	public static void createAndShowGUI() {
		JFrame frame = new JFrame("边框布局");
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
