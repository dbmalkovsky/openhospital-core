/**
 * 
 */
package org.isf.examination.service;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.isf.examination.model.PatientExamination;
import org.isf.utils.db.TranslateOHServiceException;
import org.isf.utils.exception.OHServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Mwithi
 * 
 */
@Service
@Transactional(rollbackFor=OHServiceException.class)
@TranslateOHServiceException
public class ExaminationOperations {

	@Autowired
	private ExaminationIoOperationRepository repository;
	
	public ExaminationOperations() {
	}

	/**
	 * Get from last PatientExamination (only height, weight & note)
	 */
	public PatientExamination getFromLastPatientExamination(
			PatientExamination lastPatientExamination)
	{
		PatientExamination newPatientExamination = new PatientExamination(new GregorianCalendar(),
				lastPatientExamination.getPatient(),
				lastPatientExamination.getPex_height(),
				lastPatientExamination.getPex_weight(),
				lastPatientExamination.getPex_ap_min(),
				lastPatientExamination.getPex_ap_max(),
				lastPatientExamination.getPex_hr(),
				lastPatientExamination.getPex_temp(),
				lastPatientExamination.getPex_sat(),
				lastPatientExamination.getPex_hgt(),
				lastPatientExamination.getPex_diuresis(),
				lastPatientExamination.getPex_diuresis_desc(),
				lastPatientExamination.getPex_bowel_desc(),
				lastPatientExamination.getPex_rr(),
				lastPatientExamination.getPex_auscultation(),
				lastPatientExamination.getPex_note());
		return newPatientExamination;
	}

	/**
	 * 
	 * @param patex
	 *            - the PatientExamination to save
	 * @throws OHServiceException
	 */
	public void saveOrUpdate(PatientExamination patex) throws OHServiceException {
		repository.save(patex);
	}

	public PatientExamination getByID(int ID) throws OHServiceException {
		return repository.getOne(ID);
	}

	public PatientExamination getLastByPatID(int patID) throws OHServiceException	{
		ArrayList<PatientExamination> patExamination = getByPatID(patID);
		return !patExamination.isEmpty() ? patExamination.get(0) : null;
	}

	public ArrayList<PatientExamination> getLastNByPatID(int patID, int number) throws OHServiceException {
		return new ArrayList<PatientExamination>(repository
				.findByPatient_CodeOrderByPexDateDesc(patID, PageRequest.of(0, number)).getContent());
	}

	public ArrayList<PatientExamination> getByPatID(int patID) throws OHServiceException	{
		return (ArrayList<PatientExamination>)repository.findByPatient_CodeOrderByPexDateDesc(patID);
	}

	public void remove(ArrayList<PatientExamination> patexList) throws OHServiceException {
		repository.deleteAll(patexList);
	}
}
