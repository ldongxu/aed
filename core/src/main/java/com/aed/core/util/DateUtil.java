package com.aed.core.util;



import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author liudongxu06
 * @date 2017/11/6
 */
public class DateUtil {
	
    private static Logger logger = LoggerFactory.getLogger(DateUtil.class);
    
    public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
    public static final String DEFAULT_TIME_PATTERN = "HH:mm:ss";
    public static final String DEFAULT_DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_PATTERN_YYYYMMDD = "yyyyMMdd";
    
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(DEFAULT_DATE_PATTERN);
    private static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat(DEFAULT_TIME_PATTERN);
    private static final SimpleDateFormat DATETIME_FORMAT = new SimpleDateFormat(DEFAULT_DATETIME_PATTERN);

    private DateUtil() {
    }

    /**
     * 当前时间，格式 yyyy-MM-dd HH:mm:ss
     *
     * @return 当前时间的标准形式字符串
     */
    public static String now() {
        return formatDateTime(new Date());
    }

    /**
     * 当前日期，格式 yyyy-MM-dd
     *
     * @return 当前日期的标准形式字符串
     */
    public static String today() {
        return formatDate(new Date());
    }

    /**
     * 根据特定格式格式化日期
     *
     * @param date    被格式化的日期
     * @param pattern 格式
     * @return 格式化后的字符串
     */
    public static String format(Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }

    /**
     * 格式 yyyy-MM-dd
     *
     * @param date 被格式化的日期
     * @return 格式化后的日期
     */
    public static String formatDate(Date date) {
        return DATE_FORMAT.format(date);
    }

    /**
     * 格式HH:mm:ss
     *
     * @param date 被格式化的日期
     * @return 格式化后的日期
     */
    public static String formatTime(Date date) {
        return TIME_FORMAT.format(date);
    }

    /**
     * 格式 yyyy-MM-dd HH:mm:ss
     *
     * @param date 被格式化的日期
     * @return 格式化后的日期
     */
    public static String formatDateTime(Date date) {
        return DATETIME_FORMAT.format(date);
    }

    /**
     * 将特定格式的日期转换为Date对象
     *
     * @param dateString 特定格式的日期
     * @param format     格式，例如yyyy-MM-dd
     * @return 日期对象
     */
    public static Date parse(String dateString, String format) {
        try {
            return (new SimpleDateFormat(format)).parse(dateString);
        } catch (ParseException e) {
            logger.error("Parse " + dateString + " with format " + format + " error!", e);
        }
        return null;
    }

    /**
     * 格式yyyy-MM-dd HH:mm:ss
     *
     * @param dateString 标准形式的时间字符串
     * @return 日期对象
     */
    public static Date parseDateTime(String dateString) {
        try {
            return DATETIME_FORMAT.parse(dateString);
        } catch (ParseException e) {
            logger.error("Parse " + dateString + " with format " + DEFAULT_DATETIME_PATTERN + " error!", e);
        }
        return null;
    }

    /**
     * 格式yyyy-MM-dd
     *
     * @param dateString 标准形式的日期字符串
     * @return 日期对象
     */
    public static Date parseDate(String dateString) {
        try {
            return DATE_FORMAT.parse(dateString);
        } catch (ParseException e) {
            logger.error("Parse " + dateString + " with format " + DEFAULT_DATE_PATTERN + " error!", e);
        }
        return null;
    }

    /**
     * 格式HH:mm:ss
     *
     * @param timeString 标准形式的日期字符串
     * @return 日期对象
     */
    public static Date parseTime(String timeString) {
        try {
            return TIME_FORMAT.parse(timeString);
        } catch (ParseException e) {
            logger.error("Parse " + timeString + " with format " + DEFAULT_TIME_PATTERN + " error!", e);
        }
        return null;
    }

