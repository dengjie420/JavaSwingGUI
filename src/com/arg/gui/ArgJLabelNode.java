package com.arg.gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 自定义节点控件
 * 
 * @author dengjie
 * 
 */
@SuppressWarnings("serial")
public class ArgJLabelNode extends JLabel {
	private String vol = "";
	private String showValueNo = "";

	private Image image = null;
	
	public ArgJLabelNode(){
		
	}

	public ArgJLabelNode(int x, int y, String path) {
		// TODO Auto-generated constructor stub
		this.image = new ImageIcon(path).getImage();
		this.setBounds(x, y, 30, 50);
		this.setToolTipText("节点控件");
	}

	public String getVol() {
		return vol;
	}

	public void setVol(String vol) {
		this.vol = vol;
	}

	public String getShowValueNo() {
		return showValueNo;
	}

	public void setShowValueNo(String showValueNo) {
		this.showValueNo = showValueNo;
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.drawString(this.showValueNo, 10, 20);
		g.drawString(this.vol, 0, 40);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(image, 0, 0, 30, 30, this);
	}
}
