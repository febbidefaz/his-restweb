package com.dev.generik.repository.Rad;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.ERM.Rad.RadiologiBaca;

public interface RadiologiBacaRepository extends JpaRepository<RadiologiBaca, Long> {
//	List<RadiologiBacaPeriksa> findIdrad(Long idrad);
	List<RadiologiBaca> findByIddokter(Long iddokter);

}
