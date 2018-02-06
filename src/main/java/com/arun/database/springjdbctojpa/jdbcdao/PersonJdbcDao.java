package com.arun.database.springjdbctojpa.jdbcdao;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.arun.database.springjdbctojpa.jdbcBean.Person;
import com.arun.database.springjdbctojpa.mapper.PersonMapper;

@Repository
public class PersonJdbcDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Person> findAll() {
		return jdbcTemplate.query("select * from person", new PersonMapper());
	}

	public Person findAPerson(int id) {
		return jdbcTemplate.queryForObject("select * from person where id = ?", new Object[] { id },
				new PersonMapper());
	}

	public String deleteAPerson(final int id) {
		int rowsDeleted = jdbcTemplate.update("delete from person where id= ?", new Object[] { id });
		return rowsDeleted > 0 ? "Successful" : "Failed";
	}

	public String insertAPerson(final Person person) {
		int rowsDeleted = jdbcTemplate.update("insert into person (id, name,location,birth_date) values(?,?,?,?)",
				new Object[] { person.getId(), person.getName(), person.getLocation(),
						new Timestamp(person.getBirthDate().getTime()) });
		return rowsDeleted > 0 ? "Successful" : "Failed";
	}
}
