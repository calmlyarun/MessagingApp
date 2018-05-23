package com.arun.adapter;


/**
 * Sample class to read messages from another source E.g: JMS, ActiveMQ etc
 * @author AR266832
 *
 */
public class TextMessageProcessAdapter {
	
	

//	Logger log = Logger.getAnonymousLogger();
//	private QueueConnection queueConn;
//	private QueueReceiver queueReceiver;
//
//	private String MESSAGE_TYPE_1 = "Type1";// E.g: Type1: 1 sale of apple at
//											// 10p";
//	private String MESSAGE_TYPE_2 = "Type2";// E.g: Type2: 20 sales of apples at
//											// 10p each;
//	private String MESSAGE_TYPE_3 = "Type3";// Type3: add 20p apples
//
//	public void initiateQueue(String queueName) throws SaleException {
//		try {
//
//			Properties env = new Properties();
//			env.put(Context.INITIAL_CONTEXT_FACTORY,
//					"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
//			env.put(Context.PROVIDER_URL, "tcp://localhost:61616");
//			env.put("queue.queueSampleQueue", "MyNewQueue");
//			// get the initial context
//			InitialContext ctx = new InitialContext(env);
//
//			// lookup the queue object
//			Queue queue = (Queue) ctx.lookup("queueSampleQueue");
//
//			// lookup the queue connection factory
//			QueueConnectionFactory connFactory = (QueueConnectionFactory) ctx
//					.lookup("QueueConnectionFactory");
//
//			// create a queue connection
//			queueConn = connFactory.createQueueConnection();
//
//			// create a queue session
//			QueueSession queueSession = queueConn.createQueueSession(false,
//					Session.AUTO_ACKNOWLEDGE);
//
//			// create a queue receiver
//			queueReceiver = queueSession.createReceiver(queue);
//
//			// start the connection
//			queueConn.start();
//		} catch (NamingException e) {
//			throw new SaleException("Internal Exception while initiate queue.");
//		} catch (JMSException e) {
//			throw new SaleException("Internal Exception while initiate queue.");
//
//		}
//
//	}
//
//	public Object readFromQueue() throws SaleException {
//		// receive a message
//		TextMessage message;
//		Object readObject = null;
//		try {
//			message = (TextMessage) queueReceiver.receive();
//			String messageString = message.getText();
//			// Record Raw message received
//			log.log(Level.SEVERE, "Raw message received: " + messageString
//					+ ". Time: " + System.currentTimeMillis());
//
//			/**
//			 * This is wrapper will create sale record to use upper layers. Hard
//			 * coding the Sale object based on MESSAGE_TYPE
//			 */
//
////			if (messageString.contains(MESSAGE_TYPE_1)) {
////				SaleRegister sale = new SaleRegister("apple",10,1,null);
////			
////				readObject = sale;
////			} else if (messageString.contains(MESSAGE_TYPE_2)) {
////				SaleRegister sale = new SaleRegister("apple",10,20,null);
////				readObject = sale;
////			} else if (messageString.contains(MESSAGE_TYPE_3)) {
////				SaleRegister sale = new SaleRegister("apple",20,0,null);
////				SaleTransaction saleTransaction = new SaleTransaction();
////				readObject = saleTransaction;
////			} else {
////				throw new SaleException("Unsupported Sale received.");
////			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			throw new SaleException("Internal Exception while processing sale.");
//		}
//
//		return readObject;
//	}
//
//	
//	/**
//	 * Stop queue
//	 */
//	public void stopQueue() {
//		if (queueConn != null) {
//			try {
//				queueConn.close();
//			} catch (JMSException e) {
//				log.log(Level.SEVERE, e.getMessage());
//			}
//		}
//	}

}
