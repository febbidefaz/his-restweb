package com.dev.generik.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
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

import com.dev.generik.entities.Dokter.Dokter;
import com.dev.generik.entities.Dokter.VisitDokter;
import com.dev.generik.entities.ERM.Lab.PxRJAntiPCR;
import com.dev.generik.entities.HaloRSA.BedReady;
import com.dev.generik.entities.HaloRSA.BedReadyBPJS;
import com.dev.generik.entities.HaloRSA.Berita;
import com.dev.generik.entities.HaloRSA.BeritaNew;
import com.dev.generik.entities.HaloRSA.PxNewOL;
import com.dev.generik.entities.HaloRSA.RegNewOL;
import com.dev.generik.entities.HaloRSA.RegNewOLT;
import com.dev.generik.entities.HaloRSA.Slide;
import com.dev.generik.entities.HaloRSA.SurveyNewOL;
import com.dev.generik.entities.Inap.ListPxInap;
import com.dev.generik.entities.Inap.Pelayanan;
import com.dev.generik.entities.Inap.Unit;
import com.dev.generik.entities.JadwalDokter.JadwalDokter;
import com.dev.generik.entities.PX.PxId;
import com.dev.generik.entities.display.DisplayInap;
import com.dev.generik.entities.display.DisplayInapSift;
//import com.dev.generik.entities.JadwalDokterPrakV2;
import com.dev.generik.exception.PxInapNotFound;
import com.dev.generik.models.ListPxInapModel;
import com.dev.generik.models.Metadata;
import com.dev.generik.models.ResponseX;
import com.dev.generik.models.VisitDokterModel;
import com.dev.generik.exception.BedReadyNotFound;
import com.dev.generik.exception.BedReadyBPJSNotFound;
import com.dev.generik.exception.JadwalDokterNotFound;
import com.dev.generik.exception.BeritaNotFound;
import com.dev.generik.exception.CustomException;
import com.dev.generik.repository.Display.DisplayInapRepository;
import com.dev.generik.repository.Display.DisplayInapSiftRepository;
import com.dev.generik.repository.Dokter.DokterRepository;
import com.dev.generik.repository.Dokter.VisitDokterRepository;
import com.dev.generik.repository.HaloRSA.BedReadyBPJSRepository;
import com.dev.generik.repository.HaloRSA.BedReadyRepository;
import com.dev.generik.repository.HaloRSA.BeritaNewRepository;
import com.dev.generik.repository.HaloRSA.BeritaRepository;
import com.dev.generik.repository.HaloRSA.RegNewOLRepository;
import com.dev.generik.repository.HaloRSA.RegNewOLTRepository;
import com.dev.generik.repository.HaloRSA.SlideRepository;
import com.dev.generik.repository.HaloRSA.SurveyNewOLRepository;
import com.dev.generik.repository.Inap.ListPxInapRepository;
import com.dev.generik.repository.Inap.PelayananRepository;
import com.dev.generik.repository.Inap.UnitRepository;
import com.dev.generik.repository.JadwalDokter.JadwalDokterPrakV2Repository;
import com.dev.generik.repository.JadwalDokter.JadwalDokterRepository;
import com.dev.generik.repository.Lab.PxRJAntiPCRRepository;
import com.dev.generik.repository.PX.PxIdRepository;
import com.dev.generik.repository.PX.PxNewOLRepository;

@RestController
@RequestMapping("his/about")
public class CollectionInfoController {
	@Autowired
	ListPxInapRepository repository;
	@Autowired
	BedReadyRepository bedrepository;
	@Autowired
	BedReadyBPJSRepository bedbrepository;
	@Autowired
	JadwalDokterRepository jadwalrepository;
	@Autowired
	PxNewOLRepository pxNewRepository;
	@Autowired
	BeritaRepository beritarepository;
	@Autowired
	SurveyNewOLRepository surveyNewRepository;
	@Autowired
	BeritaNewRepository beritaNewRepository;
	@Autowired
	SlideRepository sliderepository;
	@Autowired
	PelayananRepository pelayananRepository;
	@Autowired
	UnitRepository unitRepository;
	@Autowired
	RegNewOLRepository regNewRepository;
	@Autowired
	DokterRepository dokterRepository;
	@Autowired
	PxRJAntiPCRRepository pxRJAntiPCRRepository;
	@Autowired
	RegNewOLTRepository regNewTRepository;
	@Autowired
	PxIdRepository pxIdRepository;
	@Autowired
	VisitDokterRepository visitDokterRepository;
	@Autowired
	JadwalDokterPrakV2Repository prakV2Repository;
	@Autowired
	DisplayInapRepository displayInapRepository;
	@Autowired
	DisplayInapSiftRepository displayInapSiftRepository;

