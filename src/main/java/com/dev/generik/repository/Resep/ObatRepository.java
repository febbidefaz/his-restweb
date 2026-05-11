package com.dev.generik.repository.Resep;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dev.generik.entities.ERM.Resep.Obat;

public interface ObatRepository extends JpaRepository<Obat, String> {

	Optional<Obat> findByKode(String kode);
	Optional<Obat> findByKodeAndRacikan(String kode, Boolean racikan);
	List<Obat> findTop20ByOrderByNamaAsc();
	List<Obat> findByNamaContainingIgnoreCaseOrderByNamaAsc(String nama);
	List<Obat> findByGenerikContainingIgnoreCaseOrderByGenerikAsc(String generik);
	Optional<Obat> findByKodeIgnoreCase(String kode);

}
