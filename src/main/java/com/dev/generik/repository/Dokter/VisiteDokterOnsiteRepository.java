package com.dev.generik.repository.Dokter;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.Dokter.VisiteDokterOnsite;

public interface VisiteDokterOnsiteRepository extends JpaRepository<VisiteDokterOnsite, String> {
	List<VisiteDokterOnsite> findByPxIdAndKlasIdAndRoomId(Long pxid, Long klasid, Long roomid);
}
