package com.example.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JAPUtil {
	
	static EntityManagerFactory entityManagerfactory;
	
	public static EntityManager getEntityManager() {
		if(entityManagerfactory==null) {
			entityManagerfactory=Persistence.createEntityManagerFactory("PU");
			
			
		}
		return entityManagerfactory.createEntityManager();
		
	}
	

}