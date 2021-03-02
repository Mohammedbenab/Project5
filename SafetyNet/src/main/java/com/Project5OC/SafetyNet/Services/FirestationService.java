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
import com.Project5OC.SafetyNet.mapper.IObjectToDto;
import com.Project5OC.SafetyNet.model.Firestation;
import com.Project5OC.SafetyNet.model.FirestationsList;

@Service
public class FirestationService {

	Logger logger = LoggerFactory.getLogger(FirestationService.class);

	@Autowired
	private ReadJsonFile readObject;

	private FirestationsList firestationsList;

	@PostConstruct
	private void init() {
		this.firestationsList = readObject.readFirestation();
	}

	public FirestationListDTO saveFirestation(FirestationDTO firestationDTO) {
		List<Firestation> listFirestation = new ArrayList<Firestation>();
		Firestation firestation = new Firestation();
		firestation = IObjectToDto.INSTANCE.dtoToFirestation(firestationDTO);
		listFirestation = firestationsList.getFirestations();
		listFirestation.add(firestation);

//		for (Firestation firestationInList : listFirestation) {
//			if (!firestationInList.getAddress().equals(firestation.getAddress())) {
//				listFirestation.add(firestation);
//				logger.info("Firestation dos not exist, it was created");
//			}
//		}
		FirestationsList firestationsListFinal = new FirestationsList(listFirestation);
		FirestationListDTO firestationListDTO = IObjectToDto.INSTANCE.firestationListToDtoList(firestationsListFinal);
		logger.trace("FirestationListDTO was created");
		return firestationListDTO;
	}

	public FirestationListDTO updateFirestation(FirestationDTO firestationDTO) {
		List<Firestation> firestationList = new ArrayList<Firestation>();
		Firestation firestation = IObjectToDto.INSTANCE.dtoToFirestation(firestationDTO);
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
		FirestationListDTO FireStaListDTO = IObjectToDto.INSTANCE.firestationListToDtoList(firestationListF);
		logger.info("FireStaListDTO was updated");
		return FireStaListDTO;
	}

	public FirestationListDTO deleteFirestation(FirestationDTO firestationDTO) {
		List<Firestation> firestationList = new ArrayList<Firestation>();
		Firestation firestationObj = IObjectToDto.INSTANCE.dtoToFirestation(firestationDTO);
		firestationList = firestationsList.getFirestations();
		for (Firestation firestation : firestationList) {
			if ((firestation.getStation().equals(firestationObj.getStation())
					|| firestation.getAddress().equals(firestationObj.getAddress()))) {
				firestationList.remove(firestation);
				logger.info("Firestation was deleted");
			}
		}
		FirestationsList firestationListF = new FirestationsList(firestationList);
		FirestationListDTO FireStaListDTO = IObjectToDto.INSTANCE.firestationListToDtoList(firestationListF);
		logger.info("FireStaListDTO was updated");
		return FireStaListDTO;
	}

}
