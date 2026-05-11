package com.dev.generik.repository.Resep;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dev.generik.entities.ERM.Resep.ResepOLTemplateGet;

public interface ResepOLTemplateGetRepository extends JpaRepository<ResepOLTemplateGet, Long> {

	List<ResepOLTemplateGet>findByIdDokter(Long idDokter);
}

