package com.dev.generik.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dev.generik.exception.CustomException;
import com.dev.generik.entities.HaloRSA.PxRJPCRALL;
import com.dev.generik.entities.HaloRSA.RatingRegNew;
import com.dev.generik.entities.HaloRSA.Reg;
import com.dev.generik.entities.HaloRSA.RegPxOLNew;
import com.dev.generik.entities.HaloRSA.RiwayatReg;
import com.dev.generik.entities.JadwalDokter.JadwalDokterDisplay;
import com.dev.generik.entities.JadwalDokter.JadwalDokterHr;
import com.dev.generik.entities.JadwalDokter.JadwalDokterPrak;
import com.dev.generik.entities.JadwalDokter.JadwalDokterPrakLab;
import com.dev.generik.entities.JadwalDokter.JadwalDokterPrakV2;
import com.dev.generik.entities.JadwalOP.JadOPBPJS;
import com.dev.generik.entities.JadwalOP.JadwalOperasi;
import com.dev.generik.entities.JadwalOP.JadwalOperasiNow;
import com.dev.generik.entities.JadwalOP.JadwalOperasiPen;
import com.dev.generik.entities.Lab.HasilPCR;
import com.dev.generik.entities.Lab.HasilPCRWS;
import com.dev.generik.entities.Lab.Lab;
import com.dev.generik.entities.Lab.LabAntigen;
import com.dev.generik.entities.Lab.LabHasil;
import com.dev.generik.entities.Lab.LabHasilLevel;
import com.dev.generik.entities.Lab.PCRExternal;
import com.dev.generik.entities.Lab.PCRExternalCus;
import com.dev.generik.entities.Lab.PCRExternalView;
import com.dev.generik.entities.Lab.PCRRekanan;
import com.dev.generik.entities.PX.Agama;
import com.dev.generik.entities.PX.Asuransi;
import com.dev.generik.entities.PX.Kecamatan;
import com.dev.generik.entities.PX.Kelurahan;
import com.dev.generik.entities.PX.Pendidikan;
import com.dev.generik.entities.PX.Suku;
import com.dev.generik.entities.RJ.StatusTransaksiRJ;
import com.dev.generik.exception.PxInapNotFound;
import com.dev.generik.entities.Dokter.WebDokter;
import com.dev.generik.models.ResponseX;
import com.dev.generik.models.Metadata;
import com.dev.generik.models.LabModel;
import com.dev.generik.models.LaboratModel;
import com.dev.generik.models.LabIdModel;
import com.dev.generik.models.HasilPCRWSModel;
import com.dev.generik.models.HasPCRWSModel;
import com.dev.generik.models.PCRExternalModel;
import com.dev.generik.models.PCRExtModel;
//import com.dev.generik.models.PCRExternalRekananModel;
import com.dev.generik.models.PCRInstansiModel;
//import com.dev.generik.models.PCRExtRekModel;
import com.dev.generik.repository.HaloRSA.RatingRegNewRepository;
import com.dev.generik.repository.HaloRSA.RegPxOlRepository;
import com.dev.generik.repository.HaloRSA.RegRepository;
import com.dev.generik.repository.HaloRSA.RiwayatRegRepository;
import com.dev.generik.repository.JadwalDokter.JadwalDokterDisplayRepository;
import com.dev.generik.repository.JadwalDokter.JadwalDokterHrRepository;
import com.dev.generik.repository.JadwalDokter.JadwalDokterPrakLabRepository;
import com.dev.generik.repository.JadwalDokter.JadwalDokterPrakRepository;
import com.dev.generik.repository.JadwalDokter.JadwalDokterPrakV2Repository;
import com.dev.generik.repository.JadwalDokter.JadwalDokterRepository;
import com.dev.generik.repository.JadwalOP.JadOPBPJSRepository;
import com.dev.generik.repository.JadwalOP.JadOperasiNowRepository;
import com.dev.generik.repository.JadwalOP.JadOperasiPenRepository;
import com.dev.generik.repository.JadwalOP.JadOperasiRepository;
import com.dev.generik.repository.Lab.GeNoseRepository;
import com.dev.generik.repository.Lab.HasilPCRWSRepository;
import com.dev.generik.repository.Lab.LabAntigenRepository;
import com.dev.generik.repository.Lab.LabHasilLevelRepository;
import com.dev.generik.repository.Lab.LabHasilRepository;
import com.dev.generik.repository.Lab.LabRepository;
import com.dev.generik.repository.Lab.PCREkternalCusRepository;
import com.dev.generik.repository.Lab.PCREkternalViewRepository;
import com.dev.generik.repository.Lab.PCRExternalRepository;
import com.dev.generik.repository.Lab.PCRRekananRepository;
import com.dev.generik.repository.Lab.PxRJPCRALLRepository;
import com.dev.generik.repository.PX.AgamaRepository;
import com.dev.generik.repository.PX.AsuransiRepository;
import com.dev.generik.repository.PX.CamatRepository;
import com.dev.generik.repository.PX.LurahRepository;
import com.dev.generik.repository.PX.PendidikanRepository;
import com.dev.generik.repository.PX.SukuRepository;
import com.dev.generik.repository.RJ.StatusTransaksiRJRepository;
import com.dev.generik.repository.Dokter.HasilPCRRepository;
import com.dev.generik.repository.Dokter.WebDokterRepository;
import com.dev.generik.service.ValidatorFieldService;

@RestController
@RequestMapping("his/reg")
public class RegController {

