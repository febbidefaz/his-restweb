package com.dev.generik.entities.Gizi;

//import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "LOGGIZIFLOWWSDET")
@IdClass(FlowDetViewClass.class)
@Getter
@Setter
@JsonIdentityInfo(
	    generator = ObjectIdGenerators.PropertyGenerator.class,
	    property = "id")

public class FlowDetView {
	
	@Id	
	@Column(name = "ID")
	private Long id;

	@Id
	@Column(name = "PRODUCTID")
	private String productID;
	
	@Column(name = "Qty")
	private Long qty;
	
	@Column(name = "Diterima")
	private String diterima;
	
	@Column(name = "Ket")
	private String ket;
	
	//public FlowDetView() {}
	
	//public FlowDetView(Long id, String productID, Long qty) {
	//	this.id = id;
	//	this.productID = productID;
	//	this.qty = qty;		
	//}
	
	//  Relasi ManyToOne dengan Flow
 //   @ManyToOne(fetch = FetchType.LAZY)
 //   @JoinColumn(name = "id", insertable = false, updatable = false)
  //  @JsonBackReference  // Referensi balik untuk JSON
  //  private FlowView flowView;
	
}
