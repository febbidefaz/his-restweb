package com.dev.generik.repository.RJ.Tindakan;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.dev.generik.entities.RJ.Tindakan.Tindakan;

public interface TindakanRepository extends JpaRepository<Tindakan, Long> {
	@Query(value = "EXEC cboTindakan_SP", nativeQuery = true)
//	List<Tindakan> findAllAktif();  // Gunakan penamaan sesuai konvensi
	List<Tindakan> findTop20();

}
