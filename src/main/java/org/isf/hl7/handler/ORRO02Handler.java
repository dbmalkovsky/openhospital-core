package org.isf.hl7.handler;

import org.isf.generaldata.MessageBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.app.Application;
import ca.uhn.hl7v2.app.ApplicationException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v231.message.ORR_O02;

/**
 * Parses ORR^O02 messages
 */
public class ORRO02Handler implements Application {

	private static final Logger LOGGER = LoggerFactory.getLogger(ORRO02Handler.class);

	@Override
	public Message processMessage(Message message) throws ApplicationException, HL7Exception {
		if (!(message instanceof ORR_O02)) {
			throw new ApplicationException(MessageBundle.getMessage("ORRO02.error.invalidMessage"));
		}

		LOGGER.debug("Processing ORR_O02 message");
		Message response;
		try {
			ORR_O02 orrO02 = (ORR_O02) message;
			response = processORR_O02(orrO02);
		} catch (ClassCastException classCastException) {
			LOGGER.warn("Error casting {} to ORR_O02", message.getClass().getName(), classCastException);
			throw new ApplicationException(MessageBundle.formatMessage("ORRO02.error.invalidMessageType",
					message.getClass().getName()), classCastException);
		} catch (HL7Exception hl7Exception) {
			LOGGER.warn("Error while processing ORR_O02 message", hl7Exception);
			throw new ApplicationException(MessageBundle.getMessage("ORRO02.error.whileProcessing"), hl7Exception);
		}
		LOGGER.debug("Finished processing ORR_O02 message");
		return response;
	}

	/**
	 * Bulk of the processing done here. Called by the main processMessage method
	 *
	 * @param orrO02 the message to process
	 * @return the processed message
	 * @throws HL7Exception
	 */
	private Message processORR_O02(ORR_O02 orrO02) throws HL7Exception {
		return null;
	}

	@Override
	public boolean canProcess(Message message) {
		return message != null && "ORR_O02".equals(message.getName());
	}

}
