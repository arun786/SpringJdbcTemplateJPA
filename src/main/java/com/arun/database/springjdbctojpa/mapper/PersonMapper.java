package com.arun.database.springjdbctojpa.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.arun.database.springjdbctojpa.jdbcBean.Person;

public class PersonMapper implements RowMapper<Person> {

	@Override
	public Person mapRow(ResultSet rs, int arg1) throws SQLException {
		Person person = new Person();
		person.setId(rs.getInt(1));
		person.setName(rs.getString(4));
		person.setLocation(rs.getString(3));
		person.setBirthDate(rs.getDate(2));
		return person;
	}
}
