package com.arun.objects;

/**
 * 
 * @author AR266832
 *
 */
public class Product {
	private String productType;
	private Double price;
	private Integer quantity;
	
	
	
	/**
	 * @param productType
	 * @param price
	 * @param quantity
	 */
	public Product(String productType, Double price, Integer quantity) {
		super();
		this.productType = productType;
		this.price = price;
		this.quantity = quantity;
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
	public Integer getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	/**
	 * 
	 * @return
	 */
	public double getTotalValue() {
		// TODO Auto-generated method stub
		return quantity*price;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Product=" + productType + ", Value=" + getTotalValue();
	}



	
	
}