	@Autowired
	JadwalDokterRepository jadwalrepository;
	@Autowired
	JadwalDokterHrRepository hrRepository;
	@Autowired
	JadwalDokterPrakRepository prakRepository;
	@Autowired
	JadwalDokterPrakV2Repository prakV2Repository;
	@Autowired
	JadwalDokterPrakLabRepository prakLabRepository;
	@Autowired
	RiwayatRegRepository riwayatRepository;
	@Autowired
	JadOPBPJSRepository jadOPBPJSRepository;
	@Autowired
	JadOperasiRepository jadwaloperasiRepository;
	@Autowired
	JadOperasiNowRepository jadwaloperasinowRepository;
	@Autowired
	JadOperasiPenRepository jadwaloperasipenRepository;
	@Autowired
	AsuransiRepository asuransiRepository;
	@Autowired
	WebDokterRepository webdokterRepository;
	@Autowired
	RatingRegNewRepository ratingRegNewRepository;
	@Autowired
	JadwalDokterDisplayRepository jadwalDokterDisplayRepository;
	@Autowired
	RegRepository regRepository;
	@Autowired
	StatusTransaksiRJRepository statusTransaksiRJRepository;
	@Autowired
	RegPxOlRepository regPxOlRepository;
	@Autowired
	AgamaRepository agamaRepository;
	@Autowired
	SukuRepository sukuRepository;
	@Autowired
	PendidikanRepository pendidikanRepository;
	@Autowired
	LurahRepository lurahRepository;
	@Autowired
	CamatRepository camatRepository;
	@Autowired
	LabRepository labRepository;
	@Autowired
	LabHasilRepository labHasilRepository;
	@Autowired
	LabHasilLevelRepository labHasilLevelRepository;
	@Autowired
	LabAntigenRepository labAntigenRepository;
	@Autowired
	HasilPCRRepository hasilPCRRepository;
	@Autowired
	PxRJPCRALLRepository pxRJPCRALLRepository;
	@Autowired
	HasilPCRWSRepository hasilPCRWSRepository;
	@Autowired
	PCRExternalRepository pCRExternalRepository;
	@Autowired
	GeNoseRepository geNoseRepository;
	@Autowired
	PCRRekananRepository pCRRekananRepository;
	@Autowired
	PCREkternalViewRepository pCREkternalViewRepository;
	@Autowired
	PCREkternalCusRepository pCREkternalCusRepository;
	@Autowired
	ValidatorFieldService validatorFieldService;
	
	static final String SEQ_NUMERIC  = "0123456789";

	@GetMapping("/jadwaldokterdisplay")
	CollectionModel<EntityModel<JadwalDokterDisplay>> listJadwalDokterDisplay() {
		List<EntityModel<JadwalDokterDisplay>> dokterdisjadwal = jadwalDokterDisplayRepository.findAll().stream()
				.map(jadwaldokterdisplay -> EntityModel.of(jadwaldokterdisplay,
						// linkTo(methodOn(CollectionInfoController.class).jadwalDokterById(jadwaldokter.getId())).withSelfRel(),
						// linkTo(methodOn(CollectionInfoController.class).jadwalDokterByhr(jadwaldokter.getHr())).withSelfRel(),
						// linkTo(methodOn(CollectionInfoController.class).jadwalDokterBydr(jadwaldokter.getDr())).withSelfRel(),
						linkTo(methodOn(CollectionInfoController.class).listJadwalDokter()).withRel("jadwaldokter")))
				.collect(Collectors.toList());

		return CollectionModel.of(dokterdisjadwal,
				linkTo(methodOn(CollectionInfoController.class).listJadwalDokter()).withSelfRel());
	}

	@GetMapping("/jadwaldokter")
	CollectionModel<EntityModel<JadwalDokterHr>> listJadwalDokter() {
		List<EntityModel<JadwalDokterHr>> dokterjadwal = hrRepository.findAll().stream()
				.map(jadwaldokter -> EntityModel.of(jadwaldokter,
						// linkTo(methodOn(CollectionInfoController.class).jadwalDokterById(jadwaldokter.getId())).withSelfRel(),
						// linkTo(methodOn(CollectionInfoController.class).jadwalDokterByhr(jadwaldokter.getHr())).withSelfRel(),
						// linkTo(methodOn(CollectionInfoController.class).jadwalDokterBydr(jadwaldokter.getDr())).withSelfRel(),
						linkTo(methodOn(CollectionInfoController.class).listJadwalDokter()).withRel("jadwaldokter")))
				.collect(Collectors.toList());

		return CollectionModel.of(dokterjadwal,
				linkTo(methodOn(CollectionInfoController.class).listJadwalDokter()).withSelfRel());
	}

	@GetMapping("/jadwaldokter/dr")
	CollectionModel<EntityModel<JadwalDokterHr>> JadwalDokterHrBydr(@RequestParam(name = "dr") Long dr) {

		List<EntityModel<JadwalDokterHr>> rd = hrRepository.findBydr(dr).stream()
				.map(jadwaldokterhr -> EntityModel.of(jadwaldokterhr,
						linkTo(methodOn(CollectionInfoController.class).listJadwalDokter()).withRel("jadwaldokter")))
				.collect(Collectors.toList());

		return CollectionModel.of(rd,
				linkTo(methodOn(CollectionInfoController.class).listJadwalDokter()).withSelfRel());
	}