    /**
     * 格式：<br>
     * 1、yyyy-MM-dd HH:mm:ss<br>
     * 2、yyyy-MM-dd<br>
     * 3、HH:mm:ss>
     *
     * @param dateStr 日期字符串
     * @return 日期
     */
    public static Date parse(String dateStr) {
        int length = dateStr.length();
        try {
            if (length == DEFAULT_DATETIME_PATTERN.length()) {
                return parseDateTime(dateStr);
            } else if (length == DEFAULT_DATE_PATTERN.length()) {
                return parseDate(dateStr);
            } else if (length == DEFAULT_TIME_PATTERN.length()) {
                return parseTime(dateStr);
            }
        } catch (Exception e) {
            logger.error("Parse " + dateStr + " with format normal error!", e);
        }
        return null;
    }

    /**
     * 获取指定日期偏移指定时间后的时间
     *
     * @param date          基准日期
     * @param calendarField 偏移的粒度大小（小时、天、月等）使用Calendar中的常数
     * @param offsite       偏移量，正数为向后偏移，负数为向前偏移
     * @return 偏移后的日期
     */
    public static Date offsiteDate(Date date, int calendarField, int offsite) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(calendarField, offsite);
        return cal.getTime();
    }

    /**
     * 昨天
     *
     * @return 昨天
     */
    public static Date yesterday() {
        return offsiteDate(new Date(), Calendar.DAY_OF_YEAR, -1);
    }

    /**
     * 上周
     *
     * @return 上周
     */
    public static Date lastWeek() {
        return offsiteDate(new Date(), Calendar.WEEK_OF_YEAR, -1);
    }

    /**
     * 上个月
     *
     * @return 上个月
     */
    public static Date lastMouth() {
        return offsiteDate(new Date(), Calendar.MONTH, -1);
    }
    
    /**
     * 获取指定日期多少天之前的日期
     * @param date
     * @param someDays
     * @param pattern
     * @return
     */
    public static String getSomeDaysAgo(Date date, int someDays, String pattern) {
    	Date someDate = offsiteDate(date, Calendar.DAY_OF_YEAR, someDays);
    	return format(someDate, pattern);
    }
    
    /**
     * 获取指定年的最大周数
     */
    public static int getMaxWeekNumOfYear(int year) {
    	Calendar calendar = Calendar.getInstance();
    	calendar.set(year, Calendar.DECEMBER, 31, 23, 59, 59);
    	return calendar.getWeeksInWeekYear();
    }
    
    /**
     * 获取指定日期所在周
     * @param date
     * return 格式：YYYYWW
     */
    public static String getWeekOfYear(Date date) {
    	String currWeek = "";
    	
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(date);
    	int year = calendar.get(Calendar.YEAR);
    	int weekYear = calendar.getWeekYear();
    	if(year<weekYear) { // 跨年了
    		int maxWeekNumOfYear = getMaxWeekNumOfYear(year);
    		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
    		if(dayOfWeek==0) {  // 按中国人习惯，星期天应该归属到本周最后一天（美国人一周的第一天是星期天）
    			dayOfWeek = 7;
    		}
    		if(dayOfWeek==7) { // 如果是星期天，则归属到上一周
    			currWeek = year + "" + maxWeekNumOfYear;
    		} else {
    			currWeek = weekYear + "01";
    		}
    		
    	} else { // 未跨年
    		int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
    		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
    		if(dayOfWeek==0) {  // 按中国人习惯，星期天应该归属到本周最后一天（美国人一周的第一天是星期天）
    			dayOfWeek = 7;
    		}
    		if(dayOfWeek==7) { // 如果是星期天，则归属到上一周
    			weekOfYear = weekOfYear - 1;
    		}
    		if(weekOfYear<10) { // 补位
    			currWeek = String.valueOf(year) + "0" + String.valueOf(weekOfYear);
    		} else {
    			currWeek = String.valueOf(year) + String.valueOf(weekOfYear);
    		}
    	}
    	
    	return currWeek;
    }
    
    /**
     * 获取指定日期所在月份
     * @param date
     * return 格式：YYYYMM
     */
    public static String getMonthOfYear(Date date) {
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(date);
    	int year = calendar.get(Calendar.YEAR);
    	int month = calendar.get(Calendar.MONTH)+1; // 老外月份是0~11月
    	if(month<10) { // 补位
    		return year + "0" + String.valueOf(month);
    	} else {
    		return year + String.valueOf(month);
    	}
    }
    
    /**
     * 获取指定日期所在季度
     * @param date
     * return 格式：YYYYJ
     */
    public static String getQuarterOfYear(Date date) {
    	String quarter = "";
    	
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(date);
    	int year = calendar.get(Calendar.YEAR);
    	int month = calendar.get(Calendar.MONTH)+1; // 老外月份是0~11月
    	if(month>=1 && month<=3) {
    		quarter = "1";
    	} else if(month>=4 && month<=6) {
    		quarter = "2";
    	} else if(month>=7 && month<=9) {
    		quarter = "3";
    	} else if(month>=10 && month<=12) {
    		quarter = "4";
    	}
    	
    	return year + quarter;
    }
    
    /**
     * 获取指定日期所在周度的第一天的日期
     * @param date
     * @param datePattern
     * return 格式：YYYY-MM-DD
     */
    public static String getBeginDateOfWeek(Date date, String datePattern) {
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(date);
    	int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
    	if(dayOfWeek==0) {  // 按中国人习惯，星期天应该归属到本周最后一天（美国人一周的第一天是星期天）
    		calendar.add(Calendar.DATE, -7); // 将周日归属到上一周
    	}
    	calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
    	return format(calendar.getTime(), datePattern);
    }
    
    /**
     * 获取指定日期所在周最后一天的日期
     * @param date
     * @param datePattern
     * return 格式：YYYY-MM-DD
     */
    public static String getEndDateOfWeek(Date date, String datePattern) {
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(date);
    	int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
    	if(dayOfWeek!=0) {  // 按中国人习惯，星期天应该归属到本周最后一天（美国人一周的第一天是星期天）
    		calendar.add(Calendar.DATE, 7); // 按中国人习惯，一周最后一天是周日
    	}
    	calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
    	return format(calendar.getTime(), datePattern);
    }
    
    /**
     * 获取指定日期所在月度的第一天的日期
     * @param date
     * @param datePattern
     * return 格式：YYYY-MM-DD
     */
    public static String getBeginDateOfMonth(Date date, String datePattern) {
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(date);
    	calendar.add(Calendar.MONTH, 0);
    	calendar.set(Calendar.DAY_OF_MONTH, 1);
    	return format(calendar.getTime(), datePattern);
    }
    
    /**
     * 获取指定日期所在月度最后一天的日期
     * @param date
     * @param datePattern
     * return 格式：YYYY-MM-DD
     */
    public static String getEndDateOfMonth(Date date, String datePattern) {
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(date);
    	calendar.add(Calendar.MONTH, 1);
    	calendar.set(Calendar.DAY_OF_MONTH, 0);
    	return format(calendar.getTime(), datePattern);
    }
    
    /**
     * 获取指定日期所在季度的第一天的日期
     * @param date
     * return 格式：YYYY-MM-DD
     */
    public static String getBeginDateOfQuarter(Date date) {
    	String beginDate = "";
    	
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(date);
    	int year = calendar.get(Calendar.YEAR);
    	int month = calendar.get(Calendar.MONTH)+1; // 老外月份是0~11月
    	if(month>=1 && month<=3) {
    		beginDate = "01-01";
    	} else if(month>=4 && month<=6) {
    		beginDate = "04-01";
    	} else if(month>=7 && month<=9) {
    		beginDate = "07-01";
    	} else if(month>=10 && month<=12) {
    		beginDate = "10-01";
    	}
    	
    	return year + "-" + beginDate;
    }
    
    /**
     * 获取指定日期所在季度最后一天的日期
     * @param date
     * return 格式：YYYY-MM-DD
     */
    public static String getEndDateOfQuarter(Date date) {
    	String endDate = "";
    	
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(date);
    	int year = calendar.get(Calendar.YEAR);
    	int month = calendar.get(Calendar.MONTH)+1; // 老外月份是0~11月
    	if(month>=1 && month<=3) {
    		endDate = "03-31";
    	} else if(month>=4 && month<=6) {
    		endDate = "06-30";
    	} else if(month>=7 && month<=9) {
    		endDate = "09-30";
    	} else if(month>=10 && month<=12) {
    		endDate = "12-31";
    	}
    	
    	return year + "-" + endDate;
    }
    
    /**
     * 获取当前周第一天到第七天的日期列表
     * @param datePattern
     * return
     */
    public static List<String> getDateListOfCurrWeek(String datePattern) {
    	List<String> weekDateList = new ArrayList<>();
    	
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(new Date());
    	int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
    	if(dayOfWeek==0) {  // 按中国人习惯，星期天应该归属到本周最后一天（美国人一周的第一天是星期天）
    		calendar.add(Calendar.DATE, -7); // 将周日归属到上一周
    	}
    	
    	calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
    	weekDateList.add(format(calendar.getTime(), datePattern));
    	calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
    	weekDateList.add(format(calendar.getTime(), datePattern));
    	calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
    	weekDateList.add(format(calendar.getTime(), datePattern));
    	calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
    	weekDateList.add(format(calendar.getTime(), datePattern));
    	calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
    	weekDateList.add(format(calendar.getTime(), datePattern));
    	calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
    	weekDateList.add(format(calendar.getTime(), datePattern));
    	calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
    	calendar.add(Calendar.DATE, 7); // 按中国人习惯，一周最后一天是周日
    	weekDateList.add(format(calendar.getTime(), datePattern));
    	
    	return weekDateList;
    }
    
    /**
     * 获取指定日期所在周第一天到第七天的日期列表
     * @param date
     * @param datePattern
     * return
     */
    public static List<String> getDateListOfWeek(Date date, String datePattern) {
    	List<String> weekDateList = new ArrayList<>();
    	
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(date);
    	int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
    	if(dayOfWeek==0) {  // 按中国人习惯，星期天应该归属到本周最后一天（美国人一周的第一天是星期天）
    		calendar.add(Calendar.DATE, -7); // 将周日归属到上一周
    	}
    	
    	calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
    	weekDateList.add(format(calendar.getTime(), datePattern));
    	calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
    	weekDateList.add(format(calendar.getTime(), datePattern));
    	calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
    	weekDateList.add(format(calendar.getTime(), datePattern));
    	calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
    	weekDateList.add(format(calendar.getTime(), datePattern));
    	calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
    	weekDateList.add(format(calendar.getTime(), datePattern));
    	calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
    	weekDateList.add(format(calendar.getTime(), datePattern));
    	calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
    	calendar.add(Calendar.DATE, 7); // 按中国人习惯，一周最后一天是周日
    	weekDateList.add(format(calendar.getTime(), datePattern));
    	
    	return weekDateList;
    }
    
    /**
     * 获取两个日期之间的所有日期列表
     * @param beginDate
     * @param endDate
     * @param datePattern
     * return
     */
    public static List<String> getDateListBetweenToDates(Date beginDate, Date endDate, String datePattern) {
    	if(beginDate==null || endDate==null) {
    		return null;
    	}
    	
    	List<String> dateList = new ArrayList<>();
    	SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
        Calendar calendar = Calendar.getInstance();
        while (beginDate.getTime() <= endDate.getTime()){
        	dateList.add(sdf.format(beginDate));
        	calendar.setTime(beginDate);
        	calendar.add(Calendar.DATE, 1);//增加一天 放入集合
            beginDate = calendar.getTime();
        }
    	return dateList;
    }
    
    /**
     * 获取两个周之间的所有周列表
     * @param beginWeekStr
     * @param endWeekStr
     * return 格式：YYYYWW
     */
    public static List<String> getWeekListBetweenToWeeks(String beginWeekStr, String endWeekStr) {
    	if(StringUtils.isEmpty(beginWeekStr) || StringUtils.isEmpty(endWeekStr)) {
    		return null;
    	}
    	if(Integer.parseInt(beginWeekStr) > Integer.parseInt(endWeekStr)) {
    		return null;
    	}
    	List<String> weekList = new ArrayList<>();
    	String tempWeek = "";
    	int beginYear = Integer.parseInt(beginWeekStr.substring(0, 4));
    	int beginWeek = Integer.parseInt(beginWeekStr.substring(4, 6));
    	int endYear = Integer.parseInt(endWeekStr.substring(0, 4));
    	int endWeek = Integer.parseInt(endWeekStr.substring(4, 6));
    	if(beginYear<endYear) { // 不在同一年内（跨年了）
    		// 结果周列表 = beginWeek到beginYear年底剩余的周 + 中间的年份所有月 + endYear的第1周到endWeek
    		int maxWeekNumOfBeginYear = getMaxWeekNumOfYear(beginYear); // 一年的周数
    		for(int i=beginWeek; i<=maxWeekNumOfBeginYear; i++) {
    			if(i<10) {
    				tempWeek = beginYear + "0" + i;
    			} else {
    				tempWeek = beginYear + "" + i;
    			}
    			weekList.add(tempWeek);
    		}
    		int diff = endYear-beginYear; // 相差的年数
    		if(diff>1) { // 不只跨了一年
    			List<String> middleList = new ArrayList<>();
    			for(int k=1; k<diff; k++) {
    				int yearK = beginYear + k;
    				maxWeekNumOfBeginYear = getMaxWeekNumOfYear(yearK);
    				for(int m=1; m<=maxWeekNumOfBeginYear; m++) {
    					if(m<10) {
    						tempWeek = yearK + "0" + m;
    					} else {
    						tempWeek = yearK + "" + m;
    					}
    					middleList.add(tempWeek);
    				}
    			}
    			weekList.addAll(middleList);
    		}
    		for(int j=1; j<=endWeek; j++) {
    			if(j<10) {
    				tempWeek = endYear + "0" + j;
    			} else {
    				tempWeek = endYear + "" + j;
    			}
    			weekList.add(tempWeek);
    		}
    		
    	} else if(beginYear==endYear) { // 同一年
    		// 结果周列表 = beginWeek到endWeek之间全部周
    		for(int i=beginWeek; i<=endWeek; i++) {
    			if(i<10) {
    				tempWeek = beginYear + "0" + i;
    			} else {
    				tempWeek = beginYear + "" + i;
    			}
    			weekList.add(tempWeek);
    		}
    	}
    	
    	return weekList;
    }
    
    /**
     * 获取两个月份之间的所有月份列表
     * @param beginMonthStr
     * @param endMonthStr
     * return
     */
    public static List<String> getMonthListBetweenToMonths(String beginMonthStr, String endMonthStr) {
    	if(StringUtils.isEmpty(beginMonthStr) || StringUtils.isEmpty(endMonthStr)) {
    		return null;
    	}
    	if(Integer.parseInt(beginMonthStr) > Integer.parseInt(endMonthStr)) {
    		return null;
    	}
    	
    	List<String> monthList = new ArrayList<>();
    	String tempMonth = "";
    	int beginYear = Integer.parseInt(beginMonthStr.substring(0, 4));
    	int beginMonth = Integer.parseInt(beginMonthStr.substring(4, 6));
    	int endYear = Integer.parseInt(endMonthStr.substring(0, 4));
    	int endMonth = Integer.parseInt(endMonthStr.substring(4, 6));
    	if(beginYear<endYear) { // 不在同一年内（跨年了）
    		// 结果月份列表 = beginMonth到beginYear年底剩余的月 + endYear的第1月到endMonth
    		for(int i=beginMonth; i<=12; i++) {
    			if(i<10) {
    				tempMonth = beginYear + "0" + i;
    			} else {
    				tempMonth = beginYear + "" + i;
    			}
    			monthList.add(tempMonth);
    		}
    		int diff = endYear-beginYear; // 相差的年数
    		if(diff>1) { // 不只跨了一年
    			List<String> middleList = new ArrayList<>();
    			for(int k=1; k<diff; k++) {
    				int yearK = beginYear + k;
    				for(int m=1; m<=12; m++) {
    					if(m<10) {
    						tempMonth = yearK + "0" + m;
    					} else {
    						tempMonth = yearK + "" + m;
    					}
    					middleList.add(tempMonth);
    				}
    			}
    			monthList.addAll(middleList);
    		}
    		for(int j=1; j<=endMonth; j++) {
    			if(j<10) {
    				tempMonth = endYear + "0" + j;
    			} else {
    				tempMonth = endYear + "" + j;
    			}
    			monthList.add(tempMonth);
    		}
    		
    	} else if(beginYear==endYear) { // 同一年
    		// 结果月份列表 = beginMonth到endMonth之间全部月份
    		for(int i=beginMonth; i<=endMonth; i++) {
    			if(i<10) {
    				tempMonth = beginYear + "0" + i;
    			} else {
    				tempMonth = beginYear + "" + i;
    			}
    			monthList.add(tempMonth);
    		}
    	}
    	
    	return monthList;
    }
    
    /**
     * 获取两个季度之间的所有季度列表
     * @param beginQuarterStr
     * @param endQuarterStr
     * return
     */
    public static List<String> getQuarterListBetweenToQuarters(String beginQuarterStr, String endQuarterStr) {
    	if(StringUtils.isEmpty(beginQuarterStr) || StringUtils.isEmpty(endQuarterStr)) {
    		return null;
    	}
    	if(Integer.parseInt(beginQuarterStr) > Integer.parseInt(endQuarterStr)) {
    		return null;
    	}
    	
    	List<String> quarterList = new ArrayList<>();
    	String tempQuarter = "";
    	int beginYear = Integer.parseInt(beginQuarterStr.substring(0, 4));
    	int beginQuarter = Integer.parseInt(beginQuarterStr.substring(4, 5));
    	int endYear = Integer.parseInt(endQuarterStr.substring(0, 4));
    	int endQuarter = Integer.parseInt(endQuarterStr.substring(4, 5));
    	if(beginYear<endYear) { // 不在同一年内（跨年了）
    		// 结果季度列表 = beginQuarter到beginYear年底剩余的季度 + endYear的第1季度到endQuarter
    		for(int i=beginQuarter; i<=4; i++) {
    			tempQuarter = beginYear + "" + i;
    			quarterList.add(tempQuarter);
    		}
    		int diff = endYear-beginYear; // 相差的年数
    		if(diff>1) { // 不只跨了一年
    			List<String> middleList = new ArrayList<>();
    			for(int k=1; k<diff; k++) {
    				int yearK = beginYear + k;
    				for(int m=1; m<=4; m++) {
    					tempQuarter = yearK + "" + m;
    					middleList.add(tempQuarter);
    				}
    			}
    			quarterList.addAll(middleList);
    		}
    		for(int j=1; j<=endQuarter; j++) {
    			tempQuarter = endYear + "" + j;
    			quarterList.add(tempQuarter);
    		}
    		
    	} else if(beginYear==endYear) { // 同一年
    		// 结果季度列表 = beginQuarter到endQuarter之间全部季度
    		for(int i=beginQuarter; i<=endQuarter; i++) {
    			tempQuarter = beginYear + "" + i;
    			quarterList.add(tempQuarter);
    		}
    	}
    	
    	return quarterList;
    }
    
    /**
     * 获取当日剩余秒数
     * @return
     */
    public static int getRemaindSecondsToTodayEnd() {
        Calendar current = Calendar.getInstance();
        current.set(Calendar.MILLISECOND, 0);
        long currentTimes = current.getTimeInMillis();
        current.set(Calendar.HOUR_OF_DAY, 23);
        current.set(Calendar.MINUTE, 59);
        current.set(Calendar.SECOND, 59);
        long endTimes = current.getTimeInMillis();
        return (int) ((endTimes - currentTimes) / 1000);
    }
    
    /**
     * 获取截止到本周末24点剩余秒数
     * @param date
     */
    public static int getRemaindSecondsToWeekEnd() {
    	Date now = new Date();
    	String weekEnd = getEndDateOfWeek(now, DateUtil.DEFAULT_DATE_PATTERN);
    	Date endDate = parse(weekEnd + " 23:59:59", DateUtil.DEFAULT_DATETIME_PATTERN);
    	int daysDiff = getDaysDiff(now, endDate);
    	// 二者相差的天数*24*3600 + 今天剩余的秒数
    	return daysDiff * 24 * 3600 + getRemaindSecondsToTodayEnd();
    }
    
    /**
     * 获取截止到本季度末24点剩余天数
     * @param date
     */
    public static int getRemaindSecondsToQuarterEnd() {
    	Date beginDate = new Date();
    	String quarterEnd = getEndDateOfQuarter(new Date());
    	Date endDate = DateUtil.parse(quarterEnd + " 23:59:59", DateUtil.DEFAULT_DATETIME_PATTERN);
    	int daysDiff = getDaysDiff(beginDate, endDate);
    	// 二者相差的天数*24*3600 +今天剩余的秒数
    	return daysDiff * 24 * 3600 + getRemaindSecondsToTodayEnd();
    }
    
    /**
     * 获取两个日期相差的天数
     */
    public static int getDaysDiff(Date beginDate, Date endDate) {
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(beginDate);
    	int beginDay = calendar.get(Calendar.DAY_OF_YEAR);
    	calendar.setTime(endDate);
    	int endDay = calendar.get(Calendar.DAY_OF_YEAR);
    	return endDay - beginDay;
    }
    
    /**
     * 获取系统启动时间戳，作为静态资源版本号，格式：yyyyMMddHHmm
     */
    public static String getBuildNo() {
    	return DateUtil.format(new Date(), "yyyyMMddHHmm");
    }
    
    public static void main(String[] args) {
    	Date date = new Date();
    	date = parse("2018-04-29 12:00:01", DateUtil.DEFAULT_DATETIME_PATTERN);
    	System.out.println(getBeginDateOfWeek(date, DateUtil.DEFAULT_DATE_PATTERN));
    	System.out.println(getEndDateOfWeek(date, DateUtil.DEFAULT_DATE_PATTERN));
//    	System.out.println(getBeginDateOfWeek(date, DateUtil.DEFAULT_DATE_PATTERN));
//    	System.out.println(getEndDateOfWeek(date, DateUtil.DEFAULT_DATE_PATTERN));
//    	System.out.println(getBeginDateOfMonth(date, DateUtil.DEFAULT_DATE_PATTERN));
//    	System.out.println(getEndDateOfMonth(date, DateUtil.DEFAULT_DATE_PATTERN));
//    	System.out.println(getBeginDateOfQuarter(date));
//    	System.out.println(getEndDateOfQuarter(date));
//    	System.out.println(getDateListOfCurrWeek(DateUtil.DEFAULT_DATE_PATTERN));
//    	System.out.println(getDateListOfWeek(date, DateUtil.DEFAULT_DATE_PATTERN));
//    	System.out.println(getDateListBetweenToDates(date, date1, DateUtil.DATE_PATTERN_YYYYMMDD));
//    	System.out.println(getWeekListBetweenToWeeks("201750", "201910"));
//    	System.out.println(getMonthListBetweenToMonths("201801", "201810"));
//    	System.out.println(getQuarterListBetweenToQuarters("20171", "20191"));
    	System.out.println(getBuildNo());
    }
}
