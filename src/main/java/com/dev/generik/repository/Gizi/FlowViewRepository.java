package com.dev.generik.repository.Gizi;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dev.generik.entities.Gizi.FlowView;

public interface FlowViewRepository extends JpaRepository<FlowView, Long> {
	Page<FlowView> findAll(Pageable pageable);
}
