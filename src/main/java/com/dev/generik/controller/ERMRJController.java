package com.dev.generik.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URISyntaxException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dev.generik.entities.ERM.DokterERM;
import com.dev.generik.entities.ERM.JadOp.JadOp;
import com.dev.generik.entities.ERM.JadOp.JadOpDokter;
import com.dev.generik.entities.ERM.JadOp.JadOpGet;
import com.dev.generik.entities.ERM.JadOp.JadOpDiag;
import com.dev.generik.entities.ERM.JadOp.JadOpStatus;
import com.dev.generik.entities.RJ.Operasi.OperasiGetPrice;
import com.dev.generik.entities.RJ.Operasi.TransaksiOperasi;
import com.dev.generik.entities.RJ.Sensus.Sensus;
import com.dev.generik.entities.RJ.SkriningTB.ERMRJSkriningTB;
import com.dev.generik.entities.RJ.SkriningTB.ERMRJSkriningTBKet;
import com.dev.generik.entities.RJ.SkriningTB.ERMRJSkriningTBPost;
import com.dev.generik.entities.RJ.MCU.MCURJ;
import com.dev.generik.entities.RJ.NoUrut.ListNoUrut;
import com.dev.generik.entities.RJ.NoUrut.NoUrut;
import com.dev.generik.entities.RJ.NoUrut.QuePoli;
import com.dev.generik.entities.RJ.Operasi.Operasi;
import com.dev.generik.entities.RJ.Tindakan.Tindakan;
import com.dev.generik.entities.RJ.Tindakan.TindakanDokter;
import com.dev.generik.entities.ERM.JadOp.JadOpRoom;
import com.dev.generik.exception.CustomException;
import com.dev.generik.exception.CustomExceptionS;
import com.dev.generik.models.Metadata;
import com.dev.generik.models.ResponseX;
import com.dev.generik.models.ERM.JadOp.JadOpTGLResponseModel;
import com.dev.generik.models.RJ.ResponNoSEPModel;
import com.dev.generik.models.RJ.NoUrut.NoUrutModel;
import com.dev.generik.models.RJ.Tindakan.TindakanDokterModel;
import com.dev.generik.service.JadOp.JadOpDokterService;
import com.dev.generik.service.JadOp.JadOpNamaService;
import com.dev.generik.service.JadOp.JadOpDiagService;
import com.dev.generik.service.JadOp.JadOpStatusService;
import com.dev.generik.service.RJ.NoUrut.NoUrutService;
import com.dev.generik.service.RJ.Operasi.OperasiGetPriceService;
import com.dev.generik.service.RJ.Operasi.OperasiService;
import com.dev.generik.service.RJ.Tindakan.TindakanGetPriceService;
import com.dev.generik.service.RJ.Tindakan.TindakanService;
import com.dev.generik.service.JadOp.JadOpRoomService;
import com.dev.generik.repository.ERM.DokterERMRepository;
import com.dev.generik.repository.ERM.JadOp.JadOpGetRepository;
import com.dev.generik.repository.ERM.JadOp.JadOpRepository;
import com.dev.generik.repository.RJ.SensusRepository;
import com.dev.generik.repository.RJ.MCURJ.MCURJRepository;
import com.dev.generik.repository.RJ.NoUrut.NoUrutRepository;
import com.dev.generik.repository.RJ.NoUrut.QuePoliRepository;
import com.dev.generik.repository.RJ.Operasi.TransaksiOperasiRepository;
import com.dev.generik.repository.RJ.SkriningTB.ERMRJSkriningTBKetRepository;
import com.dev.generik.repository.RJ.SkriningTB.ERMRJSkriningTBPostRepository;
import com.dev.generik.repository.RJ.SkriningTB.ERMRJSkriningTBRepository;
import com.dev.generik.repository.RJ.Tindakan.TindakanDokterRepository;


@RestController
@RequestMapping("his/ermrj")
public class ERMRJController {
	
