package com.Project5OC.SafetyNet.Services;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project5OC.SafetyNet.DTO.MedicalRecordsDTO;
import com.Project5OC.SafetyNet.DTO.MedicalRecordsListDTO;
import com.Project5OC.SafetyNet.ObjectsMapper.IObjectToDtoImpl;
import com.Project5OC.SafetyNet.model.MedicalRecords;
import com.Project5OC.SafetyNet.model.MedicalRecordsList;

@Service
public class MedicalRecordsService {

	Logger logger = LoggerFactory.getLogger(MedicalRecordsService.class);

	@Autowired
	private ReadJsonFile readObject;

	@Autowired
	private IObjectToDtoImpl iObjectToDtoImpl;

	private MedicalRecordsList medicalRecordsList;

	@PostConstruct
	private void init() {
		this.medicalRecordsList = readObject.readMedical();
	}

	public MedicalRecordsListDTO saveMedical(MedicalRecordsDTO medicalRecordsDTO) {
		MedicalRecords medicalRecordsObj = iObjectToDtoImpl.dtoToMedicalRecords(medicalRecordsDTO);
		List<MedicalRecords> medicalList = medicalRecordsList.getMedicalRecords();
		int result = 0;
		for (MedicalRecords medical : medicalList) {
			if (medical.getBirthdate().equals(medicalRecordsDTO.getBirthdate())) {
				result = +1;
			}
		}
		if (result == 0) {
			medicalList.add(medicalRecordsObj);
			logger.info("Medicalrecords dos not exist, it was created");
		}
		MedicalRecordsList medicalRecordsList = new MedicalRecordsList(medicalList);
		MedicalRecordsListDTO medicalRecordsListDTO = iObjectToDtoImpl.medicalRecordsListToDtoList(medicalRecordsList);
		logger.trace("MedicalRecordsListDTO was created");

		return medicalRecordsListDTO;
	}

	public MedicalRecordsListDTO updateMedical(MedicalRecordsDTO medicalRecordsDTO) {
		MedicalRecords medicalRecordsObj = iObjectToDtoImpl.dtoToMedicalRecords(medicalRecordsDTO);
		List<MedicalRecords> medicalList = medicalRecordsList.getMedicalRecords();
		for (MedicalRecords medicalRecords : medicalList) {
			if ((medicalRecords.getFirstName().equals(medicalRecordsObj.getFirstName())
					&& medicalRecords.getLastName().equals(medicalRecordsObj.getLastName()))) {
				medicalRecords.setFirstName(medicalRecordsObj.getFirstName());
				medicalRecords.setLastName(medicalRecordsObj.getLastName());
				medicalRecords.setBirthdate(medicalRecordsObj.getBirthdate());
				medicalRecords.setMedications(medicalRecordsObj.getMedications());
				medicalRecords.setAllergies(medicalRecordsObj.getAllergies());
				logger.info("medicalRecords exist, it was updated");

			}
		}
		MedicalRecordsList medicalRecordsList = new MedicalRecordsList(medicalList);
		MedicalRecordsListDTO medicalRecordsListDTO = iObjectToDtoImpl.medicalRecordsListToDtoList(medicalRecordsList);

		logger.info("MedicalRecordsListDTO was updated");

		return medicalRecordsListDTO;
	}

	public MedicalRecordsListDTO deleteMedical(MedicalRecordsDTO medicalRecordsDTO) {
		MedicalRecords medicalRecordsObj = iObjectToDtoImpl.dtoToMedicalRecords(medicalRecordsDTO);
		List<MedicalRecords> medicalList = medicalRecordsList.getMedicalRecords();
		for (MedicalRecords medicalRecords : medicalList) {
			if ((medicalRecords.getFirstName().equals(medicalRecordsObj.getFirstName())
					&& medicalRecords.getLastName().equals(medicalRecordsObj.getLastName()))) {
				medicalList.remove(medicalRecords);
				logger.info("medicalRecords was deleted");

			}
		}
		MedicalRecordsList medicalRecordsList = new MedicalRecordsList(medicalList);
		MedicalRecordsListDTO medicalRecordsListDTO = iObjectToDtoImpl.medicalRecordsListToDtoList(medicalRecordsList);
		logger.info("MedicalRecordsListDTO was updated");

		return medicalRecordsListDTO;
	}

}
