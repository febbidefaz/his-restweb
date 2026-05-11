package com.dev.generik.entities.ERM.IGD.SkriningHPPVK;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.NamedStoredProcedureQueries;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "RISIKOHPPADMISINPERSALINAN DETAILS")
@IdClass(ERMIGDVKHPPDetClass.class)
@Getter
@Setter
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "UpdateERMRisikoHPPAdmisiNPersalinanDet", procedureName = "UpdateERMRisikoHPPAdmisiNPersalinanDet_sp", parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "nama", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "ket", type = Boolean.class), 
			}) })
public class ERMIGDVKHPPDet {
	
	@Id
	private Long id;
	@Id
	private Long nama;
	private Long kel;
	private Boolean ket;


}
