package com.dev.generik.repository.RJ;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.RJ.ListPxRJNow;

public interface ListPXRJNowRepository extends JpaRepository<ListPxRJNow, String> {
	List<ListPxRJNow> findByJp(Long jp);

}
