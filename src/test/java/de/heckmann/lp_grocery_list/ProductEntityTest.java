package de.heckmann.lp_grocery_list;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.heckmann.lp_grocery_list.configuration.PersistenceContext;
import de.heckmann.lp_grocery_list.db.entities.ProductsEntity;
import de.heckmann.lp_grocery_list.db.repository.ProductsRepository;

@ContextConfiguration(classes = PersistenceContext.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductEntityTest {

	List<ProductsEntity> addedElements = new ArrayList<ProductsEntity>();

	@Autowired
	ProductsRepository repository;

	@Ignore
	@Test
	public void findAllProducts() {
		List<ProductsEntity> peList = repository.findAll();
		assertTrue("Found not the expected products", peList.size() >= 15);
	}
	/*
	@Ignore
	@Test
	public void insertProduct() {
		String PRODUCT_NAME = "insertProduct";
		int productsCount = repository.findAll().size();
		int newProductsCount = 0;

		ProductsEntity toAdd = new ProductsEntity();
		addedElements.add(toAdd);
		toAdd.setProductName(PRODUCT_NAME);
		toAdd.setUnitsId(1L);

		repository.save(toAdd);
		newProductsCount = repository.findAll().size();

		assertTrue("New products size is not bigger then the old one",
				productsCount < newProductsCount);

		productsCount++;
		assertTrue(
				"After the insertion of a new product the difference is more than one",
				productsCount == newProductsCount);

		repository.delete(toAdd);
	}*/

	/*
	@Ignore
	@Test
	public void insertAndFindProduct() {
		String PRODUCT_NAME = "insertAndFindProduct";
		ProductsEntity toAdd = new ProductsEntity();
		addedElements.add(toAdd);
		toAdd.setProductName(PRODUCT_NAME);
		toAdd.setUnitsId(1L);

		repository.save(toAdd);

		List<ProductsEntity> peList = repository
				.findByProductName(PRODUCT_NAME);

		assertNotNull("Result set is null", peList);
		assertTrue("Product Name matches not the insertet one", peList.get(0)
				.getProductName().equals(PRODUCT_NAME));
		assertNotNull("Inserted product has no generated id", peList.get(0)
				.getId());
		repository.delete(toAdd);
	}
	*/
	
	/*
	@Ignore
	@Test
	public void insertAndDeleteProduct() {
		String PRODUCT_NAME = "insertAndDeleteProduct";
		List<ProductsEntity> listBeforeInsert = repository.findAll();
		List<ProductsEntity> listAfterInsert;
		List<ProductsEntity> listAfterInsertAndDelete;

		ProductsEntity toAdd = new ProductsEntity();
		toAdd.setProductName(PRODUCT_NAME);
		toAdd.setUnitsId(1L);

		repository.save(toAdd);
		listAfterInsert = repository.findByProductName(PRODUCT_NAME);
		assertNotNull(listAfterInsert);

		repository.delete(toAdd);
		listAfterInsertAndDelete = repository.findByProductName(PRODUCT_NAME);
		assertNull(listAfterInsertAndDelete);
	}
	*/
}