package com.coderdream.excavator.bean;

public class Shift {
	/** 工作日期 */
	private String workDate;

	/** 收入 */
	private Double income;

	/** 数量 */
	private Double amount;
	
	/** 工地 */
	private String location;

	public String getWorkDate() {
		return workDate;
	}

	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Shift [workDate=" + workDate + ", income=" + income
						+ ", amount=" + amount + "]";
	}

}
