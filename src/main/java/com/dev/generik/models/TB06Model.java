package com.dev.generik.models;

import java.io.Serializable;
//import java.util.Date;
import java.util.Date;

public class TB06Model implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 3121922636150247051L;
		private Long id;
		private String noDahak;
		private Date tqlSITB;
		private Long umur;
		private String dirujuk;
		
		public TB06Model() {
			super();
			// TODO Auto-generated constructor stub
		}

		public TB06Model(Long id, String noDahak, Date tqlSITB, Long umur, String dirujuk) {
			super();
			this.id = id;
			this.noDahak = noDahak;
			this.tqlSITB = tqlSITB;
			this.umur = umur;
			this.dirujuk = dirujuk;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNoDahak() {
			return noDahak;
		}

		public void setNoDahak(String noDahak) {
			this.noDahak = noDahak;
		}

		public Date getTqlSITB() {
			return tqlSITB;
		}

		public void setTqlSITB(Date tqlSITB) {
			this.tqlSITB = tqlSITB;
		}

		public Long getUmur() {
			return umur;
		}

		public void setUmur(Long umur) {
			this.umur = umur;
		}

		public String getDirujuk() {
			return dirujuk;
		}

		public void setDirujuk(String dirujuk) {
			this.dirujuk = dirujuk;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
	
		
		
}
