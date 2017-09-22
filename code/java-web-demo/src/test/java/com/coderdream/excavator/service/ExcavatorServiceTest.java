package com.coderdream.excavator.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.coderdream.excavator.bean.Excavator;
import com.coderdream.readfolder.util.FileUtil;
import com.coderdream.util.Constants;

/**
 * <pre>
 * 1、每月上班天数；
 * 2、每周上班天数；
 * 3、每日营收（按工地）；
 * 4、每日3个数量（按工地）；
 * 5、每周营收；
 * 6、每月营收；
 * 7、所有工地的毛收入（不除油费）；
 * 8、所有工地的纯收入（去除油费）；
 * 
 * </pre>
 * 
 * @author xulin28709
 *
 */
public class ExcavatorServiceTest {

	private static final Logger logger = LoggerFactory
					.getLogger(ExcavatorServiceTest.class);

	private String fileFolder;

	private String dataFileName;

	private List<String> locationList;

	@BeforeClass
	public void setUp() throws Exception {
		fileFolder = getClass().getResource("../../../../").getFile()
						.toString();
		dataFileName = Constants.EXCAVATOR_FILE_NAME;
		locationList = new ArrayList<String>();
		locationList.add(Constants.LOCATION_ONE);
		locationList.add(Constants.LOCATION_TWO);
		locationList.add(Constants.LOCATION_THREE);
	}

