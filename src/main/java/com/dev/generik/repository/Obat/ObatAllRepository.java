package com.dev.generik.repository.Obat;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.dev.generik.entities.Obat.ObatAll;

public interface ObatAllRepository extends JpaRepository<ObatAll, String> {
	
	//@Query(value = "CALL wsLabHasilBatas_SP", nativeQuery = true)
	@Query(value = "EXEC ObatPxALL_SP:daftarID", nativeQuery = true)
	List<ObatAll> findByIdreg(@Param("daftarID") Long daftarID);
}