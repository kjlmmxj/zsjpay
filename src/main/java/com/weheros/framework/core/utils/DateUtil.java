package com.weheros.framework.core.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {
	public static Date formatDateToString(String strDate) {
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			date = sdf.parse(strDate);
		} catch (Exception e) {
			date = new Date();
		}
		return date;
	}

	public static Date formatDateToString1(String strDate) {
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
			date = sdf.parse(strDate);
		} catch (Exception e) {
			date = new Date();
		}
		return date;
	}
	public static Date formatDateTimeToString(String strDate) {
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			date = sdf.parse(strDate);
		} catch (Exception e) {
			date = new Date();
		}
		return date;
	}

	public static String formatDate(Date date) {
		String strDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			strDate = sdf.format(date);
		} catch (Exception e) {
			strDate = sdf.format(new Date());
		}
		return strDate;
	}
	
	public static String formatDateNumber(Date date) {
		String strDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			strDate = sdf.format(date);
		} catch (Exception e) {
			strDate = sdf.format(new Date());
		}
		return strDate;
	}

	public static String formatDateHms(Date date) {
		String strDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			strDate = sdf.format(date);
		} catch (Exception e) {
			strDate = sdf.format(new Date());
		}
		return strDate;
	}

	public static String formatDate2(Date date) {
		String strDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		try {
			strDate = sdf.format(date);
		} catch (Exception e) {
			strDate = sdf.format(new Date());
		}
		return strDate;
	}

	public static String formatDateTime(Date date) {
		String strDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			strDate = sdf.format(date);
		} catch (Exception e) {
			strDate = sdf.format(new Date());
		}
		return strDate;
	}

	public static String formatDateTime2(Date date) {
		String strDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		try {
			strDate = sdf.format(date);
		} catch (Exception e) {
			strDate = sdf.format(new Date());
		}
		return strDate;
	}

	public static String getCurrentDateString() {
		Calendar calendar = new GregorianCalendar();
		int m = calendar.get(Calendar.MONTH) + 1;
		int d = calendar.get(Calendar.DAY_OF_MONTH);
		StringBuffer sbDateStr = new StringBuffer()
				.append(calendar.get(Calendar.YEAR)).append("-")
				.append(m < 10 ? "0" + m : m).append("-")
				.append(d < 10 ? "0" + d : d);
		return String.valueOf(sbDateStr);
	}

	/**
	 * 获取当前时间的前一天时间
	 * 
	 * @return
	 */
	public static String getCurrentAfterDateString() {
		Calendar calendar = new GregorianCalendar();
		int m = calendar.get(Calendar.MONTH) + 1;
		int d = calendar.get(Calendar.DAY_OF_MONTH);
		if (d != 1) {
			d = d - 1;
		} else {
			m = m - 1;
			d = maxDays(Calendar.YEAR, m);
		}
		StringBuffer sbDateStr = new StringBuffer()
				.append(calendar.get(Calendar.YEAR)).append("-")
				.append(m < 10 ? "0" + m : m).append("-")
				.append(d < 10 ? "0" + d : d);
		return String.valueOf(sbDateStr);
	}

	public static String getCurrentTimeString() {
		Calendar calendar = new GregorianCalendar();
		int m = calendar.get(Calendar.MONTH) + 1;
		int d = calendar.get(Calendar.DAY_OF_MONTH);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);

		StringBuffer sbTimeStr = new StringBuffer()
				.append(calendar.get(Calendar.YEAR)).append("-")
				.append(m < 10 ? "0" + m : m).append("-")
				.append(d < 10 ? "0" + d : d).append(" ")
				.append(hour < 10 ? "0" + hour : hour).append(":")
				.append(minute < 10 ? "0" + minute : minute).append(":")
				.append(second < 10 ? "0" + second : second);
		return String.valueOf(sbTimeStr);
	}

	public static String getCurrentTime() {
		Calendar calendar = new GregorianCalendar();
		int m = calendar.get(Calendar.MONTH) + 1;
		int d = calendar.get(Calendar.DAY_OF_MONTH);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);

		StringBuffer sbTimeStr = new StringBuffer()
				.append(calendar.get(Calendar.YEAR))
				.append(m < 10 ? "0" + m : m).append(d < 10 ? "0" + d : d)
				.append(hour < 10 ? "0" + hour : hour)
				.append(minute < 10 ? "0" + minute : minute)
				.append(second < 10 ? "0" + second : second);
		return String.valueOf(sbTimeStr);
	}

	public static String getYear(Date date) {
		String strDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		try {
			strDate = sdf.format(date);
		} catch (Exception e) {
			strDate = sdf.format(new Date());
		}
		return strDate;
	}

	public static String getMonth(Date date) {
		String strDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
		try {
			strDate = sdf.format(date);
		} catch (Exception e) {
			strDate = sdf.format(new Date());
		}
		return strDate;
	}

	

	private static int maxDays(int year, int month) {
		int maxDays = 0;
		if (year < 1900 || year > 9999) {
			return 0;
		} else if (month < 0 || month > 12) {
			return 0;
		} else {
			if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
				// 是闰年
				if (month == 2) {
					maxDays = 29;// 闰年2月29天
				} else if (month == 1 || month == 3 || month == 5 || month == 7
						|| month == 8 || month == 10 || month == 12) {
					maxDays = 31; // 1、3、5、7、8、10、12月都是31天
				} else {
					maxDays = 30; // 其他月份都是30天
				}
			} else {
				// 非闰年
				if (month == 2) {
					maxDays = 28; // 非闰年2月28天
				} else if (month == 1 || month == 3 || month == 5 || month == 7
						|| month == 8 || month == 10 || month == 12) {
					maxDays = 31; // 1、3、5、7、8、10、12月都是31天
				} else {
					maxDays = 30; // 其他月份都是30天
				}
			}
		}
		return maxDays;
	}

	

	public static boolean isBetween(String start, String end) {
		start = start.replaceAll("-", "");
		end = end.replaceAll("-", "");
		String now = getCurrentDateString().replaceAll("-", "");
		int s = Integer.parseInt(start);
		int e = Integer.parseInt(end);
		int n = Integer.parseInt(now);
		return (n - s) >= 0 && (e - n) >= 0 ? true : false;
	}

	/**
	 * 判断是否是日期并将2010-5-2转化2010-05-02
	 * 
	 * @param date
	 * @return 转化后的字符串或当前日期的字符串
	 */
	public static String forDateString(String date) {
		String strDate = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			strDate = sdf.format(sdf.parse(date));
		} catch (Exception e) {
			strDate = sdf.format(new Date());
		}
		return strDate;
	}
	
	/**
	 * 判断是否是日期并将2010-5-2 HH:mm:ss转化2010-05-02 HH:mm:ss
	 * 
	 * @param date
	 * @return 转化后的字符串或当前日期的字符串
	 */
	public static String forDateStringHms(String date) {
		String strDate = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			strDate = sdf.format(sdf.parse(date));
		} catch (Exception e) {
			strDate = sdf.format(new Date());
		}
		return strDate;
	}

	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param dase
	 *            较小的时间
	 * @param bdate
	 *            较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(Date smdate, Date bdate)
			throws ParseException {
		long time1 = smdate.getTime();
		long time2 = bdate.getTime();
		long between_days = (time2 - time1) / (1000 * 24 * 60 * 60);
		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 根据条件获取xq属于几月
	 * 
	 * @param start
	 *            开始日期
	 * @param end
	 *            结束日期
	 * @param zc
	 *            周次
	 * @param xq
	 *            星期几
	 * @return
	 */
	public static int getMonth(String start, String end, int zc, int xq) {
		int zzc = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date ksrq = null;// 本期开始时间
		Date jsrq = null;// 本期结束时间
		try {
			ksrq = sdf.parse(start);
			jsrq = sdf.parse(end);
		} catch (ParseException e) {
			return -2; // 开始日期或者结束日期不正确
		}
		if (ksrq.after(jsrq)) {
			return -3; // 开始日期大于了结束日期
		}
		long diff = jsrq.getTime() - ksrq.getTime();
		String days = diff / (1000 * 60 * 60 * 24) + "";// 本期开始时间与结束时间之间包含的天数
		int ts = Integer.parseInt(days) + 1;// 本期实际总天数
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(ksrq);
		int intWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;// 本期开始时间的星期数（0表示星期日）
		// Date ksdate = null;
		Date jsdate = null;
		switch (intWeek) {// 通过本期开始时间星期数计算本期第一周的结束日期（即第一周的星期日）
		case 0:
			// ksdate = new Date(ksrq.getTime()+1000 * 60 * 60 * 24 * 1);
			jsdate = new Date(ksrq.getTime() + 1000 * 60 * 60 * 24 * 7);
			break;
		case 1:
			// ksdate = new Date(ksrq.getTime());
			jsdate = new Date(ksrq.getTime() + 1000 * 60 * 60 * 24 * 6);
			break;
		case 2:
			// ksdate = new Date(ksrq.getTime());
			jsdate = new Date(ksrq.getTime() + 1000 * 60 * 60 * 24 * 5);
			break;
		case 3:
			// ksdate = new Date(ksrq.getTime());
			jsdate = new Date(ksrq.getTime() + 1000 * 60 * 60 * 24 * 4);
			break;
		case 4:
			// ksdate = new Date(ksrq.getTime());
			jsdate = new Date(ksrq.getTime() + 1000 * 60 * 60 * 24 * 3);
			break;
		case 5:
			// ksdate = new Date(ksrq.getTime());
			jsdate = new Date(ksrq.getTime() + 1000 * 60 * 60 * 24 * 2);
			break;
		case 6:
			// ksdate = new Date(ksrq.getTime()+1000 * 60 * 60 * 24 * 2);
			jsdate = new Date(ksrq.getTime() + 1000 * 60 * 60 * 24 * 1);
			break;
		}
		zzc = ts / 7;// 计算本期的总周次
		if (zzc % 7 != 0) {
			zzc += 1;
		}

		int m1 = -1;
		if (zc == 1) {// 当传入周次等于1时，判断传入星期数是否有效
			if (intWeek == 0) {// 当本期开始时间为周日时传入星期数只能等于7，否则传入星期数不在本期时间范围内，即无效
				if (xq < 7) {
					return -1;
				} else if (xq == 7) {
					calendar.setTime(ksrq);
					m1 = calendar.get(Calendar.MONTH) + 1;
				}
			} else {// 当本期开始时间不为周日时传入星期数只能大于或等于本期开始时间星期数，否则传入星期数不在本期时间范围内，即无效
				if (xq > intWeek) {
					calendar.setTime(new Date(ksrq.getTime() + 1000 * 60 * 60
							* 24 * (xq - intWeek)));
					m1 = calendar.get(Calendar.MONTH) + 1;
				} else if (xq == intWeek) {
					calendar.setTime(ksrq);
					m1 = calendar.get(Calendar.MONTH) + 1;
				} else {
					return -1;
				}
			}
			return m1;
		} else {// 当传入周次不等于1时，判断传入周次与星期数对应的时间是否在本期时间范围内
			calendar.setTime(jsdate);
			// calendar.add(Calendar.DATE,
			// 7*(zc-2))表示计算传入周次的前一周的结束时间，//calendar.add(Calendar.DATE,
			// 7*(zc-2)+xq)表示计算传入周次与星期数所对应的时间，
			calendar.add(Calendar.DATE, 7 * (zc - 2) + xq);
			if (calendar.getTime().getTime() <= jsrq.getTime()) {
				m1 = calendar.get(Calendar.MONTH) + 1;
			} else {
				return -1;// 传入周次与星期数对应的时间不在在本期时间范围内
			}
			return m1;
		}

	}

	public static String getThreeMonthsAgoTime() {
		Date date = new Date();
		String time = formatDate(date);
		String[] item = time.split("-");
		int year = Integer.parseInt(item[0]);
		int month = Integer.parseInt(item[1]);
		int day = Integer.parseInt(item[2]);
		if ((month - 3) <= 0) {
			month = month + 12 - 3;
			year = year - 1;
		} else {
			month = month - 3;
		}
		time = year + "-" + month + "-" + day;

		return time;
	}
}
