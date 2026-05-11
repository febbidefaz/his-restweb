package com.dev.generik.repository.Lab;

/*import java.util.Date;
import java.util.List;
import java.util.Optional; */

//import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
/*import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param; */

import com.dev.generik.entities.Lab.PCRExternalView;

public interface PCREkternalViewRepository extends JpaRepository<PCRExternalView, Long> {

	// Optional<PCRExternal>
	// findByDokteridAndTglAndRegisterAndJampraktekAndSublayanan(long dokterid,Date
	// tgl,String register,long jamprak, String sublayanan);
//	Optional<List<PCRRekanan>> findById(Long id);
//	Optional<List<PCRRekanan>> findByIdAndNama(Long id, String nama);
//	Optional<List<PCRExternal>> findById(Long id);
}
