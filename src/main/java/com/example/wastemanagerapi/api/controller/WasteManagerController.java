package com.example.wastemanagerapi.api.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.wastemanagerapi.dto.WasteManagerAddressDto;
import com.example.wastemanagerapi.dto.WasteManagerCreationDto;
import com.example.wastemanagerapi.dto.WasteManagerDto;
import com.example.wastemanagerapi.entity.WasteManagerEntity;
import com.example.wastemanagerapi.service.WasteManagerService;

@RestController
@RequestMapping("/waste-managers")
public class WasteManagerController {

	@Autowired
	private WasteManagerService wasteManagerService;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/{wasteManagerId}")
	public ResponseEntity<?> findWasteManagerById(@PathVariable long wasteManagerId) {
		try {
			WasteManagerEntity wasteManagerEntity = wasteManagerService.findById(wasteManagerId);

			if (wasteManagerEntity != null) {
				WasteManagerAddressDto address = restTemplate.getForObject(
						"http://WASTEMANAGERADDRESSAPI/" + wasteManagerEntity.getWasteManagerAddressId(),
						WasteManagerAddressDto.class);
				WasteManagerDto wasteManagerResponse = modelMapper.map(wasteManagerEntity, WasteManagerDto.class);
				wasteManagerResponse.setWasteManagerAddressDto(address);

				return ResponseEntity.ok(wasteManagerResponse);
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@PostMapping("/create")
	public ResponseEntity<?> createWasteManager(@RequestBody WasteManagerCreationDto wasteManagerCreationDto,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
		}

		try {
			WasteManagerEntity wasteManagerEntity = new WasteManagerEntity();
			wasteManagerEntity.setNombre(wasteManagerCreationDto.getNombre());
			wasteManagerEntity.setNif(wasteManagerCreationDto.getNif());
			wasteManagerEntity.setWasteManagerAddressId(wasteManagerCreationDto.getWasteManagerAddressId());
			wasteManagerEntity.setIsEnabled(wasteManagerCreationDto.getIsEnabled());
			wasteManagerService.create(wasteManagerEntity);

			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateWasteManager(@RequestBody WasteManagerCreationDto wasteManagerUpdateDto,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
		}

		try {
			WasteManagerEntity existingWasteManager = wasteManagerService.findById(wasteManagerUpdateDto.getId());
			if (existingWasteManager == null) {
				return ResponseEntity.notFound().build();
			}
			existingWasteManager.setNombre(wasteManagerUpdateDto.getNombre());
			existingWasteManager.setNif(wasteManagerUpdateDto.getNif());
			existingWasteManager.setWasteManagerAddressId(wasteManagerUpdateDto.getWasteManagerAddressId());
			existingWasteManager.setIsEnabled(wasteManagerUpdateDto.getIsEnabled());
			wasteManagerService.update(existingWasteManager);

			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

}
