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
