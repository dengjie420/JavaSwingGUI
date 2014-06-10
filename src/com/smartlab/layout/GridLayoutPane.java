package com.smartlab.layout;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * GridLayout让你建立一个组件表格，并且当组件加入时，会依序又左至右，
 * 
 * 由上至下填充到每个格子，它不能由你指定想放那个格子就放那个格子
 * 
 * @author dengjie
 * 
 */
public class GridLayoutPane {
	/**
	 * 提供布局逻辑
	 * 
	 * @param pane
	 */
	public static void addComponentsToPane(Container pane) {
		JButton[] btns = new JButton[9];
		pane.setLayout(new GridLayout(3, 3));
		for (int i = 0; i < btns.length; i++) {
			btns[i] = new JButton(i + "");
			pane.add(btns[i]);
		}
	}

	/**
	 * 实例化一个JPanel，通过它的ContentPane加载布局逻辑内容
	 */
	public static void createAndShowGUI() {
		JFrame frame = new JFrame("格子布局");
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
