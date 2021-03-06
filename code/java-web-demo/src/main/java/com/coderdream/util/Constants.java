package com.coderdream.util;

public class Constants {

	public final static String SIMPLE_DATE_FORMAT = "yyyy-MM-dd";

	public final static String TABLE_STRUCTURE_FILE_NAME = "TableStructure.xlsx";

	public final static String DATA_FILE_NAME = "Data11.xlsx";

	public final static String EXCAVATOR_FILE_NAME = "挖掘机.20171002.xlsx";

	public final static String CATEGORY_OIL_FEE = "加油费";

	public final static String CATEGORY_SERVICE = "维修保养";

	public final static String CATEGORY_LOADING = "装车";

	public final static String CATEGORY_LOADING_BIG = "大车";

	public final static String CATEGORY_LOADING_SMALL = "小车";

	public final static String CATEGORY_SHIFT = "台班";

	public final static String CATEGORY_TOTAL = "T";

	public final static String CATEGORY_LOADING_BIG_SHORT = "A";

	public final static String CATEGORY_LOADING_SMALL_SHORT = "B";

	public final static String CATEGORY_SHIFT_SHORT = "C";

	public static String CATEGORY_START_FEE = "进场费";

	public static String CATEGORY_SETTLING_CHARGE = "结余";

	/** 四化建 */
	public static String LOCATION_SHI_HUA_JIAN = "四化建";

	/** 四化建装车 */
	public static String LOCATION_SHI_HUA_JIAN_LOADING = "四化建装车";

	/** 四化建台班 */
	public static String LOCATION_SHI_HUA_JIAN_SHIFT = "四化建台班";

	/** 步行街 */
	public static String LOCATION_WALK_STREET = "步行街";
	
	/** 步行街装车 */
	public static String LOCATION_WALK_STREET_LOADING = "步行街装车";

	/** 步行街台班 */
	public static String LOCATION_WALK_STREET_SHIFT = "步行街台班";

	/** 南湖公园 */
	public static String LOCATION_NANHU_PARK = "南湖公园";
	
	/** 南湖公园装车 */
	public static String LOCATION_NANHU_PARK_LOADING = "南湖公园装车";

	/** 南湖公园台班 */
	public static String LOCATION_NANHU_PARK_SHIFT = "南湖公园台班";

	public static String DECIMAL_FORMAT = "###################.###########";

	/** 项目统计开始时间 */
	public static String PROJECT_START_DATE = "2017-01-01";

	/** 项目统计结束时间 */
	public static String PROJECT_END_DATE = "2017-06-30";

	/** 项目周期最小天数 */
	public static int PROJECT_PERIOD_MIN = 7;

	/** 项目周期最大天数 */
	public static int PROJECT_PERIOD_MAX = 100;

	/** 项目周期最大天数是项目平均周期的倍数 */
	public static double PROJECT_PERIOD_AVG_TIMES = 2.1;

	/** 空闲随机数最小值 */
	public static int IDEL_RANDOM_MIN = 1;

	/** 空闲随机数最大值 */
	public static int IDEL_RANDOM_MAX = 100;

	/** 空闲最小天数 */
	public static int IDEL_RANDOM_DAYS_MIN = 2;

	/** 空闲最大天数 */
	public static int IDEL_RANDOM_DAYS_MAX = 7;

	/** BSM评价比率最小值的10倍 */
	public static Integer BSM_RATE_MIN = 8;

	/** BSM评价比率最大值的10倍 */
	public static Integer BSM_RATE_MAX = 15;

	/** BSM单价 */
	public static Integer PDRD_PRICE = 15000;

	/** 奖金 */
	public static Integer PDRD_BONUS = 7500;

	/** 未评价 */
	public static String BSM_STATE_DEFAULT = "1";

	/** 已分配 */
	public static String BSM_STATE_NOT_CONFIRM = "2";

	/** 已评价 */
	public static String BSM_STATE_CONFIRM = "3";

}