	/**
	 * TODO
	 */
	@Test(priority = 1)
	public void testGetExcavatorList() {
		String path = fileFolder + dataFileName;
		String sheetName = Constants.LOCATION_THREE;
		List<Excavator> excavatorList = ExcavatorService.getExcavatorList(path,
						sheetName);
		for (Excavator excavator : excavatorList) {
			System.out.println(excavator);
			logger.debug(excavator.toString());
		}

		ObjectMapper mapper = new ObjectMapper();
		String excavatorListStr = "";
		try {
			excavatorListStr = mapper.writeValueAsString(excavatorList);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.debug(excavatorListStr);

		String filename = "excavator.json";
		String charsetName = "GBK";
		List<String> contents = new ArrayList<>();
		contents.add(excavatorListStr);

		FileUtil.write(contents, filename, charsetName);
	}

	@Test
	public void testGetSumGrossIncome_01() {
		String path = fileFolder + dataFileName;
		String beginDateString = "2017-01-01";
		String endDateString = "2017-12-30";
		String sheetName = Constants.LOCATION_ONE;
		Double grossIncome = ExcavatorService.getSumGrossIncome(path, sheetName,
						beginDateString, endDateString);
		logger.debug("grossIncome\t" + grossIncome);
		Double expectValue = new Double(21089);
		Assert.assertEquals(expectValue, grossIncome);
		logger.debug("grossIncome\t" + grossIncome);
	}

	@Test
	public void testGetSumGrossIncome_02() {
		String path = fileFolder + dataFileName;
		String beginDateString = "2017-01-01";
		String endDateString = "2017-05-31";
		// 步行街
		String sheetName = Constants.LOCATION_TWO;
		Double grossIncome = ExcavatorService.getSumGrossIncome(path, sheetName,
						beginDateString, endDateString);
		logger.debug("grossIncome\t" + grossIncome);
		Double expectValue = new Double(76372);
		Assert.assertEquals(expectValue, grossIncome);
		logger.debug("grossIncome\t" + grossIncome);
	}

	@Test
	public void testGetSumGrossIncome_03() {
		String path = fileFolder + dataFileName;
		String beginDateString = "2017-01-01";
		String endDateString = "2017-12-31";
		// 南湖工地
		String sheetName = Constants.LOCATION_THREE;
		Double grossIncome = ExcavatorService.getSumGrossIncome(path, sheetName,
						beginDateString, endDateString);
		Double expectValue = new Double(31635);
		Assert.assertEquals(expectValue, grossIncome);
		logger.debug("grossIncome\t" + grossIncome);
	}

	@Test
	public void testGetOutputRate_01() {
		String path = fileFolder + dataFileName;
		String beginDateString = "2017-01-01";
		String endDateString = "2017-12-01";
		String sheetName = Constants.LOCATION_ONE;
		Double outputRate = ExcavatorService.getOutputRate(path, sheetName,
						beginDateString, endDateString);

		Double expectValue = new Double(2.44);
		Assert.assertEquals(expectValue, outputRate);
		logger.debug("grossIncome\t" + outputRate);
	}

	@Test
	public void testGetOutputRate_02() {
		String path = fileFolder + dataFileName;
		String beginDateString = "2017-01-01";
		String endDateString = "2017-12-01";
		String sheetName = Constants.LOCATION_TWO;
		Double outputRate = ExcavatorService.getOutputRate(path, sheetName,
						beginDateString, endDateString);
		Double expectValue = new Double(2.1);
		Assert.assertEquals(expectValue, outputRate);
		logger.debug("grossIncome\t" + outputRate);
	}

	@Test
	public void testGetOutputRate_03() {
		String path = fileFolder + dataFileName;
		String beginDateString = "2017-01-01";
		String endDateString = "2017-12-01";
		String sheetName = Constants.LOCATION_THREE;
		Double outputRate = ExcavatorService.getOutputRate(path, sheetName,
						beginDateString, endDateString);
		Double expectValue = new Double(2.41);
		Assert.assertEquals(expectValue, outputRate);
		logger.debug("grossIncome\t" + outputRate);
	}

	@Test
	public void testGasFee_01() {
		String path = fileFolder + dataFileName;
		String beginDateString = "2017-03-01";
		String endDateString = "2017-04-01";
		String sheetName = Constants.LOCATION_THREE;
		Double gasFee = ExcavatorService.getSumGasFee(path, sheetName,
						beginDateString, endDateString);
		logger.debug("gasFee\t" + gasFee);
	}

	@Test
	public void testGasFee_02() {
		String path = fileFolder + dataFileName;
		String beginDateString = "2017-04-02";
		String endDateString = "2017-05-20";
		String sheetName = Constants.LOCATION_THREE;
		Double gasFee = ExcavatorService.getSumGasFee(path, sheetName,
						beginDateString, endDateString);
		logger.debug("gasFee\t" + gasFee);
	}

	@Test
	public void testGetGrossProfit_01() {
		String path = fileFolder + dataFileName;
		String beginDateString = "2017-04-01";
		String endDateString = "2017-04-30";
		String sheetName = Constants.LOCATION_THREE;
		Double grossProfit = ExcavatorService.getGrossProfit(path, sheetName,
						beginDateString, endDateString);
		logger.debug("grossProfit\t" + grossProfit);
	}

	@Test
	public void testGetGrossProfit_02() {
		String path = fileFolder + dataFileName;
		String beginDateString = "2017-05-01";
		String endDateString = "2017-05-31";
		String sheetName = Constants.LOCATION_THREE;
		Double grossProfit = ExcavatorService.getGrossProfit(path, sheetName,
						beginDateString, endDateString);
		logger.debug("grossProfit\t" + grossProfit);
	}

	@Test
	public void testGetGrossProfitByLocation_01() {
		String path = fileFolder + dataFileName;
		String location = Constants.LOCATION_ONE;
		String sheetName = Constants.LOCATION_THREE;
		Double grossProfit = ExcavatorService.getGrossProfitByLocation(path,
						sheetName, location);
		logger.debug(location + "grossProfit\t" + grossProfit);
	}

	@Test
	public void testGetGrossProfitByLocation_02() {
		String path = fileFolder + dataFileName;
		String location = Constants.LOCATION_TWO;
		String sheetName = Constants.LOCATION_THREE;
		Double grossProfit = ExcavatorService.getGrossProfitByLocation(path,
						sheetName, location);
		logger.debug(location + "grossProfit\t" + grossProfit);
	}

	@Test
	public void testGetGrossProfitByLocation_03() {
		String path = fileFolder + dataFileName;
		String location = Constants.LOCATION_THREE;
		String sheetName = Constants.LOCATION_THREE;
		Double grossProfit = ExcavatorService.getGrossProfitByLocation(path,
						sheetName, location);
		logger.debug(location + "grossProfit\t" + grossProfit);
	}

	@Test
	public void testGetGrossProfitByLocation_04() {
		String path = fileFolder + dataFileName;
		String sheetName = Constants.LOCATION_THREE;
		for (String location : locationList) {
			Double grossProfit = ExcavatorService.getGrossProfitByLocation(path,
							sheetName, location);
			logger.debug(location + "grossProfit\t" + grossProfit);
		}
	}

	@Test
	public void testGetAverageGrossProfitByLocation_01() {
		String path = fileFolder + dataFileName;
		String location = Constants.LOCATION_ONE;
		String sheetName = Constants.LOCATION_THREE;
		Double grossProfit = ExcavatorService.getAverageGrossProfitByLocation(
						path, sheetName, location);
		logger.debug(location + "grossProfit\t" + grossProfit);
	}

	@Test
	public void testGetAverageGrossProfitByLocation_02() {
		String path = fileFolder + dataFileName;
		String location = Constants.LOCATION_TWO;
		String sheetName = Constants.LOCATION_THREE;
		Double grossProfit = ExcavatorService.getAverageGrossProfitByLocation(
						path, sheetName, location);
		logger.debug(location + "grossProfit\t" + grossProfit);
	}

	@Test
	public void testGetAverageGrossProfitByLocation_03() {
		String path = fileFolder + dataFileName;
		String location = Constants.LOCATION_THREE;
		String sheetName = Constants.LOCATION_THREE;
		Double grossProfit = ExcavatorService.getAverageGrossProfitByLocation(
						path, sheetName, location);
		logger.debug(location + "grossProfit\t" + grossProfit);
	}

	@Test
	public void testGetAverageGrossProfitByLocation_04() {
		String path = fileFolder + dataFileName;
		String sheetName = Constants.LOCATION_THREE;
		for (String location : locationList) {
			Double grossProfit = ExcavatorService
							.getAverageGrossProfitByLocation(path, sheetName,
											location);
			logger.debug(location + "grossProfit\t" + grossProfit);
		}
	}

	@Test
	public void testGetNetProfit_01() {
		String path = fileFolder + dataFileName;
		String beginDateString = "2017-04-01";
		String endDateString = "2017-04-30";
		String sheetName = Constants.LOCATION_THREE;
		Double netProfit = ExcavatorService.getNetProfit(path, sheetName,
						beginDateString, endDateString);
		logger.debug("netProfit\t" + netProfit);
	}

	@Test
	public void testGetNetProfit_02() {
		String path = fileFolder + dataFileName;
		String beginDateString = "2017-05-01";
		String endDateString = "2017-05-31";
		String sheetName = Constants.LOCATION_THREE;
		Double netProfit = ExcavatorService.getNetProfit(path, sheetName,
						beginDateString, endDateString);
		logger.debug("netProfit\t" + netProfit);
	}

	/**
	 * Net:12378 Salary: 10000 Interest: 350000*0.02=7000
	 * 
	 */
	@Test
	public void testGetNetProfit_03() {
		String path = fileFolder + dataFileName;
		String beginDateString = "2017-04-01";
		String endDateString = "2017-05-31";
		String sheetName = Constants.LOCATION_THREE;
		Double netProfit = ExcavatorService.getNetProfit(path, sheetName,
						beginDateString, endDateString);
		logger.debug("netProfit\t" + netProfit / 2);
	}

	@Test
	public void testGetDailyGrossIncome_01() {
		String path = fileFolder + dataFileName;
		String beginDateString = "2017-04-01";
		String endDateString = "2017-05-31";
		String sheetName = Constants.LOCATION_THREE;
		Map<String, Double> dailyIncomeMap = ExcavatorService
						.getDailyGrossIncome(path, sheetName, beginDateString,
										endDateString);

		logger.debug("dailyIncomeMap size\t" + dailyIncomeMap.size());
		for (String workDate : dailyIncomeMap.keySet()) {
			Double dailyIncome = dailyIncomeMap.get(workDate);
			logger.debug(workDate + "\t" + dailyIncome);
		}
	}

	/**
	 * 3个工地的每日营收
	 */
	@Test
	public void testGetDailyGrossIncome_02() {
		String path = fileFolder + dataFileName;
		String beginDateString = "2017-03-01";
		String endDateString = "2017-08-31";
		String sheetName1 = Constants.LOCATION_ONE;
		String sheetName2 = Constants.LOCATION_TWO;
		String sheetName3 = Constants.LOCATION_THREE;
		Map<String, Double> dailyIncomeMap1 = ExcavatorService
						.getDailyGrossIncome(path, sheetName1, beginDateString,
										endDateString);
		Map<String, Double> dailyIncomeMap2 = ExcavatorService
						.getDailyGrossIncome(path, sheetName2, beginDateString,
										endDateString);
		Map<String, Double> dailyIncomeMap3 = ExcavatorService
						.getDailyGrossIncome(path, sheetName3, beginDateString,
										endDateString);
		Map<String, Double> dailyIncomeMap = new TreeMap<String, Double>();
		dailyIncomeMap.putAll(dailyIncomeMap1);
		dailyIncomeMap.putAll(dailyIncomeMap2);
		dailyIncomeMap.putAll(dailyIncomeMap3);

		logger.debug("dailyIncomeMap size\t" + dailyIncomeMap.size());
		for (String workDate : dailyIncomeMap.keySet()) {
			Double dailyIncome = dailyIncomeMap.get(workDate);
			logger.debug(workDate + "\t" + dailyIncome);
		}
	}

	/**
	 * 3个工地的每日营收
	 */
	@Test
	public void testGetIncomeAmount_01() {
		String path = fileFolder + dataFileName;
		String sheetName1 = Constants.LOCATION_ONE;
		String sheetName2 = Constants.LOCATION_TWO;
		String sheetName3 = Constants.LOCATION_THREE;
		List<Excavator> excavatorList1 = ExcavatorService.getExcavatorList(path,
						sheetName1);
		List<Excavator> excavatorList2 = ExcavatorService.getExcavatorList(path,
						sheetName2);
		List<Excavator> excavatorList3 = ExcavatorService.getExcavatorList(path,
						sheetName3);
		List<Excavator> excavatorList = new ArrayList<>();
		excavatorList.addAll(excavatorList1);
		excavatorList.addAll(excavatorList2);
		excavatorList.addAll(excavatorList3);
		Map<String, Map<String, Double>> grossProfitMap = ExcavatorService
						.getIncomeAmount(excavatorList);// TODO
		for (Map.Entry<String, Map<String, Double>> entry : grossProfitMap
						.entrySet()) {
			System.out.println("Key = " + entry.getKey() + ", Value = "
							+ entry.getValue());
			Map<String, Double> map = entry.getValue();
			for (Map.Entry<String, Double> entry2 : map.entrySet()) {
				System.out.println("Key = " + entry2.getKey() + ", Value = "
								+ entry2.getValue());
			}
		}

		ObjectMapper mapper = new ObjectMapper();
		String grossProfitMapStr = "";
		try {
			grossProfitMapStr = mapper.writeValueAsString(grossProfitMap);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.debug(grossProfitMapStr);

		String filename = "gross_profit.json";
		String charsetName = "GBK";
		List<String> contents = new ArrayList<>();
		contents.add(grossProfitMapStr);

		fileFolder = System.getProperty("user.dir");
		filename = fileFolder + "\\src\\main\\webapp\\js\\" + filename;
		FileUtil.write(contents, filename, charsetName);
	}
	
	@Test
	public void testGetWorkDayAmount_01() {
		String path = fileFolder + dataFileName;
		String sheetName1 = Constants.LOCATION_ONE;
		String sheetName2 = Constants.LOCATION_TWO;
		String sheetName3 = Constants.LOCATION_THREE;
		List<Excavator> excavatorList1 = ExcavatorService.getExcavatorList(path,
						sheetName1);
		List<Excavator> excavatorList2 = ExcavatorService.getExcavatorList(path,
						sheetName2);
		List<Excavator> excavatorList3 = ExcavatorService.getExcavatorList(path,
						sheetName3);
		List<Excavator> excavatorList = new ArrayList<>();
		excavatorList.addAll(excavatorList1);
		excavatorList.addAll(excavatorList2);
		excavatorList.addAll(excavatorList3);
		Map<String, Integer> map =  ExcavatorService
						.getWorkDayAmount(excavatorList);// TODO
		for (Map.Entry<String, Integer> entry : map
						.entrySet()) {
			System.out.println("Key = " + entry.getKey() + ", Value = "
							+ entry.getValue());
		}

		ObjectMapper mapper = new ObjectMapper();
		String grossProfitMapStr = "";
		try {
			grossProfitMapStr = mapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.debug(grossProfitMapStr);

		String filename = "workdays_count.json";
		String charsetName = "GBK";
		List<String> contents = new ArrayList<>();
		contents.add(grossProfitMapStr);

		fileFolder = System.getProperty("user.dir");
		filename = fileFolder + "\\src\\main\\webapp\\js\\" + filename;
		FileUtil.write(contents, filename, charsetName);
	}

	@Test
	public void testGetAverageDailyGrossIncome_01() {
		String path = fileFolder + dataFileName;
		String beginDateString = "2017-04-01";
		String endDateString = "2017-04-30";
		String sheetName = Constants.LOCATION_THREE;
		Double averageDailyGrossIncome = ExcavatorService
						.getAverageDailyGrossIncome(path, sheetName,
										beginDateString, endDateString);

		logger.debug("averageDailyGrossIncome\t" + averageDailyGrossIncome);
	}

	@Test
	public void testGetAverageDailyGrossIncome_02() {
		String path = fileFolder + dataFileName;
		String beginDateString = "2017-05-01";
		String endDateString = "2017-05-31";
		String sheetName = Constants.LOCATION_THREE;
		Double averageDailyGrossIncome = ExcavatorService
						.getAverageDailyGrossIncome(path, sheetName,
										beginDateString, endDateString);

		logger.debug("averageDailyGrossIncome\t" + averageDailyGrossIncome);
	}

	@Test
	public void testGetAverageDailyGrossIncome_03() {
		String path = fileFolder + dataFileName;
		String beginDateString = "2017-04-01";
		String endDateString = "2017-05-31";
		String sheetName = Constants.LOCATION_THREE;
		Double averageDailyGrossIncome = ExcavatorService
						.getAverageDailyGrossIncome(path, sheetName,
										beginDateString, endDateString);

		logger.debug("averageDailyGrossIncome\t" + averageDailyGrossIncome);
	}

	@Test
	public void testGetSettlingChargeByLocation_01() {
		String path = fileFolder + dataFileName;
		String location = Constants.LOCATION_ONE;
		String sheetName = Constants.LOCATION_THREE;
		Map<String, Double> settlingChargeMap = ExcavatorService
						.getSettlingChargeByLocation(path, sheetName, location);

		logger.debug("settlingChargeMap size\t" + settlingChargeMap.size());
		for (String workDate : settlingChargeMap.keySet()) {
			Double dailyIncome = settlingChargeMap.get(workDate);
			logger.debug(workDate + "\t" + dailyIncome);
		}
	}

	@Test
	public void testGetSettlingChargeByLocation_02() {
		String path = fileFolder + dataFileName;
		String location = Constants.LOCATION_TWO;
		String sheetName = Constants.LOCATION_THREE;
		Map<String, Double> settlingChargeMap = ExcavatorService
						.getSettlingChargeByLocation(path, sheetName, location);

		logger.debug("settlingChargeMap size\t" + settlingChargeMap.size());
		for (String workDate : settlingChargeMap.keySet()) {
			Double dailyIncome = settlingChargeMap.get(workDate);
			logger.debug(workDate + "\t" + dailyIncome);
		}
	}

	@Test
	public void testGetSettlingChargeByLocation_03() {
		String path = fileFolder + dataFileName;
		String location = Constants.LOCATION_THREE;
		String sheetName = Constants.LOCATION_THREE;
		Map<String, Double> settlingChargeMap = ExcavatorService
						.getSettlingChargeByLocation(path, sheetName, location);

		logger.debug("settlingChargeMap size\t" + settlingChargeMap.size());
		for (String workDate : settlingChargeMap.keySet()) {
			Double dailyIncome = settlingChargeMap.get(workDate);
			logger.debug(workDate + "\t" + dailyIncome);
		}
	}

	@Test
	public void testGetSettlingChargeAmountByLocation_01() {
		String path = fileFolder + dataFileName;
		String location = Constants.LOCATION_ONE;
		String sheetName = Constants.LOCATION_THREE;
		Map<String, String> settlingChargeMap = ExcavatorService
						.getSettlingChargeAmountByLocation(path, sheetName,
										location);

		logger.debug("settlingChargeMap size\t" + settlingChargeMap.size());
		for (String workDate : settlingChargeMap.keySet()) {
			String dailyIncome = settlingChargeMap.get(workDate);
			logger.debug(workDate + "\t" + dailyIncome);
		}
	}

	@Test
	public void testGetSettlingChargeAmountByLocation_02() {
		String path = fileFolder + dataFileName;
		String location = Constants.LOCATION_TWO;
		String sheetName = Constants.LOCATION_THREE;
		Map<String, String> settlingChargeMap = ExcavatorService
						.getSettlingChargeAmountByLocation(path, sheetName,
										location);

		logger.debug("settlingChargeMap size\t" + settlingChargeMap.size());
		for (String workDate : settlingChargeMap.keySet()) {
			String dailyIncome = settlingChargeMap.get(workDate);
			// logger.debug(workDate + "\t" + dailyIncome);
			System.out.println(workDate + "\t" + dailyIncome);
		}
	}

	@Test
	public void testGetSettlingChargeAmountByLocation_03() {
		String path = fileFolder + dataFileName;
		String location = Constants.LOCATION_THREE;
		String sheetName = Constants.LOCATION_THREE;
		Map<String, String> settlingChargeMap = ExcavatorService
						.getSettlingChargeAmountByLocation(path, sheetName,
										location);

		logger.debug("settlingChargeMap size\t" + settlingChargeMap.size());
		for (String workDate : settlingChargeMap.keySet()) {
			String dailyIncome = settlingChargeMap.get(workDate);
			logger.debug(workDate + "\t" + dailyIncome);
		}
	}
}
