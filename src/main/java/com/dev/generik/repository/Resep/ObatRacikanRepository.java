package com.dev.generik.repository.Resep;

//import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.data.repository.query.Param;

import com.dev.generik.entities.ERM.Resep.Obat;

public interface ObatRacikanRepository extends JpaRepository<Obat, String> {
	
	//@Query(value = "CALL wsLabHasilBatas_SP", nativeQuery = true)
//	@Query(value = "EXEC cboObatByNameRacikan_sp", nativeQuery = true)
//	List<Obat> getAll();
//	Optional<Obat> findByKode(String kode);
	@Query(value = "EXEC cboObatByNameRacikan_sp:kode", nativeQuery = true)
	//    Optional<Obat> findByKode(@Param("kode") String kode);
	//Optional<Obat> findByKodeAndRacikanTrue(@Param("kode") String kode);
	 Optional<Obat> findByKode(String kode);
}