	@GetMapping("/jadwaldokter/dh")
	CollectionModel<EntityModel<JadwalDokterPrak>> JadwalDokterPrakBydrhr(@RequestParam(name = "dr") Long dr,
			@RequestParam(name = "hr") Long hr) {

		List<EntityModel<JadwalDokterPrak>> dh = prakRepository.findByDrAndHr(dr, hr).stream()
				.map(jadwaldokterprak -> EntityModel.of(jadwaldokterprak,
						linkTo(methodOn(CollectionInfoController.class).listJadwalDokter()).withRel("jadwaldokter")))
				.collect(Collectors.toList());

		return CollectionModel.of(dh,
				linkTo(methodOn(CollectionInfoController.class).listJadwalDokter()).withSelfRel());
	}
	
	@GetMapping("/jadwaldokterV2/dh")
	CollectionModel<EntityModel<JadwalDokterPrakV2>> JadwalDokterPrakV2Bydrhr(@RequestParam(name = "dr") Long dr,
			@RequestParam(name = "hr") Long hr) {

		List<EntityModel<JadwalDokterPrakV2>> dh = prakV2Repository.findByDrAndHr(dr, hr).stream()
				.map(jadwaldokterprakV2 -> EntityModel.of(jadwaldokterprakV2))//,
					//	linkTo(methodOn(CollectionInfoController.class).listJadwalDokter()).withRel("jadwaldokter")))
				.collect(Collectors.toList());

		return CollectionModel.of(dh,
				linkTo(methodOn(CollectionInfoController.class).listJadwalDokter()).withSelfRel());
	}

	@GetMapping("/jadwaldokterLab/dh")
	CollectionModel<EntityModel<JadwalDokterPrakLab>> JadwalDokterPrakLabBydrhr(@RequestParam(name = "dr") Long dr,
			@RequestParam(name = "hr") Long hr) {

		List<EntityModel<JadwalDokterPrakLab>> dh = prakLabRepository.findByDrAndHr(dr, hr).stream()
				.map(jadwaldokterpraklab -> EntityModel.of(jadwaldokterpraklab,
						linkTo(methodOn(CollectionInfoController.class).listJadwalDokter()).withRel("jadwaldokter")))
				.collect(Collectors.toList());

		return CollectionModel.of(dh,
				linkTo(methodOn(CollectionInfoController.class).listJadwalDokter()).withSelfRel());
	}

	@GetMapping("/riwayatreg/userid")
	CollectionModel<EntityModel<RiwayatReg>> RiwayatRegByUserid(@RequestParam(name = "userid") String userid) {

		List<EntityModel<RiwayatReg>> riw = riwayatRepository.findByuserid(userid).stream()
				.map(riwayatreg -> EntityModel.of(riwayatreg,
						linkTo(methodOn(CollectionInfoController.class).listJadwalDokter()).withRel("jadwaldokter")))
				.collect(Collectors.toList());

		return CollectionModel.of(riw,
				linkTo(methodOn(CollectionInfoController.class).listJadwalDokter()).withSelfRel());
	}

	@GetMapping("/jadOPBPJS")
	CollectionModel<EntityModel<JadOPBPJS>> listJadOPBPJS() {
		List<EntityModel<JadOPBPJS>> opbpjsjadwal = jadOPBPJSRepository.findAll().stream()
				.map(opBPJSjadwal -> EntityModel.of(opBPJSjadwal)) // ,
				// linkTo(methodOn(RegController.class).listJadOPBPJS()).withRel("jadOPBPJS")))
				.collect(Collectors.toList());

		return CollectionModel.of(opbpjsjadwal, linkTo(methodOn(RegController.class).listJadOPBPJS()).withSelfRel());
	}

	@GetMapping("/jadOpBPJS/date")
	CollectionModel<EntityModel<JadOPBPJS>> jadOPBPJSBydate(
			@RequestParam(name = "bdate") @DateTimeFormat(pattern = "dd.MM.yyyy") Date bdate,
			@RequestParam(name = "edate") @DateTimeFormat(pattern = "dd.MM.yyyy") Date edate) {

		List<EntityModel<JadOPBPJS>> opbpjsjadwal = jadOPBPJSRepository.findByTanggaloperasiBetween(bdate, edate)
				.stream().map(opbpjs -> EntityModel.of(opbpjs)) // ,
//						linkTo(methodOn(RegController.class).listJadOPBPJS()).withRel("jadOPBPJS")))
				.collect(Collectors.toList());

		return CollectionModel.of(opbpjsjadwal,
				linkTo(methodOn(RegController.class).jadOPBPJSBydate(bdate, edate)).withSelfRel());
	}

	@GetMapping("/jadwaloperasi")
	CollectionModel<EntityModel<JadwalOperasi>> listJadwaloperasi() {
		List<EntityModel<JadwalOperasi>> operasijadwal = jadwaloperasiRepository.findAll().stream()
				.map(operasijad -> EntityModel.of(operasijad)).collect(Collectors.toList());

		return CollectionModel.of(operasijadwal,
				linkTo(methodOn(RegController.class).listJadwaloperasi()).withSelfRel());
	}

	@GetMapping("/jadwaloperasi/layanan")
	CollectionModel<EntityModel<JadwalOperasi>> jadwalOperasiBylayanan(@RequestParam(name = "lay") String lay) {

		List<EntityModel<JadwalOperasi>> ojl = jadwaloperasiRepository.findBylayanan(lay).stream()
				.map(opjadlay -> EntityModel.of(opjadlay)) // ,
				// linkTo(methodOn(RegController.class).listJadwaloperasi()).withRel("jadwaloperasi")))
				.collect(Collectors.toList());

		return CollectionModel.of(ojl, linkTo(methodOn(RegController.class).listJadwaloperasi()).withSelfRel());
	}

