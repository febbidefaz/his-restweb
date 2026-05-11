package com.dev.generik.repository.RM;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dev.generik.entities.RM.ListRJ;

public interface ListRJRepository extends JpaRepository<ListRJ, Long>{
	List<ListRJ> findTop10ByOrderByIdDesc();

}
