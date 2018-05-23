package com.arun.implementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import com.arun.objects.Product;
import com.arun.objects.SaleTransaction;

public class SalesRegister {

	Hashtable<String, Product> products ;
	Hashtable<Product, List<SaleTransaction>> records ;

	public static SalesRegister getInstance() {
		return new SalesRegister();
	}

	
	

	/**
	 * 
	 */
	public SalesRegister() {
		super();
		products = new Hashtable<String, Product>();
		records = new Hashtable<Product, List<SaleTransaction>>();

	}



	/**
	 * Add sale record
	 * @param product
	 */

	public void addSaleRecord(Product product) {
		if(!products.containsKey(product.getProductType())){
			products.put(product.getProductType(), product);
			records.put(product, new ArrayList<SaleTransaction>());
		}else{
			performAddSaleTransaction(product);
		}
		
	}

	/**
	 * TODO: Refactor or Optimize these procedures to avoid duplication of code.
	 * 
	 * Perform Add Sales Operation
	 * @param product
	 */
	public void performAddSaleTransaction(Product product) {
		if (products.containsKey(product.getProductType())) {
			// Sale exist
			Product originalProductObj = products.get(product.getProductType());
			List<SaleTransaction> saleTransactionList = records
					.get(originalProductObj);
			SaleTransaction saleTransaction = new SaleTransaction();
			int quantity = originalProductObj.getQuantity()
					+ product.getQuantity();
			originalProductObj.setQuantity(quantity);
			saleTransaction.setDetails(product.getProductType() + " "
					+ product.getQuantity() + " quantity added. Total: "
					+ quantity);
			saleTransaction.setTransactionTime(new Date());
			saleTransaction.setOperation("Add");
			saleTransactionList.add(saleTransaction);
			System.out.println(saleTransaction.toString());
		} else {
			System.out.println("else  "+  product.getProductType());
			addSaleRecord(product);
		}

	}

	/**
	 * TODO: Refactor or Optimize these procedures to avoid duplication of code.
	 * 
	 * Perform Subtract Sales Operation
	 * @param product
	 */
	public void performSubtractSaleTransaction(Product product) {
		if (products.containsKey(product.getProductType())) {
			// Sale exist
			Product originalProductObj = products.get(product.getProductType());
			List<SaleTransaction> saleTransactionList = records
					.get(originalProductObj);
			SaleTransaction saleTransaction = new SaleTransaction();
			int quantity = 0;

			if (originalProductObj.getQuantity() > product.getQuantity()) {
				quantity = originalProductObj.getQuantity()
						- product.getQuantity();
			}
			originalProductObj.setQuantity(quantity);
			saleTransaction.setDetails(product.getProductType() + " "
					+ product.getQuantity() + "quantity subtracted. Total: "
					+ quantity);
			saleTransaction.setTransactionTime(new Date());
			saleTransaction.setOperation("Subtract");
			saleTransactionList.add(saleTransaction);
		} else {
			addSaleRecord(product);
		}

	}

	/**
	 * TODO: Refactor or Optimize these procedures to avoid duplication of code.
	 * 
	 * Perform Multiply Sales Operation
	 * @param product
	 */
	public void performMultiplySaleTransaction(Product product) {
		if (products.containsKey(product.getProductType())) {
			// Sale exist
			Product originalProductObj = products.get(product.getProductType());
			List<SaleTransaction> saleTransactionList = records
					.get(originalProductObj);
			SaleTransaction saleTransaction = new SaleTransaction();
			int quantity = originalProductObj.getQuantity()
					* product.getQuantity();
			originalProductObj.setQuantity(quantity);
			saleTransaction.setDetails(product.getProductType() + " "
					+ product.getQuantity() + "quantity multipled. Total: "
					+ quantity);
			saleTransaction.setTransactionTime(new Date());
			saleTransaction.setOperation("Multiply");
			saleTransactionList.add(saleTransaction);
		} else {
			addSaleRecord(product);
		}

	}


	/**
	 * Get NumberOfTimesSaleIsAlterated
	 * 
	 * @return zero if not altered
	 * @return altered count
	 */
	public Integer getNumberOfTimesSaleIsAlterated(Product product) {
		List<SaleTransaction> saleTransactions = records.get(product);
		if (saleTransactions == null) {
			return 0;
		} else {
			return saleTransactions.size();
		}
	}

	/**
	 * Return true if altered otherwise false
	 * 
	 * @return
	 */
	public boolean isSaleAltered(Product product) {
		return getNumberOfTimesSaleIsAlterated(product) == 0 ? false : true;
	}

	/**
	 * Get sales report overview
	 * @return
	 */
	public String getSalesReportOverview() {
		StringBuilder sb = new StringBuilder();
		Product product;
		Enumeration<Product> recordEnumeration = records.keys();
		double total = 0.0;
		while (recordEnumeration.hasMoreElements()) {
			product = recordEnumeration.nextElement();
			total = total+product.getTotalValue();
			sb.append("\t"+product.toString()+"\n");
		}
		
		sb.append("Total number of products :"+records.size()+" & Its worth is $"+total);
		return sb.toString();
	}

	
	/**
	 * Generate detailed report
	 * @return
	 */
	public String getDetailedSalesReport() {
		StringBuilder sb = new StringBuilder();
		Product product;
		Enumeration<Product> recordEnumeration = records.keys();
		double total = 0.0;
		while (recordEnumeration.hasMoreElements()) {
			product = recordEnumeration.nextElement();
			total = total+product.getTotalValue();
			List<SaleTransaction> saleTransactionList = records.get(product);
			sb.append("\t"+product.toString()+"\n");
			int i=1;
			if (saleTransactionList != null && !saleTransactionList.isEmpty()) {
				sb.append("\t\tAltered "+saleTransactionList.size()+" times.\n");
				for(SaleTransaction transaction : saleTransactionList){
					sb.append("\t\t\t"+i+++": "+transaction.toString()+"\n");
				}
			}
		}
		sb.append("Total number of products :"+records.size()+" & Its worth is $"+total);

		return sb.toString();
	}

}
