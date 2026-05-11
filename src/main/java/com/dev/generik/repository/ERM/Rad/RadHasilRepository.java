package com.dev.generik.repository.ERM.Rad;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.ERM.Rad.RadHasil;

public interface RadHasilRepository extends JpaRepository<RadHasil, String> {
	List<RadHasil> findByidrad(Long idrad);
}
