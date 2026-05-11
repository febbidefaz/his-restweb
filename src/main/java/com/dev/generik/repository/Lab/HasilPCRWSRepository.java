package com.dev.generik.repository.Lab;

import java.util.List;
import java.util.Optional;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.Lab.HasilPCRWS;

public interface HasilPCRWSRepository extends JpaRepository<HasilPCRWS, Long> {
//	List<Lab> findByid(Long id);
	Optional<List<HasilPCRWS>> findByIdAndRmAndTgl(Long idreg, String rm, Date tgl);

}
