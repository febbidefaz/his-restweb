package com.dev.generik.repository.RJ.NoUrut;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.RJ.ListPxRJNow;

public interface ListPXRJNoUrutRepository extends JpaRepository<ListPxRJNow, String> {
	List<ListPxRJNow> findByJp(Long jp);

}
