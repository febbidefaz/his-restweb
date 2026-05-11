package com.dev.generik.repository.ERM.Register;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dev.generik.entities.ERM.Register.RegisterKepRI;

public interface RegisterKepRIRepository extends JpaRepository<RegisterKepRI, Long> {
	Optional<RegisterKepRI> findById(Long id);
}
