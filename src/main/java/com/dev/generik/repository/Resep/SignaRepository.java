package com.dev.generik.repository.Resep;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dev.generik.entities.ERM.Resep.Signa;

public interface SignaRepository extends JpaRepository<Signa, Long> {
	
	//@Query(value = "CALL wsLabHasilBatas_SP", nativeQuery = true)
	@Query(value = "EXEC cboSigna_sp", nativeQuery = true)
	List<Signa> getAll();
}
