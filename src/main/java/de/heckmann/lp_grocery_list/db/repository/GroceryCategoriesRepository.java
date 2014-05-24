package de.heckmann.lp_grocery_list.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import de.heckmann.lp_grocery_list.db.entities.GroceryCategoriesEntity;

public interface GroceryCategoriesRepository extends JpaRepository<GroceryCategoriesEntity, Long> {

	List<GroceryCategoriesEntity> findByName(String name);
}
