package com.arun.database.springjdbctojpa.jdbcdao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.arun.database.springjdbctojpa.jdbcBean.PersonJpa;

@Repository
@Transactional
public class PersonJpaDao {

	@PersistenceContext
	EntityManager entityManager;

	public PersonJpa findById(int id) {
		return entityManager.find(PersonJpa.class, id);
	}

	public PersonJpa InsertById(PersonJpa personJpa) {
		return entityManager.merge(personJpa);
	}

	public List<PersonJpa> findAll() {
		return entityManager.createNamedQuery("findAllPersons", PersonJpa.class).getResultList();
	}

}
