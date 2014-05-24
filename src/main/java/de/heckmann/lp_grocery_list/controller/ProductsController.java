package de.heckmann.lp_grocery_list.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import de.heckmann.lp_grocery_list.db.repository.ProductsRepository;
import de.heckmann.lp_grocery_list.services.ProductsService;

@Controller
@RequestMapping("/products")
public class ProductsController {
	
	@Autowired
	private ProductsRepository productsRepository;
	
	@Autowired
	private ProductsService productsService;
	

}
