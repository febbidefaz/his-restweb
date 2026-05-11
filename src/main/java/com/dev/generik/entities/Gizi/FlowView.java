package com.dev.generik.entities.Gizi;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "LOGGIZIFLOWWS")
@Getter
@Setter
@JsonIdentityInfo(
	    generator = ObjectIdGenerators.PropertyGenerator.class,
	    property = "id")

public class FlowView {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd", lenient = OptBoolean.FALSE, timezone = "Asia/Jakarta")
	@Temporal(TemporalType.DATE)
	@Column(name = "FLOWTGL")
	private Date flowTgl;
	
	@JsonFormat(shape = Shape.STRING, pattern = "HH:mm:ss", lenient = OptBoolean.FALSE, timezone = "Asia/Jakarta")
	@Temporal(TemporalType.TIME)
	@Column(name = "JAM")
	private Date jam;
	
	//public FlowView() {}
	
	//public FlowView (Long id, Date flowTgl, Date jam) {
	//	this.id = id;
	//	this.flowTgl = flowTgl;
	//	this.jam = jam;
	//}
	
	  // Relasi OneToMany dengan Book
 //   @OneToMany(mappedBy = "flowView", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  //  @JsonManagedReference  // Mengelola referensi JSON
  //  @JsonIgnore 
 //   private List<FlowDetView> flowDetViews;

//	public static boolean isEmpty() {
		// TODO Auto-generated method stub
//		return false;
//	}
	

}
