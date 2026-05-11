package com.dev.generik.repository.RJ.Operasi;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dev.generik.entities.RJ.Operasi.TransaksiOperasi;

public interface TransaksiOperasiRepository extends JpaRepository<TransaksiOperasi, Long> {
	List<TransaksiOperasi> findById(Integer id); // filter by ID
}