	@GetMapping("/jadwaloperasi/dokter")
	CollectionModel<EntityModel<JadwalOperasi>> jadwalOperasiBydokter(@RequestParam(name = "dr") String dr) {

		List<EntityModel<JadwalOperasi>> ojd = jadwaloperasiRepository.findBydokter(dr).stream()
				.map(opjaddr -> EntityModel.of(opjaddr)) // ,
				// linkTo(methodOn(RegController.class).listJadwaloperasi()).withRel("jadwaloperasi")))
				.collect(Collectors.toList());

		return CollectionModel.of(ojd, linkTo(methodOn(RegController.class).listJadwaloperasi()).withSelfRel());
	}

	@GetMapping("/jadwaloperasinow/layanan")
	CollectionModel<EntityModel<JadwalOperasiNow>> jadwalOperasiNowBylayanan(@RequestParam(name = "lay") String lay) {

		List<EntityModel<JadwalOperasiNow>> ojln = jadwaloperasinowRepository.findBylayanan(lay).stream()
				.map(opjadnlay -> EntityModel.of(opjadnlay)) // ,
				// linkTo(methodOn(RegController.class).listJadwaloperasi()).withRel("jadwaloperasi")))
				.collect(Collectors.toList());

		return CollectionModel.of(ojln, linkTo(methodOn(RegController.class).listJadwaloperasi()).withSelfRel());
	}

	@GetMapping("/jadwaloperasipen")
	CollectionModel<EntityModel<JadwalOperasiPen>> listJadwaloperasipen() {
		List<EntityModel<JadwalOperasiPen>> operasijadwalpen = jadwaloperasipenRepository.findAll().stream()
				.map(operasijadpen -> EntityModel.of(operasijadpen)).collect(Collectors.toList());

		return CollectionModel.of(operasijadwalpen,
				linkTo(methodOn(RegController.class).listJadwaloperasipen()).withSelfRel());
	}

	@GetMapping("/asuransi")
	CollectionModel<EntityModel<Asuransi>> listAsuransi() {
		List<EntityModel<Asuransi>> asuran = asuransiRepository.findAll().stream().map(asur -> EntityModel.of(asur))
				.collect(Collectors.toList());

		return CollectionModel.of(asuran, linkTo(methodOn(RegController.class).listAsuransi()).withSelfRel());
	}

	@GetMapping("/webdokter")
	CollectionModel<EntityModel<WebDokter>> listWebDokter() {
		List<EntityModel<WebDokter>> webdok = webdokterRepository.findAll().stream().map(webd -> EntityModel.of(webd))
				.collect(Collectors.toList());

		return CollectionModel.of(webdok, linkTo(methodOn(RegController.class).listWebDokter()).withSelfRel());
	}

	@GetMapping("/newRating/ratingid")
	EntityModel<RatingRegNew> getRatingRegNew(@RequestParam Long id) {
		RatingRegNew rat = ratingRegNewRepository.findById(id).orElseThrow(() -> new PxInapNotFound(id));
		return EntityModel.of(rat, linkTo(methodOn(RegController.class).getRatingRegNew(id)).withSelfRel());
	}

