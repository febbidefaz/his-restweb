package com.dev.generik.repository.TB;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

import com.dev.generik.entities.TB.TB03;

public interface TB03Repository extends JpaRepository<TB03, Long> {
	@Procedure(name = "UpdateTB03")
	void updateTB03(@Param("id") String id, 
					@Param("idtb03") String idtb03,
			//		@Param("kdPasien") String kdPasien, 
			//		@Param("nik") Long nik,
			//		@Param("jenisKelamin") String jenisKelamin, 
			//		@Param("alamatLengkap") String alamatLengkap, 
					@Param("idPropinsiFaskes") String idPropinsiFaskes,
					@Param("kdKabupatenFaskes") String kdKabupatenFaskes, 
					@Param("idPropinsiPasien") String idPropinsiPasien, 
					@Param("kdKabupatenPasien") String kdKabupatenPasien,
					@Param("kdFasyankes") String kdFasyankes,
					@Param("kodeIcdX") String kodeIcdX,
					@Param("tipeDiagnosa") Long tipeDiagnosa,
					@Param("klasifikasiLokasiAnatomi") Long klasifikasiLokasiAnatomi,
					@Param("klasifikasiRiwayatPengobatan") Long klasifikasiRiwayatPengobatan,
					@Param("tanggalMulaiPengobatan") Date tanggalMulaiPengobatan,
					@Param("panduanObat") String panduanObat,
					@Param("sebelumPengobatanHasilMikroskopis") String sebelumPengobatanHasilMikroskopis,
					@Param("sebelumPengobatanHasilTesCepat") String sebelumPengobatanHasilTesCepat,
					@Param("sebelumPengobatanHasilBiakan") String sebelumPengobatanHasilBiakan,
					@Param("hasilMikroskopisBulan2") String hasilMikroskopisBulan2,
					@Param("hasilMikroskopisBulan3") String hasilMikroskopisBulan3,
					@Param("hasilMikroskopisBulan5") String hasilMikroskopisBulan5,
					@Param("akhirPengobatanHasilMikroskopis") String akhirPengobatanHasilMikroskopis,
					@Param("tanggalHasilAkhirPengobatan") String tanggalHasilAkhirPengobatan,
					@Param("hasilAkhirPengobatan") String hasilAkhirPengobatan,
					@Param("fotoToraks") String fotoToraks
					); 
	
	Optional<List<TB03>> findByTanggalBetween(
			@DateTimeFormat(pattern="yyyy-MM-dd") Date date,
			@DateTimeFormat(pattern="yyyy-MM-dd") Date date2); 
}