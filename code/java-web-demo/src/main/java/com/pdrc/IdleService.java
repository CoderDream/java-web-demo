package com.pdrc;

import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.coderdream.util.ConnectionFactory;
import com.coderdream.util.Constants;
import com.coderdream.util.DateUtil;

public class IdleService {

	public static List<String> getTmMemberList(String workId) {
		List<String> tmMemberList = new ArrayList<>();
		// ='B-14285';
		String sql = "SELECT rag.WorkID from RC_AEGIS rag WHERE rag.AddDate < '2018-01-01' AND rag.TMWorkID= '"
				+ workId + "'";
		ResultSet rs = ConnectionFactory.execute(sql);
		try {
			while (rs.next()) {
				tmMemberList.add(rs.getString("WorkID"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return tmMemberList;
	}

	public static List<String[]> getTmMemberInfoList(String workId) {
		List<String[]> tmMemberList = new ArrayList<>();
		// ='B-14285';
		String sql = "SELECT rag.AddDate,rag.WorkID from RC_AEGIS rag WHERE rag.AddDate < '2018-01-01' AND rag.TMWorkID= '"
				+ workId + "'";
		ResultSet rs = ConnectionFactory.execute(sql);
		SimpleDateFormat sdf = new SimpleDateFormat(
				Constants.SIMPLE_DATE_FORMAT);// 格式化为年月
		try {
			while (rs.next()) {
				Date addDate = rs.getDate("AddDate");
				tmMemberList.add(new String[] { rs.getString("WorkID"),
						sdf.format(addDate.getTime()) });
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return tmMemberList;
	}

	public static List<String> getWorkDayList(String workId) {
		List<String> workDayList = new ArrayList<>();
		String sql = "SELECT rag.WorkID WorkID, ad2.[PK_日期] WorkDay FROM RC_AEGIS rag, PDRC_A_DATE ad2 WHERE ad2.[PK_日期] < '2018-1-1' AND ad2.[PK_日期] > '2016-12-31' AND ad2.[PK_日期] >= rag.AddDate AND rag.WorkID = '"
				+ workId + "'";
		ResultSet rs = ConnectionFactory.execute(sql);
		SimpleDateFormat sdf = new SimpleDateFormat(
				Constants.SIMPLE_DATE_FORMAT);// 格式化为年月
		try {
			while (rs.next()) {
				Date workDay = rs.getDate("WorkDay");
				workDayList.add(sdf.format(workDay.getTime()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return workDayList;
	}

	/**
	 * 获取在项时间列表
	 * 
	 * @param workId
	 * @return
	 */
	public static List<String[]> getInProjectPeriodDayList(String workId) {
		List<String[]> inProjectDayList = new ArrayList<>();
		String sql = "SELECT hm.WorkID, hm.InPro_Date, hm.OutPro_Date, hm.ProjectID FROM HumanMap hm WHERE hm.InPro_Date < '2018-1-1' AND hm.OutPro_Date > '2016-12-31' AND hm.WorkID = '"
				+ workId
				+ "' UNION SELECT hm.WorkID, hm.InPro_Date, hm.OutPro_Date, hm.ProjectID FROM HumanMap hm, Project_AEGIS pag WHERE hm.ProjectID = pag.ProjectID AND hm.InPro_Date < '2018-1-1' AND hm.OutPro_Date IS NULL AND pag.RealEndTime IS NULL AND pag.ParentProjectFinishStatus IS NULL AND hm.WorkID = '"
				+ workId + "'";
		ResultSet rs = ConnectionFactory.execute(sql);
		SimpleDateFormat sdf = new SimpleDateFormat(
				Constants.SIMPLE_DATE_FORMAT);// 格式化为年月

		Calendar inProDateCal = Calendar.getInstance();
		Calendar outProDateCal = Calendar.getInstance();
		try {
			while (rs.next()) {
				String str = "2017-12-31";
				Date inProDate = rs.getDate("InPro_Date");
				Date outProDate = rs.getDate("OutPro_Date") == null
						? new Date(sdf.parse(str).getTime())
						: rs.getDate("OutPro_Date");
				inProDateCal.setTime(inProDate);
				outProDateCal.setTime(outProDate);

				inProjectDayList.add(new String[] { rs.getString("WorkID"),
						sdf.format(inProDateCal.getTime()),
						sdf.format(outProDateCal.getTime()),
						rs.getString("ProjectID") });
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return inProjectDayList;
	}

	/**
	 * 获取在项时间列表
	 * 
	 * @param workId
	 * @return
	 */
	public static List<String[]> getInProjectPeriodDayList(String workId,
			String addDateStr) {
		List<String[]> inProjectDayList = new ArrayList<>();
		String sql = "SELECT hm.WorkID, hm.InPro_Date, hm.OutPro_Date, hm.ProjectID FROM HumanMap hm WHERE hm.InPro_Date < '2018-1-1' AND hm.OutPro_Date > '2016-12-31' AND hm.WorkID = '"
				+ workId
				+ "' UNION SELECT hm.WorkID, hm.InPro_Date, hm.OutPro_Date, hm.ProjectID FROM HumanMap hm, Project_AEGIS pag WHERE hm.ProjectID = pag.ProjectID AND hm.InPro_Date < '2018-1-1' AND hm.OutPro_Date IS NULL AND pag.RealEndTime IS NULL AND pag.ParentProjectFinishStatus IS NULL AND hm.WorkID = '"
				+ workId + "'";
		ResultSet rs = ConnectionFactory.execute(sql);
		SimpleDateFormat sdf = new SimpleDateFormat(
				Constants.SIMPLE_DATE_FORMAT);// 格式化为年月

		Calendar addDateCal = Calendar.getInstance();
		Calendar inProDateCal = Calendar.getInstance();
		Calendar outProDateCal = Calendar.getInstance();
		try {
			while (rs.next()) {
				String str = "2017-12-31";
				Date inProDate = rs.getDate("InPro_Date");
				Date outProDate = rs.getDate("OutPro_Date") == null
						? new Date(sdf.parse(str).getTime())
						: rs.getDate("OutPro_Date");
				addDateCal.setTime(sdf.parse(addDateStr));
				inProDateCal.setTime(inProDate);
				outProDateCal.setTime(outProDate);
				Date addDate = new Date(sdf.parse(addDateStr).getTime());
				// 与员工的入RC资源池的时间比较，以此时间为起点
				// 1、出项时间在入池时间之前，此记录无效
				if (!outProDate.before(addDate)) {
					// 2、入项时间在入池时间之前，置换为入池时间
					if (inProDate.before(addDate)) {
						inProjectDayList.add(new String[] {
								rs.getString("WorkID"), sdf.format(addDate),
								sdf.format(outProDateCal.getTime()),
								rs.getString("ProjectID") });
					} else {
						inProjectDayList
								.add(new String[] { rs.getString("WorkID"),
										sdf.format(inProDateCal.getTime()),
										sdf.format(outProDateCal.getTime()),
										rs.getString("ProjectID") });
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return inProjectDayList;
	}

	/**
	 * @param workId
	 * @return
	 */
	public static List<String> getInProjectDayList(String workId, String addDate) {
		List<String> inProjectDayList = new ArrayList<>();
		List<String[]> inProjectPeriodDayList = getInProjectPeriodDayList(
				workId, addDate);
		for (String[] strings : inProjectPeriodDayList) {
			String inProDate = strings[1];
			String outProDate = strings[2] == null ? "2017-12-31" : strings[2];
			// System.out.println(inProDate + "\t" + outProDate);

			List<String> result = DateUtil.getDayBetweenYear2017(inProDate,
					outProDate);
			inProjectDayList.addAll(result);
		}

		return inProjectDayList;
	}

	public static Integer getIdleDays(String workId, String addDate) {
		List<String> workDayList = getWorkDayList(workId);
		List<String> inProjectDayList = getInProjectDayList(workId, addDate);
		return workDayList.size() - inProjectDayList.size();
	}
	
	public static double getIdleRate(String workId, String addDate) {
		List<String> workDayList = getWorkDayList(workId);
		List<String> inProjectDayList = getInProjectDayList(workId, addDate);
		double idelRate = 0.0;
		idelRate = (workDayList.size() - inProjectDayList.size())
				/ workDayList.size();

		return idelRate;
	}

}
