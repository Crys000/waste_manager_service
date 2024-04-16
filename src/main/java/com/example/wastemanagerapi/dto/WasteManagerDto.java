package com.example.wastemanagerapi.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WasteManagerDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nombre;
	private String nif;
	private WasteManagerAddressDto wasteManagerAddressDto;
	private List<WasteCenterAuthorizationDto> listOfWasteCenterAuthorization;
	private Boolean isEnabled;
}
