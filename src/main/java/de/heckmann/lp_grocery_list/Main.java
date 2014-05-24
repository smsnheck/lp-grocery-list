package de.heckmann.lp_grocery_list;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import de.heckmann.lp_grocery_list.db.entities.ProductsEntity;
import de.heckmann.lp_grocery_list.db.repository.ProductsRepository;

public class Main {

		
	public static void main(String[] args){
		final AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		context.registerShutdownHook();
		
		Execution ex = context.getBean(Execution.class);
		ex.execute();
		
		
	}
	
}
