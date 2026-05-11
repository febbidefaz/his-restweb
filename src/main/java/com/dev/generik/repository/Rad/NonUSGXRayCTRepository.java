package com.dev.generik.repository.Rad;

import java.util.Optional;

//import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.dev.generik.entities.HaloRSA.NonUSGXRayCT;

import jakarta.persistence.IdClass;
import jakarta.transaction.Transactional;

public interface NonUSGXRayCTRepository extends JpaRepository<NonUSGXRayCT,IdClass> {
	@Procedure(name = "UpdateNonUSGXRayCT")
	void updateNonUSGXRayCT(@Param("idrad") Long idrad, @Param("jenisid") Long jenisid, @Param("result") String result,
			@Param("kesimpulan") String kesimpulan);

	@Transactional
	@Modifying
	void deleteByIdradAndJenisid(@Param("idrad") Long idrad, @Param("jenisid") Long jenisid);

	public Optional<NonUSGXRayCT> findByIdradAndJenisid(Long idrad, Long jenisid);
	public Optional<NonUSGXRayCT> findByIdrad(Long idrad);
}