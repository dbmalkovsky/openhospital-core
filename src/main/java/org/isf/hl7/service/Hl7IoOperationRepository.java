package org.isf.hl7.service;

import org.isf.hl7.model.HL7;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Hl7IoOperationRepository extends JpaRepository<HL7, Integer> {

}
