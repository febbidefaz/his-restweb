package com.dev.generik.repository.Gizi;


import org.springframework.data.jpa.repository.JpaRepository;
import com.dev.generik.entities.Gizi.FlowDetView;
import com.dev.generik.entities.Gizi.FlowDetViewClass;


public interface FlowDetViewRepository extends JpaRepository<FlowDetView, FlowDetViewClass> {

}
