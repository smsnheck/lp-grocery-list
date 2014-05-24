package de.heckmann.lp_grocery_list.db.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "grocerycategoriesentity")
public class GroceryCategoriesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long position;
	private String name;

	protected GroceryCategoriesEntity() {
	}

	public GroceryCategoriesEntity(String name, long position) {
		this.name = name;
		this.position = position;
	}

	@Override
	public String toString() {
		return String.format("GroceryCategories [%d], name: %s, position: %s",
				id, name, position);
	}

}
