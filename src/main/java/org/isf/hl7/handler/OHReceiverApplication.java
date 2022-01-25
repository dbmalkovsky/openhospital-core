package org.isf.hl7.handler;

import java.io.IOException;
import java.util.Map;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.protocol.ReceivingApplication;

public class OHReceiverApplication implements ReceivingApplication<Message> {

	/**
	 * {@inheritDoc}
	 */
	public boolean canProcess(Message theIn) {
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	public Message processMessage(Message theMessage, Map<String, Object> theMetadata) throws HL7Exception {

		String encodedMessage = new DefaultHapiContext().getPipeParser().encode(theMessage);
		System.out.println("Received message:\n" + encodedMessage + "\n\n");
		// Now generate a simple acknowledgment message and return it
		try {
			return theMessage.generateACK();
		} catch (IOException ioException) {
			throw new HL7Exception(ioException);
		}
	}

}
