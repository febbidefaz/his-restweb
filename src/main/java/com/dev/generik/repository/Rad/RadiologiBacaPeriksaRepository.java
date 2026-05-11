package com.dev.generik.repository.Rad;

import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.Rad.RadiologiBacaPeriksa;

public interface RadiologiBacaPeriksaRepository extends JpaRepository<RadiologiBacaPeriksa, String> {

//	Optional<RadiologiBacaPeriksa> findByIdrad(Long idrad);
	List<RadiologiBacaPeriksa> findByIdrad(Long idrad);

}
