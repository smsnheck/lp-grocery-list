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

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="units_id") 
	private UnitsEntity unitsEntity;

	public ProductsEntity(){}
	
	public ProductsEntity(Long idproducts, String productname,
			UnitsEntity unitsEntity) {
		this.idproducts = idproducts;
		this.productname = productname;
		this.unitsEntity = unitsEntity;
	}

	public Long getIdproducts() {
		return idproducts;
	}

	public void setIdproducts(Long idproducts) {
		this.idproducts = idproducts;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public UnitsEntity getUnitsEntity() {
		return unitsEntity;
	}

	public void setUnitsEntity(UnitsEntity unitsEntity) {
		this.unitsEntity = unitsEntity;
	}

	@Override
	public String toString() {
		return "ProductsEntity [idproducts=" + idproducts + ", productname="
				+ productname + ", unitsEntity=" + unitsEntity.getUnit() + "]";
	}

}
