package com.dev.generik.repository.Obat;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dev.generik.entities.Obat.ObatUnion;
public interface ObatUnionRepository extends JpaRepository<ObatUnion, Long> {

	List<ObatUnion> findByIdReg(Long id);

}
