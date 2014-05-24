package de.heckmann.lp_grocery_list.db.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class ProductsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idproducts")
	private Long idproducts;

	@Column(name = "productname")
	private String productname;

	// @Column(name = "units_id")
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "units_id")
	private UnitsEntity units_id;
	
	
	public ProductsEntity(){}

	public ProductsEntity(String productname) {
		this.productname = productname;
	}
	
	public ProductsEntity(String productname, UnitsEntity units_id) {
		this.productname = productname;
		this.units_id = units_id;
	}



	public UnitsEntity getUnits_id() {
		return units_id;
	}

	public void setUnits_id(UnitsEntity units_id) {
		this.units_id = units_id;
	}

	public Long getIdproducts() {
		return idproducts;
	}

	public void setIdproducts(Long id) {
		this.idproducts = id;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	@Override
	public String toString() {
		return "ProductsEntity [idproducts=" + idproducts + ", productname="
				+ productname + ", units_id=" + units_id + "]";
	}

}
