package com.dev.generik.repository.JadwalDokter;

//import java.sql.Date;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.JadwalDokter.JadwalDokterPrakV2;

public interface JadwalDokterPrakV2Repository extends JpaRepository<JadwalDokterPrakV2, Long> {
	List<JadwalDokterPrakV2> findByDrAndHr(Long dr, Long hr);
	Optional<JadwalDokterPrakV2> findByDrAndPrakAndDateAndStatus (Long dr, Long jampraktek, Date tgl, Long status);

}
