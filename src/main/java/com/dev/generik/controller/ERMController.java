package com.dev.generik.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.MessageDigest;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dev.generik.entities.ERM.IGD.SkriningHPPVK.ERMIGDVKHPPNama;
import com.dev.generik.entities.ERM.IGD.SkriningHPPVK.ERMIGDVKHPPNamaClass;
import com.dev.generik.entities.ERM.DokterERM;
import com.dev.generik.entities.ERM.Billing.RekKamarBPJS;
import com.dev.generik.entities.ERM.Billing.RekLaborat;
import com.dev.generik.entities.ERM.Billing.RekLain;
import com.dev.generik.entities.ERM.Billing.RekObat;
import com.dev.generik.entities.ERM.Billing.RekOperasi;
import com.dev.generik.entities.ERM.Billing.RekRadiologi;
import com.dev.generik.entities.ERM.Billing.RekTindakan;
import com.dev.generik.entities.ERM.Billing.RekVisit;
import com.dev.generik.entities.ERM.Billing.Rek;
import com.dev.generik.entities.ERM.IGD.SkriningHPPVK.ERMIGDVKHPP;
import com.dev.generik.entities.ERM.IGD.SkriningHPPVK.ERMIGDVKHPPDet;
import com.dev.generik.entities.ERM.IGD.SkriningHPPVK.ERMIGDVKHPPDetClass;
import com.dev.generik.entities.ERM.PA.SPPA;
import com.dev.generik.entities.ERM.PA.SPPACek;
import com.dev.generik.entities.ERM.PA.SPPADet;
import com.dev.generik.entities.ERM.PA.SPPADgDet;
import com.dev.generik.entities.ERM.PA.SPPAPeriksa;
import com.dev.generik.entities.ERM.PPRA.ObatPPRA;
import com.dev.generik.entities.ERM.Rad.RadHasilAll;
import com.dev.generik.entities.ERM.Register.RegisterKepRI;
import com.dev.generik.entities.ERM.Register.RegisterKepRIGet;
import com.dev.generik.entities.ERM.Resep.Angka;
import com.dev.generik.entities.ERM.Resep.ObAtRsp;
import com.dev.generik.entities.ERM.Resep.ObAtRspGet;
import com.dev.generik.entities.ERM.Resep.ObAtRspTemplate;
import com.dev.generik.entities.ERM.Resep.ObAtRspTemplateGet;
import com.dev.generik.entities.ERM.Resep.Obat;
import com.dev.generik.entities.ERM.Resep.ResepOL;
import com.dev.generik.entities.ERM.Resep.ResepOLRiwayat;
import com.dev.generik.entities.ERM.Resep.ResepOLTemplate;
import com.dev.generik.entities.ERM.Resep.ResepOLTemplateGet;
import com.dev.generik.entities.ERM.Resep.CekResepOL;
import com.dev.generik.entities.ERM.Resep.Signa;
import com.dev.generik.entities.Obat.ObatAll;
import com.dev.generik.entities.Obat.ObatUnion;
import com.dev.generik.entities.RJ.KesJiwa.KesJiwa;
import com.dev.generik.entities.ERM.Resep.ContensTab;
import com.dev.generik.entities.ERM.Resep.ContensTabGet;
import com.dev.generik.entities.ERM.Resep.ContensTabTemplate;
import com.dev.generik.entities.ERM.Resep.ContensTabTemplateGet;
import com.dev.generik.exception.CustomException;
import com.dev.generik.exception.CustomExceptionS;
import com.dev.generik.models.Metadata;
import com.dev.generik.models.ResponseX;
import com.dev.generik.models.Billing.RekKamarBPJSModel;
import com.dev.generik.models.Billing.RekLaboratModel;
import com.dev.generik.models.Billing.RekLainModel;
import com.dev.generik.models.Billing.RekModel;
import com.dev.generik.models.Billing.RekObatModel;
import com.dev.generik.models.Billing.RekOperasiModel;
import com.dev.generik.models.Billing.RekRadiologiModel;
import com.dev.generik.models.Billing.RekTindakanModel;
import com.dev.generik.models.Billing.RekVisitModel;
import com.dev.generik.models.IGD.ERMIGDVKHPPKelModelList;
import com.dev.generik.models.IGD.ERMIGDVKHPPModelList;
import com.dev.generik.models.Lab.LabHasilAllIdLabModel;
import com.dev.generik.models.Lab.LabHasilAllKatModel;
import com.dev.generik.models.Lab.LabHasilAllModel;
import com.dev.generik.models.Lab.LabHasilAllPerikModel;
import com.dev.generik.models.Obat.ObatAllHeaderModel;
import com.dev.generik.models.Obat.ObatAllItemModel;
import com.dev.generik.models.Obat.ObatAllRoomModel;
import com.dev.generik.models.Rad.RadHasilAllModel;
import com.dev.generik.models.Rad.RadHasilAllPerikModel;
import com.dev.generik.models.Resep.ObAtRspModel;
import com.dev.generik.models.Resep.ObAtRspTemplateModel;
import com.dev.generik.models.Resep.ResepOLGetResponseModel;
import com.dev.generik.models.Resep.ResepOLModel;
import com.dev.generik.models.Resep.ResepOLResponseModel;
import com.dev.generik.models.Resep.ResepOLTemplateModel;
import com.dev.generik.models.Resep.ResepOLTemplateNRiwayatPXModel;
import com.dev.generik.models.Resep.ResepOLTemplateResponseModel;
import com.dev.generik.models.Resep.ResepOLTemplateGetResponseModel;
//import com.dev.generik.models.Resep.ResepOLResponseModel.ObAtRspM;
import com.dev.generik.models.Resep.RespErResepOL;
import com.dev.generik.models.Resep.RespErResepOLTemplate;
import com.dev.generik.models.Register.RegisterKepRIGetModel;
import com.dev.generik.models.Register.RegisterKepRIModel;
import com.dev.generik.models.token.AuthRequest;
import com.dev.generik.models.token.AuthResponse;
import com.dev.generik.entities.ERM.IGD.SkriningHPPVK.ERMIGDVKHPPKel;
import com.dev.generik.repository.ERM.DokterERMRepository;
import com.dev.generik.repository.ERM.Billing.RekKamarBPJSRepository;
import com.dev.generik.repository.ERM.HPP.ERMIGDVKHPPDetRepository;
import com.dev.generik.repository.ERM.HPP.ERMIGDVKHPPKelRepository;
import com.dev.generik.repository.ERM.HPP.ERMIGDVKHPPNamaRepository;
import com.dev.generik.repository.ERM.HPP.ERMIGDVKHPPRepository;
import com.dev.generik.repository.ERM.PA.SPPACekRepository;
import com.dev.generik.repository.ERM.PA.SPPADetRepository;
import com.dev.generik.repository.ERM.PA.SPPADgDetRepository;
import com.dev.generik.repository.ERM.PA.SPPAPeriksaRepository;
import com.dev.generik.repository.ERM.PA.SPPARepository;
import com.dev.generik.repository.ERM.Register.RegisterKepRIGetRepository;
import com.dev.generik.repository.ERM.Register.RegisterKepRIRepository;
import com.dev.generik.repository.Obat.ObatUnionRepository;
import com.dev.generik.repository.RJ.kesJiwa.KesJiwaRepository;
import com.dev.generik.repository.Resep.AngkaRepository;
import com.dev.generik.repository.Resep.CekResepOLRepository;
import com.dev.generik.repository.Resep.ContensTabGetRepository;
import com.dev.generik.repository.Resep.ContensTabRepository;
import com.dev.generik.repository.Resep.ContensTabTemplateGetRepository;
import com.dev.generik.repository.Resep.ContensTabTemplateRepository;
import com.dev.generik.repository.Resep.ObAtRspGetRepository;
import com.dev.generik.repository.Resep.ObAtRspRepository;
import com.dev.generik.repository.Resep.ObAtRspTemplateGetRepository;
import com.dev.generik.repository.Resep.ObAtRspTemplateRepository;
import com.dev.generik.repository.Resep.ObatRepository;
import com.dev.generik.repository.Resep.ResepOLRepository;
import com.dev.generik.repository.Resep.ResepOLRiwayatRepository;
import com.dev.generik.repository.Resep.ResepOLTemplateGetRepository;
import com.dev.generik.repository.Resep.ResepOLTemplateRepository;
import com.dev.generik.service.Resep.SignaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import com.dev.generik.service.Billing.RekLaboratService;
import com.dev.generik.service.Billing.RekLainService;
import com.dev.generik.service.Billing.RekObatService;
import com.dev.generik.service.Billing.RekOperasiService;
import com.dev.generik.service.Billing.RekRadiologiService;
import com.dev.generik.service.Billing.RekService;
import com.dev.generik.service.Billing.RekTindakanService;
import com.dev.generik.service.Billing.RekVisitService;
import com.dev.generik.service.Lab.LabHasilAllService;
import com.dev.generik.service.Obat.ObatAllService;
import com.dev.generik.service.PPRA.ObatPPRAService;
import com.dev.generik.service.Rad.RadHasilAllService;

@RestController
@RequestMapping("his/erm")
public class ERMController {
	
