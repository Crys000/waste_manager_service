package com.example.wastemanagerapi.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="Waste_Center_Authorization")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WasteCenterAuthorizationEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String authorizationNumber;
	@ManyToOne
	@JoinColumn(name = "waste_manager_id", nullable = false)
	private WasteManagerEntity wasteManager;
}
