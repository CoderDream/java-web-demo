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
import com.coderdream.excavator.bean.Loading;
import com.coderdream.excavator.bean.Shift;
import com.coderdream.util.Constants;
import com.coderdream.util.DateUtil;
import com.coderdream.util.ExcelUtil;
import com.coderdream.util.MathUtil;

/**
 * 岳阳历史天气
 * 
 * http://tianqi.2345.com/t/wea_history/js/57584_20116.js
 * 
 * @author CoderDream
 *
 */
public class ExcavatorService {

	private static final Logger logger = LoggerFactory
			.getLogger(ExcavatorService.class);

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
				Double income = arrayStr[1] == null ? new Double(0)
						: Double.valueOf(arrayStr[1]);
				/** 支出 */
				Double expend = arrayStr[2] == null ? new Double(0)
						: Double.valueOf(arrayStr[2]);
				/** 类别 */
				String category = arrayStr[3];
				/** 工地 */
				String location = arrayStr[4];
				/** 备注 */
				String comment = arrayStr[5];
				/** 余额 */
				Double balance = arrayStr[6] == null ? new Double(0)
						: Double.valueOf(arrayStr[6]);
				/** 数量 */
				Double amount = arrayStr[7] == null ? new Double(0)
						: Double.valueOf(arrayStr[7]);
				/** 单价 */
				Double unitPrice = arrayStr[8] == null ? new Double(0)
						: Double.valueOf(arrayStr[8]);
				/** 去零 */
				Double fraction = arrayStr[9] == null ? new Double(0)
						: Double.valueOf(arrayStr[9]);
				/** 毛利率 */
				Double grossProfitRate = arrayStr[10] == null ? new Double(0)
						: Double.valueOf(arrayStr[10]);
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
	 * 根据SheetName查找
	 * 
	 * @param path
	 * @param sheetName
	 * @return
	 */
	public static List<Excavator> getExcavatorList(String path,
			String sheetName) {
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
				Double income = arrayStr[1] == null ? new Double(0)
						: Double.valueOf(arrayStr[1]);
				/** 支出 */
				Double expend = arrayStr[2] == null ? new Double(0)
						: Double.valueOf(arrayStr[2]);
				/** 类别 */
				String category = arrayStr[3];
				/** 工地 */
				String location = arrayStr[4];
				/** 备注 */
				String comment = arrayStr[5];
				/** 余额 */
				Double balance = arrayStr[6] == null ? new Double(0)
						: Double.valueOf(arrayStr[6]);
				/** 数量 */
				Double amount = arrayStr[7] == null ? new Double(0)
						: Double.valueOf(arrayStr[7]);
				/** 单价 */
				Double unitPrice = arrayStr[8] == null ? new Double(0)
						: Double.valueOf(arrayStr[8]);
				/** 去零 */
				Double fraction = arrayStr[9] == null ? new Double(0)
						: Double.valueOf(arrayStr[9]);
				/** 毛利率 */
				Double grossProfitRate = arrayStr[10] == null ? new Double(0)
						: Double.valueOf(arrayStr[10]);
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
	 * 根据SheetName查找
	 * 
	 * @param path
	 * @param sheetName
	 * @return
	 */
	public static List<Loading> getLoadingList(String path, String sheetName) {
		logger.debug("getLoadingList begin");
		List<Loading> loadingList = null;
		try {
			List<String[]> arrayList = ExcelUtil.readData(path, sheetName);
			if (null != arrayList && 0 < arrayList.size()) {
				loadingList = new ArrayList<>();
				logger.debug("Size: \t" + arrayList.size());
			}
			for (int i = 0; i < arrayList.size(); i++) {
				Loading loading = new Loading();
				String[] arrayStr = arrayList.get(i);

				/** 工作日期 */
				String workDate = arrayStr[0];

				/** 收入 */
				Double income = arrayStr[1] == null ? new Double(0)
						: Double.valueOf(arrayStr[1]);

				/** 数量（大车） */
				Double amountBig = arrayStr[2] == null ? new Double(0)
						: Double.valueOf(arrayStr[2]);

				/** 数量 （小车） */
				Double amountSmall = arrayStr[3] == null ? new Double(0)
						: Double.valueOf(arrayStr[3]);

				/** 工地 */
				String location = arrayStr[4];

				loading.setWorkDate(workDate);
				loading.setIncome(income);
				loading.setAmountBig(amountBig);
				loading.setAmountSmall(amountSmall);
				loading.setLocation(location);
				loadingList.add(loading);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return loadingList;
	}

	/**
	 * 根据SheetName查找
	 * 
	 * @param path
	 * @param sheetName
	 * @return
	 */
	public static List<Shift> getShiftList(String path, String sheetName) {
		logger.debug("getLoadingList begin");
		List<Shift> shiftList = null;
		try {
			List<String[]> arrayList = ExcelUtil.readData(path, sheetName);
			if (null != arrayList && 0 < arrayList.size()) {
				shiftList = new ArrayList<>();
				logger.debug("Size: \t" + arrayList.size());
			}
			for (int i = 0; i < arrayList.size(); i++) {
				Shift shift = new Shift();
				String[] arrayStr = arrayList.get(i);

				/** 工作日期 */
				String workDate = arrayStr[0];

				/** 收入 */
				Double income = arrayStr[1] == null ? new Double(0)
						: Double.valueOf(arrayStr[1]);

				/** 数量 */
				Double amount = arrayStr[2] == null ? new Double(0)
						: Double.valueOf(arrayStr[2]);

				/** 工地 */
				String location = arrayStr[3];

				shift.setWorkDate(workDate);
				shift.setIncome(income);
				shift.setAmount(amount);
				shift.setLocation(location);
				shiftList.add(shift);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return shiftList;
	}

	/**
	 * 总营收
	 * 
	 * @param path
	 * @param sheetName
	 * @param beginDateString
	 * @param endDateString
	 * @return
	 */
	public static Double getSumGrossIncome(String path, String sheetName,
			String beginDateString, String endDateString) {
		Double grossIncome = new Double(0);
		logger.debug("getExcavatorList begin");

		List<Excavator> excavatorList = ExcavatorService.getExcavatorList(path,
				sheetName);
		for (Excavator excavator : excavatorList) {
			// System.out.println(excavator);
			String workDate = excavator.getWorkDate();
			// logger.debug(excavator.toString());
			if (DateUtil.betweenTwoDate(workDate, beginDateString, endDateString)) {
				/** 收入 */
				Double income = excavator.getIncome();
				/** 类别 */
				String category = excavator.getCategory();
				if (Constants.CATEGORY_LOADING.equals(category)
						|| Constants.CATEGORY_SHIFT.equals(category)) {
					grossIncome += income;
				}
			} else {
				// logger.debug(excavator.toString());
			}
		}

		return grossIncome;
	}

	public static Double getSumGasFee(String path, String sheetName,
			String beginDateString, String endDateString) {
		Double gasFee = new Double(0);
		logger.debug("getSumGasFee begin");

		List<Excavator> excavatorList = ExcavatorService.getExcavatorList(path,
				sheetName);
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
	public static Double getOutputRate(String path, String sheetName,
			String beginDateString, String endDateString) {
		Double outputRate = new Double(0);
		// 所有的油费
		Double gasFee = ExcavatorService.getSumGasFee(path, sheetName,
				beginDateString, endDateString);
		// 所有营收（装车和台班）
		Double grossIncome = ExcavatorService.getSumGrossIncome(path, sheetName,
				beginDateString, endDateString);
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
	public static Map<String, Double> getDailyGrossIncome(String path,
			String sheetName, String beginDateString, String endDateString) {
		Map<String, Double> dailyIncomeMap = new TreeMap<String, Double>();
		logger.debug("getAverageGrossIncome begin");

		List<Excavator> excavatorList = ExcavatorService.getExcavatorList(path,
				sheetName);
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
				if (Constants.CATEGORY_LOADING.equals(category)
						|| Constants.CATEGORY_SHIFT.equals(category)) {
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
	public static Double getAverageDailyGrossIncome(String path, String sheetName,
			String beginDateString, String endDateString) {
		Double averageDailyGrossIncome = new Double(0);
		Map<String, Double> dailyIncomeMap = ExcavatorService
				.getDailyGrossIncome(path, sheetName, beginDateString, endDateString);
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

	public static Double getGrossProfit(String path, String sheetName,
			String beginDateString, String endDateString) {
		Double grossProfit = new Double(0);
		logger.debug("getExcavatorList begin");

		List<Excavator> excavatorList = ExcavatorService.getExcavatorList(path,
				sheetName);
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

				if (Constants.CATEGORY_LOADING.equals(category)
						|| Constants.CATEGORY_SHIFT.equals(category)) {
					grossProfit += income;
				}
			} else {
				// logger.debug(excavator.toString());
			}
		}

		return grossProfit;
	}

	public static Double getStandByFeeByLocation(String path, String sheetName,
			String locationParam) {
		logger.debug("getExcavatorList begin");
		List<Excavator> excavatorList = ExcavatorService.getExcavatorList(path,
				sheetName);
		Double standByFee = getStandByFeeByLocation(locationParam, excavatorList);

		return standByFee;
	}

	public static Double getStandByFeeByLocation(String locationParam,
			List<Excavator> excavatorList) {
		Double standByFee = new Double(0);
		for (Excavator excavator : excavatorList) {
			/** 工地 */
			String location = excavator.getLocation();
			if (null != location && !"".equals(locationParam)
					&& location.equals(locationParam)) {
				/** 收入 */
				Double income = excavator.getIncome();

				/** 类别 */
				String category = excavator.getCategory();
				if (Constants.CATEGORY_SHIFT.equals(category)) {
					standByFee += income;
				}
			} else {
				// logger.debug(excavator.toString());
			}
		}
		return standByFee;
	}

	public static Double getStandByFeeAmountByLocation(String locationParam,
			List<Excavator> excavatorList) {
		Double standByFee = new Double(0);
		for (Excavator excavator : excavatorList) {
			/** 工地 */
			String location = excavator.getLocation();
			if (null != location && !"".equals(locationParam)
					&& location.equals(locationParam)) {
				/** 数量 */
				Double amount = excavator.getAmount();

				/** 类别 */
				String category = excavator.getCategory();
				if (Constants.CATEGORY_SHIFT.equals(category)) {
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
	public static Double getStartFeeByLocation(String path, String sheetName,
			String locationParam) {

		logger.debug("getStartFeeByLocation begin");

		List<Excavator> excavatorList = ExcavatorService.getExcavatorList(path,
				sheetName);
		Double startFee = getStartFeeByLocation(locationParam, excavatorList);

		return startFee;
	}

	public static Double getStartFeeByLocation(String locationParam,
			List<Excavator> excavatorList) {
		Double startFee = new Double(0);
		for (Excavator excavator : excavatorList) {
			/** 工地 */
			String location = excavator.getLocation();
			if (null != location && !"".equals(locationParam)
					&& location.equals(locationParam)) {
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

	public static Double getGrossProfitByLocation(String path, String sheetName,
			String locationParam) {
		logger.debug("getExcavatorList begin");
		List<Excavator> excavatorList = ExcavatorService.getExcavatorList(path,
				sheetName);
		Double grossProfit = getGrossProfitByLocation(locationParam, excavatorList);
		return grossProfit;
	}

	public static Double getGrossProfitByLocation(String locationParam,
			List<Excavator> excavatorList) {
		Double grossProfit = new Double(0);
		for (Excavator excavator : excavatorList) {
			/** 工地 */
			String location = excavator.getLocation();
			if (null != location && !"".equals(locationParam)
					&& location.equals(locationParam)) {
				/** 收入 */
				Double income = excavator.getIncome();

				/** 类别 */
				String category = excavator.getCategory();
				if (Constants.CATEGORY_LOADING.equals(category)) {
					grossProfit += income;
				}
			} else {
				// logger.debug(excavator.toString());
			}
		}
		return grossProfit;
	}

	public static Double[] getLoadAmountByLocation(String locationParam,
			List<Excavator> excavatorList) {
		Double[] grossProfitArray = new Double[2];
		grossProfitArray[0] = new Double(0);
		grossProfitArray[1] = new Double(0);
		for (Excavator excavator : excavatorList) {
			/** 工地 */
			String location = excavator.getLocation();
			if (null != location && !"".equals(locationParam)
					&& location.equals(locationParam)) {
				/** 数量 */
				Double amount = excavator.getAmount();

				/** 备注 */
				String comment = excavator.getComment();

				/** 类别 */
				String category = excavator.getCategory();
				if (Constants.CATEGORY_LOADING.equals(category)) {
					if (Constants.CATEGORY_LOADING_BIG.equals(comment)) {
						grossProfitArray[0] += amount;
					} else if (Constants.CATEGORY_LOADING_SMALL.equals(comment)) {
						grossProfitArray[1] += amount;
					}
				}
			} else {
				// logger.debug(excavator.toString());
			}
		}
		return grossProfitArray;
	}

	public static Map<String, Map<String, Double>> getIncomeAmount(
			List<Excavator> excavatorList) {
		Map<String, Double> grossProfitMap = new TreeMap<>();
		Double grossProfit = new Double(0);
		for (Excavator excavator : excavatorList) {
			grossProfit = new Double(0);
			/** 日期 */
			String workDate = excavator.getWorkDate();

			/** 数量 */
			Double amount = excavator.getAmount();

			// /** 类别 */
			// String category = excavator.getCategory();

			/** 备注 */
			String comment = excavator.getComment();
			if (null != comment && !"".equals(comment.trim())) {

				switch (comment) {
				case Constants.CATEGORY_LOADING_BIG:
					grossProfit = grossProfitMap
							.get(workDate + "_" + Constants.CATEGORY_LOADING_BIG_SHORT);
					if (null == grossProfit) {
						grossProfit = new Double(0);
					}
					grossProfit += amount;
					grossProfitMap.put(
							workDate + "_" + Constants.CATEGORY_LOADING_BIG_SHORT,
							grossProfit);
					break;

				case Constants.CATEGORY_LOADING_SMALL:
					grossProfit = grossProfitMap
							.get(workDate + "_" + Constants.CATEGORY_LOADING_SMALL_SHORT);
					if (null == grossProfit) {
						grossProfit = new Double(0);
					}
					grossProfit += amount;
					grossProfitMap.put(
							workDate + "_" + Constants.CATEGORY_LOADING_SMALL_SHORT,
							grossProfit);
					break;

				case Constants.CATEGORY_SHIFT:
					grossProfit = grossProfitMap
							.get(workDate + "_" + Constants.CATEGORY_SHIFT_SHORT);
					if (null == grossProfit) {
						grossProfit = new Double(0);
					}
					grossProfit += amount;
					grossProfitMap.put(workDate + "_" + Constants.CATEGORY_SHIFT_SHORT,
							grossProfit);

					break;
				default:
					break;
				}
			}
		}

		Map<String, Map<String, Double>> map = new TreeMap<>();
		Map<String, Double> amountMap = null;
		String type = "";
		for (Map.Entry<String, Double> entry : grossProfitMap.entrySet()) {
			System.out
					.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			String workDateStr = entry.getKey();
			Double amount = entry.getValue();
			int index = workDateStr.lastIndexOf("_");
			if (-1 != index) {
				type = workDateStr.substring(index + 1);
				workDateStr = workDateStr.substring(0, index);
			}
			amountMap = map.get(workDateStr);
			if (null == amountMap) {
				amountMap = new TreeMap<>();
				amountMap.put(Constants.CATEGORY_LOADING_BIG_SHORT, new Double(0));
				amountMap.put(Constants.CATEGORY_LOADING_SMALL_SHORT, new Double(0));
				amountMap.put(Constants.CATEGORY_SHIFT_SHORT, new Double(0));
			}

			switch (type) {
			case Constants.CATEGORY_LOADING_BIG_SHORT:
				amountMap.put(Constants.CATEGORY_LOADING_BIG_SHORT, amount);
				map.put(workDateStr, amountMap);
				break;
			case Constants.CATEGORY_LOADING_SMALL_SHORT:
				amountMap.put(Constants.CATEGORY_LOADING_SMALL_SHORT, amount);
				map.put(workDateStr, amountMap);
				break;
			case Constants.CATEGORY_SHIFT_SHORT:
				amountMap.put(Constants.CATEGORY_SHIFT_SHORT, amount);
				map.put(workDateStr, amountMap);
				break;

			default:
				break;
			}
		}
		return map;
	}

	public static Map<String, Map<String, Double>> getIncomeAmount(
			List<Loading> loadingList, List<Shift> shiftList) {
		Map<String, Double> grossProfitMap = new TreeMap<>();
		Double grossProfitIncome = null;
		Double grossProfitBig = null;
		Double grossProfitSmall = null;
		for (Loading loading : loadingList) {
			grossProfitIncome = new Double(0);
			grossProfitBig = new Double(0);
			grossProfitSmall = new Double(0);
			/** 日期 */
			String workDate = loading.getWorkDate();

			/** 收入 */
			Double income = loading.getIncome();

			/** 数量（大车） */
			Double amountBig = loading.getAmountBig();

			/** 数量（小车） */
			Double amountSmall = loading.getAmountSmall();

			grossProfitIncome = grossProfitMap
					.get(workDate + "_" + Constants.CATEGORY_TOTAL);
			if (null == grossProfitIncome) {
				grossProfitIncome = new Double(0);
			}
			grossProfitIncome += income;
			grossProfitMap.put(workDate + "_" + Constants.CATEGORY_TOTAL,
					grossProfitIncome);

			grossProfitBig = grossProfitMap
					.get(workDate + "_" + Constants.CATEGORY_LOADING_BIG_SHORT);
			if (null == grossProfitBig) {
				grossProfitBig = new Double(0);
			}
			grossProfitBig += amountBig;
			grossProfitMap.put(workDate + "_" + Constants.CATEGORY_LOADING_BIG_SHORT,
					grossProfitBig);

			grossProfitSmall = grossProfitMap
					.get(workDate + "_" + Constants.CATEGORY_LOADING_SMALL_SHORT);
			if (null == grossProfitSmall) {
				grossProfitSmall = new Double(0);
			}
			grossProfitSmall += amountSmall;
			grossProfitMap.put(
					workDate + "_" + Constants.CATEGORY_LOADING_SMALL_SHORT,
					grossProfitSmall);
		}

		Double grossProfitShift = null;
		Double incomeShift = null;

		for (Shift shift : shiftList) {
			incomeShift = new Double(0);
			grossProfitShift = new Double(0);
			/** 日期 */
			String workDate = shift.getWorkDate();

			/** 收入 */
			Double shiftIncome = shift.getIncome();

			/** 数量 */
			Double amount = shift.getAmount();

			incomeShift = grossProfitMap
					.get(workDate + "_" + Constants.CATEGORY_TOTAL);
			if (null == incomeShift) {
				incomeShift = new Double(0);
			}
			incomeShift += shiftIncome;
			grossProfitMap.put(workDate + "_" + Constants.CATEGORY_TOTAL,
					incomeShift);

			grossProfitShift = grossProfitMap
					.get(workDate + "_" + Constants.CATEGORY_SHIFT_SHORT);
			if (null == grossProfitShift) {
				grossProfitShift = new Double(0);
			}
			grossProfitShift += amount;
			grossProfitMap.put(workDate + "_" + Constants.CATEGORY_SHIFT_SHORT,
					grossProfitShift);
		}

		Map<String, Map<String, Double>> map = new TreeMap<>();
		Map<String, Double> amountMap = null;
		String type = "";
		for (Map.Entry<String, Double> entry : grossProfitMap.entrySet()) {
			System.out
					.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			String workDateStr = entry.getKey();
			Double amount = entry.getValue();
			int index = workDateStr.lastIndexOf("_");
			if (-1 != index) {
				type = workDateStr.substring(index + 1);
				workDateStr = workDateStr.substring(0, index);
			}
			amountMap = map.get(workDateStr);
			if (null == amountMap) {
				amountMap = new TreeMap<>();
				amountMap.put(Constants.CATEGORY_TOTAL, new Double(0));
				amountMap.put(Constants.CATEGORY_LOADING_BIG_SHORT, new Double(0));
				amountMap.put(Constants.CATEGORY_LOADING_SMALL_SHORT, new Double(0));
				amountMap.put(Constants.CATEGORY_SHIFT_SHORT, new Double(0));
			}

			switch (type) {
			case Constants.CATEGORY_TOTAL:
				amountMap.put(Constants.CATEGORY_TOTAL, amount);
				map.put(workDateStr, amountMap);
				break;
			case Constants.CATEGORY_LOADING_BIG_SHORT:
				amountMap.put(Constants.CATEGORY_LOADING_BIG_SHORT, amount);
				map.put(workDateStr, amountMap);
				break;
			case Constants.CATEGORY_LOADING_SMALL_SHORT:
				amountMap.put(Constants.CATEGORY_LOADING_SMALL_SHORT, amount);
				map.put(workDateStr, amountMap);
				break;
			case Constants.CATEGORY_SHIFT_SHORT:
				amountMap.put(Constants.CATEGORY_SHIFT_SHORT, amount);
				map.put(workDateStr, amountMap);
				break;

			default:
				break;
			}
		}
		return map;
	}

	public static Map<String, Double> getMonthlyIncome(List<Loading> loadingList,
			List<Shift> shiftList) {
		Map<String, Double> monthlyIncomeAmountMap = new TreeMap<>();
		Map<String, Map<String, Double>> grossProfitMap = ExcavatorService
				.getIncomeAmount(loadingList, shiftList);
		for (Map.Entry<String, Map<String, Double>> entry : grossProfitMap
				.entrySet()) {
			System.out
					.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			Map<String, Double> map = entry.getValue();
			Double income = map.get(Constants.CATEGORY_TOTAL);
			String workday = entry.getKey();
			int index = workday.lastIndexOf("-");
			Double totalIncome = null;
			if (-1 != index) {
				String month = workday.substring(0, index);
				totalIncome = monthlyIncomeAmountMap.get(month);
				if (null == totalIncome) {
					totalIncome = new Double(0);
				}
				totalIncome += income;
				monthlyIncomeAmountMap.put(month, totalIncome);
			}
		}

		return monthlyIncomeAmountMap;
	}

	public static Map<String, Integer> getWorkDayAmount2(
			List<Loading> loadingList, List<Shift> shiftList) {
		Map<String, Integer> workDayAmountMap = new TreeMap<>();
		Map<String, Map<String, Double>> grossProfitMap = ExcavatorService
				.getIncomeAmount(loadingList, shiftList);
		Integer count = 0;
		for (Map.Entry<String, Map<String, Double>> entry : grossProfitMap
				.entrySet()) {
			System.out
					.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			String workday = entry.getKey();
			int index = workday.lastIndexOf("-");
			if (-1 != index) {
				String month = workday.substring(0, index);
				count = workDayAmountMap.get(month);
				if (null == count) {
					count = 0;
				}
				count += 1;
				workDayAmountMap.put(month, count);
			}
		}

		return workDayAmountMap;
	}

	public static Map<String, Integer> getWorkDayAmount(
			List<Excavator> excavatorList) {
		Map<String, Integer> map = new TreeMap<>();
		Map<String, Map<String, Double>> grossProfitMap = getIncomeAmount(
				excavatorList);
		Integer count = 0;
		for (Map.Entry<String, Map<String, Double>> entry : grossProfitMap
				.entrySet()) {
			System.out
					.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			String workday = entry.getKey();
			int index = workday.lastIndexOf("-");
			if (-1 != index) {
				String month = workday.substring(0, index);
				count = map.get(month);
				if (null == count) {
					count = 0;
				}
				count += 1;
				map.put(month, count);
			}
		}

		return map;
	}

	public static Map<String, Integer> getWorkDayAmount(List<Loading> loadingList,
			List<Shift> shiftList) {
		Map<String, Integer> map = new TreeMap<>();
		Map<String, Map<String, Double>> grossProfitMap = getIncomeAmount(
				loadingList, shiftList);
		Integer count = 0;
		for (Map.Entry<String, Map<String, Double>> entry : grossProfitMap
				.entrySet()) {
			System.out
					.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			String workday = entry.getKey();
			int index = workday.lastIndexOf("-");
			if (-1 != index) {
				String month = workday.substring(0, index);
				count = map.get(month);
				if (null == count) {
					count = 0;
				}
				count += 1;
				map.put(month, count);
			}
		}

		return map;
	}

	public static Map<String, Map<String, Double>> getWorkDayAmountByMonth(
			List<Loading> loadingList, List<Shift> shiftList, String monthParam) {
		Map<String, Map<String, Double>> workDayAmountMap = new TreeMap<>();
		Map<String, Map<String, Double>> grossProfitMap = getIncomeAmount(
				loadingList, shiftList);
		for (Map.Entry<String, Map<String, Double>> entry : grossProfitMap
				.entrySet()) {
			System.out
					.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			String workday = entry.getKey();

			Map<String, Double> map = entry.getValue();
			int index = workday.lastIndexOf("-");
			if (-1 != index) {
				String month = workday.substring(0, index);
				if (monthParam.equals(month)) {
					workDayAmountMap.put(workday, map);
				}
			}
		}

		return workDayAmountMap;
	}
	
	public static Map<String, Double> getWorkDayIncomeByMonth(
			List<Loading> loadingList, List<Shift> shiftList, String monthParam) {
		Map<String, Double> workDayAmountMap = new TreeMap<>();
		Map<String, Map<String, Double>> grossProfitMap = getIncomeAmount(
				loadingList, shiftList);
		for (Map.Entry<String, Map<String, Double>> entry : grossProfitMap
				.entrySet()) {
			System.out
					.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			String workday = entry.getKey();

			Map<String, Double> map = entry.getValue();
			Double income = map.get(Constants.CATEGORY_TOTAL);
			int index = workday.lastIndexOf("-");
			if (-1 != index) {
				String month = workday.substring(0, index);
				if (monthParam.equals(month)) {
					workDayAmountMap.put(workday, income);
				}
			}
		}

		return workDayAmountMap;
	}


	public static Double getOilFeeByLocation(String path, String sheetName,
			String locationParam) {

		logger.debug("getExcavatorList begin");

		List<Excavator> excavatorList = ExcavatorService.getExcavatorList(path,
				sheetName);

		Double OilFee = getOilFeeByLocation(locationParam, excavatorList);

		return OilFee;
	}

	public static Double getOilFeeByLocation(String locationParam,
			List<Excavator> excavatorList) {
		Double OilFee = new Double(0);
		for (Excavator excavator : excavatorList) {
			/** 工地 */
			String location = excavator.getLocation();
			if (null != location && !"".equals(locationParam)
					&& location.equals(locationParam)) {
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

	public static Double getNetProfitByLocation(String path, String sheetName,
			String locationParam) {
		Double grossProfit = new Double(0);
		logger.debug("getExcavatorList begin");

		List<Excavator> excavatorList = ExcavatorService.getExcavatorList(path,
				sheetName);
		for (Excavator excavator : excavatorList) {
			/** 工地 */
			String location = excavator.getLocation();
			if (null != location && !"".equals(locationParam)
					&& location.equals(locationParam)) {
				/** 收入 */
				Double income = excavator.getIncome();
				/** 支出 */
				Double expend = excavator.getExpend();

				/** 类别 */
				String category = excavator.getCategory();
				if (Constants.CATEGORY_OIL_FEE.equals(category)) {
					grossProfit -= expend;
				}

				if (Constants.CATEGORY_LOADING.equals(category)
						|| Constants.CATEGORY_SHIFT.equals(category)) {
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
	public static Map<String, Double> getSettlingChargeByLocation(String path,
			String sheetName, String locationParam) {
		Map<String, Double> settlingChargeMap = new LinkedHashMap<String, Double>();
		logger.debug("getSettlingChargeByLocation begin"); // TODO

		List<Excavator> excavatorList = ExcavatorService.getExcavatorList(path,
				sheetName);
		// 台班费
		String feeType1 = Constants.CATEGORY_SHIFT;
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
		String feeType3 = Constants.CATEGORY_LOADING;
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
	public static Map<String, String> getSettlingChargeAmountByLocation(
			String path, String sheetName, String locationParam) {
		Map<String, String> settlingChargeMap = new LinkedHashMap<String, String>();
		logger.debug("getSettlingChargeByLocation begin"); // TODO

		List<Excavator> excavatorList = ExcavatorService.getExcavatorList(path,
				sheetName);

		DecimalFormat decimalFormat = new DecimalFormat(Constants.DECIMAL_FORMAT);
		// System.out.println(decimalFormat.format(number)); //12

		// 台班费
		String feeType1 = Constants.CATEGORY_SHIFT;
		Double standByFee = getStandByFeeAmountByLocation(locationParam,
				excavatorList);
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
		String feeType3 = Constants.CATEGORY_LOADING;
		Double[] grossProfitArray = getLoadAmountByLocation(locationParam,
				excavatorList);
		if (0 < grossProfitArray[1]) {
			settlingChargeMap.put(
					feeType3 + "(" + Constants.CATEGORY_LOADING_BIG + ")",
					decimalFormat.format(grossProfitArray[0]));
			settlingChargeMap.put(
					feeType3 + "(" + Constants.CATEGORY_LOADING_SMALL + ")",
					decimalFormat.format(grossProfitArray[1]));
		} else {
			settlingChargeMap.put(feeType3,
					decimalFormat.format(grossProfitArray[0]));
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

	public static Double getAverageGrossProfitByLocation(String path,
			String sheetName, String locationParam) {
		Double grossProfit = new Double(0);
		logger.debug("getExcavatorList begin");
		Set<String> workDaySet = new HashSet<String>();
		List<Excavator> excavatorList = ExcavatorService.getExcavatorList(path,
				sheetName);
		for (Excavator excavator : excavatorList) {
			/** 日期 */
			String workDate = excavator.getWorkDate();
			/** 工地 */
			String location = excavator.getLocation();
			if (null != location && !"".equals(locationParam)
					&& location.equals(locationParam)) {
				/** 收入 */
				Double income = excavator.getIncome();
				/** 支出 */
				Double expend = excavator.getExpend();

				/** 类别 */
				String category = excavator.getCategory();
				if (Constants.CATEGORY_OIL_FEE.equals(category)) {
					grossProfit -= expend;
				}

				if (Constants.CATEGORY_LOADING.equals(category)
						|| Constants.CATEGORY_SHIFT.equals(category)) {
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

	public static Double getNetProfit(String path, String sheetName,
			String beginDateString, String endDateString) {
		Double netProfit = new Double(0);
		logger.debug("getExcavatorList begin");

		List<Excavator> excavatorList = ExcavatorService.getExcavatorList(path,
				sheetName);
		for (Excavator excavator : excavatorList) {
			String workDate = excavator.getWorkDate();
			if (DateUtil.betweenTwoDate(workDate, beginDateString, endDateString)) {
				/** 收入 */
				Double income = excavator.getIncome();
				/** 支出 */
				Double expend = excavator.getExpend();

				/** 类别 */
				String category = excavator.getCategory();
				if (Constants.CATEGORY_OIL_FEE.equals(category)
						|| Constants.CATEGORY_SERVICE.equals(category)) {
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