	@Autowired
	ERMIGDVKHPPNamaRepository eRMIGDVKHPPNamaRepository;
	@Autowired
	ERMIGDVKHPPKelRepository eRMIGDVKHPPKelRepository;
	@Autowired
	ERMIGDVKHPPRepository eRMIGDVKHPPRepository;
	@Autowired
	ERMIGDVKHPPDetRepository eRMIGDVKHPPDetRepository;
	@Autowired
	SPPARepository sPPARepository;
	@Autowired
	SPPACekRepository sPPACekRepository;
	@Autowired
	DokterERMRepository dokterERMRepository;
	@Autowired
	ObatPPRAService obatPPRAService;
	@Autowired
	ObatRepository obatRepository;
//	@Autowired
//	ObatRacikanService obatRacikanService;
	@Autowired
	SignaService signaService;
	@Autowired
	AngkaRepository angkaRepository;
	@Autowired
	ResepOLRepository resepOLRepository;
	@Autowired
	ResepOLRiwayatRepository resepOLRiwayatRepository;
	@Autowired
	CekResepOLRepository cekResepOLRepository;
	@Autowired
	ContensTabRepository contensTabRepository;
	@Autowired
	ObAtRspRepository obAtRspRepository;
	@Autowired
	ContensTabGetRepository contensTabGetRepository;
	@Autowired
	ObAtRspGetRepository obAtRspGetRepository;
	@Autowired
	RegisterKepRIGetRepository registerKepRIGetRepository;
	@Autowired
	RegisterKepRIRepository registerKepRIRepository;
	@Autowired
	ResepOLTemplateRepository resepOLTemplateRepository;
	@Autowired
	ObAtRspTemplateRepository obAtRspTemplateRepository;
	@Autowired
	ContensTabTemplateRepository contensTabTemplateRepository;
	@Autowired
	ResepOLTemplateGetRepository resepOLTemplateGetRepository;
	@Autowired
	ObAtRspTemplateGetRepository obAtRspTemplateGetRepository;
	@Autowired
	ContensTabTemplateGetRepository contensTabTemplateGetRepository;
	@Autowired
	SPPADetRepository sPPADetRepository;
	@Autowired
	SPPAPeriksaRepository sPPAPeriksaRepository;
	@Autowired
	SPPADgDetRepository sPPADgDetRepository;
	@Autowired
	KesJiwaRepository kesJiwaRepository;
	@Autowired
	ObatUnionRepository obatUnionRepository;
	@Autowired
	ObatAllService obatAllService;
	@Autowired
	LabHasilAllService labHasilAllService;
	@Autowired
	RadHasilAllService radHasilAllService;
	@Autowired
	RekKamarBPJSRepository kamarBPJSRepository;
	@Autowired
	RekService rekService;
	@Autowired
	RekVisitService rekVisitService;
	@Autowired
	RekTindakanService rekTindakanService;
	@Autowired
	RekLaboratService rekLaboratService;
	@Autowired
	RekRadiologiService rekRadiologiService;
	@Autowired
	RekLainService rekLainService;
	@Autowired
	RekOperasiService rekOperasiService;
	@Autowired
	RekObatService rekObatService;
	
		
	@PostMapping("/token/")
    public ResponseEntity<Object> generateToken(@RequestBody AuthRequest authRequest) {
        // Validasi username dan password (simulasi validasi hardcoded)
        if ("edp".equals(authRequest.getUsername()) && "edp".equals(authRequest.getPassword())) {
            // Buat token JWT
            String token = createToken(authRequest.getUsername());

            // Kembalikan token ke klien
            return ResponseEntity.ok(new AuthResponse(token));
        } else {
            // Respons jika kredensial tidak valid
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new AuthResponse("Invalid username or password"));
        }
    }

    private String createToken(String username) {
        // Kunci rahasia (gunakan yang panjang dan aman)
        String secretKey = "your-secret-key-should-be-very-long";

        // Set durasi token
        long expirationTime = System.currentTimeMillis() + 86400000; // 24 jam

        // Buat token JWT
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(expirationTime))
                .signWith(Keys.hmacShaKeyFor(secretKey.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }
	
	@GetMapping("/ERMIGDVKHPPKel/")
	List<ERMIGDVKHPPKel> ERMIGDVKHPPKel() {
		return eRMIGDVKHPPKelRepository.findAll();
	}
	
	@GetMapping("/ERMIGDVKHPPKel/{id}")
	public ERMIGDVKHPPKelModelList getERMIGDVKHPPKelList(@PathVariable Long id) {
	    return eRMIGDVKHPPKelRepository.findById(id)
	        .map(kel -> new ERMIGDVKHPPKelModelList(
	                kel.getId(), kel.getNama(), kel.getKet(), kel.getKat(),
	                eRMIGDVKHPPNamaRepository.findByidKel(id)))
	        .orElseGet(() -> new ERMIGDVKHPPKelModelList(
	                id, null, null, null, java.util.Collections.emptyList()));  // <-- 200 OK
	}

	
	@GetMapping("/ERMIGDVKHPP/{id}")
	public ERMIGDVKHPPModelList getERMIGDVKHPPList(@PathVariable Long id) {
	    return eRMIGDVKHPPRepository.findById(id)
	        .map(kpp -> {
	            List<ERMIGDVKHPPDet> det = eRMIGDVKHPPDetRepository.findByid(id);
	            return new ERMIGDVKHPPModelList(kpp.getId(), kpp.getTanggal(), kpp.getKel(), det);
	        })
	        .orElseGet(() ->
	            // tidak ada data: id diisi, field lain null, list kosong
	            new ERMIGDVKHPPModelList(id, null, null, java.util.Collections.emptyList())
	        );
	}

	
	@PostMapping("/ERMIGDVKHPP/")
	public ResponseEntity<ResponseX<ERMIGDVKHPP, Metadata>>
	saveERMIGDVKHPP(@RequestBody ERMIGDVKHPP eRMIGDVKHPP) {

	    // Null-safety sederhana
	    if (eRMIGDVKHPP == null || eRMIGDVKHPP.getTanggal() == null) {
	        Metadata meta = new Metadata(200, "Body/Tanggal tidak boleh kosong");
	        return ResponseEntity.ok(new ResponseX<>(null, meta));
	    }

	    // Validasi tanggal: harus >= hari ini (zona Asia/Jakarta)
	    LocalDate tgPx = eRMIGDVKHPP.getTanggal().toInstant()
	            .atZone(ZoneId.of("Asia/Jakarta")).toLocalDate();
	    LocalDate today = ZonedDateTime.now(ZoneId.of("Asia/Jakarta")).toLocalDate();

	    if (tgPx.isBefore(today)) {
	        String msg = "Tanggal (" + eRMIGDVKHPP.getTanggal() + ") harus sama atau lebih besar dari hari ini.";
	        Metadata meta = new Metadata(200, msg);
	        return ResponseEntity.ok(new ResponseX<>(null, meta));
	    }

	    // Validasi referensi Kel
	    if (eRMIGDVKHPP.getKel() == null ||
	        eRMIGDVKHPPKelRepository.findById(eRMIGDVKHPP.getKel()).isEmpty()) {
	        Metadata meta = new Metadata(200, "Kode (Kel) tidak ada.");
	        return ResponseEntity.ok(new ResponseX<>(null, meta));
	    }

	    // Simpan
	    ERMIGDVKHPP saved = eRMIGDVKHPPRepository.save(eRMIGDVKHPP);

	    // Respons sukses
	    Metadata metaOk = new Metadata(200, "Ok");
	    return ResponseEntity.ok(new ResponseX<>(saved, metaOk));
	}
	

	@PutMapping("/ERMIGDVKHPP/")
	public ResponseEntity<EntityModel<ERMIGDVKHPP>> updateERMIGDVKHPP(
	        @RequestParam(name = "id") Long id,
	        @RequestBody ERMIGDVKHPP eRMIGDVKHPP) {

	    // Cek referensi Kel: ubah 404 -> 200 OK
	    Optional<ERMIGDVKHPPKel> cek1 = eRMIGDVKHPPKelRepository.findById(eRMIGDVKHPP.getKel());
	    if (cek1.isEmpty()) {
	        String msg = "Kode Tidak ada..!!";
	        System.out.println(msg);

	        // kembalikan entity kosong (id diisi), 200 OK
	        ERMIGDVKHPP empty = new ERMIGDVKHPP();
	        empty.setId(id); // opsional biar id tetap tampil
	        EntityModel<ERMIGDVKHPP> resource = EntityModel.of(
	                empty,
	                linkTo(methodOn(RegNewController.class).getSPRad(id)).withSelfRel()
	        );
	        return ResponseEntity.ok(resource);
	    }

	    if (eRMIGDVKHPPRepository.findById(id).isPresent()) {

	        List<ERMIGDVKHPPDet> cek = eRMIGDVKHPPDetRepository.findByid(id);
	        if (cek.isEmpty()) {
	            ERMIGDVKHPP hppUpdate = eRMIGDVKHPPRepository.findById(id).map(hpp -> {
	                hpp.setTanggal(eRMIGDVKHPP.getTanggal());
	                hpp.setKel(eRMIGDVKHPP.getKel());
	                return eRMIGDVKHPPRepository.save(hpp);
	            }).get();

	            EntityModel<ERMIGDVKHPP> resource = EntityModel.of(
	                    hppUpdate,
	                    linkTo(methodOn(RegNewController.class).getSPRad(hppUpdate.getId())).withSelfRel()
	            );

	            // tetap 201 Created seperti semula
	            return ResponseEntity
	                    .created(resource.getRequiredLink(IanaLinkRelations.SELF).toUri())
	                    .body(resource);

	        } else {
	            String msg = "Tabel detail ada ID = (" + id + ") jadi nama tidak bisa di update..!!";
	            System.out.println(msg);
	            throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
	        }

	    } else {
	        try {
	            final String msg = "IDReg = " + id + "Tidak ada...!";
	            throw new CustomExceptionS(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
	        } catch (IllegalArgumentException e) {
	            final String msg = "Payload Tidak Valid ...";
	            throw new CustomExceptionS(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
	        }
	    }
	}

	
	@PostMapping("/ERMIGDVKHPPDet/")
    public List<ERMIGDVKHPPDet> saveERMIGDVKHPPDet(@RequestBody List<ERMIGDVKHPPDet> eRMIGDVKHPPDets) {
		//  Cek ID Induk
		for (ERMIGDVKHPPDet eRMIGDVKHPPDet : eRMIGDVKHPPDets) {
			Optional<ERMIGDVKHPP> cek = eRMIGDVKHPPRepository.findById(eRMIGDVKHPPDet.getId());	
			if (cek.isEmpty()) {
				String msg = "Kode (ID) Induk Tidak ada, Silahkan Buat ID Induk terlebih Dahulu..!!";
				System.out.println(msg);
				throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
			}	
				
		//  Cek ID Induk dan ID Kel
			List<ERMIGDVKHPP> cek1 = eRMIGDVKHPPRepository.findByIdAndKel(eRMIGDVKHPPDet.getId(), eRMIGDVKHPPDet.getKel() );	
			if (cek1.isEmpty()) {
				String msg = "Kode (ID) Induk Dan Kode Nama Tidak ada..!!";
				System.out.println(msg);
				throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
			}	
			
		// Cek Kode Kelompok dan Nama
			ERMIGDVKHPPNamaClass eRMIGDVKHPPNamaClass = new ERMIGDVKHPPNamaClass(eRMIGDVKHPPDet.getKel(), eRMIGDVKHPPDet.getNama());
			Optional<ERMIGDVKHPPNama> foundflowDet = eRMIGDVKHPPNamaRepository.findById(eRMIGDVKHPPNamaClass);
			if (foundflowDet.isEmpty()) {
				final String msg = "Kode kelompok dan nama tidak terhubung";
				throw new CustomExceptionS(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
			} 			
 
		//  Cek Kode Kelompok
			Optional<ERMIGDVKHPPKel> cek2 = eRMIGDVKHPPKelRepository.findById(eRMIGDVKHPPDet.getKel());	
			if (cek2.isEmpty()) {
				String msg = "Kode Kelompok Tidak ada";
				System.out.println(msg);
				throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
			}	
		
		//  Cek Kode Nama
			List<ERMIGDVKHPPNama> cek3 = eRMIGDVKHPPNamaRepository.findByid(eRMIGDVKHPPDet.getNama());	
			if (cek3.isEmpty()) {
				String msg = "Kode Nama Tidak ada";
				System.out.println(msg);
				throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
			}	
	
		// Cek Data Sudah Ada
			ERMIGDVKHPPDetClass eRMIGDVKHPPDetClass = new ERMIGDVKHPPDetClass(eRMIGDVKHPPDet.getId(), eRMIGDVKHPPDet.getNama());
			Optional<ERMIGDVKHPPDet> cek4 = eRMIGDVKHPPDetRepository.findById(eRMIGDVKHPPDetClass);
	
			if (cek4.isPresent()) {
				final String msg = "Data sudah ada, Silahkan Cek Kembali...!";
				throw new CustomExceptionS(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
			} 			
 		}
		return (List<ERMIGDVKHPPDet>) eRMIGDVKHPPDetRepository.saveAll(eRMIGDVKHPPDets);			
	}
	
	@PutMapping("/ERMIGDVKHPPDet/")
	public List<ERMIGDVKHPPDet> updateERMIGDVKHPPDet(@RequestBody List<ERMIGDVKHPPDet> eRMIGDVKHPPDets) {		
			//  Cek ID Induk
			for (ERMIGDVKHPPDet eRMIGDVKHPPDet : eRMIGDVKHPPDets) {
				Optional<ERMIGDVKHPP> cek = eRMIGDVKHPPRepository.findById(eRMIGDVKHPPDet.getId());	
				if (cek.isEmpty()) {
					String msg = "Kode (ID) Induk Tidak ada, Silahkan Buat ID Induk terlebih Dahulu..!!";
					System.out.println(msg);
					throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
				}	

			// Cek Kode Kelompok dan Nama
				ERMIGDVKHPPNamaClass eRMIGDVKHPPNamaClass = new ERMIGDVKHPPNamaClass(eRMIGDVKHPPDet.getKel(), eRMIGDVKHPPDet.getNama());
				Optional<ERMIGDVKHPPNama> foundflowDet = eRMIGDVKHPPNamaRepository.findById(eRMIGDVKHPPNamaClass);
				if (foundflowDet.isEmpty()) {
					final String msg = "Kode kelompok dan nama tidak terhubung";
					throw new CustomExceptionS(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
				} 			
				
			//  Cek Kode Kelompok
				Optional<ERMIGDVKHPPKel> cek2 = eRMIGDVKHPPKelRepository.findById(eRMIGDVKHPPDet.getKel());	
				if (cek2.isEmpty()) {
					String msg = "Kode Kelompok Tidak ada";
					System.out.println(msg);
					throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
				}	
			
			//Cek Kode Nama 
				List<ERMIGDVKHPPNama> cek3 = eRMIGDVKHPPNamaRepository.findByid(eRMIGDVKHPPDet.getNama());	
				if (cek3.isEmpty()) {
					String msg = "Kode Nama Tidak ada";
					System.out.println(msg);
					throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
				}	
			ERMIGDVKHPPDetClass eRMIGDVKHPPDetClass = new ERMIGDVKHPPDetClass(eRMIGDVKHPPDet.getId(), eRMIGDVKHPPDet.getNama());
			Optional<ERMIGDVKHPPDet> cek4 = eRMIGDVKHPPDetRepository.findById(eRMIGDVKHPPDetClass);
	
			if (cek4.isEmpty()) {
			final String msg = "Data tidak ada, Silahkan Cek Kembali...!";
				throw new CustomExceptionS(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
				} 			
			eRMIGDVKHPPDetRepository.UpdateERMRisikoHPPAdmisiNPersalinanDet(eRMIGDVKHPPDet.getId(), eRMIGDVKHPPDet.getNama(), eRMIGDVKHPPDet.getKet());
		} 
		return eRMIGDVKHPPDets;
	}
	
	@DeleteMapping("/ERMIGDVKHPPDet/")
	public List<ERMIGDVKHPPDet> deleteERMIGDVKHPPDet(@RequestBody List<ERMIGDVKHPPDet> eRMIGDVKHPPDets) {
			//  Cek ID Induk
			for (ERMIGDVKHPPDet eRMIGDVKHPPDet : eRMIGDVKHPPDets) {
				Optional<ERMIGDVKHPP> cek = eRMIGDVKHPPRepository.findById(eRMIGDVKHPPDet.getId());	
				if (cek.isEmpty()) {
					String msg = "Kode (ID) Induk Tidak ada, Silahkan Buat ID Induk terlebih Dahulu..!!";
					System.out.println(msg);
					throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
				}	
					
			// Cek Kode Kelompok dan Nama
				ERMIGDVKHPPNamaClass eRMIGDVKHPPNamaClass = new ERMIGDVKHPPNamaClass(eRMIGDVKHPPDet.getKel(), eRMIGDVKHPPDet.getNama());
				Optional<ERMIGDVKHPPNama> cek2 = eRMIGDVKHPPNamaRepository.findById(eRMIGDVKHPPNamaClass);
				if (cek2.isEmpty()) {
					final String msg = "Kode kelompok dan nama tidak terhubung";
					throw new CustomExceptionS(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
				} 			
	
			//  Cek Kode Kelompok
				Optional<ERMIGDVKHPPKel> cek3 = eRMIGDVKHPPKelRepository.findById(eRMIGDVKHPPDet.getKel());	
				if (cek3.isEmpty()) {
					String msg = "Kode Kelompok Tidak ada";
					System.out.println(msg);
					throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
				}	
						
			//Cek Kode Nama 
				List<ERMIGDVKHPPNama> cek4 = eRMIGDVKHPPNamaRepository.findByid(eRMIGDVKHPPDet.getNama());	
				if (cek4.isEmpty()) {
					String msg = "Kode Nama Tidak ada";
					System.out.println(msg);
					throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
				}	
	
				ERMIGDVKHPPDetClass eRMIGDVKHPPDetClass = new ERMIGDVKHPPDetClass(eRMIGDVKHPPDet.getId(), eRMIGDVKHPPDet.getNama());
				Optional<ERMIGDVKHPPDet> foundflowDet = eRMIGDVKHPPDetRepository.findById(eRMIGDVKHPPDetClass);
				if (foundflowDet.isEmpty()) {
					final String msg = "Data tidak ada, Silahkan Cek Kembali...!";
					throw new CustomExceptionS(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
				} 
				eRMIGDVKHPPDetRepository.deleteById(eRMIGDVKHPPDetClass);		
			}
			String msg = "Berhasil";
			System.out.println("delete record ERMIGDVKHPPDet");
			throw new CustomExceptionS(HttpStatus.OK.value(), msg, HttpStatus.OK);
	}
	
	@GetMapping("/SPPAPeriksa")
	public ResponseEntity<?> SPPAPeriksa(
	        @RequestParam(required = false) Long id,
	        @RequestParam(required = false) String nama) {

	    if (id != null) {
	        return sPPAPeriksaRepository.findById(id)
	                .map(ResponseEntity::ok)
	                .orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    List<SPPAPeriksa> result;

	    if (nama != null && !nama.isEmpty()) {
	        result = sPPAPeriksaRepository.findByPerikContainingIgnoreCaseOrderByPerikAsc(nama);
	    } else {
	        result = sPPAPeriksaRepository.findTop20ByOrderByPerikAsc();
	    }

	    return ResponseEntity.ok(result);
	}
	
	@GetMapping("/SPPA/{id}")
	public ResponseEntity<?> SPPAById(@PathVariable Long id) {
	    List<SPPA> result = sPPARepository.findByid(id);

	    if (result == null || result.isEmpty()) {
	        String msg = "ID = (" + id + ") PA Belum ada..!!";
	        Map<String, Object> body = new HashMap<>();
	        body.put("message", msg);
	        body.put("code", 200);
	        return ResponseEntity.ok(body); // HTTP 200
	    }

	    return ResponseEntity.ok(result); // HTTP 200 + data
	}

	
	@GetMapping("/SPPAV2/{id}")
	public ResponseEntity<List<SPPADgDet>> SPPAV2ById(@PathVariable Long id) {
	    List<SPPADgDet> dataList = sPPADgDetRepository.findByid(id);

	    if (dataList == null || dataList.isEmpty()) {
	        System.out.println("ID = (" + id + ") PA Belum ada..!!");
	        return ResponseEntity.ok(java.util.Collections.emptyList()); // 200 + []
	    }

	    // Set detail untuk tiap item
	    dataList.forEach(data -> {
	        List<SPPADet> details = sPPADetRepository.findByNo(data.getNo());
	        data.setSppadets(details == null ? java.util.Collections.emptyList() : details);
	    });

	    return ResponseEntity.ok(dataList);
	}

	
	
	 @PostMapping("/SPPADet/")
	    public ResponseEntity<ResponseX<SPPADet, Metadata>> addSPPADet(@RequestBody SPPADet sppadDet) {
	        try {
	            SPPADet saved = sPPADetRepository.save(sppadDet);
	            Metadata metadata = new Metadata(HttpStatus.CREATED.value(), "Data berhasil disimpan");
	            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseX<>(saved, metadata));
	        } catch (Exception e) {
	            Metadata metadata = new Metadata(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Gagal menyimpan: " + e.getMessage());
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseX<>(sppadDet, metadata));
	        }
	    }
	
	@PostMapping("/SPPA/")
	ResponseEntity<ResponseX<SPPA, Metadata>> addSPPA(@RequestBody SPPA sPPA) {
		SPPA regSave;
		if (sPPA.getLokasiOrgan().isBlank() || sPPA.getLokasiOrgan().isEmpty()) {
			String msg = "Lokasi Organ Tidak Boleh Kosong";
			System.out.println(msg);
			throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		if (sPPA.getKetKlinik().isBlank() || sPPA.getKetKlinik().isEmpty()) {
			String msg = "Keterangan Klinik Tidak Boleh Kosong";
			System.out.println(msg);
			throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
		}		
	/*	if (sPPA.getRiwayatLab().isBlank() || sPPA.getRiwayatLab().isEmpty()) {
			String msg = "Riwayat Lab Tidak Boleh Kosong";
			System.out.println(msg);
			throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
		} */
		if (sPPA.getId() == null)  {
			String msg = "ID = IDReg(Px) Tidak Boleh Kosong Atau PX Sudah Pulang";
			System.out.println(msg);
			throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		if (sPPA.getIdDokter() == null)  {
			String msg = "ID = ID Dokter Tidak Boleh Kosong";
			System.out.println(msg);
			throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		if (sPPA.getLokasiOrgan().length()>=200 
			//	regPxOL.getNama().length()>=31)
				|| sPPA.getDiagnosaKlinik().length()>=200 
				|| sPPA.getFiksatif().length()>=200 
				|| sPPA.getBiopsi().length()>=200 
				|| sPPA.getSputurn().length()>=200				 	
				|| sPPA.getKetKlinik().length()>=200
				|| sPPA.getRiwayatLab().length()>=200) {
			String msg = "Panjang Max 200 Karakter";
			System.out.println(msg);
			throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		
		Optional<DokterERM> cek = dokterERMRepository.findById(sPPA.getIdDokter());
		if (cek.isEmpty()) {
			String msg = "ID (Kode) Dokter tidak diketahui, silahkan Hub EDP..!!";
			System.out.println(msg);
			throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		if (sPPA.getKelasID() == null)  {
			String msg = "IDKelas Tidak Boleh Kosong";
			System.out.println(msg);
			throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
		}		
		if (sPPA.getRoomID() == null) {
			String msg = "IDRoom Tidak Boleh Kosong";
			System.out.println(msg);
			throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
		}		
		if (sPPARepository.findById(sPPA.getId()).isPresent()) {
			final String msg = "Data Sudah Di Input ...!";
			throw new CustomExceptionS(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
		} else {
			try {
				regSave = sPPARepository.save(sPPA);
			} catch (IllegalArgumentException e) {
				final String msg = "Payload Tidak Valid ...";
				throw new CustomExceptionS(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
			}
		}

		final String messageOk = "Ok";
		Metadata metadata = new Metadata(HttpStatus.OK.value(), messageOk);
		ResponseX<SPPA, Metadata> responseX = new ResponseX<>(regSave, metadata);
		return ResponseEntity.ok(responseX);
	}	
	
	@PostMapping("/SPPAV2/")
	ResponseEntity<ResponseX<SPPADgDet, Metadata>> addSPPAV2(@RequestBody SPPADgDet sPPA) {
		SPPADgDet regSave;
		if (sPPA.getLokasiOrgan().isBlank() || sPPA.getLokasiOrgan().isEmpty()) {
			String msg = "Lokasi Organ Tidak Boleh Kosong";
			System.out.println(msg);
			throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		if (sPPA.getKetKlinik().isBlank() || sPPA.getKetKlinik().isEmpty()) {
			String msg = "Keterangan Klinik Tidak Boleh Kosong";
			System.out.println(msg);
			throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
		}		
		if (sPPA.getId() == null)  {
			String msg = "ID = IDReg(Px) Tidak Boleh Kosong Atau PX Sudah Pulang";
			System.out.println(msg);
			throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		if (sPPA.getIdDokter() == null)  {
			String msg = "ID = ID Dokter Tidak Boleh Kosong";
			System.out.println(msg);
			throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		if (sPPA.getLokasiOrgan().length()>=200 
			//	regPxOL.getNama().length()>=31)
				|| sPPA.getDiagnosaKlinik().length()>=200 
				|| sPPA.getFiksatif().length()>=200 
				|| sPPA.getBiopsi().length()>=200 
				|| sPPA.getSputurn().length()>=200				 	
				|| sPPA.getKetKlinik().length()>=200
				|| sPPA.getRiwayatLab().length()>=200) {
			String msg = "Panjang Max 200 Karakter";
			System.out.println(msg);
			throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		
		Optional<DokterERM> cek = dokterERMRepository.findById(sPPA.getIdDokter());
		if (cek.isEmpty()) {
			String msg = "ID (Kode) Dokter tidak diketahui, silahkan Hub EDP..!!";
			System.out.println(msg);
			throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		if (sPPA.getKelasID() == null)  {
			String msg = "IDKelas Tidak Boleh Kosong";
			System.out.println(msg);
			throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
		}		
		if (sPPA.getRoomID() == null) {
			String msg = "IDRoom Tidak Boleh Kosong";
			System.out.println(msg);
			throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
		}		
		if (sPPARepository.findById(sPPA.getId()).isPresent()) {
			final String msg = "Data Sudah Di Input ...!";
			throw new CustomExceptionS(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
		}  try {
	        // Simpan header SPPA
	        regSave = sPPADgDetRepository.save(sPPA);

	        // Simpan detail SPPADet jika ada
	        if (sPPA.getSppadets() != null && !sPPA.getSppadets().isEmpty()) {
	            for (SPPADet detail : sPPA.getSppadets()) {
	            	 Long sppaNo = regSave.getNo();
	            	 detail.setNo(sppaNo); // Set foreign key ke SPPA.no
	                sPPADetRepository.save(detail);
	            }
	        }
	    } catch (Exception e) {
	        throw new CustomExceptionS(500, "Gagal menyimpan data: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }

	    Metadata metadata = new Metadata(HttpStatus.OK.value(), "Data berhasil disimpan");
	    ResponseX<SPPADgDet, Metadata> responseX = new ResponseX<>(regSave, metadata);
	    return ResponseEntity.ok(responseX);
	}	
	
	@PutMapping("/SPPA/")
	ResponseEntity<EntityModel<SPPA>> updateSPPA(@RequestParam(name = "no") Long no, @RequestBody SPPA sPPA)
		//	throws URISyntaxException 
	{	
		if (sPPARepository.findById(no).isPresent()) {
			
			Optional<SPPACek> cek = sPPACekRepository.findById(no);
			if (cek.isPresent()) {
				String msg = "SP PA sudah di proses, silhakan buat SP baru..!!";
				System.out.println(msg);
				throw new CustomException(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
			}
			if (sPPA.getLokasiOrgan().isBlank() || sPPA.getLokasiOrgan().isEmpty()) {
				String msg = "Lokasi Organ Tidak Boleh Kosong";
				System.out.println(msg);
				throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
			}
			if (sPPA.getKetKlinik().isBlank() || sPPA.getKetKlinik().isEmpty()) {
				String msg = "Keterangan Klinik Tidak Boleh Kosong";
				System.out.println(msg);
				throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
			}		
		/*	if (sPPA.getRiwayatLab().isBlank() || sPPA.getRiwayatLab().isEmpty()) {
				String msg = "Riwayat Lab Tidak Boleh Kosong";
				System.out.println(msg);
				throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
			} */
			if (sPPA.getLokasiOrgan().length()>=200 
					|| sPPA.getDiagnosaKlinik().length()>=200 
					|| sPPA.getFiksatif().length()>=200 
					|| sPPA.getBiopsi().length()>=200 
					|| sPPA.getSputurn().length()>=200				 	
					|| sPPA.getKetKlinik().length()>=200
					|| sPPA.getRiwayatLab().length()>=200) {
				String msg = "Panjang Max 200 Karakter";
				System.out.println(msg);
				throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
			}
			
			SPPA sPPAUpdate = sPPARepository.findById(no).map(sPP -> {
				sPP.setId(sPPA.getId());
				sPP.setIdDokter(sPPA.getIdDokter());
				sPP.setTgl(sPPA.getTgl());
				sPP.setJam(sPPA.getJam());
				sPP.setLokasiOrgan(sPPA.getLokasiOrgan());
				sPP.setDiagnosaKlinik(sPPA.getDiagnosaKlinik());
				sPP.setFiksatif(sPPA.getFiksatif());
				sPP.setBiopsi(sPPA.getBiopsi());
				sPP.setSputurn(sPPA.getSputurn());
				sPP.setJamOp(sPPA.getJamOp());
				sPP.setJamSampel(sPPA.getJamSampel());
				sPP.setKetKlinik(sPPA.getKetKlinik());
				sPP.setRiwayatLab(sPPA.getRiwayatLab());
				
				return sPPARepository.save(sPP);
			}).get();

			EntityModel<SPPA> resource = EntityModel.of(sPPAUpdate,
					linkTo(methodOn(ERMController.class).SPPAById(sPPAUpdate.getId())).withSelfRel());

			return ResponseEntity.created(resource.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(resource);
		
		} else {
			try {
				final String msg = "ID data SP Tidak ada...!";
				throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);			
					
				} catch (IllegalArgumentException e) {
				final String msg = "Payload Tidak Valid ...";
				throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
			}
		}	
	}
	
	@PutMapping("/SPPAV2/")
//	ResponseEntity<EntityModel<SPPADgDet>> updateSPPAV2(@RequestParam(name = "no") Long no, @RequestBody SPPADgDet sPPA)
	public ResponseEntity<SPPADgDet> updateSPPAV2(@RequestParam(name = "no") Long no, @RequestBody SPPADgDet sPPA)

	{	
		if (sPPARepository.findById(no).isPresent()) {
			
			Optional<SPPACek> cek = sPPACekRepository.findById(no);
			if (cek.isPresent()) {
				String msg = "SP PA sudah di proses, silhakan buat SP baru..!!";
				System.out.println(msg);
				throw new CustomException(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
			}
			if (sPPA.getLokasiOrgan().isBlank() || sPPA.getLokasiOrgan().isEmpty()) {
				String msg = "Lokasi Organ Tidak Boleh Kosong";
				System.out.println(msg);
				throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
			}
			if (sPPA.getKetKlinik().isBlank() || sPPA.getKetKlinik().isEmpty()) {
				String msg = "Keterangan Klinik Tidak Boleh Kosong";
				System.out.println(msg);
				throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
			}		
		/*	if (sPPA.getRiwayatLab().isBlank() || sPPA.getRiwayatLab().isEmpty()) {
				String msg = "Riwayat Lab Tidak Boleh Kosong";
				System.out.println(msg);
				throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
			} */
			if (sPPA.getLokasiOrgan().length()>=200 
					|| sPPA.getDiagnosaKlinik().length()>=200 
					|| sPPA.getFiksatif().length()>=200 
					|| sPPA.getBiopsi().length()>=200 
					|| sPPA.getSputurn().length()>=200				 	
					|| sPPA.getKetKlinik().length()>=200
					|| sPPA.getRiwayatLab().length()>=200) {
				String msg = "Panjang Max 200 Karakter";
				System.out.println(msg);
				throw new CustomExceptionS(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
			}
			
			// ... existing code

			SPPADgDet sPPAUpdate = sPPADgDetRepository.findById(no).map(sPP -> {
			    sPP.setId(sPPA.getId());
			    sPP.setIdDokter(sPPA.getIdDokter());
			    sPP.setTgl(sPPA.getTgl());
			    sPP.setJam(sPPA.getJam());
			    sPP.setLokasiOrgan(sPPA.getLokasiOrgan());
			    sPP.setDiagnosaKlinik(sPPA.getDiagnosaKlinik());
			    sPP.setFiksatif(sPPA.getFiksatif());
			    sPP.setBiopsi(sPPA.getBiopsi());
			    sPP.setSputurn(sPPA.getSputurn());
			    sPP.setJamOp(sPPA.getJamOp());
			    sPP.setJamSampel(sPPA.getJamSampel());
			    sPP.setKetKlinik(sPPA.getKetKlinik());
			    sPP.setRiwayatLab(sPPA.getRiwayatLab());

			    return sPPADgDetRepository.save(sPP);
			}).get();

			// 1. Hapus detail lama
			List<SPPADet> existingDetails = sPPADetRepository.findByNo(no);
			sPPADetRepository.deleteAll(existingDetails);

			// 2. Simpan detail baru
			if (sPPA.getSppadets() != null && !sPPA.getSppadets().isEmpty()) {
			    for (SPPADet detail : sPPA.getSppadets()) {
			        if (detail.getPerik() == null) {
			            throw new CustomExceptionS(422, "Field 'Nama jenis PA' tidak boleh kosong", HttpStatus.UNPROCESSABLE_ENTITY);
			        }

			        detail.setNo(no);       // relasi ke header SP
			        detail.setId(null);     // biar dianggap insert baru
			        sPPADetRepository.save(detail);
			    }
			}

			// 3. Set kembali sppadets ke objek yg akan direturn
			List<SPPADet> savedDetails = sPPADetRepository.findByNo(no);
			sPPAUpdate.setSppadets(savedDetails);

			return ResponseEntity.ok(sPPAUpdate);

		} else {
			try {
				final String msg = "ID data SP Tidak ada...!";
				throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);			
					
				} catch (IllegalArgumentException e) {
				final String msg = "Payload Tidak Valid ...";
				throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
			}
		}	
	}
	
	@DeleteMapping("/SPPA/")
	public ResponseEntity<?> deleteSPPA(@RequestParam(name = "no") Long no) {
	    Optional<SPPADgDet> sppaOpt = sPPADgDetRepository.findById(no);

	    if (sppaOpt.isPresent()) {
	    	Optional<SPPACek> cek = sPPACekRepository.findById(no);
			if (cek.isPresent()) {
				String msg = "SP PA sudah di proses, silhakan buat SP baru..!!";
				System.out.println(msg);
				throw new CustomException(HttpStatus.UNPROCESSABLE_ENTITY.value(), msg, HttpStatus.UNPROCESSABLE_ENTITY);
			}
	        // 1. Hapus detail terlebih dahulu
	        List<SPPADet> details = sPPADetRepository.findByNo(no);
	        sPPADetRepository.deleteAll(details);

	        // 2. Hapus header/main record
	        sPPADgDetRepository.deleteById(no);

	        String msg = "Data SP PA dengan no " + no + " berhasil dihapus.";
	        Metadata metadata = new Metadata(HttpStatus.OK.value(), msg);
	        return ResponseEntity.ok(metadata);
	    } else {
	        // UBAH: sebelumnya lempar 404, kini 200 OK + metadata
	        String msg = "Data SP PA dengan no = " + no + " tidak ditemukan.";
	        Metadata metadata = new Metadata(HttpStatus.OK.value(), msg);
	        return ResponseEntity.ok(metadata);
	    }
	}
	
	@GetMapping("/ObatPPRA/")
	List<ObatPPRA> getById(@RequestParam(name = "idreg") Long idreg) {
		return obatPPRAService.getById(idreg);
	}
	
	@GetMapping("/Obat/")
	public ResponseEntity<?> getObat(
	        @RequestParam(required = false) String id,
	        @RequestParam(required = false) String nama,
	        @RequestParam(required = false) String generik) {

	    // 1. Cari berdasarkan ID (kode)
	    if (id != null && !id.isEmpty()) {
	        return obatRepository.findById(id)
	                .map(ResponseEntity::ok)
	                .orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    // 2. Cari berdasarkan generik
	    if (generik != null && !generik.isEmpty()) {
	        List<Obat> listGenerik = obatRepository.findByGenerikContainingIgnoreCaseOrderByGenerikAsc(generik);
	        return listGenerik.isEmpty()
	                ? ResponseEntity.notFound().build()
	                : ResponseEntity.ok(listGenerik);
	    }

	    List<Obat> result;

	    // 3. Cari berdasarkan nama
	    if (nama != null && !nama.isEmpty()) {
	        result = obatRepository.findByNamaContainingIgnoreCaseOrderByNamaAsc(nama);
	    } else {
	        // 4. Default: ambil 20 obat pertama
	        result = obatRepository.findTop20ByOrderByNamaAsc();
	     //   result = obatRepository.findAll();
	    }

	    return ResponseEntity.ok(result);
	}	
		
	@GetMapping("/Signa/")
	public ResponseEntity<?> getSigna(
	        @RequestParam(required = false) Long id,
	        @RequestParam(required = false) String signa) {

	    if (id != null) {
	        return signaService.getById(id)
	                .map(ResponseEntity::ok)
	                .orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    List<Signa> result;
	    if (signa != null && !signa.isEmpty()) {
	        result = signaService.searchBySigna(signa);
	    } else {
	        result = signaService.getTop20();
	    }

	    return ResponseEntity.ok(result);
	}
	
	@GetMapping("/Angka/")
	public ResponseEntity<?> getAngka(
	        @RequestParam(required = false) Long id,
	        @RequestParam(required = false) String bilangan) {

	    // Get by exact ID (primary key)
	    if (id != null) {
	        return angkaRepository.findById(id)
	                .map(ResponseEntity::ok)
	                .orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    List<Angka> result;

	    // Search by bilangan (string contains)
	    if (bilangan != null && !bilangan.isEmpty()) {
	        result = angkaRepository.searchByBilanganLike(bilangan);
	    } else {
	        result = angkaRepository.findTop20ByOrderByBilanganAsc();
	    }

	    return ResponseEntity.ok(result);
	}
	
	private boolean isValidToken(String token) {
		try {
		        // Hapus prefix Bearer jika ada	
		    // Hapus "Bearer " dari token
		    if (token.startsWith("Bearer ")) {
		        token = token.substring(7);
		    }
		    String secretKey = "your-secret-key-should-be-very-long";
	
	        // Validasi token
	        Jwts.parserBuilder()
	                .setSigningKey(Keys.hmacShaKeyFor(secretKey.getBytes()))
	                .build()
	                .parseClaimsJws(token);
	
	        return true; // Token valid
	    } catch (JwtException e) {
	        return false; // Token tidak valid
	    }
	}	
	
	@PostMapping("/ResepOL2/")
	ResponseEntity<ResponseX<ResepOLResponseModel, Metadata>> addResepOL2(
			@RequestHeader("Authorization") String token,
			@RequestBody ResepOLModel resepOLModel) {
		// Validasi token
	    if (!isValidToken(token)) {
	        String msg = "Invalid or missing token.";
	        return RespErResepOL.ErResp(msg, resepOLModel);
	    }
	    // Validasi request body
	    if (resepOLModel.getIdReg() == null) {
	        String msg = "ID = IDReg(Px) Tidak Boleh Kosong Atau PX Sudah Pulang (ResepOL RI)";
	        return RespErResepOL.ErResp(msg, resepOLModel);
	    }
	    if (resepOLModel.getIdDokter() == null) {
	        String msg = "ID = ID Dokter Tidak Boleh Kosong";
	        return RespErResepOL.ErResp(msg, resepOLModel);
	    }

	    Optional<DokterERM> cek = dokterERMRepository.findById(resepOLModel.getIdDokter());
	    if (cek.isEmpty()) {
	        String msg = "ID (Kode) Dokter tidak diketahui, silahkan Hubungi EDP..!!";
	        return RespErResepOL.ErResp(msg, resepOLModel);
	    }
	    if (resepOLModel.getKelasID() == null) {
	        String msg = "IDKelas Tidak Boleh Kosong";
	        return RespErResepOL.ErResp(msg, resepOLModel);
	    }
	    if (resepOLModel.getRoomID() == null) {
	        String msg = "IDRoom Tidak Boleh Kosong";
	        return RespErResepOL.ErResp(msg, resepOLModel);
	    }

	    Date date = resepOLModel.getTgl();
	    LocalDate tgPx = date.toInstant().atZone(ZoneId.of("Asia/Jakarta")).toLocalDate();
	    ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Jakarta"));
	    ZonedDateTime yesterdayJakarta = zonedDateTime.minusDays(1);
	    LocalDate isNow = yesterdayJakarta.toLocalDate();
	    if (isNow.isAfter(tgPx) || isNow.isEqual(tgPx)) {
	        String msg = "Tanggal harus sama atau lebih besar dari hari ini..!!";
	        return RespErResepOL.ErResp(msg, resepOLModel);
	    }

	    ResepOLResponseModel response = null;
	    try {
	        // Simpan Header
	        ResepOL header = new ResepOL();
	        header.setTgl(resepOLModel.getTgl());
	        header.setJam(resepOLModel.getJam());
	        header.setIdReg(resepOLModel.getIdReg());
	        header.setIdDokter(resepOLModel.getIdDokter());
	        header.setKelasID(resepOLModel.getKelasID());
	        header.setRoomID(resepOLModel.getRoomID());
	        header.setManual(resepOLModel.getManual());
	        ResepOL savedHeader = resepOLRepository.save(header);

	        Long orderId = savedHeader.getId();
	        
	        //simpan Sub Obat Details
	        List<ContensTab> subDetails = resepOLModel.getObatList().stream()
	                .flatMap(obAtRspModel -> obAtRspModel.getRacikanList().stream())
	                .map(subDTO -> {
	                	 // Validasi mfdtd
	                    if (subDTO.getMfdtd() == null) {
	                        String msg = "ID = Mfdtd tidak boleh kosong!";
	                        throw new IllegalArgumentException(msg); // Lempar exception	                        
	                    }

	                    // Validasi Obat dengan Mfdtd
	                    Optional<Obat> ob = obatRepository.findByKodeAndRacikan(subDTO.getMfdtd(), true);
	                 // Validasi jika racikan == false
	                    if (ob.isEmpty()) {
	                        throw new IllegalArgumentException("Obat dengan kode " + subDTO.getMfdtd() + " tidak mendukung racikan!");
	                    }
	                    
	              /*      Optional<Obat> ob = obatService.getObatByKode(subDTO.getMfdtd());
	                    if (ob.isEmpty()) {
	                        String msg = "Obat dengan kode " + subDTO.getMfdtd() + " tidak ditemukan!";
	                        throw new IllegalArgumentException(msg); // Lempar exception
	                    } */
	                    
	                	ContensTab subDetail = new ContensTab();
	                	subDetail.setId(orderId);
	                	subDetail.setMfdtd(subDTO.getMfdtd());
	                	subDetail.setKode(subDTO.getKode());
	                	subDetail.setQty(subDTO.getQty());	
	                	subDetail.setRasio(subDTO.getRasio());	
	    	            return subDetail;
	    	        }).collect(Collectors.toList());
	        
	        contensTabRepository.saveAll(subDetails);	
	        
	        // Simpan Obat Detail
	        List<ObAtRsp> detail1List = resepOLModel.getObatList().stream().map(dto -> {
	        	if (dto.getKode() == null) {
                    String msg = "Kode Obat tidak boleh kosong!";
                    throw new IllegalArgumentException(msg); // Lempar exception	                        
                }
	            ObAtRsp detail1 = new ObAtRsp();
	            detail1.setId(orderId);
	            detail1.setKode(dto.getKode());
	            detail1.setQty(dto.getQty());
	            detail1.setSigna(dto.getSigna());       
	            	            	
	                 // Isi racikanList secara manual
		            List<ContensTab> racikanList = fetchRacikanListForObat(orderId, dto.getKode());
		     //       System.out.println("Fetched racikanList: " + racikanList);
		            detail1.setRacikanList(racikanList);
		            return detail1;
	        }).collect(Collectors.toList());
	        obAtRspRepository.saveAll(detail1List);
	        
	        // Isi response model
	        response = new ResepOLResponseModel();
	        response.setId(savedHeader.getId());
	        response.setTgl(savedHeader.getTgl());
	        response.setJam(savedHeader.getJam());
	        response.setIdReg(savedHeader.getIdReg());
	        response.setIdDokter(savedHeader.getIdDokter());
	        response.setKelasID(savedHeader.getKelasID());
	        response.setRoomID(savedHeader.getRoomID());
	        response.setManual(savedHeader.getManual());
	        response.setObatList(detail1List) ;
	     //   response.setRacikanList(subDetails);

	    } catch (IllegalArgumentException e) {
	        String msg = "Payload Tidak Valid ...";
	        return RespErResepOL.ErResp(msg, resepOLModel);
	    }

	    // Return successful response
	    final String messageOk = "Ok";
	    Metadata metadata = new Metadata(HttpStatus.OK.value(), messageOk);
	    ResponseX<ResepOLResponseModel, Metadata> responseX = new ResponseX<>(response, metadata);
	    return ResponseEntity.ok(responseX);
	}
	
	@PostMapping("/ResepOL/")
	ResponseEntity<ResponseX<ResepOLResponseModel, Metadata>> addResepOL(
	        @RequestHeader("Authorization") String token,
	        @RequestBody ResepOLModel resepOLModel) {

	    if (!isValidToken(token)) {
	        return RespErResepOL.ErResp("Invalid or missing token.", resepOLModel);
	    }

	    if (resepOLModel.getIdReg() == null) {
	        return RespErResepOL.ErResp("IDReg(Px) Tidak Boleh Kosong Atau PX Sudah Pulang (ResepOL RI)", resepOLModel);
	    }

	    if (resepOLModel.getIdDokter() == null) {
	        return RespErResepOL.ErResp("ID Dokter Tidak Boleh Kosong", resepOLModel);
	    }

	    List<ObatUnion> obatList = obatUnionRepository.findByIdReg(resepOLModel.getIdReg());
	    if (!obatList.isEmpty()) {
	        return RespErResepOL.ErResp("E-Resep sudah masuk Invoice, silahkan hubungi Farmasi untuk penambahan Obat", resepOLModel);
	    }

	    Optional<DokterERM> cek = dokterERMRepository.findById(resepOLModel.getIdDokter());
	    if (cek.isEmpty()) {
	        return RespErResepOL.ErResp("ID (Kode) Dokter tidak diketahui, silahkan hubungi EDP.", resepOLModel);
	    }

	    if (resepOLModel.getKelasID() == null) {
	        return RespErResepOL.ErResp("IDKelas Tidak Boleh Kosong", resepOLModel);
	    }

	    if (resepOLModel.getRoomID() == null) {
	        return RespErResepOL.ErResp("IDRoom Tidak Boleh Kosong", resepOLModel);
	    }

	    LocalDate tgPx = resepOLModel.getTgl()
	            .toInstant()
	            .atZone(ZoneId.of("Asia/Jakarta"))
	            .toLocalDate();

	    LocalDate isNow = ZonedDateTime.now(ZoneId.of("Asia/Jakarta"))
	            .minusDays(1)
	            .toLocalDate();

	    if (isNow.isAfter(tgPx) || isNow.isEqual(tgPx)) {
	        return RespErResepOL.ErResp("Tanggal harus sama atau lebih besar dari hari ini.", resepOLModel);
	    }

	    ResepOLResponseModel response = null;

	    try {
	        // Save Header
	        ResepOL header = new ResepOL();
	        header.setTgl(resepOLModel.getTgl());
	        header.setJam(resepOLModel.getJam());
	        header.setIdReg(resepOLModel.getIdReg());
	        header.setIdDokter(resepOLModel.getIdDokter());
	        header.setKelasID(resepOLModel.getKelasID());
	        header.setRoomID(resepOLModel.getRoomID());
	        header.setManual(resepOLModel.getManual());
	        header.setRacikan(resepOLModel.getRacikan());
	        header.setKetInap(resepOLModel.getKetInap());

	        // REVISI: saveAndFlush agar trigger header selesai lebih dulu
	        ResepOL savedHeader = resepOLRepository.saveAndFlush(header);
	        Long orderId = savedHeader.getId();

	        // LOG JSON BODY
	        try {
	            ObjectMapper om = new ObjectMapper();
	            om.setSerializationInclusion(JsonInclude.Include.NON_NULL);
	            String rawJson = om.writeValueAsString(resepOLModel);

	            String tokenHash = sha256(token);
	            String ts = ZonedDateTime.now(ZoneId.of("Asia/Jakarta"))
	                    .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmssSSS"));

	            String envelope = """
	            {
	              "token_sha256": "%s",
	              "received_at": "%s",
	              "order_id": %d,
	              "body": %s
	            }
	            """.formatted(tokenHash, ts, orderId, rawJson);

	            Path dir = Paths.get("D:/logs/resep");
	            Files.createDirectories(dir);

	            Path file = dir.resolve("ResepOL_Post_" + orderId + "_" + ts + ".json");
	            Files.writeString(file, envelope,
	                    StandardOpenOption.CREATE,
	                    StandardOpenOption.TRUNCATE_EXISTING);

	        } catch (Exception logEx) {
	            // jangan gagalkan proses utama hanya karena gagal tulis log
	        }

	        // Save Sub Obat Details / Racikan
	        List<ContensTab> subDetails = resepOLModel.getObatList().stream()
	                .flatMap(obAtRspModel -> obAtRspModel.getRacikanList().stream())
	                .map(contensTabModel -> {

	                    if (contensTabModel.getMfdtd() == null || contensTabModel.getKode() == null) {
	                        throw new IllegalArgumentException("Kode Obat Racikan tidak boleh kosong!");
	                    }

	                    if (contensTabModel.getQty() == null) {
	                        throw new IllegalArgumentException("Jumlah(Qty) Obat Racikan tidak boleh kosong!");
	                    }

	                    if (contensTabModel.getRasio() == null) {
	                        throw new IllegalArgumentException("Jumlah(Rasio) Obat Racikan tidak boleh kosong!");
	                    }

	                    Optional<Obat> obm = obatRepository.findByKode(contensTabModel.getMfdtd());
	                    if (obm.isEmpty()) {
	                        throw new IllegalArgumentException(
	                                "Obat Racikan(M) dengan kode " + contensTabModel.getMfdtd() + " tidak ada di DB Obat!");
	                    }

	                    Optional<Obat> ob = obatRepository.findByKode(contensTabModel.getKode());
	                    if (ob.isEmpty()) {
	                        throw new IllegalArgumentException(
	                                "Obat Racikan dengan kode " + contensTabModel.getKode() + " tidak ada di DB Obat!");
	                    }

	                    Optional<Obat> obRa = obatRepository.findByKodeAndRacikan(contensTabModel.getMfdtd(), true);
	                    if (obRa.isEmpty()) {
	                        throw new IllegalArgumentException(
	                                "Obat Racikan dengan kode " + contensTabModel.getMfdtd() + " tidak ditemukan atau tidak mendukung racikan!");
	                    }

	                    ContensTab subDetail = new ContensTab();
	                    subDetail.setId(orderId);
	                    subDetail.setMfdtd(contensTabModel.getMfdtd());
	                    subDetail.setKode(contensTabModel.getKode());
	                    subDetail.setQty(contensTabModel.getQty());
	                    subDetail.setRasio(contensTabModel.getRasio());

	                    return subDetail;
	                })
	                .collect(Collectors.toList());

	        // REVISI: simpan racikan satu per satu
	        for (ContensTab sub : subDetails) {
	            contensTabRepository.saveAndFlush(sub);
	        }

	        // Save Obat Details
	        List<ObAtRsp> detail1List = new ArrayList<>();

	        for (ObAtRspModel dto : resepOLModel.getObatList()) {

	            if (dto.getKode() == null) {
	                return RespErResepOL.ErResp("Kode Obat tidak boleh kosong!", resepOLModel);
	            }

	            if (dto.getSigna() == null) {
	                return RespErResepOL.ErResp("Signa Obat tidak boleh kosong!", resepOLModel);
	            }

	            if (dto.getQty() == null) {
	                return RespErResepOL.ErResp("Jumlah(Qty) Obat tidak boleh kosong!", resepOLModel);
	            }

	            Optional<Obat> ob = obatRepository.findByKode(dto.getKode());
	            if (ob.isEmpty()) {
	                throw new IllegalArgumentException(
	                        "Obat dengan kode " + dto.getKode() + " tidak ada di DB Obat!");
	            }

	            ObAtRsp detail1 = new ObAtRsp();
	            detail1.setId(orderId);
	            detail1.setKode(dto.getKode());
	            detail1.setQty(dto.getQty());
	            detail1.setSigna(dto.getSigna());
	            detail1.setKet(dto.getKet());

	            List<ContensTab> racikanList = fetchRacikanListForObat(orderId, dto.getKode());
	            detail1.setRacikanList(racikanList);

	            detail1List.add(detail1);
	        }

	        // REVISI: simpan obat utama satu per satu agar trigger aman
	        for (ObAtRsp detail : detail1List) {
	            obAtRspRepository.saveAndFlush(detail);
	        }

	        // Build Response
	        response = new ResepOLResponseModel();
	        response.setId(savedHeader.getId());
	        response.setTgl(savedHeader.getTgl());
	        response.setJam(savedHeader.getJam());
	        response.setIdReg(savedHeader.getIdReg());
	        response.setIdDokter(savedHeader.getIdDokter());
	        response.setKelasID(savedHeader.getKelasID());
	        response.setRoomID(savedHeader.getRoomID());
	        response.setManual(savedHeader.getManual());
	        response.setRacikan(savedHeader.getRacikan());
	        response.setKetInap(savedHeader.getKetInap());
	        response.setObatList(detail1List);

	    } catch (IllegalArgumentException e) {
	        return RespErResepOL.ErResp(e.getMessage(), resepOLModel);
	    }

	    Metadata metadata = new Metadata(HttpStatus.OK.value(), "Ok");
	    ResponseX<ResepOLResponseModel, Metadata> responseX = new ResponseX<>(response, metadata);
	    return ResponseEntity.ok(responseX);
	}
		
	@PostMapping("/ResepOLOld/")
	ResponseEntity<ResponseX<ResepOLResponseModel, Metadata>> addResepOLOld(
	        @RequestHeader("Authorization") String token,
	        @RequestBody ResepOLModel resepOLModel) {
	    // Validate token
	    if (!isValidToken(token)) {
	        String msg = "Invalid or missing token.";
	        return RespErResepOL.ErResp(msg, resepOLModel);
	    }

	    // Validate request body
	    if (resepOLModel.getIdReg() == null) {
	        String msg = "IDReg(Px) Tidak Boleh Kosong Atau PX Sudah Pulang (ResepOL RI)";
	        return RespErResepOL.ErResp(msg, resepOLModel);
	    }
	    if (resepOLModel.getIdDokter() == null) {
	        String msg = "ID Dokter Tidak Boleh Kosong";
	        return RespErResepOL.ErResp(msg, resepOLModel);
	    }
	    
	    List<ObatUnion> obatList = obatUnionRepository.findByIdReg(resepOLModel.getIdReg());
	    if (!obatList.isEmpty()) {
	        String msg = "E-Resep sudah masuk Invoice, silahkan hubungi Farmasi untuk penambahan Obat";
	        return RespErResepOL.ErResp(msg, resepOLModel);
	    } 	 
	    

	    Optional<DokterERM> cek = dokterERMRepository.findById(resepOLModel.getIdDokter());
	    if (cek.isEmpty()) {
	        String msg = "ID (Kode) Dokter tidak diketahui, silahkan hubungi EDP.";
	        return RespErResepOL.ErResp(msg, resepOLModel);
	    }
	    if (resepOLModel.getKelasID() == null) {
	        String msg = "IDKelas Tidak Boleh Kosong";
	        return RespErResepOL.ErResp(msg, resepOLModel);
	    }
	    if (resepOLModel.getRoomID() == null) {
	        String msg = "IDRoom Tidak Boleh Kosong";
	        return RespErResepOL.ErResp(msg, resepOLModel);
	    }

	    // Validate date
	    LocalDate tgPx = resepOLModel.getTgl().toInstant().atZone(ZoneId.of("Asia/Jakarta")).toLocalDate();
	    LocalDate isNow = ZonedDateTime.now(ZoneId.of("Asia/Jakarta")).minusDays(1).toLocalDate();
	    if (isNow.isAfter(tgPx) || isNow.isEqual(tgPx)) {
	        String msg = "Tanggal harus sama atau lebih besar dari hari ini.";
	        return RespErResepOL.ErResp(msg, resepOLModel);
	    }

	    ResepOLResponseModel response = null;
	    try {
	        // Save Header
	        ResepOL header = new ResepOL();
	        header.setTgl(resepOLModel.getTgl());
	        header.setJam(resepOLModel.getJam());
	        header.setIdReg(resepOLModel.getIdReg());
	        header.setIdDokter(resepOLModel.getIdDokter());
	        header.setKelasID(resepOLModel.getKelasID());
	        header.setRoomID(resepOLModel.getRoomID());
	        header.setManual(resepOLModel.getManual());
	        header.setRacikan(resepOLModel.getRacikan());
	        header.setKetInap(resepOLModel.getKetInap());	        
	        ResepOL savedHeader = resepOLRepository.save(header);

	        Long orderId = savedHeader.getId();
	     
	     // --- LOG JSON BODY (mulai) ---
	        try {
	            ObjectMapper om = new ObjectMapper();
	            om.setSerializationInclusion(JsonInclude.Include.NON_NULL);
	            String rawJson = om.writeValueAsString(resepOLModel);

	            String tokenHash = sha256(token);
	            String ts = ZonedDateTime.now(ZoneId.of("Asia/Jakarta"))
	                    .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmssSSS"));

	            String envelope = """
	            {
	              "token_sha256": "%s",
	              "received_at": "%s",
	              "order_id": %d,
	              "body": %s
	            }
	            """.formatted(tokenHash, ts, orderId, rawJson);

	            // >>> Force ke D:\logs\resep (Windows)
	            Path dir = Paths.get("D:/logs/resep");
	            Files.createDirectories(dir);

	            Path file = dir.resolve("ResepOL_Post_" + orderId + "_" + ts + ".json");
	            Files.writeString(file, envelope,
	                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
	        } catch (Exception logEx) {
	            // jangan gagalkan proses utama hanya karena gagal tulis log
	        }
	        // --- LOG JSON BODY (selesai) ---


	        // Save Sub Obat Details
	        List<ContensTab> subDetails = resepOLModel.getObatList().stream()
	                .flatMap(obAtRspModel -> obAtRspModel.getRacikanList().stream())
	                .map(contensTabModel -> { // Replace 'subDTO' with 'contensTabModel'
	                    // Validate mfdtd
	                    if (contensTabModel.getMfdtd() == null || contensTabModel.getKode() == null) {
	                        String msg = "Kode Obat Racikan tidak boleh kosong!";
	                        throw new IllegalArgumentException(msg);
	                    }
	                    
	                    // Validate mfdtd
	                    if (contensTabModel.getQty() == null ) {
	                        String msg = "Jumlah(Qty) Obat Racikan tidak boleh kosong!";
	                        throw new IllegalArgumentException(msg);
	                    }
	                    
	                    // Validate mfdtd
	                    if (contensTabModel.getRasio() == null ) {
	                        String msg = "Jumlah(Rasio) Obat Racikan tidak boleh kosong!";
	                        throw new IllegalArgumentException(msg);
	                    }
	                    
	                    // Validate Obat 
	                    Optional<Obat> obm = obatRepository.findByKode(contensTabModel.getMfdtd());
	                    if (obm.isEmpty()) {
	                        throw new IllegalArgumentException(
	                                "Obat Racikan(M) dengan kode " + contensTabModel.getMfdtd() + " tidak ada di DB Obat!");
	                    }
	                    
	                    Optional<Obat> ob = obatRepository.findByKode(contensTabModel.getKode());
	                    if (ob.isEmpty()) {
	                        throw new IllegalArgumentException(
	                                "Obat Racikan dengan kode " + contensTabModel.getKode() + " tidak ada di DB Obat!");
	                    }

	                    // Validate Obat with mfdtd
	                    Optional<Obat> obRa = obatRepository.findByKodeAndRacikan(contensTabModel.getMfdtd(), true);
	                    if (obRa.isEmpty()) {
	                        throw new IllegalArgumentException(
	                                "Obat Racikan dengan kode " + contensTabModel.getMfdtd() + " tidak ditemukan atau tidak mendukung racikan!");
	                    }

	                    // Create ContensTab
	                    ContensTab subDetail = new ContensTab();
	                    subDetail.setId(orderId);
	                    subDetail.setMfdtd(contensTabModel.getMfdtd());
	                    subDetail.setKode(contensTabModel.getKode());
	                    subDetail.setQty(contensTabModel.getQty());
	                    subDetail.setRasio(contensTabModel.getRasio());
	                    return subDetail;
	                }).collect(Collectors.toList());

	        contensTabRepository.saveAll(subDetails);

	        // Save Obat Details
	        List<ObAtRsp> detail1List = new ArrayList<>();
	        for (ObAtRspModel dto : resepOLModel.getObatList()) {
	            if (dto.getKode() == null) {
	                String msg = "Kode Obat tidak boleh kosong!";
	                return RespErResepOL.ErResp(msg, resepOLModel);
	            }
	            
	            if (dto.getSigna() == null) {
	                String msg = "Signa Obat tidak boleh kosong!";
	                return RespErResepOL.ErResp(msg, resepOLModel);
	            }
	            
	            if (dto.getQty() == null) {
	                String msg = "Jumlah(Qty) Obat tidak boleh kosong!";
	                return RespErResepOL.ErResp(msg, resepOLModel);
	            }
	            
	         // Validate Obat 
                Optional<Obat> ob = obatRepository.findByKode(dto.getKode());
                if (ob.isEmpty()) {
                    throw new IllegalArgumentException(
                            "Obat dengan kode " + dto.getKode() + " tidak ada di DB Obat!");
                }

	            ObAtRsp detail1 = new ObAtRsp();
	            detail1.setId(orderId);
	            detail1.setKode(dto.getKode());
	            detail1.setQty(dto.getQty());
	            detail1.setSigna(dto.getSigna());
	            detail1.setKet(dto.getKet());

	            List<ContensTab> racikanList = fetchRacikanListForObat(orderId, dto.getKode());
	            detail1.setRacikanList(racikanList);
	            detail1List.add(detail1);
	        }
	        obAtRspRepository.saveAll(detail1List);

	        // Build Response
	        response = new ResepOLResponseModel();
	        response.setId(savedHeader.getId());
	        response.setTgl(savedHeader.getTgl());
	        response.setJam(savedHeader.getJam());
	        response.setIdReg(savedHeader.getIdReg());
	        response.setIdDokter(savedHeader.getIdDokter());
	        response.setKelasID(savedHeader.getKelasID());
	        response.setRoomID(savedHeader.getRoomID());
	        response.setManual(savedHeader.getManual());
	        response.setRacikan(savedHeader.getRacikan());
	        response.setKetInap(savedHeader.getKetInap());
	        response.setObatList(detail1List);

	    } catch (IllegalArgumentException e) {
	        String msg = e.getMessage();
	        return RespErResepOL.ErResp(msg, resepOLModel);
	    }

	    // Return successful response
	    final String messageOk = "Ok";
	    Metadata metadata = new Metadata(HttpStatus.OK.value(), messageOk);
	    ResponseX<ResepOLResponseModel, Metadata> responseX = new ResponseX<>(response, metadata);
	    return ResponseEntity.ok(responseX);
	}
	
	private List<ContensTab> fetchRacikanListForObat(Long id, String kd) {
		 //   System.out.println("Fetching racikanList for id: " + id + ", kode: " + kd );
		  //  return contensTabRepository.findByIdAndMfdtd(id, kd) ;
		    List<ContensTab> racikanList = contensTabRepository.findByIdAndMfdtd(id, kd);
		    return racikanList == null ? Collections.emptyList() : racikanList;	    
		}
	
	private static String sha256(String s) {
	    try {
	        MessageDigest md = MessageDigest.getInstance("SHA-256");
	        byte[] d = md.digest(s.getBytes(StandardCharsets.UTF_8));
	        StringBuilder sb = new StringBuilder();
	        for (byte b : d) sb.append(String.format("%02x", b));
	        return sb.toString();
	    } catch (Exception e) { return ""; }
	} 
		
	@PutMapping("/ResepOL/")
	public ResponseEntity<ResponseX<ResepOLResponseModel, Metadata>> updateResepOL(
	        @RequestHeader("Authorization") String token,
	        @RequestBody ResepOLModel resepOLModel) {

	    // Validasi token
	    if (!isValidToken(token)) {
	        return RespErResepOL.ErResp("Invalid or missing token.", resepOLModel);
	    }

	    if (resepOLModel.getId() == null) {
	        return RespErResepOL.ErResp("ID ResepOL wajib dikirim untuk update!", resepOLModel);
	    }

	    Optional<ResepOL> existing = resepOLRepository.findById(resepOLModel.getId());
	    if (existing.isEmpty()) {
	        return RespErResepOL.ErResp("Data ResepOL tidak ditemukan!", resepOLModel);
	    }
	    
	    // Validate request body
	    if (resepOLModel.getIdReg() == null) {
	        String msg = "IDReg(Px) Tidak Boleh Kosong Atau PX Sudah Pulang (ResepOL RI)";
	        return RespErResepOL.ErResp(msg, resepOLModel);
	    }
	    if (resepOLModel.getIdDokter() == null) {
	        String msg = "ID Dokter Tidak Boleh Kosong";
	        return RespErResepOL.ErResp(msg, resepOLModel);
	    }
	    
	    List<ObatUnion> obatList = obatUnionRepository.findByIdReg(resepOLModel.getIdReg());
	    if (!obatList.isEmpty()) {
	        String msg = "E-Resep sudah masuk Invoice, silahkan hubungi Farmasi untuk penambahan Obat";
	        return RespErResepOL.ErResp(msg, resepOLModel);
	    }


	    Optional<DokterERM> cek = dokterERMRepository.findById(resepOLModel.getIdDokter());
	    if (cek.isEmpty()) {
	        String msg = "ID (Kode) Dokter tidak diketahui, silahkan hubungi EDP.";
	        return RespErResepOL.ErResp(msg, resepOLModel);
	    }
	    if (resepOLModel.getKelasID() == null) {
	        String msg = "IDKelas Tidak Boleh Kosong";
	        return RespErResepOL.ErResp(msg, resepOLModel);
	    }
	    if (resepOLModel.getRoomID() == null) {
	        String msg = "IDRoom Tidak Boleh Kosong";
	        return RespErResepOL.ErResp(msg, resepOLModel);
	    }

	    // Validate date
	    LocalDate tgPx = resepOLModel.getTgl().toInstant().atZone(ZoneId.of("Asia/Jakarta")).toLocalDate();
	    LocalDate isNow = ZonedDateTime.now(ZoneId.of("Asia/Jakarta")).minusDays(1).toLocalDate();
	    if (isNow.isAfter(tgPx) || isNow.isEqual(tgPx)) {
	        String msg = "Tanggal harus sama atau lebih besar dari hari ini.";
	        return RespErResepOL.ErResp(msg, resepOLModel);
	    }


	    try {
	        // Update Header
	        ResepOL header = existing.get();
	        header.setTgl(resepOLModel.getTgl());
	        header.setJam(resepOLModel.getJam());
	        header.setIdReg(resepOLModel.getIdReg());
	        header.setIdDokter(resepOLModel.getIdDokter());
	        header.setKelasID(resepOLModel.getKelasID());
	        header.setRoomID(resepOLModel.getRoomID());
	        header.setManual(resepOLModel.getManual());
	        header.setRacikan(resepOLModel.getRacikan());
	        header.setKetInap(resepOLModel.getKetInap());
	        resepOLRepository.save(header);
	        Long orderId = header.getId();
	        
	     // --- LOG JSON BODY (UPDATE) ---
	        try {
	            ObjectMapper om = new ObjectMapper();
	            om.setSerializationInclusion(JsonInclude.Include.NON_NULL);
	            String rawJson = om.writeValueAsString(resepOLModel);

	            String tokenHash = sha256(token);
	            String ts = ZonedDateTime.now(ZoneId.of("Asia/Jakarta"))
	                    .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmssSSS"));

	            String envelope = """
	            {
	              "operation": "update",
	              "token_sha256": "%s",
	              "received_at": "%s",
	              "order_id": %d,
	              "body": %s
	            }
	            """.formatted(tokenHash, ts, orderId, rawJson);

	            // Force tulis ke D:\logs\resep (Windows)
	            Path dir = Paths.get("D:/logs/resep");
	            Files.createDirectories(dir);

	            Path file = dir.resolve("ResepOL_Put_" + orderId + "_" + ts + ".json");
	            Files.writeString(file, envelope,
	                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
	        } catch (Exception logEx) {
	            // jangan gagalkan proses utama hanya karena gagal tulis log
	        }
	        // --- LOG JSON BODY (SELESAI) ---


	        // Bersihkan data lama
	        obAtRspRepository.deleteById(orderId);
	        contensTabRepository.deleteById(orderId);

	        // Simpan ulang racikan (ContensTab)
	        List<ContensTab> subDetails = resepOLModel.getObatList().stream()
	                .flatMap(ob -> ob.getRacikanList().stream())
	                .map(model -> {
	                    if (model.getMfdtd() == null || model.getKode() == null || model.getQty() == null || model.getRasio() == null) {
	                        throw new IllegalArgumentException("Semua field racikan wajib diisi!");
	                    }
	                    if (obatRepository.findByKode(model.getKode()).isEmpty()) {
	                        throw new IllegalArgumentException("Obat racikan tidak ditemukan: " + model.getKode());
	                    }
	                    if (obatRepository.findByKodeAndRacikan(model.getMfdtd(), true).isEmpty()) {
	                        throw new IllegalArgumentException("Obat racikan M tidak valid: " + model.getMfdtd());
	                    }
	                    return new ContensTab(orderId, model.getMfdtd(), model.getKode(), model.getQty(), model.getRasio());
	                })
	                .collect(Collectors.toList());
	        contensTabRepository.saveAll(subDetails);

	        // Simpan ulang obat utama (ObAtRsp)
	        List<ObAtRsp> detailList = new ArrayList<>();
	        for (ObAtRspModel dto : resepOLModel.getObatList()) {
	            if (dto.getKode() == null || dto.getQty() == null || dto.getSigna() == null) {
	                return RespErResepOL.ErResp("Kode, Qty, dan Signa wajib diisi pada obat!", resepOLModel);
	            }

	            if (obatRepository.findByKode(dto.getKode()).isEmpty()) {
	                throw new IllegalArgumentException("Obat tidak ditemukan: " + dto.getKode());
	            }

	            ObAtRsp detail = new ObAtRsp(orderId, dto.getKode(), dto.getQty(), dto.getSigna(), dto.getKet());
	            List<ContensTab> racikanList = fetchRacikanListForObat(orderId, dto.getKode());
	            detail.setRacikanList(racikanList);
	            detailList.add(detail);
	        }
	        obAtRspRepository.saveAll(detailList);

	        // Build Response
	        ResepOLResponseModel response = new ResepOLResponseModel();
	        response.setId(header.getId());
	        response.setTgl(header.getTgl());
	        response.setJam(header.getJam());
	        response.setIdReg(header.getIdReg());
	        response.setIdDokter(header.getIdDokter());
	        response.setKelasID(header.getKelasID());
	        response.setRoomID(header.getRoomID());
	        response.setManual(header.getManual());
	        response.setRacikan(header.getRacikan());
	        response.setKetInap(header.getKetInap());
	        response.setObatList(detailList);

	        Metadata meta = new Metadata(HttpStatus.OK.value(), "Update berhasil");
	        return ResponseEntity.ok(new ResponseX<>(response, meta));

	    } catch (IllegalArgumentException e) {
	        return RespErResepOL.ErResp(e.getMessage(), resepOLModel);
	    }
	}

	
	@GetMapping("/ResepOL/{id}")
    public ResponseEntity<ResponseX<ResepOLGetResponseModel, Metadata>> ResepOLById(@PathVariable Long id) {
        // Cari data header berdasarkan idReg
        Optional<ResepOL> optionalResepOL  = resepOLRepository.findById(id);

        if (optionalResepOL.isEmpty()) {
            // 200 OK, body = null, metadata message menjelaskan
            Metadata metadata = new Metadata(HttpStatus.OK.value(), "Data not found");
            return ResponseEntity.ok(new ResponseX<>(null, metadata));
        }        
        ResepOL header = optionalResepOL.get();

        // Ambil detail obat berdasarkan header ID
        List<ObAtRspGet> obatList = obAtRspGetRepository.findById(header.getId());

        // Proses setiap detail obat untuk menambahkan racikanList
        for (ObAtRspGet obat : obatList) {
            List<ContensTabGet> racikanList = contensTabGetRepository.findByIdAndMfdtd(obat.getId(), obat.getKode());
            obat.setRacikanList(racikanList.isEmpty() ? Collections.emptyList() : racikanList);
        }

        // Bangun response model
        ResepOLGetResponseModel response = new ResepOLGetResponseModel();
        response.setId(header.getId());
        response.setTgl(header.getTgl());
        response.setJam(header.getJam());
        response.setIdReg(header.getIdReg());
        response.setIdDokter(header.getIdDokter());
        response.setKelasID(header.getKelasID());
        response.setRoomID(header.getRoomID());
        response.setManual(header.getManual());
        response.setRacikan(header.getRacikan());
        response.setKetInap(header.getKetInap());
        response.setObatList(obatList);        
        
        final String messageOk = "Ok";
		Metadata metadata = new Metadata(HttpStatus.OK.value(), messageOk);
        return ResponseEntity.ok(new ResponseX<>(response, metadata));
    }
	
	@GetMapping("/ResepOL/TemplateNRiwayatPX")
	public ResponseEntity<ResponseX<ResepOLTemplateNRiwayatPXModel, Metadata>>
	getResepOLTemplateNRiwayatPX(@RequestParam("idDokter") Long idDokter,
	                             @RequestParam("rm") String rm) {

	    List<ResepOLTemplate> templateList = resepOLTemplateRepository.findByIdDokter(idDokter);
	    List<ResepOLRiwayat>  riwayatList  = resepOLRiwayatRepository.findByRm(rm);

	    boolean templateKosong = templateList == null || templateList.isEmpty();
	    boolean riwayatKosong  = riwayatList  == null || riwayatList.isEmpty();

	    if (templateKosong && riwayatKosong) {
	        String msg = "Data Template dan Riwayat E-Resep tidak ditemukan untuk ID Dokter (" + idDokter + ") dan RM (" + rm + ")";
	        Metadata metadata = new Metadata(HttpStatus.OK.value(), msg); // <- 200
	        ResepOLTemplateNRiwayatPXModel empty =
	            new ResepOLTemplateNRiwayatPXModel(Collections.emptyList(), Collections.emptyList());
	        return ResponseEntity.ok(new ResponseX<>(empty, metadata));    // <- 200
	    }

	    String msg = "Data ditemukan";
	    Metadata metadata = new Metadata(HttpStatus.OK.value(), msg);
	    ResepOLTemplateNRiwayatPXModel combined =
	        new ResepOLTemplateNRiwayatPXModel(templateList, riwayatList);
	    return ResponseEntity.ok(new ResponseX<>(combined, metadata));
	}


	
	@GetMapping("/ResepOL/IdReg/{idReg}")
	public ResponseEntity<ResponseX<List<ResepOL>, Metadata>> ResepOLByIdReg(@PathVariable Long idReg) {
	    List<ResepOL> cek = resepOLRepository.findByIdReg(idReg);

	    if (cek.isEmpty()) {
	        String msg = "ID Px = (" + idReg + ") E-Resep Belum ada..!!";
	        List<ResepOL> emptyResponse = Collections.emptyList();
	        Metadata metadata = new Metadata(HttpStatus.OK.value(), msg); // <- 200

	        return ResponseEntity.ok(new ResponseX<>(emptyResponse, metadata)); // <- 200
	    } else {
	        Metadata metadata = new Metadata(HttpStatus.OK.value(), "Ok");
	        return ResponseEntity.ok(new ResponseX<>(cek, metadata));
	    }
	}

	
	@GetMapping("/ResepOL/ListIdReg/{id}")
	public ResponseEntity<ResponseX<List<ResepOLGetResponseModel>, Metadata>> ResepOLListById(@PathVariable Long id) {
	    List<ResepOL> resepList = resepOLRepository.findByIdReg(id);

	    if (resepList == null || resepList.isEmpty()) {
	        Metadata metadata = new Metadata(HttpStatus.OK.value(), "Data not found"); // <- 200
	        return ResponseEntity.ok(new ResponseX<>(Collections.emptyList(), metadata)); // <- 200 + []
	    }

	    List<ResepOLGetResponseModel> resultList = new ArrayList<>();

	    for (ResepOL header : resepList) {
	        List<ObAtRspGet> obatList = obAtRspGetRepository.findById(header.getId());

	        for (ObAtRspGet obat : obatList) {
	            List<ContensTabGet> racikanList = contensTabGetRepository.findByIdAndMfdtd(obat.getId(), obat.getKode());
	            obat.setRacikanList(racikanList.isEmpty() ? Collections.emptyList() : racikanList);
	        }

	        ResepOLGetResponseModel response = new ResepOLGetResponseModel();
	        response.setId(header.getId());
	        response.setTgl(header.getTgl());
	        response.setJam(header.getJam());
	        response.setIdReg(header.getIdReg());
	        response.setIdDokter(header.getIdDokter());
	        response.setKelasID(header.getKelasID());
	        response.setRoomID(header.getRoomID());
	        response.setManual(header.getManual());
	        response.setRacikan(header.getRacikan());
	        response.setKetInap(header.getKetInap());
	        response.setObatList(obatList);

	        resultList.add(response);
	    }

	    Metadata metadata = new Metadata(HttpStatus.OK.value(), "Ok");
	    return ResponseEntity.ok(new ResponseX<>(resultList, metadata));
	}

	
	@GetMapping("/ResepOL/Riwayat/{rm}")
	public ResponseEntity<ResponseX<List<ResepOLRiwayat>, Metadata>> ResepOLRiwayatByRM(@PathVariable("rm") String rm) {
	    List<ResepOLRiwayat> cek = resepOLRiwayatRepository.findByRm(rm);

	    if (cek == null || cek.isEmpty()) {
	        String msg = "ID Px = (" + rm + ") E-Resep Belum ada..!!";
	        Metadata metadata = new Metadata(HttpStatus.OK.value(), msg); // <- 200
	        return ResponseEntity.ok(new ResponseX<>(Collections.emptyList(), metadata)); // <- 200 + []
	    } else {
	        Metadata metadata = new Metadata(HttpStatus.OK.value(), "Ok");
	        return ResponseEntity.ok(new ResponseX<>(cek, metadata));
	    }
	}
	
	@PutMapping("/ResepOL/{id}")
	public ResponseEntity<ResponseX<ResepOLResponseModel, Metadata>> updateResepOL(
			@RequestHeader("Authorization") String token,
			@PathVariable Long id, @RequestBody ResepOLModel resepOLModel) {
		
		// Validasi token
	    if (!isValidToken(token)) {
	        String msg = "Invalid or missing token.";
	        return RespErResepOL.ErResp(msg, resepOLModel);
	    }
		
	    // Cari data berdasarkan ID
	    Optional<ResepOL> optionalResepOL = resepOLRepository.findById(id);
	    if (optionalResepOL.isEmpty()) {
	        String msg = "ID (E-Resep) = (" + id + ") tidak ditemukan.";
	        return RespErResepOL.ErResp(msg, resepOLModel);
	    }

	    ResepOL existingResep = optionalResepOL.get();

	    // Validasi data input
	    if (resepOLModel.getIdReg() == null) {
	        String msg = "ID = IDReg(Px) Tidak Boleh Kosong Atau PX Sudah Pulang (ResepOL RI)";
	        return RespErResepOL.ErResp(msg, resepOLModel);
	    }
	    if (resepOLModel.getIdDokter() == null) {
	        String msg = "ID = ID Dokter Tidak Boleh Kosong";
	        return RespErResepOL.ErResp(msg, resepOLModel);
	    }

	    Optional<DokterERM> cekDokter = dokterERMRepository.findById(resepOLModel.getIdDokter());
	    if (cekDokter.isEmpty()) {
	        String msg = "ID (Kode) Dokter tidak diketahui, silahkan Hubungi EDP..!!";
	        return RespErResepOL.ErResp(msg, resepOLModel);
	    }

	    if (resepOLModel.getKelasID() == null) {
	        String msg = "IDKelas Tidak Boleh Kosong";
	        return RespErResepOL.ErResp(msg, resepOLModel);
	    }

	    if (resepOLModel.getRoomID() == null) {
	        String msg = "IDRoom Tidak Boleh Kosong";
	        return RespErResepOL.ErResp(msg, resepOLModel);
	    }

	    Date date = resepOLModel.getTgl();
	    LocalDate tgPx = date.toInstant().atZone(ZoneId.of("Asia/Jakarta")).toLocalDate();
	    ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Jakarta"));
	    ZonedDateTime yesterdayJakarta = zonedDateTime.minusDays(1);
	    LocalDate isNow = yesterdayJakarta.toLocalDate();
	    if (isNow.isAfter(tgPx) || isNow.isEqual(tgPx)) {
	        String msg = "Tanggal harus sama atau lebih besar dari hari ini..!!";
	        return RespErResepOL.ErResp(msg, resepOLModel);
	    }

	    try {
	        // Update Header
	        existingResep.setTgl(resepOLModel.getTgl());
	        existingResep.setJam(resepOLModel.getJam());
	        existingResep.setIdReg(resepOLModel.getIdReg());
	        existingResep.setIdDokter(resepOLModel.getIdDokter());
	        existingResep.setKelasID(resepOLModel.getKelasID());
	        existingResep.setRoomID(resepOLModel.getRoomID());
	        existingResep.setManual(resepOLModel.getManual());
	        existingResep.setKetInap(resepOLModel.getKetInap());
	        ResepOL updatedHeader = resepOLRepository.save(existingResep);
	        
	        // Update Sub Obat Details
	   //     List<ContensTab> subDetails = resepOLModel.getObatList().stream()
	   //             .flatMap(obAtRspModel -> obAtRspModel.getRacikanList().stream())
	        List<ContensTab> subDetails = resepOLModel.getObatList().stream()
	                .filter(Objects::nonNull)
	                .flatMap(obAtRspModel -> Optional.ofNullable(obAtRspModel.getRacikanList())
	                                                 .orElse(Collections.emptyList())
	                                                 .stream())        
	                .map(contensTabModel -> { //.map(subDTO -> {
	                	 // Validate mfdtd
	                    if (contensTabModel.getMfdtd() == null || contensTabModel.getKode() == null) {
	                        String msg = "Kode Obat Racikan tidak boleh kosong!";
	                        throw new IllegalArgumentException(msg);
	                    }
	                    
	                    // Validate Qty
	                    if (contensTabModel.getQty() == null ) {
	                        String msg = "Jumlah(Qty) Obat Racikan tidak boleh kosong!";
	                        throw new IllegalArgumentException(msg);
	                    }
	                    
	                    // Validate Rasio
	                    if (contensTabModel.getRasio() == null ) {
	                        String msg = "Jumlah(Rasio) Obat Racikan tidak boleh kosong!";
	                        throw new IllegalArgumentException(msg);
	                    }
	                    
	                    // Validate Obat 
	                    Optional<Obat> obm = obatRepository.findByKode(contensTabModel.getMfdtd());
	                    if (obm.isEmpty()) {
	                        throw new IllegalArgumentException(
	                                "Obat Racikan(M) dengan kode " + contensTabModel.getMfdtd() + " tidak ada di DB Obat!");
	                    }
	                    
	                    Optional<Obat> ob = obatRepository.findByKode(contensTabModel.getKode());
	                    if (ob.isEmpty()) {
	                        throw new IllegalArgumentException(
	                                "Obat Racikan dengan kode " + contensTabModel.getKode() + " tidak ada di DB Obat!");
	                    }

	                    // Validate Obat with mfdtd
	                    Optional<Obat> obRa = obatRepository.findByKodeAndRacikan(contensTabModel.getMfdtd(), true);
	                    if (obRa.isEmpty()) {
	                        throw new IllegalArgumentException(
	                                "Obat Racikan dengan kode " + contensTabModel.getMfdtd() + " tidak ditemukan atau tidak mendukung racikan!");
	                    }
	                    
	                    // Create ContensTab
	                    ContensTab subDetail = new ContensTab();
	                    subDetail.setId(updatedHeader.getId());
	                    subDetail.setMfdtd(contensTabModel.getMfdtd());
	                    subDetail.setKode(contensTabModel.getKode());
	                    subDetail.setQty(contensTabModel.getQty());
	                    subDetail.setRasio(contensTabModel.getRasio());
	                    return subDetail;
	                }).collect(Collectors.toList());

	        // Hapus racikan lama dan tambahkan yang baru
	        contensTabRepository.deleteById(updatedHeader.getId());
	        contensTabRepository.saveAll(subDetails);

	        // Update Obat Detail
	      //  List<ObAtRsp> detail1List = resepOLModel.getObatList().stream().map(dto -> {
	        List<ObAtRsp> detail1List = new ArrayList<>();
	 	    for (ObAtRspModel dto : resepOLModel.getObatList()) {
	 	    	 if (dto.getKode() == null) {
		              String msg = "Kode Obat tidak boleh kosong!";
		              return RespErResepOL.ErResp(msg, resepOLModel);
		            }
		            
		         if (dto.getSigna() == null) {
		              String msg = "Signa Obat tidak boleh kosong!";
		              return RespErResepOL.ErResp(msg, resepOLModel);
		            }
		            
		         if (dto.getQty() == null) {
		              String msg = "Jumlah(Qty) Obat tidak boleh kosong!";
		              return RespErResepOL.ErResp(msg, resepOLModel);
		            }
		            
		         // Validate Obat 
	                Optional<Obat> ob = obatRepository.findByKode(dto.getKode());
	                if (ob.isEmpty()) {
	                    throw new IllegalArgumentException(
	                            "Obat dengan kode " + dto.getKode() + " tidak ada di DB Obat!");
	                }
	            ObAtRsp detail1 = new ObAtRsp();
	            detail1.setId(updatedHeader.getId());
	            detail1.setKode(dto.getKode());
	            detail1.setQty(dto.getQty());
	            detail1.setSigna(dto.getSigna());

	            // Isi racikanList secara manual
	            List<ContensTab> racikanList = fetchRacikanListForObat(updatedHeader.getId(), dto.getKode());
	            detail1.setRacikanList(racikanList);
	            detail1List.add(detail1);
	        }
	     //       return detail1;
	     //   }).collect(Collectors.toList());

	        // Hapus detail lama dan tambahkan yang baru
	        obAtRspRepository.deleteById(updatedHeader.getId());
	        obAtRspRepository.saveAll(detail1List);

	        // Bangun response model
	        ResepOLResponseModel response = new ResepOLResponseModel();
	        response.setId(updatedHeader.getId());
	        response.setTgl(updatedHeader.getTgl());
	        response.setJam(updatedHeader.getJam());
	        response.setIdReg(updatedHeader.getIdReg());
	        response.setIdDokter(updatedHeader.getIdDokter());
	        response.setKelasID(updatedHeader.getKelasID());
	        response.setRoomID(updatedHeader.getRoomID());
	        response.setManual(updatedHeader.getManual());
	        response.setKetInap(updatedHeader.getKetInap());
	        response.setObatList(detail1List);

	        Metadata metadata = new Metadata(HttpStatus.OK.value(), "Updated Successfully");
	        return ResponseEntity.ok(new ResponseX<>(response, metadata));

	    } catch (Exception e) {
	        String msg = "Error updating ResepOL: " + e.getMessage();
	        return RespErResepOL.ErResp(msg, resepOLModel);
	    }
	}
	
	@DeleteMapping("/ResepOL/{id}")
	public ResponseEntity<Metadata> deleteResepOL(
	        @RequestHeader("Authorization") String token,
	        @PathVariable Long id) {
	    // Validate token
	    if (!isValidToken(token)) {
	        String msg = "Invalid or missing token.";
	        Metadata metadata = new Metadata(HttpStatus.UNAUTHORIZED.value(), msg);
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(metadata);
	    }

	    try {
	        // Check if ResepOL exists
	    	Optional<ResepOL> resepOLOptional = resepOLRepository.findById(id);
	        if (resepOLOptional.isEmpty()) {
	            String msg = "ResepOL dengan ID " + id + " tidak ditemukan.";
	            // UBAH: 404 -> 200
	            Metadata metadata = new Metadata(HttpStatus.OK.value(), msg);
	            return ResponseEntity.ok(metadata);
	        }

	        Optional<CekResepOL> cekResepOLOptional = cekResepOLRepository.findById(id);
	        if (cekResepOLOptional.isEmpty()) {
	            String msg = "ResepOL dengan ID " + id + " Sudah di proses.";
	            // UBAH: 404 -> 200
	            Metadata metadata = new Metadata(HttpStatus.OK.value(), msg);
	            return ResponseEntity.ok(metadata);
	        }

	        // Delete associated ContensTab entries
	        contensTabRepository.deleteById(id);
	 
	        // Delete associated ObAtRsp entries
	        obAtRspRepository.deleteById(id);

	        // Delete ResepOL
	        resepOLRepository.deleteById(id);

	        // Return success response
	        String msg = "ResepOL dengan ID " + id + " berhasil dihapus.";
	        Metadata metadata = new Metadata(HttpStatus.OK.value(), msg);
	        return ResponseEntity.ok(metadata);

	    } catch (Exception e) {
	        // Handle unexpected errors
	        String msg = "Terjadi kesalahan saat menghapus ResepOL dengan ID " + id + ".";
	        Metadata metadata = new Metadata(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg);
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(metadata);
	    }
	}
	
	@GetMapping("/RegisterKepRIId/{id}")
	public ResponseEntity<?> getRegisterKepRIId(@PathVariable Long id) {
	    List<RegisterKepRIGet> rows = registerKepRIGetRepository.findAllById(id);

	    if (rows == null || rows.isEmpty()) {
	        String msg = "NO = (" + id + ") Tidak ada..!!";
	        // HTTP 200 (sesuai kebijakanmu sebelumnya), body sesuai contoh
	        return ResponseEntity.ok(java.util.Map.of(
	            "message", msg,
	            "code", 200   // kalau mau persis seperti contohmu (404), ubah ke 404
	        ));
	    }

	    List<RegisterKepRIGetModel> data = rows.stream()
	        .map(r -> new RegisterKepRIGetModel(r.getId(), r.getNo(), r.getPenerima(), r.getTelp()))
	        .collect(java.util.stream.Collectors.toList());

	    return ResponseEntity.ok(data);
	}
	
	@GetMapping("/RegisterKepRINo/{no}")
	public RegisterKepRIGetModel getRegisterKepRI(@PathVariable Long no) {
	    List<RegisterKepRIGet> cek = registerKepRIGetRepository.findByid(no);

	    if (cek == null || cek.isEmpty()) {
	        System.out.println("NO = (" + no + ") Tidak ada..!!");
	        // 200 OK + body dengan field null; NO tetap ditampilkan
	        return new RegisterKepRIGetModel(
	            null,          // id
	            no,            // no (biar tetap muncul)
	            null,          // penerima
	            null           // telp
	        );
	    }

	    RegisterKepRIGet r = cek.get(0);
	    return new RegisterKepRIGetModel(
	        r.getId(),
	        r.getNo(),
	        r.getPenerima(),
	        r.getTelp()
	    );
	}

	
	@PutMapping("/RegisterKepRI/{no}")
	public RegisterKepRIModel updateRegisterKepRI(@PathVariable Long no,
	                                              @RequestBody RegisterKepRIGetModel model) {
	    Optional<RegisterKepRI> cek = registerKepRIRepository.findById(no);
	    if (cek.isEmpty()) {
	        String msg = "NO = (" + no + ") Tidak ada..!!";
	        System.out.println(msg);
	        // 200 OK + objek dengan field null (empty-object pattern)
	        return new RegisterKepRIModel(
	            null,  // penerima
	            null   // telp
	        );
	    }

	    RegisterKepRI existingRegisterKepRI = cek.get();
	    existingRegisterKepRI.setPenerima(model.getPenerima());
	    existingRegisterKepRI.setTelp(model.getTelp());
	    RegisterKepRI updated = registerKepRIRepository.save(existingRegisterKepRI);

	    return new RegisterKepRIModel(
	        updated.getPenerima(),
	        updated.getTelp()
	    );
	}
	
	@GetMapping("/ResepOLTemplate/IdDokter/{idDokter}")
	public ResponseEntity<ResponseX<List<ResepOLTemplate>, Metadata>> ResepOLTemplateByIdDokter(
	        @PathVariable Long idDokter) {

	    List<ResepOLTemplate> cek = resepOLTemplateRepository.findByIdDokter(idDokter);

	    if (cek == null || cek.isEmpty()) {
	        String msg = "ID Px = (" + idDokter + ") E-Resep Belum ada..!!";
	        System.out.println(msg);

	        List<ResepOLTemplate> emptyResponse = Collections.emptyList();
	        Metadata metadata = new Metadata(HttpStatus.OK.value(), msg); // <- 200

	        return ResponseEntity.ok(new ResponseX<>(emptyResponse, metadata)); // <- 200 OK
	    } else {
	        final String messageOk = "Ok";
	        Metadata metadata = new Metadata(HttpStatus.OK.value(), messageOk);
	        return ResponseEntity.ok(new ResponseX<>(cek, metadata));
	    }
	}
	
	@GetMapping("/ResepOLTemplate/{id}")
	public ResponseEntity<ResponseX<ResepOLTemplateGetResponseModel, Metadata>> ResepOLTemplateById(@PathVariable Long id) {
	    Optional<ResepOLTemplateGet> optionalResepOL = resepOLTemplateGetRepository.findById(id);

	    if (optionalResepOL.isEmpty()) {
	        Metadata metadata = new Metadata(HttpStatus.OK.value(), "Data not found"); // 200, bukan 404
	        return ResponseEntity.ok(new ResponseX<>(null, metadata));
	    }

	    ResepOLTemplateGet header = optionalResepOL.get();

	    // Ambil detail obat
	    List<ObAtRspTemplateGet> obatList = obAtRspTemplateGetRepository.findById(header.getId());
	    for (ObAtRspTemplateGet obat : obatList) {
	        List<ContensTabTemplateGet> racikanList =
	            contensTabTemplateGetRepository.findByIdAndMfdtd(obat.getId(), obat.getKode());
	        obat.setRacikanList(racikanList.isEmpty() ? Collections.emptyList() : racikanList);
	    }

	    // Build response
	    ResepOLTemplateGetResponseModel response = new ResepOLTemplateGetResponseModel();
	    response.setId(header.getId());
	    response.setIdDokter(header.getIdDokter());
	    response.setNama(header.getNama());
	    response.setApproved(header.getApproved());
	    response.setRacikan(header.getRacikan());
	    response.setObatList(obatList);

	    Metadata metadata = new Metadata(HttpStatus.OK.value(), "Ok");
	    return ResponseEntity.ok(new ResponseX<>(response, metadata));
	}

	
	@PostMapping("/ResepOLTemplate/")
	ResponseEntity<ResponseX<ResepOLTemplateResponseModel, Metadata>> addResepOLTemplate(
	      //  @RequestHeader("Authorization") String token,
	        @RequestBody ResepOLTemplateModel resepOLTemplateModel) {
	    // Validate token
	 /*   if (!isValidToken(token)) {
	        String msg = "Invalid or missing token.";
	        return RespErResepOL.ErResp(msg, resepOLModel);
	    } */

	    // Validate request body
	    if (resepOLTemplateModel.getIdDokter() == null) {
	        String msg = "ID Dokter Tidak Boleh Kosong";
	        return RespErResepOLTemplate.ErResp(msg, resepOLTemplateModel);
	    }

	    Optional<DokterERM> cek = dokterERMRepository.findById(resepOLTemplateModel.getIdDokter());
	    if (cek.isEmpty()) {
	        String msg = "ID (Kode) Dokter tidak diketahui, silahkan hubungi EDP.";
	        return RespErResepOLTemplate.ErResp(msg, resepOLTemplateModel);
	    }
	  
	    ResepOLTemplateResponseModel response = null;
	    try {
	        // Save Header
	        ResepOLTemplate header = new ResepOLTemplate();
	        header.setIdDokter(resepOLTemplateModel.getIdDokter());
	        header.setNama(resepOLTemplateModel.getNama());
	        header.setApproved(resepOLTemplateModel.getApproved());
	        header.setRacikan(resepOLTemplateModel.getRacikan());
	        ResepOLTemplate savedHeader = resepOLTemplateRepository.save(header);

	        Long orderId = savedHeader.getId();

	        // Save Sub Obat Details
	        List<ContensTabTemplate> subDetails = resepOLTemplateModel.getObatList().stream()
	                .flatMap(obAtRspTemplateModel -> obAtRspTemplateModel.getRacikanList().stream())
	                .map(contensTabTemplateModel -> { // Replace 'subDTO' with 'contensTabModel'
	                    // Validate mfdtd
	                    if (contensTabTemplateModel.getMfdtd() == null || contensTabTemplateModel.getKode() == null) {
	                        String msg = "Kode Obat Racikan tidak boleh kosong!";
	                        throw new IllegalArgumentException(msg);
	                    }
	                    
	                    // Validate mfdtd
	                    if (contensTabTemplateModel.getQty() == null ) {
	                        String msg = "Jumlah(Qty) Obat Racikan tidak boleh kosong!";
	                        throw new IllegalArgumentException(msg);
	                    }
	                    
	                    // Validate mfdtd
	                    if (contensTabTemplateModel.getRasio() == null ) {
	                        String msg = "Jumlah(Rasio) Obat Racikan tidak boleh kosong!";
	                        throw new IllegalArgumentException(msg);
	                    }
	                    
	                    // Validate Obat 
	                    Optional<Obat> obm = obatRepository.findByKode(contensTabTemplateModel.getMfdtd());
	                    if (obm.isEmpty()) {
	                        throw new IllegalArgumentException(
	                                "Obat Racikan(M) dengan kode " + contensTabTemplateModel.getMfdtd() + " tidak ada di DB Obat!");
	                    }
	                    
	                    Optional<Obat> ob = obatRepository.findByKode(contensTabTemplateModel.getKode());
	                    if (ob.isEmpty()) {
	                        throw new IllegalArgumentException(
	                                "Obat Racikan dengan kode " + contensTabTemplateModel.getKode() + " tidak ada di DB Obat!");
	                    }

	                    // Validate Obat with mfdtd
	                    Optional<Obat> obRa = obatRepository.findByKodeAndRacikan(contensTabTemplateModel.getMfdtd(), true);
	                    if (obRa.isEmpty()) {
	                        throw new IllegalArgumentException(
	                                "Obat Racikan dengan kode " + contensTabTemplateModel.getMfdtd() + " tidak ditemukan atau tidak mendukung racikan!");
	                    }

	                    // Create ContensTab
	                    ContensTabTemplate subDetail = new ContensTabTemplate();
	                    subDetail.setId(orderId);
	                    subDetail.setMfdtd(contensTabTemplateModel.getMfdtd());
	                    subDetail.setKode(contensTabTemplateModel.getKode());
	                    subDetail.setQty(contensTabTemplateModel.getQty());
	                    subDetail.setRasio(contensTabTemplateModel.getRasio());
	                    return subDetail;
	                }).collect(Collectors.toList());

	        contensTabTemplateRepository.saveAll(subDetails);

	        // Save Obat Details
	        List<ObAtRspTemplate> detail1List = new ArrayList<>();
	        for (ObAtRspTemplateModel dto : resepOLTemplateModel.getObatList()) {
	            if (dto.getKode() == null) {
	                String msg = "Kode Obat tidak boleh kosong!";
	                return RespErResepOLTemplate.ErResp(msg, resepOLTemplateModel);
	            }
	            
	            if (dto.getSigna() == null) {
	                String msg = "Signa Obat tidak boleh kosong!";
	                return RespErResepOLTemplate.ErResp(msg, resepOLTemplateModel);
	            }
	            
	            if (dto.getQty() == null) {
	                String msg = "Jumlah(Qty) Obat tidak boleh kosong!";
	                return RespErResepOLTemplate.ErResp(msg, resepOLTemplateModel);
	            }
	            
	         // Validate Obat 
                Optional<Obat> ob = obatRepository.findByKode(dto.getKode());
                if (ob.isEmpty()) {
                    throw new IllegalArgumentException(
                            "Obat dengan kode " + dto.getKode() + " tidak ada di DB Obat!");
                }

	            ObAtRspTemplate detail1 = new ObAtRspTemplate();
	            detail1.setId(orderId);
	            detail1.setKode(dto.getKode());
	            detail1.setQty(dto.getQty());
	            detail1.setSigna(dto.getSigna());

	            List<ContensTabTemplate> racikanList = fetchRacikanListForObatTemplate(orderId, dto.getKode());
	            detail1.setRacikanList(racikanList);
	            detail1List.add(detail1);
	        }
	        obAtRspTemplateRepository.saveAll(detail1List);

	        // Build Response
	        response = new ResepOLTemplateResponseModel();
	        response.setId(savedHeader.getId());
	        response.setIdDokter(savedHeader.getIdDokter());
	        response.setNama(savedHeader.getNama());
	        response.setApproved(savedHeader.getApproved());
	        response.setRacikan(savedHeader.getRacikan());
	        response.setObatList(detail1List);

	    } catch (IllegalArgumentException e) {
	        String msg = e.getMessage();
	        return RespErResepOLTemplate.ErResp(msg, resepOLTemplateModel);
	    }

	    // Return successful response
	    final String messageOk = "Ok";
	    Metadata metadata = new Metadata(HttpStatus.OK.value(), messageOk);
	    ResponseX<ResepOLTemplateResponseModel, Metadata> responseX = new ResponseX<>(response, metadata);
	    return ResponseEntity.ok(responseX);
	}
	
	private List<ContensTabTemplate> fetchRacikanListForObatTemplate(Long id, String kd) {
		 //   System.out.println("Fetching racikanList for id: " + id + ", kode: " + kd );
		  //  return contensTabRepository.findByIdAndMfdtd(id, kd) ;
		    List<ContensTabTemplate> racikanList = contensTabTemplateRepository.findByIdAndMfdtd(id, kd);
		    return racikanList == null ? Collections.emptyList() : racikanList;	    
		}	

	@PutMapping("/ResepOLTemplate/{id}")
	public ResponseEntity<ResponseX<ResepOLTemplateResponseModel, Metadata>> updateResepOLTemplate(
		//	@RequestHeader("Authorization") String token,
			@PathVariable Long id, @RequestBody ResepOLTemplateModel resepOLTemplateModel) {
		
		// Validasi token
	/*    if (!isValidToken(token)) {
	        String msg = "Invalid or missing token.";
	        return RespErResepOL.ErResp(msg, resepOLModel);
	    } */
		
	    // Cari data berdasarkan ID
	    Optional<ResepOLTemplate> optionalResepOL = resepOLTemplateRepository.findById(id);
	    if (optionalResepOL.isEmpty()) {
	        String msg = "ID (E-Resep) = (" + id + ") tidak ditemukan.";
	        return RespErResepOLTemplate.ErResp(msg, resepOLTemplateModel);
	    }

	    ResepOLTemplate existingResep = optionalResepOL.get();

	    // Validasi data input
	    Optional<DokterERM> cekDokter = dokterERMRepository.findById(resepOLTemplateModel.getIdDokter());
	    if (cekDokter.isEmpty()) {
	        String msg = "ID (Kode) Dokter tidak diketahui, silahkan Hubungi EDP..!!";
	        return RespErResepOLTemplate.ErResp(msg, resepOLTemplateModel);
	    }

	  	try {
	        // Update Header
	        existingResep.setIdDokter(resepOLTemplateModel.getIdDokter());
	        existingResep.setNama(resepOLTemplateModel.getNama());
	        existingResep.setApproved(resepOLTemplateModel.getApproved());
	        existingResep.setRacikan(resepOLTemplateModel.getRacikan());
	        ResepOLTemplate updatedHeader = resepOLTemplateRepository.save(existingResep);
	        
	        // Update Sub Obat Details
	   //     List<ContensTab> subDetails = resepOLModel.getObatList().stream()
	   //             .flatMap(obAtRspModel -> obAtRspModel.getRacikanList().stream())
	        List<ContensTabTemplate> subDetails = resepOLTemplateModel.getObatList().stream()
	                .filter(Objects::nonNull)
	                .flatMap(obAtRspTemplateModel -> Optional.ofNullable(obAtRspTemplateModel.getRacikanList())
	                                                 .orElse(Collections.emptyList())
	                                                 .stream())        
	                .map(contensTabTemplateModel -> { //.map(subDTO -> {
	                	 // Validate mfdtd
	                    if (contensTabTemplateModel.getMfdtd() == null || contensTabTemplateModel.getKode() == null) {
	                        String msg = "Kode Obat Racikan tidak boleh kosong!";
	                        throw new IllegalArgumentException(msg);
	                    }
	                    
	                    // Validate Qty
	                    if (contensTabTemplateModel.getQty() == null ) {
	                        String msg = "Jumlah(Qty) Obat Racikan tidak boleh kosong!";
	                        throw new IllegalArgumentException(msg);
	                    }
	                    
	                    // Validate Rasio
	                    if (contensTabTemplateModel.getRasio() == null ) {
	                        String msg = "Jumlah(Rasio) Obat Racikan tidak boleh kosong!";
	                        throw new IllegalArgumentException(msg);
	                    }
	                    
	                    // Validate Obat 
	                    Optional<Obat> obm = obatRepository.findByKode(contensTabTemplateModel.getMfdtd());
	                    if (obm.isEmpty()) {
	                        throw new IllegalArgumentException(
	                                "Obat Racikan(M) dengan kode " + contensTabTemplateModel.getMfdtd() + " tidak ada di DB Obat!");
	                    }
	                    
	                    Optional<Obat> ob = obatRepository.findByKode(contensTabTemplateModel.getKode());
	                    if (ob.isEmpty()) {
	                        throw new IllegalArgumentException(
	                                "Obat Racikan dengan kode " + contensTabTemplateModel.getKode() + " tidak ada di DB Obat!");
	                    }

	                    // Validate Obat with mfdtd
	                    Optional<Obat> obRa = obatRepository.findByKodeAndRacikan(contensTabTemplateModel.getMfdtd(), true);
	                    if (obRa.isEmpty()) {
	                        throw new IllegalArgumentException(
	                                "Obat Racikan dengan kode " + contensTabTemplateModel.getMfdtd() + " tidak ditemukan atau tidak mendukung racikan!");
	                    }
	                    
	                    // Create ContensTab
	                    ContensTabTemplate subDetail = new ContensTabTemplate();
	                    subDetail.setId(updatedHeader.getId());
	                    subDetail.setMfdtd(contensTabTemplateModel.getMfdtd());
	                    subDetail.setKode(contensTabTemplateModel.getKode());
	                    subDetail.setQty(contensTabTemplateModel.getQty());
	                    subDetail.setRasio(contensTabTemplateModel.getRasio());
	                    return subDetail;
	                }).collect(Collectors.toList());

	        // Hapus racikan lama dan tambahkan yang baru
	        contensTabTemplateRepository.deleteById(updatedHeader.getId());
	        contensTabTemplateRepository.saveAll(subDetails);

	        // Update Obat Detail
	      //  List<ObAtRsp> detail1List = resepOLModel.getObatList().stream().map(dto -> {
	        List<ObAtRspTemplate> detail1List = new ArrayList<>();
	 	    for (ObAtRspTemplateModel dto : resepOLTemplateModel.getObatList()) {
	 	    	 if (dto.getKode() == null) {
		              String msg = "Kode Obat tidak boleh kosong!";
		              return RespErResepOLTemplate.ErResp(msg, resepOLTemplateModel);
		            }
		            
		         if (dto.getSigna() == null) {
		              String msg = "Signa Obat tidak boleh kosong!";
		              return RespErResepOLTemplate.ErResp(msg, resepOLTemplateModel);
		            }
		            
		         if (dto.getQty() == null) {
		              String msg = "Jumlah(Qty) Obat tidak boleh kosong!";
		              return RespErResepOLTemplate.ErResp(msg, resepOLTemplateModel);
		            }
		            
		         // Validate Obat 
	                Optional<Obat> ob = obatRepository.findByKode(dto.getKode());
	                if (ob.isEmpty()) {
	                    throw new IllegalArgumentException(
	                            "Obat dengan kode " + dto.getKode() + " tidak ada di DB Obat!");
	                }
	            ObAtRspTemplate detail1 = new ObAtRspTemplate();
	            detail1.setId(updatedHeader.getId());
	            detail1.setKode(dto.getKode());
	            detail1.setQty(dto.getQty());
	            detail1.setSigna(dto.getSigna());

	            // Isi racikanList secara manual
	            List<ContensTabTemplate> racikanList = fetchRacikanListForObatTemplate(updatedHeader.getId(), dto.getKode());
	            detail1.setRacikanList(racikanList);
	            detail1List.add(detail1);
	        }
	     //       return detail1;
	     //   }).collect(Collectors.toList());

	        // Hapus detail lama dan tambahkan yang baru
	        obAtRspTemplateRepository.deleteById(updatedHeader.getId());
	        obAtRspTemplateRepository.saveAll(detail1List);

	        // Bangun response model
	        ResepOLTemplateResponseModel response = new ResepOLTemplateResponseModel();
	        response.setId(updatedHeader.getId());
	        response.setIdDokter(updatedHeader.getIdDokter());
	        response.setNama(updatedHeader.getNama());
	        response.setApproved(updatedHeader.getApproved());
	        response.setRacikan(updatedHeader.getRacikan());
	        response.setObatList(detail1List);

	        Metadata metadata = new Metadata(HttpStatus.OK.value(), "Updated Successfully");
	        return ResponseEntity.ok(new ResponseX<>(response, metadata));

	    } catch (Exception e) {
	        String msg = "Error updating ResepOL: " + e.getMessage();
	        return RespErResepOLTemplate.ErResp(msg, resepOLTemplateModel);
	    }
	}
	
	@DeleteMapping("/ResepOLTemplate/{id}")
	public ResponseEntity<Metadata> deleteResepOLTemplate(
	        @RequestHeader("Authorization") String token,
	        @PathVariable Long id) {

	    // Token check tetap 401 (tidak diminta diubah)
	    if (!isValidToken(token)) {
	        String msg = "Invalid or missing token.";
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
	                .body(new Metadata(HttpStatus.UNAUTHORIZED.value(), msg));
	    }

	    try {
	        Optional<ResepOLTemplate> resepOLOptional = resepOLTemplateRepository.findById(id);
	        if (resepOLOptional.isEmpty()) {
	            // UBAH: 404 -> 200
	            String msg = "ResepOL dengan ID " + id + " tidak ditemukan.";
	            return ResponseEntity.ok(new Metadata(HttpStatus.OK.value(), msg));
	            // Jika ingin HTTP 200 tapi code metadata tetap 404:
	            // return ResponseEntity.ok(new Metadata(HttpStatus.NOT_FOUND.value(), msg));
	        }

	        // Hapus relasi
	        contensTabTemplateRepository.deleteById(id);
	        obAtRspTemplateRepository.deleteById(id);

	        // Hapus header
	        resepOLTemplateRepository.deleteById(id);

	        String msg = "Template Resep OL dengan ID " + id + " berhasil dihapus.";
	        return ResponseEntity.ok(new Metadata(HttpStatus.OK.value(), msg));

	    } catch (Exception e) {
	        String msg = "Terjadi kesalahan saat menghapus Template Resep OL dengan ID " + id + ".";
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body(new Metadata(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg));
	    }
	}

	
	@GetMapping("/SrtKesJiwa/{id}")
    public ResponseEntity<KesJiwa> getSrtKesJiwaById(@PathVariable Long id) {
        return kesJiwaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
	
	@GetMapping("/SrtKesJiwa/{idReg}")
	public List<KesJiwa> getByIdReg(@PathVariable Long idReg) {
	    return kesJiwaRepository.findByIdReg(idReg);
	}

    // ➕ POST
    @PostMapping("/SrtKesJiwa/")
    public KesJiwa SrtKesJiwaPost(@RequestBody KesJiwa data) {
        return kesJiwaRepository.save(data);
    }

    // 🛠 PUT
    @PutMapping("/SrtKesJiwa/{id}")
    public ResponseEntity<KesJiwa> SrtKesJiwaUpdate(@PathVariable Long id, @RequestBody KesJiwa updateData) {
        return kesJiwaRepository.findById(id)
                .map(existing -> {
                    updateData.setId(id); // pastikan ID tetap
                    return ResponseEntity.ok(kesJiwaRepository.save(updateData));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // ❌ DELETE
    @DeleteMapping("/SrtKesJiwa/{id}")
    public ResponseEntity<Void> kesJiwaRepositoryDel(@PathVariable Long id) {
        if (kesJiwaRepository.existsById(id)) {
        	kesJiwaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/ObatAll1")
    public ResponseEntity<List<ObatAll>> getObatAll1(@RequestParam Long id) {
        return ResponseEntity.ok(obatAllService.getByidreg(id));
    }
   
    @GetMapping("/ObatAll")
    public ResponseEntity<ObatAllHeaderModel> getObatAll(@RequestParam("id") Long idReg) {
        List<ObatAll> rows = obatAllService.getByidreg(idReg);
        if (rows == null || rows.isEmpty()) {
            return ResponseEntity.ok(null);
        }

        // Header dari baris pertama
        ObatAll first = rows.get(0);
        ObatAllHeaderModel header = new ObatAllHeaderModel();
        header.setRegNum(first.getRegNum());
        header.setNamaPx(first.getNamaPx());
        header.setAddr(first.getAddr());
        header.setTanggalLahir(first.getTanggalLahir());
        header.setTelepon(first.getTelepon());
        header.setTunai(first.getTunai() == null ? 0.0f : first.getTunai().floatValue());
        header.setKelurahan(first.getKelurahan());

        // Group room: roomID|roomName|invoiceDate
        Map<String, ObatAllRoomModel> roomMap = new LinkedHashMap<>();
        // Set idd per room untuk cegah duplikasi
        Map<String, Set<String>> roomSeenIdd = new LinkedHashMap<>();

        for (ObatAll r : rows) {
            Long roomID = r.getRoomID() == null ? null : r.getRoomID().longValue();
            String roomName = r.getRoomName();
            LocalDate invDate = (r.getInvoiceDate() == null) ? null : r.getInvoiceDate().toLocalDate();

            String roomKey = (roomID == null ? "null" : roomID.toString())
                    + "|" + (roomName == null ? "" : roomName)
                    + "|" + (invDate == null ? "null" : invDate.toString());

            ObatAllRoomModel room = roomMap.get(roomKey);
            if (room == null) {
                room = new ObatAllRoomModel();
                room.setRoomID(roomID);
                room.setRoomName(roomName);
            //    room.setId(r.getId() == null ? null : r.getId().longValue());
                room.setInvoiceDate(invDate);
                room.setItems(new ArrayList<>());
                roomMap.put(roomKey, room);
                roomSeenIdd.put(roomKey, new HashSet<>());
            }

            // Skip jika idd sudah pernah ditambahkan ke room ini
            String idd = r.getIdd();
            if (idd != null && roomSeenIdd.get(roomKey).contains(idd)) {
                continue; // JANGAN tampilkan dan JANGAN jumlahkan
            }

            ObatAllItemModel it = new ObatAllItemModel();
            it.setIdd(idd);
            it.setKode(r.getKode());
            it.setProductName(r.getProductName());
            it.setQty(r.getQty());
            it.setDiscount(r.getDiscount());
            it.setPrice(r.getPrice());
            it.setTotalLine(r.getTotalLine());
            it.setId(r.getId());

            room.getItems().add(it);
            if (idd != null) {
                roomSeenIdd.get(roomKey).add(idd);
            }
        }

        header.setRooms(new ArrayList<>(roomMap.values()));
        return ResponseEntity.ok(header);
    }
    
    @GetMapping("/LabAll")
    public ResponseEntity<LabHasilAllModel> getLabAll(@RequestParam("id") Long idReg) {
        // Ambil flat rows (entity) dari SP
        List<com.dev.generik.entities.ERM.Lab.LabHasilAll> rows = labHasilAllService.getByidreg(idReg);
        if (rows == null || rows.isEmpty()) {
            return ResponseEntity.ok(null);
        }

        // ===== Header (ambil dari baris pertama) =====
        var first = rows.get(0);
        var resp = new LabHasilAllModel();
        resp.setIdd(first.getIdd());
        resp.setNama(first.getNama());
        resp.setAddr(first.getAddr());
        resp.setKelurahan(first.getKelurahan());
        resp.setJenisKelamin(first.getJenisKelamin());
        resp.setTanggalLahir(first.getTanggalLahir());
        resp.setIdReg(first.getIdreg());
        resp.setRegNum(first.getRegNum());

        // ===== Group per IDLAB =====
        Map<Long, LabHasilAllIdLabModel> idlabMap = new LinkedHashMap<>();
        // Untuk dedup per-kategori per idlab
        Map<Long, Map<String, LabHasilAllKatModel>> idlabKatMap = new LinkedHashMap<>();
        // Untuk dedup per "periksa" di dalam kategori (per idlab)
        Map<Long, Map<String, Set<String>>> idlabKatSeenPeriksa = new LinkedHashMap<>();

        for (var r : rows) {
            Long idlab = r.getIdlab();

            // -- init idlab container
            var idlabModel = idlabMap.get(idlab);
            if (idlabModel == null) {
                idlabModel = new LabHasilAllIdLabModel();
                idlabModel.setTh(r.getTh());
                idlabModel.setBln(r.getBln());
                idlabModel.setHr(r.getHr());
                idlabModel.setDokter(r.getDokter());
                idlabModel.setKelas(r.getKelas());
                idlabModel.setJamAmbil(r.getJamAmbil());
                idlabModel.setIdlab(idlab);
                idlabModel.setRujukan(r.getRujukan());
                idlabModel.setTlab(r.getTlab());
                idlabModel.setRoomName(r.getRoomName());
                idlabModel.setJamcheck(r.getJamcheck());
                idlabModel.setTanggal(r.getTanggal());
                idlabModel.setNote(r.getNote());
                idlabModel.setUsr(r.getUsr());
                idlabModel.setIsok(r.getIsok());
                idlabModel.setPxrs(r.getPxrs());
                idlabModel.setDetails(r.getDetails());
                idlabModel.setKategoris(new ArrayList<>());

                idlabMap.put(idlab, idlabModel);
                idlabKatMap.put(idlab, new LinkedHashMap<>());
                idlabKatSeenPeriksa.put(idlab, new LinkedHashMap<>());
            }

            // -- group kategori di dalam idlab
            Long kateId = r.getKateID();
            String kategori = r.getKategori();
            String katKey = (kateId == null ? "null" : kateId.toString())
                          + "|" + (kategori == null ? "" : kategori);

            var perIdLabKatMap = idlabKatMap.get(idlab);
            var katModel = perIdLabKatMap.get(katKey);
            if (katModel == null) {
                katModel = new LabHasilAllKatModel();
                katModel.setKateID(kateId);
                katModel.setKategori(kategori);
                katModel.setPeriks(new ArrayList<>());
                perIdLabKatMap.put(katKey, katModel);
                idlabKatSeenPeriksa.get(idlab).put(katKey, new HashSet<>());
            }

            // -- dedup periksa: kunci = prepID|perik
            String perKey = (r.getId() == null ? "null" : r.getId().toString())
                          + "|" + (r.getPerik() == null ? "" : r.getPerik());
            Set<String> seenPeriksa = idlabKatSeenPeriksa.get(idlab).get(katKey);
            if (seenPeriksa.contains(perKey)) {
                continue; // skip duplikat
            }

            // -- add periksa
            var p = new LabHasilAllPerikModel();
            p.setId(r.getId());
            p.setPrepID(r.getPrepID());
            p.setPerik(r.getPerik());
            p.setNorL(r.getNorL());
            p.setLevels(r.getLevels());
            p.setMetode(r.getMetode());
            p.setMetodeID(r.getMetodeID());
            p.setBiaya(r.getBiaya());
            p.setPot(r.getPot());
            p.setDiscount(r.getDiscount() == null ? null : r.getDiscount().floatValue());

            katModel.getPeriks().add(p);
            seenPeriksa.add(perKey);
        }

        // Pindahkan kategori2 per-idlab ke model final
        List<LabHasilAllIdLabModel> idlabList = new ArrayList<>();
        for (var entry : idlabMap.entrySet()) {
            Long idlab = entry.getKey();
            LabHasilAllIdLabModel idlabModel = entry.getValue();

            var perIdLabKatMap = idlabKatMap.get(idlab);
            idlabModel.setKategoris(new ArrayList<>(perIdLabKatMap.values()));

            idlabList.add(idlabModel);
        }

        resp.setIdLab(idlabList);
        return ResponseEntity.ok(resp);
    }
    
    @GetMapping("/RadAll")
    public ResponseEntity<List<RadHasilAllModel>> getRadAll(@RequestParam("id") Long idReg) {

        List<RadHasilAll> rows = radHasilAllService.getByidreg(idReg);
        if (rows == null || rows.isEmpty()) {
            return ResponseEntity.ok(null);
        }

        // Group per IDRad
        Map<Long, RadHasilAllModel> idradMap = new LinkedHashMap<>();
        // Dedup periks per IDRad berdasarkan Idd
        Map<Long, Set<Long>> seenPeriksaPerIdrad = new LinkedHashMap<>();
        Map<Long, Long> noUrutPerIdrad = new LinkedHashMap<>();

        for (RadHasilAll r : rows) {
            Long idrad = r.getIdrad();
            if (idrad == null) continue;

            // Inisialisasi container per idrad
            RadHasilAllModel m = idradMap.get(idrad);
            if (m == null) {
                m = new RadHasilAllModel();
                // Header spesifik IDRad
                m.setIdd(r.getIdd());                // jika ingin idd pertama untuk idrad tsb
                m.setIdrad(idrad);
                m.setIdreg(r.getIdreg());
                m.setRegNum(r.getRegNum());

                // Identitas pasien (boleh sama untuk semua idrad)
                m.setNama(r.getNama());
                m.setAddr(r.getAddr());
                m.setKelurahan(r.getKelurahan());
                m.setJenisKelamin(r.getJenisKelamin());
                m.setTanggalLahir(r.getTanggalLahir());

                // Info pemeriksaan utk idrad
                m.setTh(r.getTh());
                m.setBln(r.getBln());
                m.setHr(r.getHr());
                m.setAlatid(r.getAlatid());
                m.setAlatname(r.getAlatname());
                m.setDokter(r.getDokter());
                m.setKlas(r.getKlas());
                m.setTrad(r.getTrad());
                m.setUsr(r.getUsr());
                m.setShift(r.getShift());
                m.setDetails(r.getDetails());
                m.setDr(r.getDr());
                m.setTtd(r.getTtd());

                m.setPeriks(new ArrayList<>());

                idradMap.put(idrad, m);
                seenPeriksaPerIdrad.put(idrad, new LinkedHashSet<>());
                noUrutPerIdrad.put(idrad, 0L);
            }

            // Dedup: jangan tampilkan/jumlahkan jika Idd sama dalam satu idrad
            Long idd = r.getIdd();
            if (idd != null && seenPeriksaPerIdrad.get(idrad).contains(idd)) {
                continue;
            }

            // Tambahkan periksa
            Long noUrut = noUrutPerIdrad.get(idrad) + 1;
            noUrutPerIdrad.put(idrad, noUrut);

            RadHasilAllPerikModel p = new RadHasilAllPerikModel();
            p.setNourut(noUrut);
            p.setPeriksa(r.getPeriksa());
            p.setBiaya(r.getBiaya());
            p.setPot(r.getPot());
            p.setDiscount(r.getDiscount() == null ? null : r.getDiscount().floatValue());
            p.setResult(r.getResult());

            idradMap.get(idrad).getPeriks().add(p);
            if (idd != null) seenPeriksaPerIdrad.get(idrad).add(idd);
        }

        // Hasil akhir: satu objek per IDRad (mis. salah satunya idrad=330778)
        List<RadHasilAllModel> result = new ArrayList<>(idradMap.values());
        return ResponseEntity.ok(result);
    }
    
    
    @GetMapping("/KamarBPJS")
	List<RekKamarBPJS> GetKamarBPJS(@RequestParam("id") Long id) {
		return kamarBPJSRepository.findByid(id);
	}   
  
    
    @GetMapping("/Rek")
    public ResponseEntity<RekModel> getRek(@RequestParam("id") Long id) {

        // ===== Header (Optional) =====
        Optional<Rek> pxOpt = rekService.getByidreg(id);
        if (pxOpt.isEmpty()) {
            return ResponseEntity.ok(null);
        }
        Rek px = pxOpt.get();

        RekModel resp = new RekModel();
        resp.setId(px.getId());
        resp.setRegister(px.getRegister());
        resp.setNama(px.getNama());
        resp.setAddr(px.getAddr());
        resp.setKelurahan(px.getKelurahan());
        resp.setJenisKelamin(px.getJenisKelamin());
        resp.setTanggalLahir(px.getTanggalLahir());
        resp.setKasir(px.getKasir());
        resp.setShift(px.getShift());
        resp.setTglbyr(px.getTglbyr());
        resp.setPxrj(px.getPxrj());
        resp.setTotal(px.getTotal());

        // ===== Kamar BPJS (list) =====
        List<RekKamarBPJS> kamarRows = kamarBPJSRepository.findByid(id);
        List<RekKamarBPJSModel> kamarList = new ArrayList<>();
        if (kamarRows != null && !kamarRows.isEmpty()) {
            for (var r : kamarRows) {
                RekKamarBPJSModel m = new RekKamarBPJSModel();
                m.setNomer(r.getNomer());
                m.setId(r.getId());
                m.setKelasid(r.getKelasid());
                m.setTmasuk(r.getTmasuk());
                m.setTkeluar(r.getTkeluar());
                m.setLama(r.getLama() == null ? null : r.getLama().floatValue());
                m.setSewa(r.getSewa() == null ? null : r.getSewa().floatValue());
                m.setDiscount(r.getDiscount() == null ? null : r.getDiscount().floatValue());
                m.setKelas(r.getKelas());
                m.setRoomname(r.getRoomname());
                kamarList.add(m);
            }
        }
        resp.setRekKamarBPJS(kamarList);

        // ===== Visit (list) =====
        List<RekVisit> visitRows = rekVisitService.getByidreg(id);
        List<RekVisitModel> visitList = new ArrayList<>();
        if (visitRows != null && !visitRows.isEmpty()) {
            for (var v : visitRows) {
                RekVisitModel vm = new RekVisitModel();
                vm.setIdd(v.getIdd());
                vm.setId(v.getId());
                vm.setDokter(v.getDokter());
                vm.setNtimes(v.getNtimes());
                vm.setBiaya(v.getBiaya());
                vm.setDiscount(v.getDiscount() == null ? null : v.getDiscount().floatValue());
                visitList.add(vm);
            }
        }
        resp.setRekVisits(visitList);
        
     // ===== Tindakan (list) =====
        List<RekTindakan> tindakanRows = rekTindakanService.getByidreg(id);
        List<RekTindakanModel> TindakanList = new ArrayList<>();
        if (tindakanRows != null && !tindakanRows.isEmpty()) {
            for (var t : tindakanRows) {
                RekTindakanModel tm = new RekTindakanModel();
                tm.setIdd(t.getIdd());
                tm.setId(t.getId());
                tm.setTindak(t.getTindak());
                tm.setNtimes(t.getNtimes());
                tm.setBiayatindak(t.getBiayatindak());
                tm.setDiscount(t.getDiscount() == null ? null : t.getDiscount().floatValue());
                TindakanList.add(tm);
            }
        }
        resp.setRekTindakans(TindakanList);
        
     // ===== Laborat (list) =====
        List<RekLaborat> laboratRows = rekLaboratService.getByidreg(id);
        List<RekLaboratModel> LaboratList = new ArrayList<>();
        if (laboratRows != null && !laboratRows.isEmpty()) {
            for (var l : laboratRows) {
            	RekLaboratModel lm = new RekLaboratModel();
                lm.setIdd(l.getIdd());
                lm.setId(l.getId());
                lm.setTlab(l.getTlab());
                lm.setBiayalab(l.getBiayalab());
                lm.setDiscount(l.getDiscount() == null ? null : l.getDiscount().floatValue());
                LaboratList.add(lm);
            }
        }
        resp.setRekLaborats(LaboratList);
        
     // ===== Radiologi (list) =====
        List<RekRadiologi> radiologiRows = rekRadiologiService.getByidreg(id);
        List<RekRadiologiModel> RadiologiList = new ArrayList<>();
        if (radiologiRows != null && !radiologiRows.isEmpty()) {
            for (var ra : radiologiRows) {
            	RekRadiologiModel ram = new RekRadiologiModel();
            	ram.setIdd(ra.getIdd());
            	ram.setId(ra.getId());
            	ram.setTrad(ra.getTrad());
            	ram.setBiayarad(ra.getBiayarad());
            	ram.setDiscount(ra.getDiscount() == null ? null : ra.getDiscount().floatValue());
            	ram.setPeriksa(ra.getPeriksa());
                RadiologiList.add(ram);
            }
        }
        resp.setRekRadiologis(RadiologiList);
        
     // ===== Lain (list) =====
        List<RekLain> lainRows = rekLainService.getByidreg(id);
        List<RekLainModel> LainList = new ArrayList<>();
        if (lainRows != null && !lainRows.isEmpty()) {
            for (var ll : lainRows) {
            	RekLainModel llm = new RekLainModel();
                llm.setIdd(ll.getIdd());
                llm.setId(ll.getId());
                llm.setLain(ll.getLain());
                llm.setBiaya(ll.getBiaya());
                llm.setDiscount(ll.getDiscount() == null ? null : ll.getDiscount().floatValue());
                LainList.add(llm);
            }
        }
        resp.setRekLains(LainList);
        
     // ===== Operasi (list) =====
        List<RekOperasi> operasiRows = rekOperasiService.getByidreg(id);
        List<RekOperasiModel> OperasiList = new ArrayList<>();
        if (operasiRows != null && !operasiRows.isEmpty()) {
            for (var o : operasiRows) {
            	RekOperasiModel om = new RekOperasiModel();
                om.setIdd(o.getIdd());
                om.setId(o.getId());
                om.setNamajenis(o.getNamajenis());
                om.setBiaya(o.getBiaya());
                om.setPot(o.getPot() == null ? null : o.getPot().floatValue());
                om.setC(o.getC());
                OperasiList.add(om);
            }
        }
        resp.setRekOperasis(OperasiList);    
      
     // ===== Obat (list) =====
        List<RekObat> obatRows = rekObatService.getByidreg(id);
        List<RekObatModel> ObatList = new ArrayList<>();
        if (obatRows != null && !obatRows.isEmpty()) {
            for (var o : obatRows) {
            	RekObatModel om = new RekObatModel();
                om.setIdd(o.getIdd());
                om.setId(o.getId());
                om.setDate(o.getDate());
                om.setHutangobat(o.getHutangobat());
                ObatList.add(om);
            }
        }
        resp.setRekObats(ObatList);        
        
        return ResponseEntity.ok(resp);
    }


}