	@GetMapping("/pxinap/{id}")
	EntityModel<ListPxInap> pxInapById(@PathVariable Long id) {
		ListPxInap que = repository.findById(id).orElseThrow(() -> new PxInapNotFound(id));
		return EntityModel.of(que, linkTo(methodOn(CollectionInfoController.class).pxInapById(id)).withSelfRel());
	}

	@GetMapping("/pxid/{id}")
	EntityModel<PxId> pxIdById(@PathVariable Long id) {
		PxId pxi = pxIdRepository.findById(id).orElseThrow(() -> new PxInapNotFound(id));
		return EntityModel.of(pxi, linkTo(methodOn(CollectionInfoController.class).pxIdById(id)).withSelfRel());
	}

	@GetMapping("/bedready/{id}")
	EntityModel<BedReady> bedReadyById(@PathVariable Long id) {
		BedReady bed = bedrepository.findById(id).orElseThrow(() -> new BedReadyNotFound(id));
		return EntityModel.of(bed, linkTo(methodOn(CollectionInfoController.class).bedReadyById(id)).withSelfRel());
	}

	@GetMapping("/bedreadybpjs/{id}")
	EntityModel<BedReadyBPJS> bedReadyBPJSById(@PathVariable Long id) {
		BedReadyBPJS bedb = bedbrepository.findById(id).orElseThrow(() -> new BedReadyBPJSNotFound(id));
		return EntityModel.of(bedb,
				linkTo(methodOn(CollectionInfoController.class).bedReadyBPJSById(id)).withSelfRel());
	}

	@GetMapping("/jadwaldokter/{id}")
	EntityModel<JadwalDokter> jadwalDokterById(@PathVariable Long id) {
		JadwalDokter jad = jadwalrepository.findById(id).orElseThrow(() -> new JadwalDokterNotFound(id));
		return EntityModel.of(jad, linkTo(methodOn(CollectionInfoController.class).jadwalDokterById(id)).withSelfRel());
	}

	@GetMapping("/berita/{id}")
	EntityModel<Berita> beritaById(@PathVariable Long id) {
		Berita jad = beritarepository.findById(id).orElseThrow(() -> new BeritaNotFound(id));
		return EntityModel.of(jad, linkTo(methodOn(CollectionInfoController.class).beritaById(id)).withSelfRel());
	}

	@GetMapping("/jadwaldokter/hari")
	CollectionModel<EntityModel<JadwalDokter>> jadwalDokterByhr(@RequestParam(name = "hr") Long hr) {

		List<EntityModel<JadwalDokter>> rh = jadwalrepository.findByhr(hr).stream().map(jadwaldokter -> EntityModel.of(
				jadwaldokter, linkTo(methodOn(CollectionInfoController.class).jadwalDokterByhr(hr)).withSelfRel(),
				linkTo(methodOn(CollectionInfoController.class).jadwalDokterBydr(jadwaldokter.getDr())).withSelfRel(),
				linkTo(methodOn(CollectionInfoController.class).jadwalDokterById(jadwaldokter.getId())).withSelfRel(),
				linkTo(methodOn(CollectionInfoController.class).listJadwalDokter()).withRel("jadwaldokter")))
				.collect(Collectors.toList());

		return CollectionModel.of(rh,
				linkTo(methodOn(CollectionInfoController.class).listJadwalDokter()).withSelfRel());
	}

