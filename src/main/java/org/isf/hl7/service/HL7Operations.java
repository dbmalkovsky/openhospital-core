package org.isf.hl7.service;

import org.isf.utils.db.TranslateOHServiceException;
import org.isf.utils.exception.OHServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor= OHServiceException.class)
@TranslateOHServiceException
public class HL7Operations {

	@Autowired
	private Hl7IoOperationRepository hl7IoOperationRepository;

	public HL7Operations() {

	}
}
