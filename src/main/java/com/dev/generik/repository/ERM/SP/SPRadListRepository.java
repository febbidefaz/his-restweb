package com.dev.generik.repository.ERM.SP;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dev.generik.entities.ERM.SP.SPRadGet;

public interface SPRadListRepository extends JpaRepository<SPRadGet, Long> {
	
	List<SPRadGet> findByid(Long id);
	/*@Procedure(name = "UpdateSPLab")
	void updateSPLab(
			@Param("NO") Long no,
			@Param("ID") Long id, 
			@Param("IDDokter") Long IDDokter, 
			@Param("OK") Boolean ok,
			@Param("TGL") Date tgl, 
			@Param("Jam") Date jam, 
			@Param("HeDL") Boolean HEDL
			);*/

}