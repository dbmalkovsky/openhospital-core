package org.isf.hl7.handler;

import org.isf.generaldata.MessageBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.app.Application;
import ca.uhn.hl7v2.app.ApplicationException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v231.message.ORU_R01;

/**
 * Parses ORU^R01 messages
 */
public class ORUR01Handler implements Application {

	private static final Logger LOGGER = LoggerFactory.getLogger(ORUR01Handler.class);

	@Override
	public Message processMessage(Message message) throws ApplicationException, HL7Exception {
		if (!(message instanceof ORU_R01)) {
			throw new ApplicationException(MessageBundle.getMessage("ORUR01.error.invalidMessage"));
		}

		LOGGER.debug("Processing ORU_R01 message");
		Message response;
		try {
			ORU_R01 oru = (ORU_R01) message;
			response = processORU_R01(oru);
		} catch (ClassCastException classCastException) {
			LOGGER.warn("Error casting {} to ORU_R01", message.getClass().getName(), classCastException);
			throw new ApplicationException(MessageBundle.formatMessage("ORUR01.error.invalidMessageType",
					message.getClass().getName()), classCastException);
		} catch (HL7Exception hl7Exception) {
			LOGGER.warn("Error while processing ORU_R01 message", hl7Exception);
			throw new ApplicationException(MessageBundle.getMessage("ORUR01.error.whileProcessing"), hl7Exception);
		}
		LOGGER.debug("Finished processing ORU_R01 message");
		return response;
	}

	/**
	 * Bulk of the processing done here. Called by the main processMessage method
	 *
	 * @param oruR01 the message to process
	 * @return the processed message
	 * @throws HL7Exception
	 */
	private Message processORU_R01(ORU_R01 oruR01) throws HL7Exception {
		return null;
	}

	@Override
	public boolean canProcess(Message message) {
		return message != null && "ORU_R01".equals(message.getName());
	}

}
