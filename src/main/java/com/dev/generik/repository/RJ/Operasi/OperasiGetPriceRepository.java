package com.dev.generik.repository.RJ.Operasi;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.dev.generik.entities.RJ.Operasi.Operasi;

public interface OperasiGetPriceRepository extends JpaRepository<Operasi, Long> {
	@Query(value = "EXEC cboJenisOp_SP", nativeQuery = true)
	List<Operasi> findAllAktif();  // Gunakan penamaan sesuai konvensi
}
