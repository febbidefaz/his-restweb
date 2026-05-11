package com.dev.generik.repository.ERM.Rad;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.ERM.Rad.RadHasilPX;

public interface RadHasilPXRepository extends JpaRepository<RadHasilPX, String> {
	List<RadHasilPX> findByidrad(Long idrad);
}
