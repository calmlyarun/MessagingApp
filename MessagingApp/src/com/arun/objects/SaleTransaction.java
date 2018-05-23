package com.arun.objects;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author AR266832
 *
 */
public class SaleTransaction {

	private String operation;
	private String details;
	private Date transactionTime;
	/**
	 * @return the operation
	 */
	public String getOperation() {
		return operation;
	}
	/**
	 * @param operation the operation to set
	 */
	public void setOperation(String operation) {
		this.operation = operation;
	}
	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}
	/**
	 * @param details the details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}

	/**
	 * @return the transactionTime
	 */
	public Date getTransactionTime() {
		return transactionTime;
	}
	/**
	 * @param transactionTime the transactionTime to set
	 */
	public void setTransactionTime(Date transactionTime) {
		this.transactionTime = transactionTime;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		Format format = new SimpleDateFormat("yyyy MM dd HH:mm:ss");
		return "SaleTransaction [details=" + details + ", transactionTime="
				+ format.format(transactionTime) + "]";
	}
	
	
	
	
}
