package com.pdrc;

import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IdleServiceTest {
	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() {
	}

	@BeforeClass
	public void beforeClass() {
	}

	@AfterClass
	public void afterClass() {
	}

	@Test
	public void getWorkDayList_01() {
		String workId = "B-34678";
		List<String> workDayList = IdleService.getWorkDayList(workId);
		for (String workDay : workDayList) {
			System.out.println(workDay);
		}
	}

	@Test
	public void getWorkDayList_02() {
		String workId = "B-9852";
		List<String> workDayList = IdleService.getWorkDayList(workId);
		System.out.println("size:\t" + workDayList.size());
		for (String workDay : workDayList) {
			System.out.println(workDay);
		}
	}

	@Test
	public void getWorkDayList_03() {
		String workId = "B-33149";
		List<String> workDayList = IdleService.getWorkDayList(workId);
		System.out.println("size:\t" + workDayList.size());
		for (String workDay : workDayList) {
			System.out.println(workDay);
		}
	}

	/**
	 * B-18939
	 */
	@Test
	public void getInProjectPeriodDayList_01() {
		String workId = "B-18939";
		List<String[]> inProjectDayList = IdleService
				.getInProjectPeriodDayList(workId);
		for (String[] inProjectDay : inProjectDayList) {
			for (String string : inProjectDay) {
				System.out.print(string + "\t");
			}
			System.out.println();
		}
	}

	@Test
	public void getInProjectPeriodDayList_02() {
		String workId = "B-19769";
		List<String[]> inProjectDayList = IdleService
				.getInProjectPeriodDayList(workId);
		for (String[] inProjectDay : inProjectDayList) {
			for (String string : inProjectDay) {
				System.out.print(string + "\t");
			}
			System.out.println();
		}
	}

	@Test
	public void getInProjectPeriodDayList_03() {
		String workId = "B-19776";
		List<String[]> inProjectDayList = IdleService
				.getInProjectPeriodDayList(workId);
		for (String[] inProjectDay : inProjectDayList) {
			for (String string : inProjectDay) {
				System.out.print(string + "\t");
			}
			System.out.println();
		}
	}

	@Test
	public void getInProjectPeriodDayList_04() {
		String workId = "B-20413";
		List<String[]> inProjectDayList = IdleService
				.getInProjectPeriodDayList(workId);
		for (String[] inProjectDay : inProjectDayList) {
			for (String string : inProjectDay) {
				System.out.print(string + "\t");
			}
			System.out.println();
		}
	}

	@Test
	public void getInProjectPeriodDayList_05() {
		String workId = "B-25004";
		List<String[]> inProjectDayList = IdleService
				.getInProjectPeriodDayList(workId);
		for (String[] inProjectDay : inProjectDayList) {
			for (String string : inProjectDay) {
				System.out.print(string + "\t");
			}
			System.out.println();
		}
	}

	@Test
	public void getInProjectPeriodDayList_06() {
		String workId = "B-9852";
		List<String[]> inProjectDayList = IdleService
				.getInProjectPeriodDayList(workId);
		for (String[] inProjectDay : inProjectDayList) {
			for (String string : inProjectDay) {
				System.out.print(string + "\t");
			}
			System.out.println();
		}
	}

	@Test
	public void getInProjectPeriodDayList_07() {
		String workId = "B-13532";
		List<String[]> inProjectDayList = IdleService
				.getInProjectPeriodDayList(workId);
		for (String[] inProjectDay : inProjectDayList) {
			for (String string : inProjectDay) {
				System.out.print(string + "\t");
			}
			System.out.println();
		}
	}

	@Test
	public void getInProjectPeriodDayList_08() {
		String workId = "B-33149";
		String addDateStr = "2017-02-03";
		List<String[]> inProjectDayList = IdleService
				.getInProjectPeriodDayList(workId, addDateStr);
		for (String[] inProjectDay : inProjectDayList) {
			for (String string : inProjectDay) {
				System.out.print(string + "\t");
			}
			System.out.println();
		}
	}

	// @Test
	// public void getInProjectDayList_01() {
	// String workId = "B-9852";
	// List<String> inProjectDayList = IdleService.getInProjectDayList(workId);
	// System.out.println("size:\t" + inProjectDayList.size());
	// for (String inProjectDay : inProjectDayList) {
	// System.out.println(inProjectDay);
	// }
	// }
	//
	// @Test
	// public void getInProjectDayList_02() {
	// String workId = "B-34678";
	// List<String> inProjectDayList = IdleService.getInProjectDayList(workId);
	// System.out.println("size:\t" + inProjectDayList.size());
	// for (String inProjectDay : inProjectDayList) {
	// System.out.println(inProjectDay);
	// }
	// }
	//
	// @Test
	// public void getInProjectDayList_03() {
	// String workId = "B-15655";
	// List<String> inProjectDayList = IdleService.getInProjectDayList(workId);
	// System.out.println("size:\t" + inProjectDayList.size());
	// for (String inProjectDay : inProjectDayList) {
	// System.out.println(inProjectDay);
	// }
	// }

	@Test
	public void getIdleDays_01() {
		String workId = "B-33149";
		String addDate = "2017-02-03";
		Integer idleDays = IdleService.getIdleDays(workId, addDate);
		System.out.println(idleDays);
	}
	
	@Test
	public void getIdleDays_02() {
		String workId = "B-34809";
		String addDate = "2017-05-06";
		Integer idleDays = IdleService.getIdleDays(workId, addDate);
		System.out.println(idleDays);
	}
	
	
	

	// @Test
	// public void getIdleDays_02() {
	// String workId = "B-33149";
	// Integer idleDays = IdleService.getIdleDays(workId);
	// System.out.println(idleDays);
	// }
	//
	//
	//
	 @Test
	public void getIdleRate_01() {
		String workId = "B-36054";
		String addDate = "2017-07-03";
		double idleRate = IdleService.getIdleRate(workId, addDate);
		System.out.println(idleRate);
	}
	
	// @Test
	// public void getIdleRateList_02() {
	// String workId = "B-33425";
	// double idleRate = IdleService.getIdleRateList(workId);
	// System.out.println(idleRate);
	// }
	//
	// @Test
	// public void getTmMemberList_01() {
	// String tmWorkId = "B-14285";
	// List<String> tmMemberList = IdleService.getTmMemberList(tmWorkId);
	// System.out.println(tmMemberList.size());
	// for (String workId : tmMemberList) {
	// System.out.println(workId);
	// }
	// }
	//
	// @Test
	// public void getTmMemberList_02() {
	// String tmWorkId = "B-14285";
	// List<String> tmMemberList = IdleService.getTmMemberList(tmWorkId);
	// System.out.println(tmMemberList.size());
	// for (String workId : tmMemberList) {
	// System.out.println(workId + "\t" + IdleService.getIdleDays(workId));
	// }
	// }
	//
	// @Test
	// public void getTmMemberList_03() {
	// String tmWorkId = "B-14285";
	// List<String> tmMemberList = IdleService.getTmMemberList(tmWorkId);
	// System.out.println(tmMemberList.size());
	// for (String workId : tmMemberList) {
	// int days = IdleService.getIdleDays(workId);
	// if (0 != days) {
	// System.out.println(
	// workId + "\t" + days);
	// }
	// }
	// }
	//
	// @Test
	// public void getTmMemberList_04() {
	// String tmWorkId = "B-14285";
	// List<String> tmMemberList = IdleService.getTmMemberList(tmWorkId);
	// System.out.println(tmMemberList.size());
	// for (String workId : tmMemberList) {
	// int days = IdleService.getIdleDays(workId);
	// if (365 == days) {
	// System.out.println(
	// workId + "\t" + days);
	// }
	// }
	// }

	@Test
	public void getTmMemberInfoList_01() {
		String tmWorkId = "B-14285";
		List<String[]> tmMemberInfoList = IdleService
				.getTmMemberInfoList(tmWorkId);
		System.out.println(tmMemberInfoList.size());
		for (String[] strings : tmMemberInfoList) {
			int days = IdleService.getIdleDays(strings[0], strings[1]);
			if (0 != days) {
				System.out.println(strings[0] + "\t" + days);
			}
		}
	}

	@Test
	public void getIdleRateList_01() {
		String tmWorkId = "B-14285";
		List<String[]> tmMemberInfoList = IdleService
				.getTmMemberInfoList(tmWorkId);
		System.out.println(tmMemberInfoList.size());
		for (String[] strings : tmMemberInfoList) {
			double idleRate = IdleService.getIdleRate(strings[0],
					strings[1]);
			System.out.println(strings[0] + "\t" + idleRate);
		}
	}

}
