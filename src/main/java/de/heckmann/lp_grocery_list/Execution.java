package de.heckmann.lp_grocery_list;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.heckmann.lp_grocery_list.db.entities.ProductsEntity;
import de.heckmann.lp_grocery_list.db.repository.ProductsRepository;

@Component
public class Execution {

	@Autowired
	ProductsRepository productsRepository;

	public void execute(){
		List<ProductsEntity> productsList = productsRepository.findAll(); 
	
		System.out.println("Found " + productsList.size() + " products!");
		
		for(ProductsEntity pe : productsList){
			System.out.println(pe.toString());
		}
	}

}
