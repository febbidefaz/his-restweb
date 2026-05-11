package com.dev.generik.repository.Resep;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dev.generik.entities.ERM.Resep.ResepOLTemplate;

public interface ResepOLTemplateRepository extends JpaRepository<ResepOLTemplate, Long> {

	List<ResepOLTemplate>findByIdDokter(Long idDokter);
}

