package com.dev.generik.repository.ERM.Billing;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dev.generik.entities.ERM.Billing.RekKamarBPJS;


public interface RekKamarBPJSRepository extends JpaRepository<RekKamarBPJS, Long>{
	List<RekKamarBPJS> findByid(Long id);
}
