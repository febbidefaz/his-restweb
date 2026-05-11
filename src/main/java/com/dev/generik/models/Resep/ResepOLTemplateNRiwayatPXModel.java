package com.dev.generik.models.Resep;

import java.util.List;
import com.dev.generik.entities.ERM.Resep.ResepOLRiwayat;
import com.dev.generik.entities.ERM.Resep.ResepOLTemplate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResepOLTemplateNRiwayatPXModel {
	private List<ResepOLTemplate> template;
	private List<ResepOLRiwayat> riwayat;

	public ResepOLTemplateNRiwayatPXModel(List<ResepOLTemplate> template, List<ResepOLRiwayat> riwayat) {
		this.template = template;
		this.riwayat = riwayat;
	}

	public List<ResepOLTemplate> getTemplate() {
		return template;
	}

	public void setTemplate(List<ResepOLTemplate> template) {
		this.template = template;
	}

	public List<ResepOLRiwayat> getRiwayat() {
		return riwayat;
	}

	public void setRiwayat(List<ResepOLRiwayat> riwayat) {
		this.riwayat = riwayat;
	}
}

