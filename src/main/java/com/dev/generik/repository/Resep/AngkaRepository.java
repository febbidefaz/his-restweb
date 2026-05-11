package com.dev.generik.repository.Resep;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dev.generik.entities.ERM.Resep.Angka;

public interface AngkaRepository extends JpaRepository<Angka, Long> {
    List<Angka> findTop20ByOrderByBilanganAsc();
    @Query(value = "SELECT * FROM ANGKA WHERE CAST(BILANGAN AS VARCHAR) LIKE %:keyword% ORDER BY BILANGAN ASC", nativeQuery = true)
    List<Angka> searchByBilanganLike(@Param("keyword") String keyword);

}