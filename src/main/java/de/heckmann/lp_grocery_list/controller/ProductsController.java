package de.heckmann.lp_grocery_list.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import de.heckmann.lp_grocery_list.db.entities.ProductsEntity;
import de.heckmann.lp_grocery_list.db.entities.UnitsEntity;
import de.heckmann.lp_grocery_list.db.repository.ProductsRepository;
import de.heckmann.lp_grocery_list.services.ProductsService;

@Controller
@RequestMapping("/products")
public class ProductsController {
	
	@Autowired
	private ProductsRepository productsRepository;
	
	@Autowired
	private ProductsService productsService;
	
	@RequestMapping(method=RequestMethod.POST, produces="application/json")
	public @ResponseBody ResponseEntity<ProductsEntity> createProduct(
			@RequestParam String productName,
			@RequestParam Long units_id){
		
		ProductsEntity newEntity = new ProductsEntity(productName, new UnitsEntity(units_id));
		productsService.create(newEntity);
		
		return new ResponseEntity<ProductsEntity>(HttpStatus.CREATED);
	}
	

}
