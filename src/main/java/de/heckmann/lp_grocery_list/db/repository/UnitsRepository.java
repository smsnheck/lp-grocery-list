package de.heckmann.lp_grocery_list.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import de.heckmann.lp_grocery_list.db.entities.UnitsEntity;

public interface UnitsRepository extends JpaRepository<UnitsEntity, Long>{

	List<UnitsEntity> findByUnit(@Param("unit") String unit);
	
	List<Long> findIdByUnit(@Param("unit") String unit);
}
