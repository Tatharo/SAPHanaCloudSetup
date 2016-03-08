package com.tatharo.absenceapp.persistence.repository;

import javax.persistence.EntityManager;

import com.tatharo.absenceapp.persistence.config.EntityManagerProvider;
import com.tatharo.absenceapp.persistence.model.Person;

public class PersonRepository {

	public void savePerson(Person person){
		EntityManager em = EntityManagerProvider.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em.merge(person);
		em.getTransaction().commit();
		em.close();
	}
}