	@Autowired
	JadOpRepository jadOpRepository;
	@Autowired
	JadOpGetRepository jadOpGetRepository;
	@Autowired
	JadOpDokterService jadOpDokterService;
	@Autowired
	JadOpNamaService jadOpNamaService;
	@Autowired
	JadOpDiagService jadOpDiagService;
	@Autowired
	JadOpStatusService jadOpStatusService; 
	@Autowired
	JadOpRoomService jadOpRoomService;
	@Autowired
	ERMRJSkriningTBRepository eRMRJSkriningTBRepository;
	@Autowired
	ERMRJSkriningTBPostRepository eRMRJSkriningTBPostRepository;
	@Autowired
	ERMRJSkriningTBKetRepository eRMRJSkriningTBKetRepository;
	@Autowired
	DokterERMRepository dokterERMRepository;
	@Autowired
	SensusRepository sensusRepository;
	@Autowired
	TindakanService tindakanService;
	@Autowired
	TindakanGetPriceService tindakanGetPriceService;
	@Autowired
	OperasiService operasiService;
	@Autowired
	OperasiGetPriceService operasiGetPriceService;
	@Autowired
	TindakanDokterRepository tindakanDokterRepository;
	@Autowired
	TransaksiOperasiRepository transaksiOperasiRepository;
	@Autowired
	MCURJRepository mCURJRepository;
	@Autowired
	NoUrutService noUrutService;
	@Autowired
	QuePoliRepository quePoliRepository;
	@Autowired
	NoUrutRepository noUrutRepository;
	
	@GetMapping("/jadOpDokter/")
	List<JadOpDokter> JadOpDok() {
		return jadOpDokterService.getAll();
	}	

