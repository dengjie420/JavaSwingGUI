package com.smartlab.layout;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * FlowLayout类是最简单的布局管理器。它按照和页面上排列单词的类似方式来安排组件
 * 
 * ----从左到右，直至没有多余的空间，然后转到下一行
 * 
 * @author dengjie
 * 
 */
public class FlowLayoutPanel {

	/**
	 * 提供布局逻辑
	 * 
	 * @param pane
	 */
	public static void addComponentsToPane(Container pane) {
		pane.setLayout(new FlowLayout());
		for (int i = 0; i < 8; i++) {
			pane.add(new JButton("Btn" + i));
		}
	}

	/**
	 * 实例化一个JPanel，通过它的ContentPane加载布局逻辑内容
	 */
	public static void createAndShowGUI() {
		JFrame frame = new JFrame("流动布局");
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
