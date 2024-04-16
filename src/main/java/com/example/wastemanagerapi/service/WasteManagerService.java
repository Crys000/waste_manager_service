package com.example.wastemanagerapi.service;

import com.example.wastemanagerapi.entity.WasteManagerEntity;

public interface WasteManagerService {
	
	 void create(WasteManagerEntity wasteManager);
	 void update(WasteManagerEntity wasteManager);
	 WasteManagerEntity findById(Long id);
}
