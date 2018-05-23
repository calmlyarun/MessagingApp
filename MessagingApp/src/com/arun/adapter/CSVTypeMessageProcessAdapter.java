/**
 * 
 */
package com.arun.adapter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * @author AR266832
 *
 */
public class CSVTypeMessageProcessAdapter {
	Logger log = Logger.getAnonymousLogger();
	private ArrayList<Message> messages = new ArrayList<Message>();

	/**
	 * Initial function to read and collect all messages from file
	 * TODO: Use specific logger for record
	 * @param path
	 */
	public void collectAllMessagesFromFile(String path) {

			BufferedReader in = null;
			InputStream is = null;
			InputStreamReader isr = null;
			try {
				is = getClass().getResourceAsStream(path);
			    isr = new InputStreamReader(is);
			    in = new BufferedReader(isr);
				String line;
				System.out.println("Read raw message from file...");
				while ((line = in.readLine()) != null) {
					System.out.println(line);
					String[] params = line.split(",");
					if (params.length == 3) {
						Message message = new Message(params[0],
								Double.valueOf(params[1]),
								Double.valueOf(params[2]));
						messages.add(message);
					} else if (params.length == 4) {
						Message message = new Message(params[0],
								Double.valueOf(params[1]),
								Double.valueOf(params[2]));
						if (params[3].equalsIgnoreCase(Message.OPERATION_ADD)) {
							message.setOperation(Message.OPERATION_ADD);
						} else if (params[3]
								.equalsIgnoreCase(Message.OPERATION_SUBTRACT)) {
							message.setOperation(Message.OPERATION_SUBTRACT);
						} else if (params[3]
								.equalsIgnoreCase(Message.OPERATION_MULTIPLY)) {
							message.setOperation(Message.OPERATION_MULTIPLY);
						}

						messages.add(message);
					} else {
						System.out.println("Invalid params." + line);
					}
				}

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					is.close();
					isr.close();
					in.close();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
	}

	/**
	 * Read message from Adapter & Make one raw copy of the message
	 * @return
	 */
	public Message readMessage() {
		Message message = null;
		if (messages != null) {
			if (!messages.isEmpty()) {
				message = messages.remove(0);
			}
		}
		System.err.println(this.getClass().getSimpleName()+": "+message.toString());
		return message;
	}

	/**
	 * 
	 * @return
	 */
	public static CSVTypeMessageProcessAdapter getInstance() {
		return new CSVTypeMessageProcessAdapter();
	}

	
}
