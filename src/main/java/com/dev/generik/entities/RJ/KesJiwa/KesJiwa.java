package com.dev.generik.entities.RJ.KesJiwa;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "SrtKetKesJiwa")
public class KesJiwa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idReg;
    private String no;
    private String nama;

    @Column(name = "Tanggal_Lahir")
    private LocalDateTime tanggalLahir;

    @Column(name = "Jenis_Kelamin")
    private String jenisKelamin;

    private String addr;
    private String kelurahan;
    private String pendidikan;
    private String pekerjaan;

    private Long psikopatologi;
    private Long kepribadian;
    private String kecerdasan;
    private String fungsiEksekutif;
    private Long tambahan;
    private String keperluan;
    private Boolean tampil;
   
}

