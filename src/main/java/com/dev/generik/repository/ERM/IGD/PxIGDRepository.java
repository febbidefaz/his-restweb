package com.dev.generik.repository.ERM.IGD;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dev.generik.entities.ERM.IGD.PxIGD;

public interface PxIGDRepository extends JpaRepository<PxIGD, Long> {
	List<PxIGD> findByPxId(Long pxid);
}
