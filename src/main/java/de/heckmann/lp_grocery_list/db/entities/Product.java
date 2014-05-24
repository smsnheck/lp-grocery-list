package de.heckmann.lp_grocery_list.db.entities;

import java.io.Serializable;

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
public class Product implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "productname")
	private String productName;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="units_id")
	private UnitsEntity unitsEntity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public UnitsEntity getUnitsEntity() {
		return unitsEntity;
	}

	public void setUnitsEntity(UnitsEntity unitsEntity) {
		this.unitsEntity = unitsEntity;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName
				+ ", unitsEntity=" + unitsEntity + "]";
	}
	
}
