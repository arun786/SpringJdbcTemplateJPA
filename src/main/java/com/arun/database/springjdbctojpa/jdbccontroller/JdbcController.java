package com.arun.database.springjdbctojpa.jdbccontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.arun.database.springjdbctojpa.jdbcBean.Person;
import com.arun.database.springjdbctojpa.jdbcdao.PersonJdbcDao;

@RestController
public class JdbcController {

	@Autowired
	PersonJdbcDao personJdbcDao;

	@GetMapping(value = "/getAllPerson")
	public ResponseEntity<List<Person>> getAllPerson() {
		List<Person> persons = personJdbcDao.findAll();
		return new ResponseEntity<List<Person>>(persons, HttpStatus.OK);
	}

	@GetMapping(value = "/getAPerson/{id}")
	public ResponseEntity<Person> findAPerson(@PathVariable final int id) {
		Person person = personJdbcDao.findAPerson(id);
		return new ResponseEntity<Person>(person, HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteAPerson/{id}")
	public ResponseEntity<String> deleteAPerson(@PathVariable final int id) {
		String result = personJdbcDao.deleteAPerson(id);
		return new ResponseEntity<String>(result, HttpStatus.GONE);
	}

	@PostMapping(value = "/insertAPerson")
	public ResponseEntity<String> insertAPerson(@RequestBody Person person) {
		String result = personJdbcDao.insertAPerson(person);
		return new ResponseEntity<String>(result, HttpStatus.CREATED);
	}
}
