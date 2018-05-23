package com.arun.adapter;

/**
 * 
 * @author AR266832
 *
 */
public class Message {
	public static String OPERATION_ADD="ADD";
	public static String OPERATION_SUBTRACT="SUBTRACT";
	public static String OPERATION_MULTIPLY="MULTIPLY";
	
	private String productType;
	private Double price;
	private Double quantity;
	private String operation;
	
	
	
	/**
	 * @param productType
	 * @param price
	 * @param quantity
	 */
	public Message(String productType, Double price, Double quantity) {
		super();
		this.productType = productType;
		this.price = price;
		this.quantity = quantity;
	}
	/**
	 * @param productType
	 * @param price
	 * @param quantity
	 * @param operation
	 */
	public Message(String productType, Double price, Double quantity,
			String operation) {
		super();
		this.productType = productType;
		this.price = price;
		this.quantity = quantity;
		this.operation = operation;
	}
	/**
	 * @return the productType
	 */
	public String getProductType() {
		return productType;
	}
	/**
	 * @param productType the productType to set
	 */
	public void setProductType(String productType) {
		this.productType = productType;
	}
	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	/**
	 * @return the quantity
	 */
	public Double getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Message [productType=" + productType + ", price=" + price
				+ ", quantity=" + quantity + ", operation=" + operation + "]";
	}
	
	
	
}
