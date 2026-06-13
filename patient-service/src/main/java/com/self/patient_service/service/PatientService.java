package com.self.patient_service.service;

import com.self.patient_service.dto.PatientRequestDTO;
import com.self.patient_service.dto.PatientResponseDTO;
import com.self.patient_service.exception.EmailAlreadyExistsException;
import com.self.patient_service.mapper.PatientMapper;
import com.self.patient_service.model.Patient;
import com.self.patient_service.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository){
        this.patientRepository=patientRepository;
    }

    public List<PatientResponseDTO> getPatient(){
        List<Patient> patients=patientRepository.findAll();

        List<PatientResponseDTO> patientResponseDTOs = patients.stream()
                .map(PatientMapper::toDTO).toList();

        return patientResponseDTOs;
    }

    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO){

        if(patientRepository.existsByEmail(patientRequestDTO.getEmail())){
            throw new EmailAlreadyExistsException("A patient with this email already exists "+patientRequestDTO.getEmail());
        }
        Patient newPatient= patientRepository.save(PatientMapper.toModel(patientRequestDTO));

        return PatientMapper.toDTO(newPatient);
    }
}
