package com.arun;

import com.arun.implementation.SalesMessageProcessingImpl;

public class Main {

	public static void main(String argv[]) throws Exception {
		SalesMessageProcessingImpl messageProcessingImpl = SalesMessageProcessingImpl
				.getInstance();
		messageProcessingImpl
				.setupMessageProcessAdapter("/resources/SampleMessages.csv");

		
		for(int i=0;i<15;i++){
			messageProcessingImpl.processSaleMessage();
			Thread.sleep(100);
		}
	}


}
