package com.self.patient_service.dto;

import com.self.patient_service.dto.validators.CreatePatientValidationGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientRequestDTO {
    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name cannot exceed 100 character")
    private String name;

    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Address is required")
    private String address;

    @NotBlank(message = "Date of birth cis required")
    private String dateOfBirth;

    @NotNull(groups = CreatePatientValidationGroup.class, message = "Registered date is required")
    private String registeredDate;
}
