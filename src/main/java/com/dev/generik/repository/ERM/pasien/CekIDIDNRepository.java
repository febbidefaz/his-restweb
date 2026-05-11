package com.dev.generik.repository.ERM.pasien;

//import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.ERM.Pasien.CekIDIDN;

public interface CekIDIDNRepository extends JpaRepository<CekIDIDN, Long> {
//	Optional<CekIDIDN> findById(String id);
}
