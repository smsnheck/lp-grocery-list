package de.heckmann.lp_grocery_list.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.heckmann.lp_grocery_list.db.entities.ProductsEntity;
import de.heckmann.lp_grocery_list.db.repository.ProductsRepository;

@Transactional
@Service
public class ProductsService {

	@Autowired
	private ProductsRepository productsRepository;

	public Boolean create(ProductsEntity productsEntity) {
		ProductsEntity savedProduct = productsRepository.save(productsEntity);
		if (savedProduct != null) {
			return true;
		} else {
			return false;
		}
	}
}