	@GetMapping("/JadOpTGL/")
	public ResponseEntity<List<JadOpTGLResponseModel>> getJadOpByBetTgl(
	        @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
	        @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {

	    List<JadOp> jadwalList = jadOpRepository.findByTanggalBetween(
	        java.sql.Date.valueOf(start), java.sql.Date.valueOf(end)
	    );

	    List<JadOpTGLResponseModel> result = jadwalList.stream()
	            .map(j -> new JadOpTGLResponseModel(j.getTindakanId(), j.getDokterId(), j.getTanggal()))
	            .collect(Collectors.toList());

	    return ResponseEntity.ok(result);
	}
	
	@GetMapping("/JadOpPerTGL/")
	public ResponseEntity<List<JadOpGet>> getJadOpByTgl(
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        
        Date sqlDate = java.sql.Date.valueOf(date);
        List<JadOpGet> jadopList = jadOpGetRepository.findByTanggal(sqlDate);

        return ResponseEntity.ok(jadopList);
   	}
		
	@GetMapping("/jadOpDiag")
	public ResponseEntity<?> getJadOpDiag(
	        @RequestParam(required = false) Long id,
	        @RequestParam(required = false) String initial,
	        @RequestParam(required = false) String nama) {

	    if (id != null) {
	        return jadOpDiagService.findById(id)
	                .map(ResponseEntity::ok)
	                .orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    List<JadOpDiag> result;
	    if (nama != null && !nama.isEmpty()) {
	        result = jadOpDiagService.findByNamaContains(nama);
	    } else 
	    if (initial != null && !initial.isEmpty()) {
	        result = jadOpDiagService.findByInitialContains(initial);
	    } else {
	        result = jadOpDiagService.getTop20(); // ambil default 20
	    }

	    return ResponseEntity.ok(result);
	}
	
	@GetMapping("/jadOpStatus/")
	List<JadOpStatus> JadOpStatus() {
		return jadOpStatusService.getAll();
	}
	
	@GetMapping("/JadOpRoom")
	public ResponseEntity<?> getJadOpRoom(
	        @RequestParam(required = false) Long id,
	        @RequestParam(required = false) String nama) {

	    if (id != null) {
	        return jadOpRoomService.findById(id)
	                .map(ResponseEntity::ok)
	                .orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    List<JadOpRoom> result;
	    if (nama != null && !nama.isEmpty()) {
	        result = jadOpRoomService.findByNamaContains(nama);
	    } else {
	        result = jadOpRoomService.getTop20(); // ambil default 20
	    }

	    return ResponseEntity.ok(result);
	}
	
	@GetMapping("/JadOp/Id/{id}")
	public ResponseEntity<?> JadOpByNo(@PathVariable Long id) {
	    List<JadOpGet> rows = jadOpGetRepository.findByid(id);

	    if (rows == null || rows.isEmpty()) {
	        String msg = "ID = (" + id + ") Jadwal Operasi Belum ada..!!";
	        System.out.println(msg);
	        // HTTP 200, body berisi message + code (404 sesuai contoh)
	        return ResponseEntity.ok(java.util.Map.of(
	            "message", msg,
	            "code", 200
	        ));
	    }

	    // Data ada → langsung kembalikan list (HTTP 200)
	    return ResponseEntity.ok(rows);
	}
	
	@GetMapping("/JadOp/No/{nomor}")
	public ResponseEntity<?> JadOpById(@PathVariable Long nomor) {
	    Optional<JadOpGet> cek = jadOpGetRepository.findById(nomor);

	    if (cek.isEmpty()) {
	        String msg = "ID = (" + nomor + ") Jadwal Operasi Belum ada..!!";
	        System.out.println(msg);
	        // HTTP 200 + payload sesuai contoh
	        return ResponseEntity.ok(java.util.Map.of(
	            "message", msg,
	            "code", 200
	        ));
	    }

	    // Data ada → 200 + objek
	    return ResponseEntity.ok(cek.get());
	}

	@PostMapping("/JadOp/")
	ResponseEntity<ResponseX<JadOp, Metadata>> addJadOp(@RequestBody JadOp jadOp) {
		JadOp regSave;
		
		 // Validasi panjang data sebelum update
	    validateJadOp(jadOp);
	    
			try {
				regSave = jadOpRepository.save(jadOp);
			} catch (IllegalArgumentException e) {
				final String msg = "Payload Tidak Valid ...";
				throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);

		}

		final String messageOk = "Ok";
		Metadata metadata = new Metadata(HttpStatus.OK.value(), messageOk);
		ResponseX<JadOp, Metadata> responseX = new ResponseX<>(regSave, metadata);
		return ResponseEntity.ok(responseX);

	}
	
	@PutMapping("/JadOp/")
	public ResponseEntity<EntityModel<JadOp>> updateSPPA(
	        @RequestParam(name = "nomor") Long nomor, 
	        @RequestBody JadOp jadOp) {

	    // Cek apakah data dengan ID yang diberikan ada
	    JadOp existingJadOp = jadOpRepository.findById(nomor)
	            .orElseThrow(() -> new CustomException(HttpStatus.BAD_REQUEST.value(), "ID Jadwal Operasi Tidak ada...!", HttpStatus.BAD_REQUEST));

	    // Validasi panjang data sebelum update
	    validateJadOp(jadOp);

	    try {
	        // Memperbarui data yang ditemukan
	        existingJadOp.setTindakanId(jadOp.getTindakanId());
	        existingJadOp.setKelasId(jadOp.getKelasId());
	        existingJadOp.setRoomId(jadOp.getRoomId());
	        existingJadOp.setDokterId(jadOp.getDokterId());
	        existingJadOp.setTanggal(jadOp.getTanggal());
	        existingJadOp.setJam(jadOp.getJam());
	        existingJadOp.setStatus(jadOp.getStatus());
	        existingJadOp.setDiagnosaId(jadOp.getDiagnosaId());
	        existingJadOp.setKetDiag(jadOp.getKetDiag());
	        existingJadOp.setTempat(jadOp.getTempat());
	        existingJadOp.setKlsStrgRen(jadOp.getKlsStrgRen());
	        existingJadOp.setKelasIdRen(jadOp.getKelasIdRen());
	        existingJadOp.setRoomIdRen(jadOp.getRoomIdRen());

	        JadOp updatedJadOp = jadOpRepository.save(existingJadOp);

	        // Membangun EntityModel dengan self-link
	        EntityModel<JadOp> resource = EntityModel.of(updatedJadOp,
	                linkTo(methodOn(ERMRJController.class).JadOpById(updatedJadOp.getId())).withSelfRel());

	        return ResponseEntity.ok(resource);

	    } catch (IllegalArgumentException e) {
	        throw new CustomException(HttpStatus.BAD_REQUEST.value(), "Payload Tidak Valid ...", HttpStatus.BAD_REQUEST);
	    }
	}

	// Metode validasi panjang string agar kode utama tetap bersih
	private void validateJadOp(JadOp jadOp) {
	    if (jadOp.getTindakanId().length() > 50) {
	        throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), "Panjang Tindakan Max 50 Karakter", HttpStatus.UNPROCESSABLE_ENTITY);
	    }
	    if (jadOp.getDiagnosaId().length() > 1001) {
	        throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), "Panjang Diagnosa Max 1001 Karakter", HttpStatus.UNPROCESSABLE_ENTITY);
	    }
	    if (jadOp.getKetDiag().length() > 50) {
	        throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), "Panjang Keterangan Diagnosa Max 50 Karakter", HttpStatus.UNPROCESSABLE_ENTITY);
	    }
	    if (jadOp.getDokterId().length() > 80) {
	        throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), "Panjang Dokter Max 80 Karakter", HttpStatus.UNPROCESSABLE_ENTITY);
	    }
	    if (jadOp.getStatus().length() > 30) {
	        throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), "Panjang Status Max 30 Karakter", HttpStatus.UNPROCESSABLE_ENTITY);
	    }
	}

	@DeleteMapping("/JadOp/")
	public ResponseEntity<ResponseX<Void, Metadata>> deleteJadOp(@RequestParam(name = "nomor") Long nomor) {
	    // Cek apakah data ada
	    Optional<JadOp> existing = jadOpRepository.findById(nomor);
	    if (existing.isEmpty()) {
	        // UBAH: 404 -> 200 OK + metadata pesan
	        String msg = "Data Jadwal Operasi dengan nomor (" + nomor + ") tidak ditemukan";
	        Metadata metadata = new Metadata(HttpStatus.OK.value(), msg);
	        return ResponseEntity.ok(new ResponseX<>(null, metadata));
	    }

	    // Hapus data
	    try {
	        jadOpRepository.delete(existing.get());
	    } catch (Exception e) {
	        throw new CustomException(
	            HttpStatus.INTERNAL_SERVER_ERROR.value(),
	            "Gagal menghapus data",
	            HttpStatus.INTERNAL_SERVER_ERROR
	        );
	    }

	    // Response sukses
	    Metadata metadata = new Metadata(HttpStatus.OK.value(), "Data berhasil dihapus");
	    return ResponseEntity.ok(new ResponseX<>(null, metadata));
	}
	
	@GetMapping("/SkriningTB/{id}")
	public ResponseEntity<?> eRMRJSkriningTBById(@PathVariable Long id) {
	    Optional<ERMRJSkriningTB> cek = eRMRJSkriningTBRepository.findById(id);

	    if (cek.isEmpty()) {
	        String msg = "ID = (" + id + ") Skrining TB RJ Belum ada..!!";
	        System.out.println(msg);
	        return ResponseEntity.ok(java.util.Map.of(
	            "message", msg,
	            "code", 200
	        ));
	    }

	    // Data ada → kembalikan objeknya (HTTP 200)
	    return ResponseEntity.ok(cek.get());
	}
	
	@PostMapping("/SkriningTB")
	ResponseEntity<ResponseX<ERMRJSkriningTBPost, Metadata>> addERMRJSkriningTBPost(@RequestBody ERMRJSkriningTBPost eRMRJSkriningTBPost) {
		ERMRJSkriningTBPost regSave;
		if (eRMRJSkriningTBPost.getId() == null)  {
			String msg = "(TB RJ) ID = IDReg(Px) Tidak Boleh Kosong Atau PX Tidak Ada";
			System.out.println(msg);
			throw new CustomException(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		if (eRMRJSkriningTBPost.getIdDokter() == null)  {
			String msg = "ID Dokter Tidak Boleh Kosong";
			System.out.println(msg);
			throw new CustomException(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		Optional<DokterERM> cek = dokterERMRepository.findById(eRMRJSkriningTBPost.getIdDokter());
		if (cek.isEmpty()) {
			String msg = "ID (Kode) Dokter tidak diketahui, silahkan Hub EDP..!!";
			System.out.println(msg);
			throw new CustomException(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	//	if (eRMRJSkriningTBRepository.findById(eRMRJSkriningTBPost.getId()).isPresent()) {
	//		final String msg = "Data Sudah Di Input ...!";
	//		throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
	//	} 
		else {
			try {
				regSave = eRMRJSkriningTBPostRepository.save(eRMRJSkriningTBPost);
			} catch (IllegalArgumentException e) {
				final String msg = "Payload Tidak Valid ...";
				throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
			}
		}

		final String messageOk = "Ok";
		Metadata metadata = new Metadata(HttpStatus.OK.value(), messageOk);
		ResponseX<ERMRJSkriningTBPost, Metadata> responseX = new ResponseX<>(regSave, metadata);
		return ResponseEntity.ok(responseX);
	}	
	
	@PutMapping("/SkriningTB")
	ResponseEntity<EntityModel<ERMRJSkriningTBPost>> updateERMSkriningTB(@RequestParam(name = "id") Long id, @RequestBody ERMRJSkriningTBPost eRMRJSkriningTBPost)
			throws URISyntaxException 
	{	
		if (eRMRJSkriningTBPostRepository.findById(id).isPresent()) {
			
			//Optional<ERMIGDSkriningCovidPost> cek = eRMIGDSkriningCovidPostRepository.findById(id);
			ERMRJSkriningTBPost eRMRJSkriningTBPostUpdate = eRMRJSkriningTBPostRepository.findById(id).map(sPLb -> {
				sPLb.setId(eRMRJSkriningTBPost.getId());
				sPLb.setTanggal(eRMRJSkriningTBPost.getTanggal());
				sPLb.setIdDokter(eRMRJSkriningTBPost.getIdDokter());
				sPLb.setBatuk(eRMRJSkriningTBPost.getBatuk());
				sPLb.setSesak(eRMRJSkriningTBPost.getSesak());
				sPLb.setBeratBadan(eRMRJSkriningTBPost.getBeratBadan());
				sPLb.setRiwayat(eRMRJSkriningTBPost.getRiwayat());
				sPLb.setKet(eRMRJSkriningTBPost.getKet());
				sPLb.setDm(eRMRJSkriningTBPost.getDm());
				sPLb.setHiv(eRMRJSkriningTBPost.getHiv());
		//		sPLb.setGejala(eRMIGDSkriningTBPost.getGejala());
				
				return eRMRJSkriningTBPostRepository.save(sPLb);
			}).get();

			EntityModel<ERMRJSkriningTBPost> resource = EntityModel.of(eRMRJSkriningTBPostUpdate,
					linkTo(methodOn(ERMRJController.class).eRMRJSkriningTBById(eRMRJSkriningTBPostUpdate.getId())).withSelfRel());

			return ResponseEntity.created(resource.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(resource);
		
		} else {
			try {
				final String msg = "(TB) ID Pasien Inap Tidak ada Atau PX Sudah Pulang...!";
				throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);			
					
				} catch (IllegalArgumentException e) {
				final String msg = "Payload Tidak Valid ...";
				throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
			}
		}	
	}
	
	@GetMapping("/SkriningTBKet")
	List<ERMRJSkriningTBKet> ERMIGDSkriningTBKet() {
		return eRMRJSkriningTBKetRepository.findAll();
	}
	
	@PutMapping("/SensusIRJ")
	public ResponseEntity<Sensus> updateSensus(@RequestParam(name = "id") Long id, @RequestBody Sensus sensus)
			throws URISyntaxException {
		
		Optional<Sensus> optionalSensus = sensusRepository.findById(id);
		
		if (optionalSensus.isPresent()) {
			Sensus sensusUpdate = optionalSensus.map(existing -> {
				existing.setId(sensus.getId());
				existing.setDatang(sensus.getDatang());
				existing.setLama(sensus.getLama());
				existing.setUpx(sensus.getUpx());	
				existing.setSensusIRJ(sensus.getSensusIRJ());
				return sensusRepository.save(existing);
			}).get();

			return ResponseEntity.ok(sensusUpdate);

		} else {
			final String msg = "(Sensus) ID Pasien RJ Tidak...!";
			throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/NoSEP")
	public ResponseEntity<ResponNoSEPModel> updateNoSEP(@RequestBody Sensus sensus) throws URISyntaxException {

	    Long id = sensus.getId();

	    // Validasi ID
	    if (id == null) {
	        final String msg = "ID Pasien kosong!";
	        throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
	    }

	    // Cari data sensus berdasarkan ID
	    Optional<Sensus> optionalSensus = sensusRepository.findById(id);

	    if (optionalSensus.isPresent()) {
	        Sensus sensusUpdate = optionalSensus.map(existing -> {
	            existing.setNoSEP(sensus.getNoSEP());
	            return sensusRepository.save(existing);
	        }).get();

	        // Kembalikan response model khusus
	        ResponNoSEPModel response = new ResponNoSEPModel(
	            sensusUpdate.getId(),
	            sensusUpdate.getNoSEP()
	        );

	        return ResponseEntity.ok(response);

	    } else {
	        final String msg = "(Sensus) ID Pasien Tidak ada...!";
	        throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
	    }
	}


	
	@GetMapping("/Tindakan")
	public ResponseEntity<?> getTindakan(
	    @RequestParam(required = false) Long id,
	    @RequestParam(required = false) String nama) {

	    if (id != null) {
	        return tindakanService.findById(id)
	            .map(ResponseEntity::ok)
	            .orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    List<Tindakan> result;

	    if (nama != null && !nama.isEmpty()) {
	        result = tindakanService.findByNamaContains(nama);
	    } else {
	        result = tindakanService.getTop20();
	    }

	    return ResponseEntity.ok(result);
	}
	
	@GetMapping("/TindakanPrice")
	public Map<String, Double> getPrice(
	        @RequestParam int idReg,
	        @RequestParam int tindakanId
	    ) {
	        Double price = tindakanGetPriceService.getPrice(idReg, tindakanId);
	        return Map.of("price", price);
	}
	
	@GetMapping("/Operasi")
	public ResponseEntity<?> getOperasi(
	        @RequestParam(required = false) Long id,
	        @RequestParam(required = false) String nama) {

	    if (id != null) {
	        return operasiService.findById(id)
	                .map(ResponseEntity::ok)
	                .orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    List<Operasi> result;
	    if (nama != null && !nama.isEmpty()) {
	        result = operasiService.findByNamaContains(nama);
	    } else {
	        result = operasiService.getTop20(); // ambil default 20
	    }

	    return ResponseEntity.ok(result);
	}
	
	@GetMapping("/OperasiPrice")
    public OperasiGetPrice getHargaOperasi(
            @RequestParam("idreg") Integer idReg,
            @RequestParam("opeid") Integer opeId) {
        return operasiGetPriceService.getBiayaOperasi(idReg, opeId);
    }
	
	@GetMapping("/TindakanDokterID/{id}")
	public List<TindakanDokter> getTindakanDokterIDById(@PathVariable Long id) {
	    return tindakanDokterRepository.findByid(id); // untuk List<TindakanDokter> yang punya ID tertentu
	}
	
	@PostMapping("/TindakanDokter/")
    public TindakanDokter createTindakanDokter(@RequestBody TindakanDokterModel dto) {
        TindakanDokter entity = new TindakanDokter();

        entity.setId(dto.getId());
        entity.setActID(dto.getActID());
        entity.setTindakID(dto.getTindakID());
        entity.setTanggal(dto.getTanggal());
        entity.setBiaya(dto.getBiaya());
        entity.setPot(dto.getPot());
        entity.setJam(dto.getJam());
        entity.setDokterID(dto.getDokterID());
        entity.setKlasID(dto.getKlasID());
        entity.setRoomID(dto.getRoomID());
        entity.setPosted(dto.getPosted());

        return tindakanDokterRepository.save(entity);
    }
	
	@DeleteMapping("/TindakanDokter/{actID}")
	public ResponseEntity<?> deleteTindakanDokter(@PathVariable Long actID) {
	    if (tindakanDokterRepository.existsById(actID)) {
	        tindakanDokterRepository.deleteById(actID);
	        return ResponseEntity.ok("TindakanDokter deleted successfully");
	    } else {
	        return ResponseEntity.status(404).body("Data tidak ditemukan : " + actID);
	    }
	}
	
	@GetMapping("/TransaksiOperasiID/{id}")
	public List<TransaksiOperasi> getTransaksiOperasiIDById(@PathVariable Integer id) {
	    return transaksiOperasiRepository.findById(id); // untuk List<TindakanDokter> yang punya ID tertentu
	}
	
	@PostMapping("/TransaksiOperasi")
	public TransaksiOperasi createTransaksiOperasi(@RequestBody TransaksiOperasi operasi) {
	    // Jangan isi Ope_ID karena kolom itu auto increment
	  //  operasi.setOpeID(null); 
	    return transaksiOperasiRepository.save(operasi);
	}
	
	@DeleteMapping("/TransaksiOperasi/{opeID}")
	public ResponseEntity<String> deleteOperasi(@PathVariable Long opeID) {
	    if (transaksiOperasiRepository.existsById(opeID)) {
	        try {
	            transaksiOperasiRepository.deleteById(opeID);
	            return ResponseEntity.ok("Transaksi Operasi dengan ID: " + opeID + " berhasil dihapus.");
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                    .body("Gagal menghapus Transaksi Operasi dengan ID: " + opeID + ".");
	        }
	    } else {
	        // 404 -> 200 OK
	        return ResponseEntity.ok("Transaksi Operasi dengan ID: " + opeID + " tidak ditemukan.");
	    }
	}
	
	@GetMapping("/MCURJ/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
	    Optional<MCURJ> result = mCURJRepository.findById(id);

	    if (result.isPresent()) {
	        return ResponseEntity.ok(result.get());
	    } else {
	        Map<String, String> response = new HashMap<>();
	        response.put("message", "Data dengan ID " + id + " tidak ditemukan.");
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	    }
	}
	
	 @PostMapping("/MCURJ/")
	 public ResponseEntity<MCURJ> createOrUpdate(@RequestBody MCURJ data) {
	     boolean exists = mCURJRepository.existsById(data.getId());
	     MCURJ saved = mCURJRepository.save(data);

	     if (exists) {
	         return ResponseEntity.ok(saved); // status 200 OK untuk update
	     } else {
	         return ResponseEntity.status(HttpStatus.CREATED).body(saved); // status 201 Created
	     }
	 }

	 @DeleteMapping("/MCURJ/{id}")
	 public ResponseEntity<?> delete(@PathVariable Long id) {
	     if (!mCURJRepository.existsById(id)) {
	         Map<String, String> response = new HashMap<>();
	         response.put("message", "Data dengan ID " + id + " tidak ditemukan.");
	         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	     }

	     mCURJRepository.deleteById(id);
	     return ResponseEntity.noContent().build();
	 }
	 
	 @GetMapping("/ListNoUrut")
	    public ResponseEntity<?> getPasienRawatJalan(
	            @RequestParam("tanggal") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate tanggal,
	            @RequestParam("subLayanan") String subLayanan,
	            @RequestParam("dokterID") Long dokterID,
	            @RequestParam("jp") String jp
	    ) {
	        List<ListNoUrut> result = noUrutService.getDaftarPasien(Date.valueOf(tanggal), subLayanan, dokterID, jp);
	        return ResponseEntity.ok(result);
	    }
	 // QuePoli
	 @PostMapping("/QuePoli")
	    public ResponseEntity<QuePoli> createQuePoli(@RequestBody QuePoli quePoli) {
	        QuePoli savedQuePoli = quePoliRepository.save(quePoli);
	        return ResponseEntity.status(HttpStatus.CREATED).body(savedQuePoli);
	    }

	    // PUT: Update an existing entry
	 
	 @PutMapping("/QuePoli/")
	 public ResponseEntity<?> updateQuePoliAndSensus(@RequestBody NoUrutModel req) {

	     Optional<QuePoli> optQuePoli = quePoliRepository.findById(req.getQuePoliId());
	     Optional<NoUrut> optSensus = noUrutRepository.findById(req.getId());

	     if (optQuePoli.isEmpty()) {
	         throw new CustomException(HttpStatus.BAD_REQUEST.value(), "Data No Poli tidak ditemukan", HttpStatus.BAD_REQUEST);
	     }
	     if (optSensus.isEmpty()) {
	         throw new CustomException(HttpStatus.BAD_REQUEST.value(), "Data No Pendaftaran tidak ditemukan", HttpStatus.BAD_REQUEST);
	     }

	     // Update QuePoli
	     QuePoli quePoli = optQuePoli.get();
	     quePoli.setCallNo(req.getCallNo());
	     quePoli.setDayDate(req.getDayDate());
	     quePoli.setDoctor(req.getDoctor());
	     quePoli.setId(req.getId());
	     quePoli.setJamPraktek(req.getJamPraktek());
	     quePoli.setIsLock(req.getIsLock());
	     quePoli.setSubLayanan(req.getSubLayanan());
	     quePoliRepository.save(quePoli);

	     // Update Sensus
	     NoUrut sensus = optSensus.get();
	     sensus.setPxNo(req.getCallNo());
	     noUrutRepository.save(sensus);

	     return ResponseEntity.ok(Map.of("message", "Update berhasil" ));
	 }

	 
	 @DeleteMapping("/QuePoli/{id}")
	 public ResponseEntity<?> delQuePoli(@PathVariable Long id) {
	     if (!quePoliRepository.existsById(id)) {
	         Map<String, String> response = new HashMap<>();
	         response.put("message", "Data dengan ID " + id + " tidak ditemukan.");
	         // UBAH: 404 -> 200
	         return ResponseEntity.ok(response);
	     }

	     quePoliRepository.deleteById(id);
	     return ResponseEntity.noContent().build(); // tetap 204 saat berhasil
	 }	 

}



