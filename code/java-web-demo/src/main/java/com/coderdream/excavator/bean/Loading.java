package com.coderdream.excavator.bean;

public class Loading {
	/** 工作日期 */
	private String workDate;

	/** 收入 */
	private Double income;

	/** 数量（大车） */
	private Double amountBig;

	/** 数量 （小车） */
	private Double amountSmall;

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

	public Double getAmountBig() {
		return amountBig;
	}

	public void setAmountBig(Double amountBig) {
		this.amountBig = amountBig;
	}

	public Double getAmountSmall() {
		return amountSmall;
	}

	public void setAmountSmall(Double amountSmall) {
		this.amountSmall = amountSmall;
	}

	@Override
	public String toString() {
		return "Loading [workDate=" + workDate + ", income=" + income
						+ ", amountBig=" + amountBig + ", amountSmall="
						+ amountSmall + "]";
	}

}
