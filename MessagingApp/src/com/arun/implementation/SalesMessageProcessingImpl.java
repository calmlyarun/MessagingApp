package com.arun.implementation;

import com.arun.adapter.CSVTypeMessageProcessAdapter;
import com.arun.adapter.Message;
import com.arun.objects.Product;

public class SalesMessageProcessingImpl {
	private static final long MESSAGE_PROCESSING_CAPACITY = 10;
	private static final long MID_TERM_RECORD_LIMIT = 5;
	private int messageProcessCounter = 0;
	CSVTypeMessageProcessAdapter csvTypeMessageProcessAdapter;
	SalesRegister salesRegister = SalesRegister.getInstance();;

	public static SalesMessageProcessingImpl getInstance() {
		return new SalesMessageProcessingImpl();
	}

	/**
	 * CSV Adapter initialization & collect all messages
	 * 
	 * @param filePath
	 */
	public void setupMessageProcessAdapter(String filePath) {

		csvTypeMessageProcessAdapter = CSVTypeMessageProcessAdapter
				.getInstance();
		csvTypeMessageProcessAdapter.collectAllMessagesFromFile(filePath);
	}

	/**
	 * Process the each message
	 */
	public void processSaleMessage() {

		Message message = csvTypeMessageProcessAdapter.readMessage();

		Product product = constructProduct(message);
		if (message.getOperation() == null) {
			// New sale record
			salesRegister.addSaleRecord(product);
		} else if (message.getOperation().equalsIgnoreCase(
				Message.OPERATION_ADD)) {
			salesRegister.performAddSaleTransaction(product);
		} else if (message.getOperation().equalsIgnoreCase(
				Message.OPERATION_SUBTRACT)) {
			salesRegister.performSubtractSaleTransaction(product);
		} else if (message.getOperation().equalsIgnoreCase(
				Message.OPERATION_MULTIPLY)) {
			salesRegister.performMultiplySaleTransaction(product);
		}
		messageProcessCounter++;

		if (messageProcessCounter == MESSAGE_PROCESSING_CAPACITY) {
			/**
			 * TODO: Considering application will exit when ever it reaches the
			 * capacity. If running in multithread env, sync needs to be done
			 * 
			 */
			System.out
					.println("Sorry. Message limit reached "
							+ messageProcessCounter
							+ ". Stop processing further messages. Printing detailed report...");
			System.out.println("********************************************");
			System.out.println(salesRegister.getDetailedSalesReport());
			System.out.println("********************************************");
			System.exit(0);

		} else if (messageProcessCounter % MID_TERM_RECORD_LIMIT == 0) {
			System.out.println("********************************************");
			System.out.println("Mid term limit reached ("+MID_TERM_RECORD_LIMIT+"). Sales Overview is...");
			System.out.println("********************************************");

			System.out.println(salesRegister.getSalesReportOverview());
			System.out.println("********************************************");

		}
	}

	/**
	 * Construct Product
	 * 
	 * @param message
	 * @return
	 */
	private Product constructProduct(Message message) {
		Product product = new Product(message.getProductType(),
				message.getPrice(), message.getQuantity().intValue());

		return product;
	}
}
