package com.dev.generik.repository.RJ.Tindakan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.dev.generik.entities.RJ.Tindakan.TindakanGetPrice;

public interface TindakanGetPriceRepository extends JpaRepository<TindakanGetPrice, Long> {
	@Query(value = "EXEC GetPrice_Tindakan_SP:idReg, :tindakId", nativeQuery = true)
	Double getPriceTindakan(
	        @Param("idReg") int idReg,
	        @Param("tindakId") int tindakId
	    );
//	List<Tindakan> findAllAktif(); 
//	List<Tindakan> findByJp(Long jp);

}
