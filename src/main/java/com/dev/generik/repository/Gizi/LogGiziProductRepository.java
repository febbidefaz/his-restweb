package com.dev.generik.repository.Gizi;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dev.generik.entities.Gizi.LogGiziProduct;

public interface LogGiziProductRepository extends JpaRepository<LogGiziProduct, String> {
	
}
