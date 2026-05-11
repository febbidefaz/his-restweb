package com.dev.generik.repository.RJ.Tindakan;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dev.generik.entities.RJ.Tindakan.TindakanDokter;
//import com.dev.generik.entities.RJ.Tindakan.TindakanDokterId;

public interface TindakanDokterRepository extends JpaRepository<TindakanDokter, Long> {
//public interface TindakanDokterRepository extends JpaRepository<TindakanDokter, TindakanDokterId> {
	List<TindakanDokter> findByid(Long id); // filter by ID
//	@Query(value = "EXEC cboTindakan_SP", nativeQuery = true)
//	List<Tindakan> findAllAktif();  // Gunakan penamaan sesuai konvensi
//	List<Tindakan> FindAll();
	
//	List<Tindakan> findByJp(Long jp);

}
