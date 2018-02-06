# JPA 

## JPA uses Entity Manager

For all crud operations mainly when we are updating the database, delete, insert or update, we have to use 1 annotations.

	1. @Transactional
	
and autowire the EntityManager. Either

use the below 
	@PersistenceContext
	EntityManager entityManager;
or
	@Autowired
	EntityManager entityManager;

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

## Entity Class
	
	package com.arun.database.springjdbctojpa.jdbcBean;

	import java.util.Date;
	
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.Id;
	import javax.persistence.NamedQuery;
	import javax.persistence.Table;
	
	@Entity
	@Table(name = "person")
	@NamedQuery(name = "findAllPersons", query = "select p from PersonJpa p")
	public class PersonJpa {
	
		@Id
		@GeneratedValue
		private int id;
		private String name;
		private String location;
		private Date birthDate;
	
		public PersonJpa() {
			super();
		}
	
		public PersonJpa(String name, String location, Date birthDate) {
			super();
			this.name = name;
			this.location = location;
			this.birthDate = birthDate;
		}
	
		public PersonJpa(int id, String name, String location, Date birthDate) {
			super();
			this.id = id;
			this.name = name;
			this.location = location;
			this.birthDate = birthDate;
		}
	
		public int getId() {
			return id;
		}
	
		public void setId(int id) {
			this.id = id;
		}
	
		public String getName() {
			return name;
		}
	
		public void setName(String name) {
			this.name = name;
		}
	
		public String getLocation() {
			return location;
		}
	
		public void setLocation(String location) {
			this.location = location;
		}
	
		public Date getBirthDate() {
			return birthDate;
		}
	
		public void setBirthDate(Date birthDate) {
			this.birthDate = birthDate;
		}
	
	}
		