package com.dev.generik.entities.HaloRSA;

import java.io.Serializable;
import java.util.Objects;

public class NonUSGXRayCTId implements Serializable{
	
	private static final long serialVersionUID = -2995485292687802706L;
	private Long idrad;
	private Long jenisid;
	
	public NonUSGXRayCTId() {
		super();
	}
	
	public NonUSGXRayCTId(Long idrad, Long jenisid) {
		super();
		this.idrad = idrad;
		this .jenisid = jenisid;
	
	}

	@Override
	public int hashCode() {
		return Objects.hash(idrad, jenisid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NonUSGXRayCTId other = (NonUSGXRayCTId) obj;
		return Objects.equals(idrad, other.idrad) && Objects.equals(jenisid, other.jenisid);
	}
	
	
	
}
