package org.isf.hl7.handler;

import org.isf.generaldata.MessageBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.app.Application;
import ca.uhn.hl7v2.app.ApplicationException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v231.message.ACK;

/**
 * Parses ACK messages
 */
public class ACKHandler implements Application {

	private static final Logger LOGGER = LoggerFactory.getLogger(ACKHandler.class);

	@Override
	public Message processMessage(Message message) throws ApplicationException, HL7Exception {
		if (!(message instanceof ACK)) {
			throw new ApplicationException(MessageBundle.getMessage("ACK.error.invalidMessage"));
		}

		LOGGER.debug("Processing ACK message");
		Message response;
		try {
			ACK ack = (ACK) message;
			response = processACK(ack);
		} catch (ClassCastException classCastException) {
			LOGGER.warn("Error casting {} to ACK", message.getClass().getName(), classCastException);
			throw new ApplicationException(MessageBundle.formatMessage("ACK.error.invalidMessageType",
					message.getClass().getName()), classCastException);
		} catch (HL7Exception hl7Exception) {
			LOGGER.warn("Error while processing ACK message", hl7Exception);
			throw new ApplicationException(MessageBundle.getMessage("ACK.error.WhileProcessing"), hl7Exception);
		}
		LOGGER.debug("Finished processing ACK message");
		return response;
	}

	/**
	 * Bulk of the processing done here. Called by the main processMessage method
	 *
	 * @param ack the message to process
	 * @return the processed message
	 * @throws HL7Exception
	 */
	private Message processACK(ACK ack) throws HL7Exception {
		return null;
	}

	@Override
	public boolean canProcess(Message message) {
		return message != null && "ACK".equals(message.getName());
	}

}
