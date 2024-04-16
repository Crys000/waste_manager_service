package com.example.wastemanagerapi.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="Waste_Manager")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WasteManagerEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nombre;
	private String nif;
	private Long wasteManagerAddressId;
	@OneToMany(mappedBy = "wasteManager", cascade = CascadeType.ALL)
	private List<WasteCenterAuthorizationEntity> listOfWasteCenterAuthorization = new ArrayList<>();
	private Boolean isEnabled = Boolean.TRUE;
	private Long version = 0L;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	private Date createdDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedDate;

	@PrePersist
	protected void onCreate() {
		this.createdDate = (this.createdDate == null) ? new Date() : this.createdDate;
		this.lastModifiedDate = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.lastModifiedDate = new Date();
	}

}
