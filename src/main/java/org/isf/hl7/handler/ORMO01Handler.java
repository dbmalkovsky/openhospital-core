package org.isf.hl7.handler;

import org.isf.generaldata.MessageBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.app.Application;
import ca.uhn.hl7v2.app.ApplicationException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v231.message.ORM_O01;

/**
 * Parses ORM^O01 messages
 */
public class ORMO01Handler implements Application {

	private static final Logger LOGGER = LoggerFactory.getLogger(ORMO01Handler.class);

	@Override
	public Message processMessage(Message message) throws ApplicationException, HL7Exception {
		if (!(message instanceof ORM_O01)) {
			throw new ApplicationException(MessageBundle.getMessage("ORMO01.error.invalidMessage"));
		}

		LOGGER.debug("Processing ORM_O01 message");
		Message response;
		try {
			ORM_O01 ormO01 = (ORM_O01) message;
			response = processORM_O01(ormO01);
		} catch (ClassCastException classCastException) {
			LOGGER.warn("Error casting {} to ORM_O01", message.getClass().getName(), classCastException);
			throw new ApplicationException(MessageBundle.formatMessage("ORMO01.error.invalidMessageType",
					message.getClass().getName()), classCastException);
		} catch (HL7Exception hl7Exception) {
			LOGGER.warn("Error while processing ORU_R01 message", hl7Exception);
			throw new ApplicationException(MessageBundle.getMessage("ORMO01.error.whileProcessing"), hl7Exception);
		}
		LOGGER.debug("Finished processing ORM_O01 message");
		return response;
	}

	/**
	 * Bulk of the processing done here. Called by the main processMessage method
	 *
	 * @param ormO01 the message to process
	 * @return the processed message
	 * @throws HL7Exception
	 */
	private Message processORM_O01(ORM_O01 ormO01) throws HL7Exception {
		return null;
	}

	@Override
	public boolean canProcess(Message message) {
		return message != null && "ORM_O01".equals(message.getName());
	}

}
