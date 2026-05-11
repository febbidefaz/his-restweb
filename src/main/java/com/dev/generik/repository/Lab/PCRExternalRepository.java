package com.dev.generik.repository.Lab;

import java.util.Date;
import java.util.List;
import java.util.Optional;

//import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

import com.dev.generik.entities.Lab.PCRExternal;

public interface PCRExternalRepository extends JpaRepository<PCRExternal, Long> {
	@Procedure(name = "UpdatePCRExternal")
	void updatePCR(@Param("id") Long id, @Param("nama") String nama, @Param("alamat") String alamat,
			@Param("tgllahir") Date tgllahir, @Param("tgl") Date tgl, @Param("instansi") Long instansi,
			@Param("ktp") String ktp, @Param("hasil") String hasil, @Param("nik") String nik,
			@Param("pembayaran") Long pembayaran, @Param("bukti") String bukti);

	// Optional<PCRExternal>
	// findByDokteridAndTglAndRegisterAndJampraktekAndSublayanan(long dokterid,Date
	// tgl,String register,long jamprak, String sublayanan);
	Optional<List<PCRExternal>> findByIdAndTgllahir(Long id, Date tgllahir);

	Optional<List<PCRExternal>> findByIdAndNama(Long id, String nama);

//	List<PCRExternal> findByInstansi(Long instansi);
	Optional<PCRExternal> findById(Long id);

	Optional<List<PCRExternal>> findByInstansiAndTglBetween(Long instansi,
			@DateTimeFormat(pattern = "yyyy-MM-dd") Date bdate, @DateTimeFormat(pattern = "yyyy-MM-dd") Date edate);

//	List<PCRExternal> findById(Long id);
}