	@GetMapping("/jadwaldokter/dokter")
	CollectionModel<EntityModel<JadwalDokter>> jadwalDokterBydr(@RequestParam(name = "dr") Long dr) {

		List<EntityModel<JadwalDokter>> rd = jadwalrepository.findBydr(dr).stream().map(jadwaldokter -> EntityModel.of(
				jadwaldokter, linkTo(methodOn(CollectionInfoController.class).jadwalDokterBydr(dr)).withSelfRel(),
				linkTo(methodOn(CollectionInfoController.class).jadwalDokterByhr(jadwaldokter.getHr())).withSelfRel(),
				linkTo(methodOn(CollectionInfoController.class).jadwalDokterById(jadwaldokter.getId())).withSelfRel(),
				linkTo(methodOn(CollectionInfoController.class).listJadwalDokter()).withRel("jadwaldokter")))
				.collect(Collectors.toList());

		return CollectionModel.of(rd,
				linkTo(methodOn(CollectionInfoController.class).listJadwalDokter()).withSelfRel());
	}

	@GetMapping("/newpx/onlineid")
	EntityModel<PxNewOL> getPxNew(@RequestParam Long id) {
		PxNewOL px = pxNewRepository.findById(id).orElseThrow(() -> new PxInapNotFound(id));
		return EntityModel.of(px, linkTo(methodOn(CollectionInfoController.class).getPxNew(id)).withSelfRel());
	}

	@GetMapping("/newsurvey/surveyid")
	EntityModel<SurveyNewOL> getSurveyNew(@RequestParam Long id) {
		SurveyNewOL survey = surveyNewRepository.findById(id).orElseThrow(() -> new PxInapNotFound(id));
		return EntityModel.of(survey, linkTo(methodOn(CollectionInfoController.class).getSurveyNew(id)).withSelfRel());
	}

	@GetMapping("/newberita/beritaid")
	EntityModel<BeritaNew> getBeritaNew(@RequestParam Long id) {
		BeritaNew ber = beritaNewRepository.findById(id).orElseThrow(() -> new PxInapNotFound(id));
		return EntityModel.of(ber, linkTo(methodOn(CollectionInfoController.class).getBeritaNew(id)).withSelfRel());
	}

	@GetMapping("/newreg/regid")
	EntityModel<RegNewOLT> getRegNewT(@RequestParam Long id) {
		RegNewOLT reg = regNewTRepository.findById(id).orElseThrow(() -> new PxInapNotFound(id));
		return EntityModel.of(reg, linkTo(methodOn(CollectionInfoController.class).getRegNewT(id)).withSelfRel());
	}

	@GetMapping("/pxinap")
	CollectionModel<EntityModel<ListPxInap>> listPxOpname() {
		List<EntityModel<ListPxInap>> inapPx = repository.findAll().stream()
				.map(pxinap -> EntityModel.of(pxinap,
						linkTo(methodOn(CollectionInfoController.class).pxInapById(pxinap.getId())).withSelfRel(),
						linkTo(methodOn(CollectionInfoController.class).listPxOpname()).withRel("pxinap")))
				.collect(Collectors.toList());

		return CollectionModel.of(inapPx,
				linkTo(methodOn(CollectionInfoController.class).listPxOpname()).withSelfRel());
	}
	
	@GetMapping("/pxinap/visite")
	public ResponseEntity<ResponseX<List<ListPxInapModel>, Metadata>> getVisitPxInap() {

		List<ListPxInap> lstInap = repository.findAll();

		List<ListPxInapModel> arrayPxInap = new ArrayList<>();
		for (ListPxInap px : lstInap) {
			ListPxInapModel pim = new ListPxInapModel();
			pim.setId(px.getId());
			pim.setTmsk(px.getTmsk());
			pim.setNorm(px.getNorm());
			pim.setRoom(px.getRoom());
			pim.setKelas(px.getKelas());
			pim.setPx(px.getPx());
			pim.setAddr(px.getAddr());
			pim.setJmsk(px.getJmsk());
			pim.setRegid(px.getRegid());
			pim.setPavid(px.getPavid());
			pim.setPav(px.getPav());
			pim.setBiaya(px.getBiaya());
			pim.setPhk3(px.getPhk3());
			pim.setKelasbpjs(px.getKelasbpjs());
			pim.setPxrs(px.getPxrs());
			
			List<VisitDokterModel> arrayVisite = new ArrayList<>();
			List<VisitDokter> lstVisit = visitDokterRepository.findByIdpx(px.getId());
			for (VisitDokter vdo : lstVisit) {
				VisitDokterModel vm = new VisitDokterModel();
		//		vm.setId(vdo.getIdpx());
				vm.setDokterid(vdo.getDokterid());
				vm.setDokter(vdo.getDokter());
				arrayVisite.add(vm);
			}
			pim.setLstVisite(arrayVisite);
			arrayPxInap.add(pim);
		}
		Metadata metadata = new Metadata(HttpStatus.OK.value(), "Ok");
		ResponseX<List<ListPxInapModel>, Metadata> responseX = new ResponseX<>(arrayPxInap, metadata);
		return ResponseEntity.ok(responseX);
	}

