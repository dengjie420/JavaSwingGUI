package com.smartlab.layout;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * BoxLayout可以将组件由上至下或由左至右依次加入当前面板
 * 
 * @author dengjie
 * 
 */
public class BoxLayoutPane {

	/**
	 * 提供布局逻辑
	 * 
	 * @param pane
	 */
	public static void addComponentsToPane(Container pane) {
		JPanel xPane = new JPanel();
		xPane.setLayout(new BoxLayout(xPane, BoxLayout.X_AXIS));
		addButtons(xPane);
		JPanel yPane = new JPanel();
		yPane.setLayout(new BoxLayout(yPane, BoxLayout.Y_AXIS));
		addButtons(yPane);
		pane.add(xPane, BorderLayout.PAGE_END);
		pane.add(yPane, BorderLayout.PAGE_START);
	}

	private static void addAButton(String text, Container container) {
		JButton btn = new JButton(text);
		btn.setAlignmentX(Component.CENTER_ALIGNMENT);
		container.add(btn);
	}

	private static void addButtons(Container container) {
		for (int i = 0; i < 8; i++) {
			addAButton("btn" + i, container);
		}
	}

	/**
	 * 实例化一个JPanel，通过它的ContentPane加载布局逻辑内容
	 */
	public static void createAndShowGUI() {
		JFrame frame = new JFrame("盒子布局");
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
