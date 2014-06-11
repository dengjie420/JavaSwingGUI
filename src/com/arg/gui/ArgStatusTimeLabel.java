package com.arg.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

/**
 * 显示当前时间
 * 
 * @author dengjie
 * 
 */
@SuppressWarnings("serial")
public class ArgStatusTimeLabel extends ArgStatusLabel{
	private int delay = 1000;

	public ArgStatusTimeLabel() {
		ActionListener taskPerformer = new ActionListener() {

			public void actionPerformed(ActionEvent evt) {
				setText(new DateTimeUtils().getDateTime());
			}
		};
		new Timer(delay, taskPerformer).start();
	}
}