	@GetMapping("/bedready")
	CollectionModel<EntityModel<BedReady>> listBedReady() {
		List<EntityModel<BedReady>> readybed = bedrepository.findAll().stream()
				.map(bedready -> EntityModel.of(bedready,
						linkTo(methodOn(CollectionInfoController.class).bedReadyById(bedready.getId())).withSelfRel(),
						linkTo(methodOn(CollectionInfoController.class).listBedReady()).withRel("bedready")))
				.collect(Collectors.toList());

		return CollectionModel.of(readybed,
				linkTo(methodOn(CollectionInfoController.class).listBedReady()).withSelfRel());
	}

	@GetMapping("/bedreadybpjs")
	CollectionModel<EntityModel<BedReadyBPJS>> listBedReadyB() {
		List<EntityModel<BedReadyBPJS>> readybedb = bedbrepository.findAll().stream()
				.map(bedreadybpjs -> EntityModel.of(bedreadybpjs,
						linkTo(methodOn(CollectionInfoController.class).bedReadyBPJSById(bedreadybpjs.getId()))
								.withSelfRel(),
						linkTo(methodOn(CollectionInfoController.class).listBedReadyB()).withRel("bedreadybpjs")))
				.collect(Collectors.toList());

		return CollectionModel.of(readybedb,
				linkTo(methodOn(CollectionInfoController.class).listBedReadyB()).withSelfRel());
	}

	@GetMapping("/jadwaldokter")
	CollectionModel<EntityModel<JadwalDokter>> listJadwalDokter() {
		List<EntityModel<JadwalDokter>> dokterjadwal = jadwalrepository.findAll().stream()
				.map(jadwaldokter -> EntityModel.of(jadwaldokter,
						linkTo(methodOn(CollectionInfoController.class).jadwalDokterById(jadwaldokter.getId()))
								.withSelfRel(),
						linkTo(methodOn(CollectionInfoController.class).jadwalDokterByhr(jadwaldokter.getHr()))
								.withSelfRel(),
						linkTo(methodOn(CollectionInfoController.class).jadwalDokterBydr(jadwaldokter.getDr()))
								.withSelfRel(),
						linkTo(methodOn(CollectionInfoController.class).listJadwalDokter()).withRel("jadwaldokter")))
				.collect(Collectors.toList());

		return CollectionModel.of(dokterjadwal,
				linkTo(methodOn(CollectionInfoController.class).listJadwalDokter()).withSelfRel());
	}

	@GetMapping("/berita")
	CollectionModel<EntityModel<Berita>> listBerita() {
		List<EntityModel<Berita>> beritaList = beritarepository.findAll().stream()
				.map(berita -> EntityModel.of(berita,
						linkTo(methodOn(CollectionInfoController.class).beritaById(berita.getId())).withSelfRel(),
						linkTo(methodOn(CollectionInfoController.class).listBerita()).withRel("berita")))
				.collect(Collectors.toList());

		return CollectionModel.of(beritaList,
				linkTo(methodOn(CollectionInfoController.class).listBerita()).withSelfRel());
	}

	@GetMapping("/slide")
	CollectionModel<EntityModel<Slide>> listSlide() {
		List<EntityModel<Slide>> slideList = sliderepository.findAll().stream().map(slide -> EntityModel.of(slide,
				// linkTo(methodOn(CollectionInfoController.class).slideById(slide.getId())).withSelfRel(),
				linkTo(methodOn(CollectionInfoController.class).listSlide()).withRel("slide")))
				.collect(Collectors.toList());

		return CollectionModel.of(slideList,
				linkTo(methodOn(CollectionInfoController.class).listSlide()).withSelfRel());
	}

