package com.dev.generik.repository.Rad;

//import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.dev.generik.entities.ERM.Rad.Radiologi;

public interface RadiologiRepository extends JpaRepository<Radiologi, Long> {
	@Procedure(name = "UpdateRadiologi")
	void updateRadiologi(@Param("id") Long id, @Param("normlv") String normlv, @Param("kesimpulan") String kesimpulan);

	@Query("Select r from Radiologi r where r.periksa LIKE %?1%")
	public Optional<Radiologi> findAll(String periksa);
	
	public Optional<Radiologi> findById(Long idrad);
	
	public Optional<Radiologi> findByPeriksa(String periksa);
	
	public Optional<Radiologi> findByPeriksaLike(String periksa);
	@Query("Select r from Radiologi r where r.periksa LIKE %:periksa%")
	public Optional<Radiologi> searchByPeriksaLike(@Param("periksa") String periksa);

}