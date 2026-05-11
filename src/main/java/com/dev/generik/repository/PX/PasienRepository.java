package com.dev.generik.repository.PX;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generik.entities.PX.Pasien;

public interface PasienRepository extends JpaRepository<Pasien, String> {

}
