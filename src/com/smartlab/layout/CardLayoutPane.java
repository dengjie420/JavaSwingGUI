package com.smartlab.layout;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * 卡片布局和其他布局不同，因为它隐藏了一些组件。
 * 
 * 卡片布局就是一组容器或者组件，它们一次仅仅显是一个，
 * 
 * 组中的每个容器称为卡片
 * 
 * @author dengjie
 * 
 */
public class CardLayoutPane {

	/**
	 * 提供布局逻辑
	 * 
	 * @param pane
	 */
	public static void addComponentsToPane(Container pane) {
		final JPanel contentPane = new JPanel();
		JPanel controlPane = new JPanel();
		final CardLayout cardLayout = new CardLayout();
		pane.setLayout(new BorderLayout());
		pane.add(contentPane, BorderLayout.CENTER);
		pane.add(controlPane, BorderLayout.PAGE_END);
		controlPane.setLayout(new FlowLayout());
		JButton[] btn = new JButton[10];
		for (int i = 0; i < 10; i++) {
			btn[i] = new JButton("NO." + i);
			contentPane.add(btn[i]);
		}
		contentPane.setLayout(cardLayout);
		JButton nextBtn = new JButton("NEXT");
		nextBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cardLayout.next(contentPane);
			}
		});
		controlPane.add(nextBtn);
	}

	/**
	 * 实例化一个JPanel，通过它的ContentPane加载布局逻辑内容
	 */
	public static void createAndShowGUI() {
		JFrame frame = new JFrame("卡片布局");
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