	@GetMapping("/unit/pelayanan")
	CollectionModel<EntityModel<Unit>> unitBypelayanan(@RequestParam(name = "pelayanan") Long pelayanan) {
		List<EntityModel<Unit>> un = unitRepository.findBypelayanan(pelayanan).stream()
				.map(unit -> EntityModel.of(unit,
						linkTo(methodOn(CollectionInfoController.class).unitBypelayanan(pelayanan)).withSelfRel()))
				// linkTo(methodOn(CollectionInfoController.class).listJ()).withRel("pelayanan")))
				.collect(Collectors.toList());

		return CollectionModel.of(un, linkTo(methodOn(CollectionInfoController.class).listUnit()).withSelfRel());
	}
	
/*	@GetMapping("/displayInap")
	EntityModel<DisplayInap> displayInapByUser(@RequestParam String user) {
		DisplayInap ds = displayInapRepository.findByUser(user).orElseThrow(() -> new DisplayInapNotFound(user));
		return EntityModel.of(ds, linkTo(methodOn(CollectionInfoController.class).displayInapByUser(user)).withSelfRel());
	} */
	
	@GetMapping("/displayInap")
	CollectionModel<EntityModel<DisplayInap>> displayInapByUser(@RequestParam(name = "user") String us) {
		List<EntityModel<DisplayInap>> un = displayInapRepository.findByUser(us).stream()
				.map(unit -> EntityModel.of(unit,
						linkTo(methodOn(CollectionInfoController.class).displayInapByUser(us)).withSelfRel()))
				.collect(Collectors.toList());

		return CollectionModel.of(un, linkTo(methodOn(CollectionInfoController.class).listUnit()).withSelfRel());
	} 
	
	@GetMapping("/displayInapSift")
	CollectionModel<EntityModel<DisplayInapSift>> displayInapSiftByUser(@RequestParam(name = "user") String us,
			@RequestParam(name = "sift") String sift) {
		List<EntityModel<DisplayInapSift>> uns = displayInapSiftRepository.findByUserAndSift(us, sift).stream()
				.map(unit -> EntityModel.of(unit,
						linkTo(methodOn(CollectionInfoController.class).displayInapSiftByUser(us, sift)).withSelfRel()))
				.collect(Collectors.toList());

		return CollectionModel.of(uns, linkTo(methodOn(CollectionInfoController.class).listUnit()).withSelfRel());
	} 
	
	@GetMapping("/unit")
	CollectionModel<EntityModel<Unit>> listUnit() {
		List<EntityModel<Unit>> uni = unitRepository.findAll().stream().map(unit -> EntityModel.of(unit,
				// linkTo(methodOn(CollectionInfoController.class).unitById(unit.getId())).withSelfRel(),
				// linkTo(methodOn(CollectionInfoController.class).unitByPelayanan(unit.getPelayanan())).withSelfRel(),
				linkTo(methodOn(CollectionInfoController.class).listUnit()).withRel("unit")))
				.collect(Collectors.toList());

		return CollectionModel.of(uni, linkTo(methodOn(CollectionInfoController.class).listUnit()).withSelfRel());
	}

	@GetMapping("/pelayanan")
	CollectionModel<EntityModel<Pelayanan>> listPelayanan() {
		List<EntityModel<Pelayanan>> pelayananList = pelayananRepository.findAll().stream()
				.map(pelayanan -> EntityModel.of(pelayanan,
						// linkTo(methodOn(CollectionInfoController.class).slideById(slide.getId())).withSelfRel(),
						linkTo(methodOn(CollectionInfoController.class).listPelayanan()).withRel("pelayanan")))
				.collect(Collectors.toList());

		return CollectionModel.of(pelayananList,
				linkTo(methodOn(CollectionInfoController.class).listPelayanan()).withSelfRel());
	}

	@GetMapping("/dokter")
	CollectionModel<EntityModel<Dokter>> listDokter() {
		List<EntityModel<Dokter>> dok = dokterRepository.findAll().stream().map(dokl -> EntityModel.of(dokl))
				.collect(Collectors.toList());

		return CollectionModel.of(dok, linkTo(methodOn(CollectionInfoController.class).listDokter()).withSelfRel());
	}

