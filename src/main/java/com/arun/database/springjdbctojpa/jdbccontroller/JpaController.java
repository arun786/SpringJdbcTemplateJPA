package com.arun.database.springjdbctojpa.jdbccontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.arun.database.springjdbctojpa.jdbcBean.PersonJpa;
import com.arun.database.springjdbctojpa.jdbcdao.PersonJpaDao;

@RestController
public class JpaController {

	@Autowired
	private PersonJpaDao personJpaDao;

	@GetMapping("/jpaperson/{id}")
	public ResponseEntity<PersonJpa> finbdById(@PathVariable int id) {
		PersonJpa personJpa = personJpaDao.findById(id);
		return new ResponseEntity<PersonJpa>(personJpa, HttpStatus.OK);
	}

	@PutMapping("/jpapersoninsert")
	public ResponseEntity<PersonJpa> insertIntoPerson(@RequestBody PersonJpa personJpa) {
		PersonJpa response = personJpaDao.InsertById(personJpa);
		return new ResponseEntity<PersonJpa>(response, HttpStatus.CREATED);
	}

	@GetMapping("/jpapersons")
	public ResponseEntity<List<PersonJpa>> findAll() {
		List<PersonJpa> personJpa = personJpaDao.findAll();
		return new ResponseEntity<List<PersonJpa>>(personJpa, HttpStatus.OK);
	}
}
