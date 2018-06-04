package com.coderdream.util;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.sql.ResultSet;

import org.testng.annotations.AfterClass;

public class ConnectionFactoryTest {
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

	/**
	 * 找出Idle日数量
	 */
	@Test
	public void execute_01() {
		String sql = "SELECT t2.WorkID, COUNT(*) COUNTNUMBER FROM ( SELECT ad.[PK_日期], hm.WorkID FROM ( SELECT ad2.[PK_日期] FROM RC_AEGIS rag, PDRC_A_DATE ad2 WHERE ad2.[PK_日期] < '2018-1-1' AND ad2.[PK_日期] > '2016-12-31' AND ad2.[PK_日期] >= rag.InDate AND rag.WorkID = 'B-34678' ) ad LEFT JOIN HumanMap hm ON ( ad.[PK_日期] >= hm.InPro_Date AND ad.[PK_日期] <= hm.OutPro_Date ) AND hm.WorkID = 'B-34678' ) AS t2 WHERE t2.WorkID IS NULL GROUP BY t2.WorkID";
		ResultSet rs = ConnectionFactory.execute(sql);
		try {
			while (rs.next()) {
				System.out.print(",COUNTNUMBER=" + rs.getInt("COUNTNUMBER"));
				System.out.println("");
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

	}

	/**
	 * 找出工作日
	 */
	@Test
	public void execute_02() {
		String sql = "SELECT rag.WorkID WorkID, ad2.[PK_日期] WorkDay FROM RC_AEGIS rag, PDRC_A_DATE ad2 WHERE ad2.[PK_日期] < '2018-1-1' AND ad2.[PK_日期] > '2016-12-31' AND ad2.[PK_日期] >= rag.InDate AND rag.WorkID = 'B-34678'";
		ResultSet rs = ConnectionFactory.execute(sql);
		try {
			while (rs.next()) {
				System.out.print("WorkID=" + rs.getString("WorkID")
						+ ",WorkDay=" + rs.getString("WorkDay"));
				System.out.println("");
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

	}
}
