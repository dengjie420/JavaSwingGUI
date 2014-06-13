package com.arg.gui;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;

/**
 * 自定义节点控件的拖拽
 * 
 * @author dengjie
 * 
 */
public class ArgNodeControlMove {

	private static ArgNodeControlMove node = null;
	private boolean flag = false;
	private int x = 0;
	private int y = 0;
	private int width = 0;
	private int height = 0;
	/**
	 * 节点类型
	 */
	public static int NODE = 1;
	public static int VALVE = 2;

	private ArgNodeControlMove(int parentWidth, int parentHeight) {
		this.width = parentWidth;
		this.height = parentHeight;
	}

	public static ArgNodeControlMove getInstance(int parentWidth,
			int parentHeight) {
		if (node == null) {
			node = new ArgNodeControlMove(parentWidth, parentHeight);
		}
		return node;
	}

	public void listenControlsMove(final JComponent component, final int type) {

		component.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				flag = true;
				x = e.getX();
				y = e.getY();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				flag = false;
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				if (type == NODE) {
					// 创建节点下挂的水阀
					ArgValveCountSet.createAndShowGUI();
				} else if (type == VALVE) {
					// 
				}
			}

		});

		component.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				if (flag) {
					Point point = component.getLocation();
					component.setLocation(e.getPoint().x + point.x - x,
							e.getPoint().y + point.y - y);
					/**
					 * 尽管限制了控件的移动范围， 但是四个角落还是没法限制
					 */
					if (component.getX() < 0) {
						component.setLocation(0, e.getPoint().y + point.y - y);
					}
					if (component.getY() < 0) {
						component.setLocation(e.getPoint().x + point.x - x, 0);
					}
					if (component.getX() < 0 && component.getY() < 0) {
						component.setLocation(0, 0);
					}
					if ((component.getX() + component.getWidth()) > width) {
						component.setLocation(width - component.getWidth(),
								e.getPoint().y + point.y - y);
					}
					if ((component.getY() + component.getHeight()) > (height - 20)) {
						component.setLocation(e.getPoint().x + point.x - x,
								height - component.getHeight() - 20);
					}
				}
			}
		});
	}
}
