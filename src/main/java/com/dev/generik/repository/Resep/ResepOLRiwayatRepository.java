package com.dev.generik.repository.Resep;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.dev.generik.entities.ERM.Resep.ResepOLRiwayat;

public interface ResepOLRiwayatRepository extends JpaRepository<ResepOLRiwayat, Long> {
	
	//List<ResepOLRiwayat>findByIdReg(Long idReg);
	//List<ResepOLRiwayat>findByRm(String rm);
	@Query(value = "EXEC wsResepOLWSRiwayat_SP:rm", nativeQuery = true)
	List<ResepOLRiwayat> findByRm(@Param("rm") String rm);
}
