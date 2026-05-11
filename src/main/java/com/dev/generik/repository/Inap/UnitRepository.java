package com.dev.generik.repository.Inap;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.Inap.Unit;

public interface UnitRepository extends JpaRepository<Unit, Long> {
	List<Unit> findBypelayanan(Long pelayanan);
}