	@PostMapping("/newRating")
	ResponseEntity<EntityModel<RatingRegNew>> addNewRating(@RequestBody RatingRegNew ratingNew)
			throws URISyntaxException {
		RatingRegNew ratingSave = ratingRegNewRepository.save(ratingNew);
		EntityModel<RatingRegNew> resource = EntityModel.of(ratingSave,
				linkTo(methodOn(RegController.class).getRatingRegNew(ratingSave.getKd())).withSelfRel());

		return ResponseEntity.created(resource.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(resource);
	}

	@GetMapping("/regpxol/regpxolid")
	EntityModel<RegPxOLNew> getRegPxOL(@RequestParam Long id) {
		RegPxOLNew regpx = regPxOlRepository.findById(id).orElseThrow(() -> new PxInapNotFound(id));
		return EntityModel.of(regpx, linkTo(methodOn(RegController.class).getRegPxOL(id)).withSelfRel());
	}

	@GetMapping("/regpxol/userid")
	CollectionModel<EntityModel<RegPxOLNew>> RegPxOLNewByUserid(@RequestParam(name = "userid") String userid) {

		List<EntityModel<RegPxOLNew>> rpo = regPxOlRepository.findByuserid(userid).stream()
				.map(regPxOLNew -> EntityModel.of(regPxOLNew,
						linkTo(methodOn(CollectionInfoController.class).listJadwalDokter()).withRel("jadwaldokter")))
				.collect(Collectors.toList());

		return CollectionModel.of(rpo,
				linkTo(methodOn(CollectionInfoController.class).listJadwalDokter()).withSelfRel());
	}

//	@PostMapping("/regpxol")
//	ResponseEntity<EntityModel<RegPxOLNew>> addregpxol(@RequestBody RegPxOLNew regPxOL) throws URISyntaxException {
//		RegPxOLNew regPxOLSave = regPxOlRepository.save(regPxOL);
//		EntityModel<RegPxOLNew> resource = EntityModel.of(regPxOLSave,
//				linkTo(methodOn(RegController.class).getRegPxOL(regPxOLSave.getId())).withSelfRel());

//		return ResponseEntity.created(resource.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(resource);
//	}
	
	@PostMapping("/regpxol")
	ResponseEntity<EntityModel<RegPxOLNew>> addregpxolv3(@RequestBody RegPxOLNew regPxOL) throws URISyntaxException {
		if (regPxOL.getNama().isBlank() ||
			regPxOL.getNama().isEmpty() ||
			regPxOL.getNama().length()>=31) {
					final String msg = "Nama Tidak valid atau Nama terlalu panjang (Maksimal 30 huruf)";
					throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg,HttpStatus.BAD_REQUEST);		
			}
		if (regPxOL.getNik().isBlank() || 
				regPxOL.getNik().isEmpty() ||
				!validatorFieldService.isValidSequence(SEQ_NUMERIC, regPxOL.getNik())) {
				final String msg = "Nomer NIK Tidak Valid atau Tidak Boleh Selain Angka!";
				throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg,HttpStatus.BAD_REQUEST);		
			}
		if (regPxOL.getNojkn().isBlank() || 
				regPxOL.getNojkn().isEmpty() ||
				!validatorFieldService.isValidSequence(SEQ_NUMERIC, regPxOL.getNojkn())) {
				final String msg = "Nomer JKN Tidak Valid atau Tidak Boleh Selain Angka!";
				throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg,HttpStatus.BAD_REQUEST);		
			}
		if (regPxOL.getAddr().length()>=45) {
						final String msg = "Alamat terlalu panjang (Maksimal 45 huruf)";
						throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg,HttpStatus.BAD_REQUEST);		
			}
		if (regPxOL.getSuamiistri().length()>=20) {
			final String msg = "Nama Suamai/Istri terlalu panjang (Maksimal 20 huruf)";
			throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg,HttpStatus.BAD_REQUEST);		
			}
		if (regPxOL.getAyahibu().length()>=15) {
			final String msg = "Nama Ayah terlalu panjang (Maksimal 15 huruf)";
			throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg,HttpStatus.BAD_REQUEST);		
		}
		else {
				
		RegPxOLNew regPxOLSave = regPxOlRepository.save(regPxOL);
		EntityModel<RegPxOLNew> resource = EntityModel.of(regPxOLSave,
				linkTo(methodOn(RegController.class).getRegPxOL(regPxOLSave.getId())).withSelfRel());

		return ResponseEntity.created(resource.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(resource);
			}
	}
	
	//
	@GetMapping("/hasilpcr")
	CollectionModel<EntityModel<HasilPCR>> hasilpcrByid(@RequestParam(name = "id") Long id) {

		List<EntityModel<HasilPCR>> rpo = hasilPCRRepository.findById(id).stream()
				.map(regPxOLNew -> EntityModel.of(regPxOLNew,
						linkTo(methodOn(CollectionInfoController.class).listJadwalDokter()).withRel("jadwaldokter")))
				.collect(Collectors.toList());

		return CollectionModel.of(rpo,
				linkTo(methodOn(CollectionInfoController.class).listJadwalDokter()).withSelfRel());
	}

	@PostMapping("/hasilpcr")
	ResponseEntity<EntityModel<HasilPCR>> addhasilpcr(@RequestBody HasilPCR hasilPCR) throws URISyntaxException {
		HasilPCR hasilPCRSave = hasilPCRRepository.save(hasilPCR);
		EntityModel<HasilPCR> resource = EntityModel.of(hasilPCRSave,
				linkTo(methodOn(RegController.class).getRegPxOL(hasilPCRSave.getId())).withSelfRel());

		return ResponseEntity.created(resource.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(resource);
	}

	@DeleteMapping("/deletehasilpcr")
	void deletehasilPCR(@RequestParam(name = "id") Long id) {
		hasilPCRRepository.deleteById(id);
		System.out.println("delete record PCR External....");
	}

	@PostMapping("/HasilPCR/Hasil")
	public ResponseEntity<ResponseX<HasPCRWSModel, Metadata>> getLab(@RequestBody HasilPCRWS nope) {

		Optional<List<HasilPCRWS>> px = hasilPCRWSRepository.findByIdAndRmAndTgl(nope.getId(), nope.getRm(),
				nope.getTgl());
		if (px.isPresent()) {
			final List<HasilPCRWSModel> pxList = new ArrayList<>();
			px.get().forEach(p -> pxList.add(new HasilPCRWSModel(p.getId(), p.getRm(), p.getTgl(), p.getPcr())));

			ResponseEntity<List<HasilPCRWS>> ok = ResponseEntity.of(px);
			String messageOk = "Ok";
			Metadata metadata = new Metadata(ok.getStatusCode().value(), messageOk);
			ResponseX<HasPCRWSModel, Metadata> responseX = new ResponseX<>(new HasPCRWSModel(pxList), metadata);
			return ResponseEntity.ok(responseX);
		} else {
			final String msg = "ID, No RM, Tanggal Lahir ada yang salah";
			throw new CustomException(HttpStatus.NOT_FOUND.value(), msg, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/reg")
	CollectionModel<EntityModel<Reg>> listReg() {
		List<EntityModel<Reg>> webdok = regRepository.findAll().stream().map(webd -> EntityModel.of(webd))
				.collect(Collectors.toList());

		return CollectionModel.of(webdok, linkTo(methodOn(RegController.class).listReg()).withSelfRel());
	}

	@GetMapping("/reg/reg")
	CollectionModel<EntityModel<Reg>> RegByreg(@RequestParam(name = "reg") String reg) {

		List<EntityModel<Reg>> rpo = regRepository.findByreg(reg).stream()
				.map(regPxOLNew -> EntityModel.of(regPxOLNew,
						linkTo(methodOn(CollectionInfoController.class).listJadwalDokter()).withRel("listreg")))
				.collect(Collectors.toList());

		return CollectionModel.of(rpo, linkTo(methodOn(RegController.class).listReg()).withSelfRel());
	}

	@PostMapping("/lab/labantigen")
	public ResponseEntity<ResponseX<LabModel, Metadata>> getLab(@RequestBody LabIdModel nope) {

		Optional<List<LabAntigen>> px = labAntigenRepository.findByIdregAndRmAndTgllhr(nope.getIdreg(), nope.getRm(),
				nope.getTgllhr());
		if (px.isPresent()) {
			final List<LaboratModel> pxList = new ArrayList<>();
			px.get().forEach(p -> pxList.add(new LaboratModel(p.getId(), p.getIdreg(), p.getTlab(), p.getJamambil(),
					p.getJamcek(), p.getDokter(), p.getRm(), p.getNama(), p.getTgllhr(), p.getJk(), p.getAddr(),
					p.getKelas(), p.getGrplab(), p.getRoom(), p.getTh(), p.getBln(), p.getHr())));

			ResponseEntity<List<LabAntigen>> ok = ResponseEntity.of(px);
			String messageOk = "Ok";
			Metadata metadata = new Metadata(ok.getStatusCode().value(), messageOk);
			ResponseX<LabModel, Metadata> responseX = new ResponseX<>(new LabModel(pxList), metadata);
			return ResponseEntity.ok(responseX);
		} else {
			final String msg = "ID, No RM, Tanggal Lahir ada yang salah";
			throw new CustomException(HttpStatus.NOT_FOUND.value(), msg, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/lab/lab")
	CollectionModel<EntityModel<Lab>> LabByid(@RequestParam(name = "id") Long id) {
		List<EntityModel<Lab>> la = labRepository.findByid(id).stream().map(lab -> EntityModel.of(lab))
				.collect(Collectors.toList());

		return CollectionModel.of(la, linkTo(methodOn(RegController.class).listReg()).withSelfRel());
	}

	@GetMapping("/lab/labhasil")
	CollectionModel<EntityModel<LabHasil>> LabHasilByidlab(@RequestParam(name = "idlab") Long idlab) {
		List<EntityModel<LabHasil>> labh = labHasilRepository.findByidlab(idlab).stream()
				.map(labha -> EntityModel.of(labha)).collect(Collectors.toList());

		return CollectionModel.of(labh, linkTo(methodOn(RegController.class).listReg()).withSelfRel());
	}

	@GetMapping("/lab/labhasillevel")
	CollectionModel<EntityModel<LabHasilLevel>> LabHasilLevelBylvl(@RequestParam(name = "lvl") Long lvl) {
		List<EntityModel<LabHasilLevel>> lahal = labHasilLevelRepository.findBylvl(lvl).stream()
				.map(labhale -> EntityModel.of(labhale)).collect(Collectors.toList());

		return CollectionModel.of(lahal, linkTo(methodOn(RegController.class).listReg()).withSelfRel());
	}

	@GetMapping("/statustransaksirj")
	CollectionModel<EntityModel<StatusTransaksiRJ>> listStatusTransaksiRJ() {
		List<EntityModel<StatusTransaksiRJ>> rjstatustransaksi = statusTransaksiRJRepository.findAll().stream()
				.map(strj -> EntityModel.of(strj)).collect(Collectors.toList());

		return CollectionModel.of(rjstatustransaksi,
				linkTo(methodOn(RegController.class).listStatusTransaksiRJ()).withSelfRel());
	}

	@GetMapping("/agama")
	CollectionModel<EntityModel<Agama>> listAgama() {
		List<EntityModel<Agama>> aga = agamaRepository.findAll().stream().map(agm -> EntityModel.of(agm))
				.collect(Collectors.toList());

		return CollectionModel.of(aga, linkTo(methodOn(RegController.class).listAgama()).withSelfRel());
	}
	
	@GetMapping("/agamaV2")
	public List<Agama> listAgamaV2() {
	    return agamaRepository.findAll();
	}
	
	@GetMapping("/sukuV2")
	public List<Suku> listSukuV2() {
	    return sukuRepository.findAll();
	}
	
	@GetMapping("/pendidikanV2")
	public List<Pendidikan> listPendidikanV2() {
	    return pendidikanRepository.findAll();
	}

	@GetMapping("/suku")
	CollectionModel<EntityModel<Suku>> listSuku() {
		List<EntityModel<Suku>> suk = sukuRepository.findAll().stream().map(sk -> EntityModel.of(sk))
				.collect(Collectors.toList());

		return CollectionModel.of(suk, linkTo(methodOn(RegController.class).listSuku()).withSelfRel());
	}

	@GetMapping("/pendidikan")
	CollectionModel<EntityModel<Pendidikan>> listPendidikan() {
		List<EntityModel<Pendidikan>> pend = pendidikanRepository.findAll().stream().map(pendi -> EntityModel.of(pendi))
				.collect(Collectors.toList());

		return CollectionModel.of(pend, linkTo(methodOn(RegController.class).listPendidikan()).withSelfRel());
	}

	@GetMapping("/lurah")
	CollectionModel<EntityModel<Kelurahan>> KelurahanByCamatid(@RequestParam(name = "camatid") Long camatid) {
		List<EntityModel<Kelurahan>> lur = lurahRepository.findByCamatid(camatid).stream()
				.map(lura -> EntityModel.of(lura)).collect(Collectors.toList());

		return CollectionModel.of(lur, linkTo(methodOn(RegController.class).listCamat()).withSelfRel());
	}

	@GetMapping("/camat")
	CollectionModel<EntityModel<Kecamatan>> listCamat() {
		List<EntityModel<Kecamatan>> cam = camatRepository.findAll().stream().map(cama -> EntityModel.of(cama))
				.collect(Collectors.toList());

		return CollectionModel.of(cam, linkTo(methodOn(RegController.class).listCamat()).withSelfRel());
	}

	@GetMapping("/pxrjpcrall")
	CollectionModel<EntityModel<PxRJPCRALL>> listPxRJPCRALL() {
		List<EntityModel<PxRJPCRALL>> pxrjpcr = pxRJPCRALLRepository.findAll().stream()
				.map(pxrjpc -> EntityModel.of(pxrjpc)).collect(Collectors.toList());

		return CollectionModel.of(pxrjpcr, linkTo(methodOn(RegController.class).listCamat()).withSelfRel());
	}

	@PostMapping("/PCRExternal")
	ResponseEntity<EntityModel<PCRExternal>> addPCRExernal(@RequestBody PCRExternal pCRExternal)
			throws URISyntaxException {
		PCRExternal pCRExternalSave = pCRExternalRepository.save(pCRExternal);
		EntityModel<PCRExternal> resource = EntityModel.of(pCRExternalSave,
				linkTo(methodOn(RegController.class).getRegPxOL(pCRExternalSave.getId())).withSelfRel());

		return ResponseEntity.created(resource.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(resource);
	}

	@GetMapping("/PCRExternal")
	CollectionModel<EntityModel<PCRExternal>> listPCRExternal() {
		List<EntityModel<PCRExternal>> asuran = pCRExternalRepository.findAll().stream()
				.map(asur -> EntityModel.of(asur)).collect(Collectors.toList());

		return CollectionModel.of(asuran, linkTo(methodOn(RegController.class).listAsuransi()).withSelfRel());
	}

	@GetMapping("/PCRExternal/ID")
	CollectionModel<EntityModel<PCRExternal>> PCREkternalByID(@RequestParam(name = "id") Long id) {

		List<EntityModel<PCRExternal>> ekid = pCRExternalRepository.findById(id).stream()
				.map(pCRExternal -> EntityModel.of(pCRExternal))// ,
				// linkTo(methodOn(CollectionInfoController.class).listJadwalDokter()).withRel("jadwaldokter")))
				.collect(Collectors.toList());

		return CollectionModel.of(ekid,
				linkTo(methodOn(CollectionInfoController.class).listJadwalDokter()).withSelfRel());
	}

	@GetMapping("/PCRExternal/Instansi")
	CollectionModel<EntityModel<PCRExternalCus>> PCREkternalCusByinstansi(
			@RequestParam(name = "instansi") Long instansi) {

		List<EntityModel<PCRExternalCus>> ints = pCREkternalCusRepository.findByInstansi(instansi).stream()
				.map(pCRExternalCus -> EntityModel.of(pCRExternalCus))// ,
				// linkTo(methodOn(CollectionInfoController.class).listJadwalDokter()).withRel("jadwaldokter")))
				.collect(Collectors.toList());

		return CollectionModel.of(ints,
				linkTo(methodOn(CollectionInfoController.class).listJadwalDokter()).withSelfRel());
	}

	@GetMapping("/PCREkternalView")
	CollectionModel<EntityModel<PCRExternalView>> listPCREkternalView() {
		List<EntityModel<PCRExternalView>> asuranvi = pCREkternalViewRepository.findAll().stream()
				.map(asurvi -> EntityModel.of(asurvi)).collect(Collectors.toList());

		return CollectionModel.of(asuranvi, linkTo(methodOn(RegController.class).listAsuransi()).withSelfRel());
	}

	@GetMapping("/PCRRekanan")
	CollectionModel<EntityModel<PCRRekanan>> listPCRRekanan() {
		List<EntityModel<PCRRekanan>> pcrrek = pCRRekananRepository.findAll().stream()
				.map(pcrre -> EntityModel.of(pcrre)).collect(Collectors.toList());

		return CollectionModel.of(pcrrek, linkTo(methodOn(RegController.class).listAsuransi()).withSelfRel());
	}

	/*
	 * @GetMapping("/GeNose") CollectionModel<EntityModel<GeNose>> listGeNose() {
	 * List<EntityModel<GeNose>> genose =
	 * geNoseRepository.findAll().stream().map(gen -> EntityModel.of(gen))
	 * .collect(Collectors.toList());
	 * 
	 * return
	 * CollectionModel.of(genose,linkTo(methodOn(RegController.class).listAsuransi()
	 * ).withSelfRel()); }
	 */

	@PutMapping("/PCRExternal")
	ResponseEntity<EntityModel<PCRExternal>> updatePCRExternal(@RequestParam(name = "id") Long id,
			@RequestBody PCRExternal pCRExternal) throws URISyntaxException {

		PCRExternal pCRExternalUpdate = pCRExternalRepository.findById(id).map(pcr -> {
			pcr.setNama(pCRExternal.getNama());
			pcr.setAlamat(pCRExternal.getAlamat());
			pcr.setTgllahir(pCRExternal.getTgllahir());
			pcr.setTgl(pCRExternal.getTgl());
			pcr.setInstansi(pCRExternal.getInstansi());
			pcr.setKtp(pCRExternal.getKtp());
			pcr.setHasil(pCRExternal.getHasil());
			pcr.setNik(pCRExternal.getNik());
			return pCRExternalRepository.save(pcr);
		}).get();

		EntityModel<PCRExternal> resource = EntityModel.of(pCRExternalUpdate,
				linkTo(methodOn(CollectionInfoController.class).getPxNew(pCRExternalUpdate.getId())).withSelfRel());

		return ResponseEntity.created(resource.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(resource);
	}

	@PutMapping("/PCRExternalBukti")
	ResponseEntity<EntityModel<PCRExternal>> updateBuktiPCRExternal(@RequestParam(name = "id") Long id,
			@RequestBody PCRExternal pCRExternal) throws URISyntaxException {

		PCRExternal pCRExternalUpdate = pCRExternalRepository.findById(id).map(pcr -> {
			pcr.setPembayaran(pCRExternal.getPembayaran());
			pcr.setBukti(pCRExternal.getBukti());

			return pCRExternalRepository.save(pcr);
		}).get();

		EntityModel<PCRExternal> resource = EntityModel.of(pCRExternalUpdate,
				linkTo(methodOn(CollectionInfoController.class).getPxNew(pCRExternalUpdate.getId())).withSelfRel());

		return ResponseEntity.created(resource.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(resource);
	}

	@DeleteMapping("/PCRExternal")
	void deletePCRExternal(@RequestParam(name = "id") Long id) {
		pCRExternalRepository.deleteById(id);
		System.out.println("delete record PCR External....");
	}

	@PostMapping("/PCRExternal/Hasil")
	public ResponseEntity<ResponseX<PCRExtModel, Metadata>> getPCR(@RequestBody PCRExternal nope) {

		Optional<List<PCRExternal>> px = pCRExternalRepository.findByIdAndTgllahir(nope.getId(), nope.getTgllahir());
		if (px.isPresent()) {
			final List<PCRExternalModel> pxList = new ArrayList<>();
			px.get().forEach(p -> pxList.add(new PCRExternalModel(p.getId(), p.getTgllahir(), p.getHasil())));

			ResponseEntity<List<PCRExternal>> ok = ResponseEntity.of(px);
			String messageOk = "Ok";
			Metadata metadata = new Metadata(ok.getStatusCode().value(), messageOk);
			ResponseX<PCRExtModel, Metadata> responseX = new ResponseX<>(new PCRExtModel(pxList), metadata);
			return ResponseEntity.ok(responseX);
		} else {
			final String msg = "ID atau Tanggal Lahir ada yang salah";
			throw new CustomException(HttpStatus.NOT_FOUND.value(), msg, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/PCRExternal/Periode")
	ResponseEntity<ResponseX<List<PCRExternal>, Metadata>> pcrEkternalByfindByInstansiAndTglBetween(
			@RequestBody PCRInstansiModel attMod) {

		Optional<List<PCRExternal>> attPeg = pCRExternalRepository.findByInstansiAndTglBetween(attMod.getInstansi(),
				attMod.getbDate(), attMod.geteDate());
		if (attPeg.isEmpty()) {
			final String msg = "Listing data empty";
			throw new CustomException(HttpStatus.NOT_FOUND.value(), msg, HttpStatus.NOT_FOUND);
		} else {
			ResponseX<List<PCRExternal>, Metadata> responseX = new ResponseX<>(attPeg.get(),
					new Metadata(ResponseEntity.of(Optional.of(attPeg)).getStatusCode().value(),
							ResponseEntity.of(Optional.of(attPeg)).getStatusCode().toString()));
			return ResponseEntity.ok(responseX);
		}
	}

	/*@PostMapping("/PCRExternal/Login1")
	public ResponseEntity<ResponseX<PCRExtRekModel, Metadata>> getPCRRek(@RequestBody PCRRekanan nope) {

		Optional<List<PCRRekanan>> px = pCRRekananRepository.findByUsernameAndPassword(nope.getUsername(),
				nope.getPassword());
		if (px.isPresent()) {
			final List<PCRExternalRekananModel> pxList = new ArrayList<>();
			px.get().forEach(p -> pxList.add(new PCRExternalRekananModel(p.getId())));

			ResponseEntity<List<PCRRekanan>> ok = ResponseEntity.of(px);
			String messageOk = "Ok";
			Metadata metadata = new Metadata(ok.getStatusCode().value(), messageOk);
			ResponseX<PCRExtRekModel, Metadata> responseX = new ResponseX<>(new PCRExtRekModel(pxList), metadata);
			return ResponseEntity.ok(responseX);
		} else {
			final String msg = "Username atau Password ada yang salah";
			throw new CustomException(HttpStatus.NOT_FOUND.value(), msg, HttpStatus.NOT_FOUND);
		}
	}*/
	
	/*
	@PostMapping("/PCRExternal/Login")
	public ResponseEntity<ResponseX<PCRExtRekModel, Metadata>> login(@RequestBody PCRRekanan req) {

	    var listOpt = pCRRekananRepository.findByUsernameAndPassword(req.getUsername(), req.getPassword());

	    if (listOpt.isEmpty() || listOpt.get().isEmpty()) {
	        throw new CustomException(HttpStatus.UNAUTHORIZED.value(),
	                "Username atau Password ada yang salah",
	                HttpStatus.UNAUTHORIZED);
	    }

	    List<PCRExternalRekananModel> pxList = listOpt.get().stream()
	            .map(p -> new PCRExternalRekananModel(p.getId()))
	            .toList();

	    Metadata metadata = new Metadata(HttpStatus.OK.value(), "Ok");
	    ResponseX<PCRExtRekModel, Metadata> responseX =
	            new ResponseX<>(new PCRExtRekModel(pxList), metadata);

	    return ResponseEntity.ok(responseX);
	}
	*/

	@DeleteMapping("/regpxol")
	void deleteRegPxOLNew(@RequestParam(name = "id") Long id) {
		regPxOlRepository.deleteById(id);
		System.out.println("delete record PCR External....");
	}

}