	@GetMapping("/pxRJAntiPCR")
	CollectionModel<EntityModel<PxRJAntiPCR>> listPxRJAntiPCR() {
		List<EntityModel<PxRJAntiPCR>> pxrjanti = pxRJAntiPCRRepository.findAll().stream()
				.map(pxrjantip -> EntityModel.of(pxrjantip)).collect(Collectors.toList());

		return CollectionModel.of(pxrjanti,
				linkTo(methodOn(CollectionInfoController.class).listPxRJAntiPCR()).withSelfRel());
	}

	@GetMapping("/dokter/{id}")
	EntityModel<Dokter> dokterById(@PathVariable Long id) {
		Dokter jad = dokterRepository.findById(id).orElseThrow(() -> new BeritaNotFound(id));
		return EntityModel.of(jad, linkTo(methodOn(CollectionInfoController.class).dokterById(id)).withSelfRel());
	}

	@PostMapping("/newpx")
	ResponseEntity<EntityModel<PxNewOL>> addNewPx(@RequestBody PxNewOL pxNew) throws URISyntaxException {
		PxNewOL pxSave = pxNewRepository.save(pxNew);
		EntityModel<PxNewOL> resource = EntityModel.of(pxSave,
				linkTo(methodOn(CollectionInfoController.class).getPxNew(pxSave.getId())).withSelfRel());

		return ResponseEntity.created(resource.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(resource);
	}

// start here ....	
	@PostMapping("/newreg")
//	ResponseEntity<EntityModel<RegNewOL>> addNewReg(@RequestBody RegNewOL regNew) throws URISyntaxException {
	ResponseEntity<ResponseX<RegNewOL, Metadata>> addNewReg(@RequestBody RegNewOL regNew) {
		RegNewOL regSave;
		if (regNewRepository.findByDokteridAndTglAndRegisterAndJampraktekAndSublayanan(regNew.getDokterid(),
				regNew.getTgl(), regNew.getRegister(), regNew.getJampraktek(), regNew.getSublayanan()).isPresent()) {
			final String msg = "Pasien sudah terdaftar ...!";
			throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
		} else {
			try {
				regSave = regNewRepository.save(regNew);
			} catch (IllegalArgumentException e) {
				final String msg = "Payload Tidak Valid ...";
				throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
			}
		}
//		RegNewOL regSave = regNewRepository.save(regNew);
//		EntityModel<RegNewOL> resource = EntityModel.of(regSave, 
//			linkTo(methodOn(CollectionInfoController.class).getRegNew(regSave.getId())).withSelfRel());
		final String messageOk = "Ok";
		Metadata metadata = new Metadata(HttpStatus.OK.value(), messageOk);
		ResponseX<RegNewOL, Metadata> responseX = new ResponseX<>(regSave, metadata);
		return ResponseEntity.ok(responseX);

//		return  ResponseEntity.created(resource.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(resource);
	}
	
	@PostMapping("/newregV2")
	ResponseEntity<ResponseX<RegNewOL, Metadata>> addNewRegV2(@RequestBody RegNewOL regNew) {
		RegNewOL regSave;
		if (prakV2Repository.findByDrAndPrakAndDateAndStatus(regNew.getDokterid(),
				regNew.getJampraktek(), regNew.getTgl(), (long) 1).isPresent()) {
			final String msg = "Dokter Cuti Atau Rawat Jalan Libur ...!";
			throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
		}
		else if (prakV2Repository.findByDrAndPrakAndDateAndStatus(regNew.getDokterid(),
				regNew.getJampraktek(), regNew.getTgl(), (long) 2).isPresent()) {
			final String msg = "Quota Penuh ...!";
			throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
		}
		else if (prakV2Repository.findByDrAndPrakAndDateAndStatus(regNew.getDokterid(),
				regNew.getJampraktek(), regNew.getTgl(), (long) 3).isPresent()) {
			final String msg = "Pendaftaran Sudah Tutup ...!";
			throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
		}
		else if (regNewRepository.findByDokteridAndTglAndRegisterAndJampraktekAndSublayanan(regNew.getDokterid(),
				regNew.getTgl(), regNew.getRegister(), regNew.getJampraktek(), regNew.getSublayanan()).isPresent()) {
			final String msg = "Pasien sudah terdaftar ...!";
			throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
		} else {
			try {
				regSave = regNewRepository.save(regNew);
			} catch (IllegalArgumentException e) {
				final String msg = "Payload Tidak Valid ...";
				throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
			}
		}
		final String messageOk = "Ok";
		Metadata metadata = new Metadata(HttpStatus.OK.value(), messageOk);
		ResponseX<RegNewOL, Metadata> responseX = new ResponseX<>(regSave, metadata);
		return ResponseEntity.ok(responseX);

	}
	
	@PostMapping("/newregV3")
	ResponseEntity<ResponseX<RegNewOL, Metadata>> addNewRegV3(@RequestBody RegNewOL regNew) {
		RegNewOL regSave;
		if (prakV2Repository.findByDrAndPrakAndDateAndStatus(regNew.getDokterid(),
				regNew.getJampraktek(), regNew.getTgl(), (long) 1).isPresent()) {
			final String msg = "Dokter Cuti Atau Rawat Jalan Libur ...!";
			throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
		}
		else if (prakV2Repository.findByDrAndPrakAndDateAndStatus(regNew.getDokterid(),
				regNew.getJampraktek(), regNew.getTgl(), (long) 2).isPresent()) {
			final String msg = "Quota Penuh ...!";
			throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
		}
		else if (prakV2Repository.findByDrAndPrakAndDateAndStatus(regNew.getDokterid(),
				regNew.getJampraktek(), regNew.getTgl(), (long) 3).isPresent()) {
			final String msg = "Pendaftaran Sudah Tutup ...!";
			throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
		}
		else if (regNewRepository.findByDokteridAndTglAndRegisterAndJampraktekAndSublayanan(regNew.getDokterid(),
				regNew.getTgl(), regNew.getRegister(), regNew.getJampraktek(), regNew.getSublayanan()).isPresent()) {
			final String msg = "Pasien sudah terdaftar ...!";
			throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
		} else {
			try {
				regSave = regNewRepository.save(regNew);
			} catch (IllegalArgumentException e) {
				final String msg = "Payload Tidak Valid ...";
				throw new CustomException(HttpStatus.BAD_REQUEST.value(), msg, HttpStatus.BAD_REQUEST);
			}
		}
		final String messageOk = "Ok";
		Metadata metadata = new Metadata(HttpStatus.OK.value(), messageOk);
		ResponseX<RegNewOL, Metadata> responseX = new ResponseX<>(regSave, metadata);
		return ResponseEntity.ok(responseX);

	}

/*	private Long setStatus(int i) {
		// TODO Auto-generated method stub
		return null;
	} */

	@PostMapping("/newsurvey")
	ResponseEntity<EntityModel<SurveyNewOL>> addNewSurvey(@RequestBody SurveyNewOL surveyNew)
			throws URISyntaxException {
		SurveyNewOL surveySave = surveyNewRepository.save(surveyNew);
		EntityModel<SurveyNewOL> resource = EntityModel.of(surveySave,
				linkTo(methodOn(CollectionInfoController.class).getSurveyNew(surveySave.getId())).withSelfRel());

		return ResponseEntity.created(resource.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(resource);
	}

	@PostMapping("/newberita")
	ResponseEntity<EntityModel<BeritaNew>> addNewBerita(@RequestBody BeritaNew beritaNew) throws URISyntaxException {
		BeritaNew beritaSave = beritaNewRepository.save(beritaNew);
		EntityModel<BeritaNew> resource = EntityModel.of(beritaSave,
				linkTo(methodOn(CollectionInfoController.class).getBeritaNew(beritaSave.getId())).withSelfRel());

		return ResponseEntity.created(resource.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(resource);
	}

	@PutMapping("/updateBerita")
	ResponseEntity<EntityModel<BeritaNew>> updateBerita(@RequestParam(name = "beritaid") Long beritaid,
			@RequestBody BeritaNew beritaNew) throws URISyntaxException {

		BeritaNew beritaUpdate = beritaNewRepository.findById(beritaid).map(berita -> {
			berita.setJudul(beritaNew.getJudul());
			berita.setTanggal(beritaNew.getTanggal());
			berita.setIsi(beritaNew.getIsi());
			berita.setFotojudul(beritaNew.getFotojudul());
			berita.setFoto1(beritaNew.getFoto1());
			berita.setFoto2(beritaNew.getFoto2());
			berita.setFoto3(beritaNew.getFoto3());
			berita.setFoto4(beritaNew.getFoto4());
			berita.setSlide(beritaNew.getSlide());
			return beritaNewRepository.save(berita);
		}).get();
		// .orElseGet(() -> {
//                    pxNew.setId(pxid);
//                    return beritaNewRepository.save(beritaNew);
//                });

		EntityModel<BeritaNew> resource = EntityModel.of(beritaUpdate,
				linkTo(methodOn(CollectionInfoController.class).getBeritaNew(beritaUpdate.getId())).withSelfRel());

		return ResponseEntity.created(resource.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(resource);
	}

	@DeleteMapping("/deleteBerita")
	void deleteNewBeritaNewOnline(@RequestParam(name = "beritaid") Long beritaid) {
		beritaNewRepository.deleteById(beritaid);
		System.out.println("delete record Berita New Online ....");
	}

	@PutMapping("/updatePx")
	ResponseEntity<EntityModel<PxNewOL>> updateNewPx(@RequestParam(name = "pxid") Long pxid, @RequestBody PxNewOL pxNew)
			throws URISyntaxException {

		PxNewOL pxUpdate = pxNewRepository.findById(pxid).map(px -> {
			px.setNorm(pxNew.getNorm());
			px.setNama(pxNew.getNama());
			px.setAddr(pxNew.getAddr());
			px.setNojkn(pxNew.getNojkn());
			px.setNoktp(pxNew.getNoktp());
			px.setPhone(pxNew.getPhone());
			px.setPhoto(pxNew.getPhoto());
			px.setSextype(pxNew.getSextype());
			px.setStatus(pxNew.getStatus());
			px.setTlahir(pxNew.getTlahir());
			return pxNewRepository.save(px);
		}).get();
//                .orElseGet(() -> {
//                    pxNew.setId(pxid);
//                    return pxNewRepository.save(pxNew);
//                });

		EntityModel<PxNewOL> resource = EntityModel.of(pxUpdate,
				linkTo(methodOn(CollectionInfoController.class).getPxNew(pxUpdate.getId())).withSelfRel());

		return ResponseEntity.created(resource.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(resource);
	}

	@DeleteMapping("/deletePx")
	void deleteNewPxNewOnline(@RequestParam(name = "pxid") Long pxid) {
		pxNewRepository.deleteById(pxid);
		System.out.println("delete record Px New Online ....");
	}

	@DeleteMapping("/deleteReg")
	void deleteRegNew(@RequestParam(name = "regid") Long regid) {
		regNewRepository.deleteById(regid);
		System.out.println("delete record Reg New ....");
	}

	@PutMapping("/updateReg")
	ResponseEntity<EntityModel<RegNewOL>> updateReg(@RequestParam(name = "regid") Long regid,
			@RequestBody RegNewOL regNewOL) throws URISyntaxException {

		RegNewOL regUpdate = regNewRepository.findById(regid).map(reg -> {
			// reg.setUserid(regNewOL.getUserid());
			// reg.setSublayanan(regNewOL.getSublayanan());
			// reg.setLayanan(regNewOL.getLayanan());
			// reg.setTgl(regNewOL.getTgl());
			// reg.setJam_praktek(regNewOL.getJam_praktek());
			// reg.setShift(regNewOL.getShift());
			// reg.setRegister(regNewOL.getRegister());
			// reg.setUpx(regNewOL.getUpx());
			// reg.setDokterid(regNewOL.getDokterid());
			// reg.setTherapyid(regNewOL.getTherapyid());
			// reg.setPxno(regNewOL.getPxno());
			// reg.setKtp(regNewOL.getKtp());
			reg.setBuktitransfer(regNewOL.getBuktitransfer());
			reg.setStatus(regNewOL.getStatus());
			// reg.setNorujukan(regNewOL.getNorujukan());

			return regNewRepository.save(reg);
		}).get();
		// .orElseGet(() -> {
//                    regNewOL.setId(pxid);
//                    return beritaNewRepository.save(beritaNew);
//                });

		EntityModel<RegNewOL> resource = EntityModel.of(regUpdate,
				linkTo(methodOn(CollectionInfoController.class).getRegNewT(regUpdate.getId())).withSelfRel());

		return ResponseEntity.created(resource.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(resource);
	}

}
