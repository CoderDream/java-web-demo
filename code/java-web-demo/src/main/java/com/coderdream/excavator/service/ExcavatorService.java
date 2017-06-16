package com.coderdream.excavator.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.coderdream.excavator.bean.Excavator;
import com.coderdream.util.Constants;
import com.coderdream.util.DateUtil;
import com.coderdream.util.ExcelUtil;
import com.coderdream.util.MathUtil;

public class ExcavatorService {

	private static final Logger logger = LoggerFactory.getLogger(ExcavatorService.class);

	public static List<Excavator> getExcavatorListBackup(String path) {
		logger.debug("getExcavatorList begin");
		List<Excavator> excavatorList = null;
		String sheetName = "Total";
		// String sheetName = Constants.LOCATION_THREE;
		try {
			List<String[]> arrayList = ExcelUtil.readData(path, sheetName);
			if (null != arrayList && 0 < arrayList.size()) {
				excavatorList = new ArrayList<Excavator>();
				logger.debug("Size: \t" + arrayList.size());
			}
			for (int i = 0; i < arrayList.size(); i++) {
				Excavator excavator = new Excavator();
				String[] arrayStr = arrayList.get(i);

				/** 日期 */
				String workDate = arrayStr[0];
				/** 收入 */
				Double income = arrayStr[1] == null ? new Double(0) : Double.valueOf(arrayStr[1]);
				/** 支出 */
				Double expend = arrayStr[2] == null ? new Double(0) : Double.valueOf(arrayStr[2]);
				/** 类别 */
				String category = arrayStr[3];
				/** 工地 */
				String location = arrayStr[4];
				/** 备注 */
				String comment = arrayStr[5];
				/** 余额 */
				Double balance = arrayStr[6] == null ? new Double(0) : Double.valueOf(arrayStr[6]);
				/** 数量 */
				Double amount = arrayStr[7] == null ? new Double(0) : Double.valueOf(arrayStr[7]);
				/** 单价 */
				Double unitPrice = arrayStr[8] == null ? new Double(0) : Double.valueOf(arrayStr[8]);
				/** 去零 */
				Double fraction = arrayStr[9] == null ? new Double(0) : Double.valueOf(arrayStr[9]);
				/** 毛利率 */
				Double grossProfitRate = arrayStr[10] == null ? new Double(0) : Double.valueOf(arrayStr[10]);
				/** 毛利 */
				Double grossProfit = new Double(0);

				excavator.setWorkDate(workDate);
				excavator.setIncome(income);
				excavator.setExpend(expend);
				excavator.setCategory(category);
				excavator.setLocation(location);
				excavator.setComment(comment);
				excavator.setBalance(balance);
				excavator.setAmount(amount);
				excavator.setUnitPrice(unitPrice);
				excavator.setFraction(fraction);
				excavator.setGrossProfitRate(grossProfitRate);
				excavator.setGrossProfit(grossProfit);
				excavatorList.add(excavator);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return excavatorList;
	}

	public static List<Excavator> getExcavatorList(String path, String sheetName) {
		logger.debug("getExcavatorList begin");
		List<Excavator> excavatorList = null;
		// String sheetName = "Total";
		// String sheetName = Constants.LOCATION_THREE;
		try {
			List<String[]> arrayList = ExcelUtil.readData(path, sheetName);
			if (null != arrayList && 0 < arrayList.size()) {
				excavatorList = new ArrayList<Excavator>();
				logger.debug("Size: \t" + arrayList.size());
			}
			for (int i = 0; i < arrayList.size(); i++) {
				Excavator excavator = new Excavator();
				String[] arrayStr = arrayList.get(i);

				/** 日期 */
				String workDate = arrayStr[0];
				/** 收入 */
				Double income = arrayStr[1] == null ? new Double(0) : Double.valueOf(arrayStr[1]);
				/** 支出 */
				Double expend = arrayStr[2] == null ? new Double(0) : Double.valueOf(arrayStr[2]);
				/** 类别 */
				String category = arrayStr[3];
				/** 工地 */
				String location = arrayStr[4];
				/** 备注 */
				String comment = arrayStr[5];
				/** 余额 */
				Double balance = arrayStr[6] == null ? new Double(0) : Double.valueOf(arrayStr[6]);
				/** 数量 */
				Double amount = arrayStr[7] == null ? new Double(0) : Double.valueOf(arrayStr[7]);
				/** 单价 */
				Double unitPrice = arrayStr[8] == null ? new Double(0) : Double.valueOf(arrayStr[8]);
				/** 去零 */
				Double fraction = arrayStr[9] == null ? new Double(0) : Double.valueOf(arrayStr[9]);
				/** 毛利率 */
				Double grossProfitRate = arrayStr[10] == null ? new Double(0) : Double.valueOf(arrayStr[10]);
				/** 毛利 */
				Double grossProfit = new Double(0);

				excavator.setWorkDate(workDate);
				excavator.setIncome(income);
				excavator.setExpend(expend);
				excavator.setCategory(category);
				excavator.setLocation(location);
				excavator.setComment(comment);
				excavator.setBalance(balance);
				excavator.setAmount(amount);
				excavator.setUnitPrice(unitPrice);
				excavator.setFraction(fraction);
				excavator.setGrossProfitRate(grossProfitRate);
				excavator.setGrossProfit(grossProfit);
				excavatorList.add(excavator);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return excavatorList;
	}

	/**
	 * 营收
	 * @param path
	 * @param sheetName
	 * @param beginDateString
	 * @param endDateString
	 * @return
	 */
	public static Double getSumGrossIncome(String path, String sheetName, String beginDateString,
			String endDateString) {
		Double grossIncome = new Double(0);
		logger.debug("getExcavatorList begin");

		List<Excavator> excavatorList = ExcavatorService.getExcavatorList(path, sheetName);
		for (Excavator excavator : excavatorList) {
			// System.out.println(excavator);
			String workDate = excavator.getWorkDate();
			// logger.debug(excavator.toString());
			if (DateUtil.betweenTwoDate(workDate, beginDateString, endDateString)) {
				/** 收入 */
				Double income = excavator.getIncome();
				/** 类别 */
				String category = excavator.getCategory();
				if (Constants.CATEGORY_LOAD.equals(category) || Constants.CATEGORY_STAND_BY.equals(category)) {
					grossIncome += income;
				}
			} else {
				// logger.debug(excavator.toString());
			}
		}

		return grossIncome;
	}

	public static Double getSumGasFee(String path, String sheetName, String beginDateString, String endDateString) {
		Double gasFee = new Double(0);
		logger.debug("getSumGasFee begin");

		List<Excavator> excavatorList = ExcavatorService.getExcavatorList(path, sheetName);
		for (Excavator excavator : excavatorList) {
			// System.out.println(excavator);
			String workDate = excavator.getWorkDate();
			// logger.debug(excavator.toString());
			if (DateUtil.betweenTwoDate(workDate, beginDateString, endDateString)) {
				/** 支出 */
				Double expend = excavator.getExpend();
				/** 类别 */
				String category = excavator.getCategory();
				if (Constants.CATEGORY_OIL_FEE.equals(category)) {
					gasFee += expend;
				}
			} else {
				// logger.debug(excavator.toString());
			}
		}

		return gasFee;
	}

	/**
	 * @param path
	 * @param sheetName
	 * @param beginDateString
	 * @param endDateString
	 * @return
	 */
	public static Double getOutputRate(String path, String sheetName, String beginDateString, String endDateString) {
		Double outputRate = new Double(0);
		// 所有的油费
		Double gasFee = ExcavatorService.getSumGasFee(path, sheetName, beginDateString, endDateString);
		// 所有营收（装车和台班）
		Double grossIncome = ExcavatorService.getSumGrossIncome(path, sheetName, beginDateString, endDateString);
		if (0.0 != gasFee && 0.0 != grossIncome) {
			outputRate = MathUtil.setScale(grossIncome / gasFee, 2);
		}
		return outputRate;
	}

	//
	/**
	 * 毛利
	 * 
	 * @param path
	 * @param beginDateString
	 * @param endDateString
	 * @return
	 */
	public static Map<String, Double> getDailyGrossIncome(String path, String sheetName, String beginDateString,
			String endDateString) {
		Map<String, Double> dailyIncomeMap = new TreeMap<String, Double>();
		logger.debug("getAverageGrossIncome begin");

		List<Excavator> excavatorList = ExcavatorService.getExcavatorList(path, sheetName);
		for (Excavator excavator : excavatorList) {
			String workDate = excavator.getWorkDate();
			if (DateUtil.betweenTwoDate(workDate, beginDateString, endDateString)) {
				/** 收入 */
				Double income = excavator.getIncome();
				Double oldIncome = dailyIncomeMap.get(workDate);
				if (null == oldIncome) {
					oldIncome = new Double(0);
				}
				/** 类别 */
				String category = excavator.getCategory();
				if (Constants.CATEGORY_LOAD.equals(category) || Constants.CATEGORY_STAND_BY.equals(category)) {
					if (income > 0) {
						oldIncome += income;
						dailyIncomeMap.put(workDate, oldIncome);
					}
				}
			} else {
				// logger.debug(excavator.toString());
			}
		}

		return dailyIncomeMap;
	}

	//
	public static Double getAverageDailyGrossIncome(String path, String sheetName, String beginDateString,
			String endDateString) {
		Double averageDailyGrossIncome = new Double(0);
		Map<String, Double> dailyIncomeMap = ExcavatorService.getDailyGrossIncome(path, sheetName, beginDateString,
				endDateString);
		logger.debug("getAverageGrossIncome begin");
		Double sum = new Double(0);
		int mapSize = dailyIncomeMap.size();
		for (String workDate : dailyIncomeMap.keySet()) {
			Double dailyIncome = dailyIncomeMap.get(workDate);
			logger.debug(workDate + "\t" + dailyIncome);
			sum += dailyIncome;
		}

		averageDailyGrossIncome = MathUtil.setScale(sum / mapSize, 2);
		return averageDailyGrossIncome;
	}

	public static Double getGrossProfit(String path, String sheetName, String beginDateString, String endDateString) {
		Double grossProfit = new Double(0);
		logger.debug("getExcavatorList begin");

		List<Excavator> excavatorList = ExcavatorService.getExcavatorList(path, sheetName);
		for (Excavator excavator : excavatorList) {
			String workDate = excavator.getWorkDate();
			if (DateUtil.betweenTwoDate(workDate, beginDateString, endDateString)) {
				/** 收入 */
				Double income = excavator.getIncome();
				/** 支出 */
				Double expend = excavator.getExpend();

				/** 类别 */
				String category = excavator.getCategory();
				if (Constants.CATEGORY_OIL_FEE.equals(category)) {
					grossProfit -= expend;
				}

				if (Constants.CATEGORY_LOAD.equals(category) || Constants.CATEGORY_STAND_BY.equals(category)) {
					grossProfit += income;
				}
			} else {
				// logger.debug(excavator.toString());
			}
		}

		return grossProfit;
	}

	public static Double getStandByFeeByLocation(String path, String sheetName, String locationParam) {
		logger.debug("getExcavatorList begin");
		List<Excavator> excavatorList = ExcavatorService.getExcavatorList(path, sheetName);
		Double standByFee = getStandByFeeByLocation(locationParam, excavatorList);

		return standByFee;
	}

	public static Double getStandByFeeByLocation(String locationParam, List<Excavator> excavatorList) {
		Double standByFee = new Double(0);
		for (Excavator excavator : excavatorList) {
			/** 工地 */
			String location = excavator.getLocation();
			if (null != location && !"".equals(locationParam) && location.equals(locationParam)) {
				/** 收入 */
				Double income = excavator.getIncome();

				/** 类别 */
				String category = excavator.getCategory();
				if (Constants.CATEGORY_STAND_BY.equals(category)) {
					standByFee += income;
				}
			} else {
				// logger.debug(excavator.toString());
			}
		}
		return standByFee;
	}

	public static Double getStandByFeeAmountByLocation(String locationParam, List<Excavator> excavatorList) {
		Double standByFee = new Double(0);
		for (Excavator excavator : excavatorList) {
			/** 工地 */
			String location = excavator.getLocation();
			if (null != location && !"".equals(locationParam) && location.equals(locationParam)) {
				/** 数量 */
				Double amount = excavator.getAmount();

				/** 类别 */
				String category = excavator.getCategory();
				if (Constants.CATEGORY_STAND_BY.equals(category)) {
					standByFee += amount;
				}
			} else {
				// logger.debug(excavator.toString());
			}
		}
		return standByFee;
	}

	/**
	 * @param path
	 * @param locationParam
	 * @return
	 */
	public static Double getStartFeeByLocation(String path, String sheetName, String locationParam) {

		logger.debug("getStartFeeByLocation begin");

		List<Excavator> excavatorList = ExcavatorService.getExcavatorList(path, sheetName);
		Double startFee = getStartFeeByLocation(locationParam, excavatorList);

		return startFee;
	}

	public static Double getStartFeeByLocation(String locationParam, List<Excavator> excavatorList) {
		Double startFee = new Double(0);
		for (Excavator excavator : excavatorList) {
			/** 工地 */
			String location = excavator.getLocation();
			if (null != location && !"".equals(locationParam) && location.equals(locationParam)) {
				/** 收入 */
				Double income = excavator.getIncome();

				/** 类别 */
				String category = excavator.getCategory();
				if (Constants.CATEGORY_START_FEE.equals(category)) {
					startFee += income;
				}
			} else {
				// logger.debug(excavator.toString());
			}
		}
		return startFee;
	}

	public static Double getGrossProfitByLocation(String path, String sheetName, String locationParam) {
		logger.debug("getExcavatorList begin");
		List<Excavator> excavatorList = ExcavatorService.getExcavatorList(path, sheetName);
		Double grossProfit = getGrossProfitByLocation(locationParam, excavatorList);
		return grossProfit;
	}

	public static Double getGrossProfitByLocation(String locationParam, List<Excavator> excavatorList) {
		Double grossProfit = new Double(0);
		for (Excavator excavator : excavatorList) {
			/** 工地 */
			String location = excavator.getLocation();
			if (null != location && !"".equals(locationParam) && location.equals(locationParam)) {
				/** 收入 */
				Double income = excavator.getIncome();

				/** 类别 */
				String category = excavator.getCategory();
				if (Constants.CATEGORY_LOAD.equals(category)) {
					grossProfit += income;
				}
			} else {
				// logger.debug(excavator.toString());
			}
		}
		return grossProfit;
	}

	public static Double[] getLoadAmountByLocation(String locationParam, List<Excavator> excavatorList) {
		Double[] grossProfitArray = new Double[2];
		grossProfitArray[0] = new Double(0);
		grossProfitArray[1] = new Double(0);
		for (Excavator excavator : excavatorList) {
			/** 工地 */
			String location = excavator.getLocation();
			if (null != location && !"".equals(locationParam) && location.equals(locationParam)) {
				/** 数量 */
				Double amount = excavator.getAmount();

				/** 备注 */
				String comment = excavator.getComment();

				/** 类别 */
				String category = excavator.getCategory();
				if (Constants.CATEGORY_LOAD.equals(category)) {
					if (Constants.CATEGORY_LOAD_BIG.equals(comment)) {
						grossProfitArray[0] += amount;
					} else if (Constants.CATEGORY_LOAD_SMALL.equals(comment)) {
						grossProfitArray[1] += amount;
					}
				}
			} else {
				// logger.debug(excavator.toString());
			}
		}
		return grossProfitArray;
	}

	public static Double getOilFeeByLocation(String path, String sheetName, String locationParam) {

		logger.debug("getExcavatorList begin");

		List<Excavator> excavatorList = ExcavatorService.getExcavatorList(path, sheetName);

		Double OilFee = getOilFeeByLocation(locationParam, excavatorList);

		return OilFee;
	}

	public static Double getOilFeeByLocation(String locationParam, List<Excavator> excavatorList) {
		Double OilFee = new Double(0);
		for (Excavator excavator : excavatorList) {
			/** 工地 */
			String location = excavator.getLocation();
			if (null != location && !"".equals(locationParam) && location.equals(locationParam)) {
				/** 支出 */
				Double expend = excavator.getExpend();

				/** 类别 */
				String category = excavator.getCategory();
				if (Constants.CATEGORY_OIL_FEE.equals(category)) {
					OilFee += expend;
				}
			} else {
				// logger.debug(excavator.toString());
			}
		}
		return OilFee;
	}

	public static Double getNetProfitByLocation(String path, String sheetName, String locationParam) {
		Double grossProfit = new Double(0);
		logger.debug("getExcavatorList begin");

		List<Excavator> excavatorList = ExcavatorService.getExcavatorList(path, sheetName);
		for (Excavator excavator : excavatorList) {
			/** 工地 */
			String location = excavator.getLocation();
			if (null != location && !"".equals(locationParam) && location.equals(locationParam)) {
				/** 收入 */
				Double income = excavator.getIncome();
				/** 支出 */
				Double expend = excavator.getExpend();

				/** 类别 */
				String category = excavator.getCategory();
				if (Constants.CATEGORY_OIL_FEE.equals(category)) {
					grossProfit -= expend;
				}

				if (Constants.CATEGORY_LOAD.equals(category) || Constants.CATEGORY_STAND_BY.equals(category)) {
					grossProfit += income;
				}
			} else {
				// logger.debug(excavator.toString());
			}
		}

		return grossProfit;
	}

	/**
	 * <pre>
	 *台班时间
	 *进场费
	 *装车
	 *扣油费
	 * </pre>
	 * 
	 * @param path
	 * @param locationParam
	 * @return
	 */
	public static Map<String, Double> getSettlingChargeByLocation(String path, String sheetName, String locationParam) {
		Map<String, Double> settlingChargeMap = new LinkedHashMap<String, Double>();
		logger.debug("getSettlingChargeByLocation begin"); // TODO

		List<Excavator> excavatorList = ExcavatorService.getExcavatorList(path, sheetName);
		// 台班费
		String feeType1 = Constants.CATEGORY_STAND_BY;
		Double standByFee = getStandByFeeByLocation(locationParam, excavatorList);
		if (0 < standByFee) {
			settlingChargeMap.put(feeType1, standByFee);
		}

		// 进场费
		String feeType2 = Constants.CATEGORY_START_FEE;
		Double startFee = getStartFeeByLocation(locationParam, excavatorList);
		if (0 < startFee) {
			settlingChargeMap.put(feeType2, startFee);
		}

		// 装车
		String feeType3 = Constants.CATEGORY_LOAD;
		Double grossProfit = getGrossProfitByLocation(locationParam, excavatorList);
		settlingChargeMap.put(feeType3, grossProfit);

		// 油费
		String feeType4 = Constants.CATEGORY_OIL_FEE;
		Double OilFee = getOilFeeByLocation(locationParam, excavatorList);
		settlingChargeMap.put(feeType4, OilFee);

		// 结余
		String feeType5 = Constants.CATEGORY_SETTLING_CHARGE;
		Double settlingCharge = standByFee + startFee + grossProfit - OilFee;
		settlingChargeMap.put(feeType5, settlingCharge);

		return settlingChargeMap;
	}

	/**
	 * <pre>
	 *台班时间
	 *进场费
	 *装车
	 *扣油费
	 * </pre>
	 * 
	 * @param path
	 * @param locationParam
	 * @return
	 */
	public static Map<String, String> getSettlingChargeAmountByLocation(String path, String sheetName,
			String locationParam) {
		Map<String, String> settlingChargeMap = new LinkedHashMap<String, String>();
		logger.debug("getSettlingChargeByLocation begin"); // TODO

		List<Excavator> excavatorList = ExcavatorService.getExcavatorList(path, sheetName);

		DecimalFormat decimalFormat = new DecimalFormat(Constants.DECIMAL_FORMAT);
		// System.out.println(decimalFormat.format(number)); //12

		// 台班费
		String feeType1 = Constants.CATEGORY_STAND_BY;
		Double standByFee = getStandByFeeAmountByLocation(locationParam, excavatorList);
		if (0 < standByFee) {
			settlingChargeMap.put(feeType1, decimalFormat.format(standByFee) + " 小时");
		}

		// 进场费
		String feeType2 = Constants.CATEGORY_START_FEE;
		Double startFee = getStartFeeByLocation(locationParam, excavatorList);
		if (0 < startFee) {
			settlingChargeMap.put(feeType2, decimalFormat.format(startFee) + "");
		}

		// 装车
		String feeType3 = Constants.CATEGORY_LOAD;
		Double[] grossProfitArray = getLoadAmountByLocation(locationParam, excavatorList);
		if (0 < grossProfitArray[1]) {
			settlingChargeMap.put(feeType3 + "(" + Constants.CATEGORY_LOAD_BIG + ")",
					decimalFormat.format(grossProfitArray[0]));
			settlingChargeMap.put(feeType3 + "(" + Constants.CATEGORY_LOAD_SMALL + ")",
					decimalFormat.format(grossProfitArray[1]));
		} else {
			settlingChargeMap.put(feeType3, decimalFormat.format(grossProfitArray[0]));
		}

		// 油费
		String feeType4 = Constants.CATEGORY_OIL_FEE;
		Double OilFee = getOilFeeByLocation(locationParam, excavatorList);
		settlingChargeMap.put(feeType4, decimalFormat.format(OilFee) + "");

		// 结余
		// String feeType5 = Constants.CATEGORY_SETTLING_CHARGE;
		// Double settlingCharge = standByFee + startFee + grossProfit - OilFee;
		// settlingChargeMap.put("5." + feeType5, settlingCharge);

		return settlingChargeMap;
	}

	public static Double getAverageGrossProfitByLocation(String path, String sheetName, String locationParam) {
		Double grossProfit = new Double(0);
		logger.debug("getExcavatorList begin");
		Set<String> workDaySet = new HashSet<String>();
		List<Excavator> excavatorList = ExcavatorService.getExcavatorList(path, sheetName);
		for (Excavator excavator : excavatorList) {
			/** 日期 */
			String workDate = excavator.getWorkDate();
			/** 工地 */
			String location = excavator.getLocation();
			if (null != location && !"".equals(locationParam) && location.equals(locationParam)) {
				/** 收入 */
				Double income = excavator.getIncome();
				/** 支出 */
				Double expend = excavator.getExpend();

				/** 类别 */
				String category = excavator.getCategory();
				if (Constants.CATEGORY_OIL_FEE.equals(category)) {
					grossProfit -= expend;
				}

				if (Constants.CATEGORY_LOAD.equals(category) || Constants.CATEGORY_STAND_BY.equals(category)) {
					grossProfit += income;
					workDaySet.add(workDate);
				}
			} else {
				// logger.debug(excavator.toString());
			}
		}

		if (workDaySet.size() > 0) {

			return MathUtil.setScale(grossProfit / workDaySet.size(), 2);
		} else {
			return new Double(0);
		}
	}

	public static Double getNetProfit(String path, String sheetName, String beginDateString, String endDateString) {
		Double netProfit = new Double(0);
		logger.debug("getExcavatorList begin");

		List<Excavator> excavatorList = ExcavatorService.getExcavatorList(path, sheetName);
		for (Excavator excavator : excavatorList) {
			String workDate = excavator.getWorkDate();
			if (DateUtil.betweenTwoDate(workDate, beginDateString, endDateString)) {
				/** 收入 */
				Double income = excavator.getIncome();
				/** 支出 */
				Double expend = excavator.getExpend();

				/** 类别 */
				String category = excavator.getCategory();
				if (Constants.CATEGORY_OIL_FEE.equals(category) || Constants.CATEGORY_SERVICE.equals(category)) {
					netProfit -= expend;
				}

				netProfit += income;
			} else {
				// logger.debug(excavator.toString());
			}
		}

		return netProfit;
	}

}
