package com.dev.generik.entities.HaloRSA;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@Entity
@Getter 
@Setter
@Table(name = "WSREGNEWOLT")

public class RegNewOLT implements Serializable {

	private static final long serialVersionUID = -4031144012940015082L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "USERID")
	@NonNull
	private String userid;

	@Column(name = "SUBLAYANAN")
	@NonNull
	private String sublayanan;

	@Column(name = "LAYANAN")
	@NonNull
	private String layanan;

	@Column(name = "TGL")
	@Temporal(TemporalType.DATE)
	@NonNull
	private Date tgl;

	@Column(name = "JAM_PRAKTEK")
	@NonNull
	private Long jampraktek;

	@Column(name = "REGISTER")
	@NonNull
	private String register;

	@Column(name = "DOKTERID")
	@NonNull
	private Long dokterid;

	@Column(name = "KTP")
	@Nullable
	private String ktp;

	@Column(name = "BUKTITRANSFER")
	@Nullable
	private String buktitransfer;

	@Column(name = "STATUS")
//	@Nullable
	private Long status;

	@Column(name = "NORUJUKAN")
	@Nullable
	private String norujukan;

	@Column(name = "Upx")
//	@Nullable
	private Long upx;

	@Column(name = "Idol")
//	@Nullable
	private Long idol;

	@Column(name = "Pxno")
	private Long pxno;

	@Temporal(TemporalType.TIME)
	@Column(name = "JAwal")
	private Date jawal;

	@Temporal(TemporalType.TIME)
	@Column(name = "JAkhir")
	private Date jakhir;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "Estimasi")
	private Date estimasi;

}
