package com.example.wastemanagerapi.dto;

import lombok.NoArgsConstructor;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WasteCenterAuthorizationDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String authorizationNumber;
	private Long wasteManagerId;
}
