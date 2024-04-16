package com.example.wastemanagerapi.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WasteManagerCreationDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nombre;
	private String nif;
	private Long wasteManagerAddressId;
	private List<WasteCenterAuthorizationDto> listOfWasteCenterAuthorization;
	private Boolean isEnabled;
}
