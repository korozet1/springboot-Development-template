package com.korozet.zet.util;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateUtil {

	public static final String DATE_PATTERN = "yyyy-MM-dd";

	/**
	 * 获取精确到秒的时间戳
	 * @param
	 * @return
	 */
	public static int getSecondTimestampTwo(){
		Date date=new Date();
		if (null == date) {
			return 0;
		}
		String timestamp = String.valueOf(date.getTime()/1000);
		return Integer.valueOf(timestamp);
	}
	/*
	 * 将时间转换为时间戳:yyyy-MM-dd HH:mm:ss
	 */
	public static Long dateToStamp(String s) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = simpleDateFormat.parse(s);
		long ts = date.getTime();
		//res = String.valueOf(ts);
		return ts;
	}

	/**
	 * String(yyyy-MM-dd HH:mm:ss)转10位时间戳
	 * @param time
	 * @return
	 */
	public static Integer StringToTimestamp(String time){

		int times = 0;
		try {
			times = (int) ((Timestamp.valueOf(time).getTime())/1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(times==0){
			System.out.println("String转10位时间戳失败");
		}
		return times;

	}

	/**
	 * 获取日期时间的年份，如2017-02-13，返回2017
	 * @param date
	 * @return
	 */
	public static int getYear(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.YEAR);
	}

	/**
	 * 获取日期时间的月份，如2017年2月13日，返回2
	 * @param date
	 * @return
	 */
	public static int getMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MONTH) + 1;
	}

	/**
	 * 获取日期时间当月的总天数，如2017-02-13，返回28
	 * @param date
	 * @return
	 */
	public static int getDaysOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.getActualMaximum(Calendar.DATE);
	}


	/**
	 * 字符串解析成时间对象
	 * @param dateTimeString String
	 * @param pattern StrUtils.DATE_TIME_PATTERN || StrUtils.DATE_PATTERN，如果为空，则为yyyy-MM-dd
	 * @return
	 * @throws ParseException
	 */
	public static Date dateParse(String dateTimeString, String pattern) throws ParseException{
		if(StringUtils.isBlank(pattern)){
			pattern = DateUtil.DATE_PATTERN;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.parse(dateTimeString);
	}

	/**
	 * 转换从excel里面读取出来的时间，转为时间戳
	 * @param date
	 * @return
	 */
	public static Integer excelDate(String date){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:dd");
		Calendar calendar = new GregorianCalendar(1900,0,-1);
		Date d = calendar.getTime();
		Date dd = DateUtils.addDays(d,Integer.valueOf(date));
		return StringToTimestamp(sdf.format(dd));
	}

	/**
	 * 时间格式化成字符串
	 * @param date Date
	 * @param pattern StrUtils.DATE_TIME_PATTERN || StrUtils.DATE_PATTERN， 如果为空，则为yyyy-MM-dd
	 * @return
	 * @throws ParseException
	 */
	public static String dateFormat(Date date, String pattern) throws ParseException{
		if(StringUtils.isBlank(pattern)){
			pattern = DateUtil.DATE_PATTERN;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	/**
	 * 时间戳转换成日期格式字符串
	 * @param seconds 精确到秒的字符串
	 * @param
	 * @return
	 */
	public static String timeStamp2Date(String seconds,String format) {
		if(seconds == null || seconds.isEmpty() || seconds.equals("null")){
			return "";
		}
		if(format == null || format.isEmpty()){
			format = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(new Date(Long.valueOf(seconds+"000")));
	}

	//获取当前年
	public static String getSysYear() {
		Calendar date = Calendar.getInstance();
		String year = String.valueOf(date.get(Calendar.YEAR));
		return year;
	}

	/**
	 * 获取本年的第一天
	 * @return String
	 * **/
	public static String getYearStart(){
		return new SimpleDateFormat("yyyy").format(new Date())+"-01-01";
	}

	/**
	 * 获取本年的最后一天
	 * @return String
	 * **/
	public static String getYearEnd(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH,calendar.getActualMaximum(Calendar.MONTH));
		calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		Date currYearLast = calendar.getTime();
		return new SimpleDateFormat("yyyy-MM-dd").format(currYearLast);
	}

	/**
	 * 获取当前日期(yyyy-MM-dd HH:mm:ss)
	 * @return
	 */
	public static String getTodays(String format){
		return new SimpleDateFormat(format).format(new Date());
	}
	/**
	 * 获取今天(yyyy-MM-dd)
	 * @return String
	 * */
	public static String getToday(){
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}

	/**
	 * 获取本月开始日期
	 * @return String
	 * **/
	public static String getMonthStart(){
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.MONTH, 0);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date time=cal.getTime();
		return new SimpleDateFormat("yyyy-MM-dd").format(time);
	}
	/**
	 * 获取本月最后一天
	 * @return String
	 * **/
	public static String getMonthEnd(){
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		Date time=cal.getTime();
		return new SimpleDateFormat("yyyy-MM-dd").format(time);
	}

	/**
	 * 获取本周的第一天
	 * @return String
	 * **/
	public static String getWeekStart(){
		Calendar cal=Calendar.getInstance();
		cal.setFirstDayOfWeek(Calendar.MONDAY);//设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
		cal.add(Calendar.WEEK_OF_MONTH, 0);
		cal.set(Calendar.DAY_OF_WEEK, 2);
		Date time=cal.getTime();
		return new SimpleDateFormat("yyyy-MM-dd").format(time);
	}


	/**
	 * 获取本周的最后一天
	 * @return String
	 * **/
	public static String getWeekEnd(){
		Calendar cal=Calendar.getInstance();
		cal.setFirstDayOfWeek(Calendar.MONDAY);//设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
		cal.set(Calendar.DAY_OF_WEEK, cal.getActualMaximum(Calendar.DAY_OF_WEEK));
		cal.add(Calendar.DAY_OF_WEEK, 1);
		Date time=cal.getTime();
		return new SimpleDateFormat("yyyy-MM-dd").format(time);
	}
	//获取今天星期几
	public static String getCurrDayOfWeek(String date) throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		// SimpleDateFormat dateFm = new SimpleDateFormat("yyyy年MM月dd日 EEEE", Locale.ENGLISH);
		SimpleDateFormat dateFm = new SimpleDateFormat("EEEE", Locale.CHINA);
		return dateFm.format(sdf.parse(date));
	}



	// 获取上周的开始时间
	public static Date getBeginDayOfLastWeek() {
		Date date = new Date();
		if (date == null) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
		if (dayofweek == 1) {
			dayofweek += 7;
		}
		cal.add(Calendar.DATE, 2 - dayofweek - 7);
		return getDayStartTime(cal.getTime());
	}

	// 获取上周的结束时间
	public static Date getEndDayOfLastWeek() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getBeginDayOfLastWeek());
		cal.add(Calendar.DAY_OF_WEEK, 6);
		Date weekEndSta = cal.getTime();
		return getDayEndTime(weekEndSta);
	}
	// 获取某个日期的开始时间
	public static Timestamp getDayStartTime(Date d) {
		Calendar calendar = Calendar.getInstance();
		if (null != d)
			calendar.setTime(d);
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
				calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return new Timestamp(calendar.getTimeInMillis());
	}

	// 获取某个日期的结束时间
	public static Timestamp getDayEndTime(Date d) {
		Calendar calendar = Calendar.getInstance();
		if (null != d)
			calendar.setTime(d);
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
				calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return new Timestamp(calendar.getTimeInMillis());
	}

	//上个月的现在
	public static String getNowOfLastMonth() {
		// Date Format will be display
		SimpleDateFormat aSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		GregorianCalendar aGregorianCalendar = new GregorianCalendar();
		// Get last month GregorianCalendar object
		aGregorianCalendar.set(Calendar.MONTH, aGregorianCalendar
				.get(Calendar.MONTH) - 1);
		// Format the date to get year and month
		String nowOfLastMonth = aSimpleDateFormat
				.format(aGregorianCalendar.getTime());
		return nowOfLastMonth;
	}

	//去年的现在
	public static String getNowOfLastYear() {
		// Date Format will be display
		SimpleDateFormat aSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		GregorianCalendar aGregorianCalendar = new GregorianCalendar();
		// Get last month GregorianCalendar object
		aGregorianCalendar.set(Calendar.YEAR, aGregorianCalendar
				.get(Calendar.YEAR) - 1);
		// Format the date to get year and month
		String currentYearAndMonth = aSimpleDateFormat
				.format(aGregorianCalendar.getTime());
		return currentYearAndMonth;
	}


	/**
	 * 获取昨天的日期
	 * @return
	 */
	public static String getYesterday(){
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DATE,-1);
		Date d=cal.getTime();
		SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
		String yesterday=sp.format(d);//获取昨天日期
		return yesterday;
	}


	/**
	 * 校验开始时间是否大于结束时间
	 *
	 * @param startTime 开始时间字符串
	 * @param endTime 结束时间字符串
	 * @param format 格式
	 * @return
	 */
	public static boolean checkTimeRange(String startTime, String endTime, String format) {
		try {

			SimpleDateFormat sdf = new SimpleDateFormat(format);
			Date startDate = null;
			Date endDate = null;

			startDate = sdf.parse(startTime);
			endDate = sdf.parse(endTime);

			if (startDate.after(endDate)) { //startDate是否在endTime之后，为true 表示  startTime>endTime
				return true;
			} else {
				return false;
			}
            /*
            if (startDate.getTimee()>endDate.getEndTime()) { //判断时间戳
                return true;
            } else {
               return false;
            }*/
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}



	//获取某个日期几天前后的日期
	public static String addDay(String date, int num)   {
		Date date1 = null;
		try {
			date1 = DateUtil.dateParse(date, "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar startDT = Calendar.getInstance();
		startDT.setTime(date1);
		startDT.add(Calendar.DATE, num);
		return sdf.format(startDT.getTime());
	}
	/**
	 * 获取本周周几的日期
	 * @param day 周几（从周日开始，周日=1，周六=7）
	 * @return
	 */
	public static String getWeekDay(int day){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		Calendar cld = Calendar.getInstance(Locale.CHINA);
		cld.setFirstDayOfWeek(Calendar.MONDAY);//以周一为首日
		cld.setTimeInMillis(System.currentTimeMillis());//当前时间
		cld.set(Calendar.DAY_OF_WEEK, day);
		return df.format(cld.getTime());
	}


	/**
	 * 获取下周周几的日期
	 * @param day 周几（从周日开始，周日=1，周六=7）
	 * @return
	 */
	public static String getNextWeekDay(int day){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		Calendar cld = Calendar.getInstance(Locale.CHINA);
		cld.setFirstDayOfWeek(Calendar.MONDAY);//以周一为首日
		cld.setTimeInMillis(System.currentTimeMillis());//当前时间
		cld.set(Calendar.DAY_OF_WEEK, day);
		return addDay(df.format(cld.getTime()),7);
	}


	public static int weekStrToNum(String str){
		if(str.equals("周一")){
			return 2;
		}else if(str.equals("周二")){
			return 3;
		}else if(str.equals("周三")){
			return 4;
		}else if(str.equals("周四")){
			return 5;
		}else if(str.equals("周五")){
			return 6;
		}else if(str.equals("周六")){
			return 7;
		}else if(str.equals("周日")){
			return 1;
		}else{
			return 0;
		}
	}

	/**
	 * 获取当前周几
	 * @return
	 */
	public static int getWeek() {
		Date today = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(today);
		int weekday = c.get(Calendar.DAY_OF_WEEK);
		return weekday;
	}


	public static long timeDifference(String startStr,String endStr){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long ss = 0;
		try {
			Date startDate=df.parse(startStr);
			Date endDate=df.parse(endStr);
			long startTime=startDate.getTime();
			long endTime=endDate.getTime();
			ss=endTime-startTime;

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return ss;
	}

	/**
	 * 获取指定月的第一天日期和最后一天日期
	 *
	 * @param todayTime:"2017-03-15"
	 * @return arr[0] 第一天日期 ；arr[1]最后一天日期
	 * @throws ParseException
	 */
	public static String[] getMonthStartAndEndDate(String todayTime) {
		String[] arr = new String[2];
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(sdf.parse(todayTime));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.set(Calendar.DAY_OF_MONTH, 1);
		arr[0] = sdf.format(c.getTime());
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		arr[1] = sdf.format(c.getTime());
		return arr;

	}



	/**
	 * 当前时间加上num月或减num个月后的时间
	 *
	 * @return
	 * @throws ParseException
	 */
	public static String subMonth(int num) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new Date());
		Date dt = null;
		try {
			dt = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(dt);
		rightNow.add(Calendar.MONTH, num);
		Date dt1 = rightNow.getTime();
		String reStr = sdf.format(dt1);
		return reStr;
	}


	/**
	 * 计算两个时间之间的时间差分钟数
	 * @param date 传入时间
	 * @param tyep 1：当前时间减传入时间 2：传入时间减当前时间
	 * @return
	 */
	public static  long timeDiff(String date,Integer tyep){
		long currentTime =getSecondTimestampTwo();
		//从对象中拿到时间
		long dateTime=StringToTimestamp(date);
		long diff=0;
		if(tyep==1){
			diff=(currentTime-dateTime)/60;
		}else{
			diff=(dateTime-currentTime)/60;
		}
		return diff;
	}

	/**
	 * 返回当前日 ss
	 * @return
	 */
	public static String getToDay(){
		String day=getToday().substring(8,10);
		return day;
	}


	/**
	 * 计算两个时间的时间差
	 * @param date
	 * @return
	 */
	public static Integer getTimeDiffBySecond(String date) {
		Integer time1=StringToTimestamp(date);
		Integer time2= getSecondTimestampTwo();
		return time1-time2;
	}


	/**
	 * 当前时间加上num天或减num天后的时间
	 *
	 * @return
	 * @throws ParseException
	 */
	public static String subDay(String endDate, int num) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = null;
		try {
			date = sdf.format(dateParse(endDate,"yyyy-MM-dd"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date dt = null;
		try {
			dt = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(dt);
		rightNow.add(Calendar.DATE, num);
		Date dt1 = rightNow.getTime();
		String reStr = sdf.format(dt1);
		return reStr;
	}

	public static LocalDateTime stringToLocalTime(String date){
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime ldt = LocalDateTime.parse(date,df);
		return ldt;
	}

}
