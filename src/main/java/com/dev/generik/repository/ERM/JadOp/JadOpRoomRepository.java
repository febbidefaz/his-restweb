package com.dev.generik.repository.ERM.JadOp;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dev.generik.entities.ERM.JadOp.JadOpRoom;

public interface JadOpRoomRepository extends JpaRepository<JadOpRoom, Long> {
	
	List<JadOpRoom> findTop20ByOrderByNamaAsc();
	List<JadOpRoom> findByNamaContainingIgnoreCaseOrderByNamaAsc(String keyword);

}
