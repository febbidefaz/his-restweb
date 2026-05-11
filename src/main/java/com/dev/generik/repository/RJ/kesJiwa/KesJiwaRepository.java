package com.dev.generik.repository.RJ.kesJiwa;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dev.generik.entities.RJ.KesJiwa.KesJiwa;

public interface KesJiwaRepository extends JpaRepository<KesJiwa, Long> {
	List<KesJiwa> findByIdReg(Long idReg);
	//List<ListPxRJNow> findByJp(Long jp);

}
