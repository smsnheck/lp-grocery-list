package de.heckmann.lp_grocery_list.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import de.heckmann.lp_grocery_list.db.entities.ProductsEntity;

public interface ProductsRepository extends JpaRepository<ProductsEntity, Long>{

	List<ProductsEntity> findByProductname(@Param("productname") String productname);
}
