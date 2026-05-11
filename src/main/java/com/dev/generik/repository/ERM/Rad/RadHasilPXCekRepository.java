package com.dev.generik.repository.ERM.Rad;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dev.generik.entities.ERM.Rad.RadHasilPXCek;

public interface RadHasilPXCekRepository extends JpaRepository<RadHasilPXCek, Long> {
	List<RadHasilPXCek> findByidrad(Long idrad);
}
