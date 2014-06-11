package com.arg.gui;

import java.util.Calendar;

/**
 * 自定义日期
 * 
 * @author dengjie
 * 
 */
public class DateTimeUtils {

	private Calendar cal = Calendar.getInstance();

	/**
	 * 获取当前日期
	 * 
	 * @return
	 */
	public String getDate() {
		String monthStr = "";
		String dayStr = "";

		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);

		if (month < 10) {
			monthStr = "0" + month;
		} else {
			monthStr = "" + month;
		}
		if (day < 10) {
			dayStr = "0" + day;
		} else {
			dayStr = "" + day;
		}

		String date = year + "-" + monthStr + "-" + dayStr;

		return date;
	}

	/**
	 * 获取当前时间
	 * 
	 * @return
	 */
	public String getTime() {
		String hourStr = "";
		String minStr = "";
		String secStr = "";

		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);

		if (hour < 10) {
			hourStr = "0" + hour;
		} else {
			hourStr = "" + hour;
		}
		if (min < 10) {
			minStr = "0" + min;
		} else {
			minStr = "" + min;
		}
		if (sec < 10) {
			secStr = "0" + sec;
		} else {
			secStr = "" + sec;
		}

		String time = hourStr + ":" + minStr + ":" + secStr;

		return time;
	}

	/**
	 * 获取当前日期
	 * 
	 * @return
	 */
	public String getDateTime() {
		return getDate() + " " + getTime();
	}

}
