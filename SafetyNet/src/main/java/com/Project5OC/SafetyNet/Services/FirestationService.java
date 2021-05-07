package com.Project5OC.SafetyNet.Services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project5OC.SafetyNet.DTO.FirestationDTO;
import com.Project5OC.SafetyNet.DTO.FirestationListDTO;
import com.Project5OC.SafetyNet.ObjectsMapper.IObjectToDtoImpl;
import com.Project5OC.SafetyNet.model.Firestation;
import com.Project5OC.SafetyNet.model.FirestationsList;

@Service
public class FirestationService {

	Logger logger = LoggerFactory.getLogger(FirestationService.class);

	@Autowired
	private ReadJsonFile readObject;

	@Autowired
	private IObjectToDtoImpl iObjectToDtoImpl;

	private FirestationsList firestationsList;

	@PostConstruct
	private void init() {
		this.firestationsList = readObject.readFirestation();
	}

	public FirestationListDTO saveFirestation(FirestationDTO firestationDTO) {
		List<Firestation> listFirestation = new ArrayList<Firestation>();
		Firestation firestationObj = iObjectToDtoImpl.dtoToFirestation(firestationDTO);
		listFirestation = firestationsList.getFirestations();
		int result = 0;
		for (Firestation fire : listFirestation) {
			if (fire.getAddress().equals(firestationObj.getAddress())
					&& fire.getStation().equals(firestationObj.getStation())) {
				result = +1;
			}
		}
		if (result == 0) {
			listFirestation.add(firestationObj);
			logger.info("Firestation dos not exist, it was created");
		}
		FirestationsList firestationsListFinal = new FirestationsList(listFirestation);
		FirestationListDTO firestationListDTO = iObjectToDtoImpl.firestationListToDtoList(firestationsListFinal);
		logger.trace("FirestationListDTO was created");
		return firestationListDTO;
	}

	public FirestationListDTO updateFirestation(FirestationDTO firestationDTO) {
		List<Firestation> firestationList = new ArrayList<Firestation>();
		Firestation firestation = iObjectToDtoImpl.dtoToFirestation(firestationDTO);
		firestationList = firestationsList.getFirestations();
		;
		for (Firestation list : firestationList) {
			if ((list.getStation().equals(firestation.getStation())
					|| list.getAddress().equals(firestation.getAddress()))) {
				list.setAddress(firestation.getAddress());
				list.setStation(firestation.getStation());
				logger.info("Firestation exist, it was updated");

			}
		}
		FirestationsList firestationListF = new FirestationsList(firestationList);
		FirestationListDTO FireStaListDTO = iObjectToDtoImpl.firestationListToDtoList(firestationListF);
		logger.info("FireStaListDTO was updated");
		return FireStaListDTO;
	}

	public FirestationListDTO deleteFirestation(FirestationDTO firestationDTO) {
		Firestation firestationObj = iObjectToDtoImpl.dtoToFirestation(firestationDTO);
		List<Firestation> firestationList = new ArrayList<Firestation>();
		firestationList = firestationsList.getFirestations();
		for (Firestation firestation : firestationList) {
			if (firestation.getStation().equals(firestationObj.getStation())
					&& firestation.getAddress().equals(firestationObj.getAddress())) {
				firestationList.remove(firestation);
				logger.info("Firestation was deleted");
			}
		}
		FirestationsList firestationListF = new FirestationsList(firestationList);
		FirestationListDTO FireStaListDTO = iObjectToDtoImpl.firestationListToDtoList(firestationListF);
		logger.info("FireStaListDTO was update");
		return FireStaListDTO;
	}

}
