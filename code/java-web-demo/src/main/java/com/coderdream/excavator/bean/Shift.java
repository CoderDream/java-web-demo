package com.coderdream.excavator.bean;

public class Shift {
	/** 工作日期 */
	private String workDate;

	/** 收入 */
	private Double income;

	/** 数量 */
	private Double amount;

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

	@Override
	public String toString() {
		return "Shift [workDate=" + workDate + ", income=" + income
						+ ", amount=" + amount + "]";
	}

}
