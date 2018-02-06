package com.arun.database.springjdbctojpa.jdbcBean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "find_all_courses", query = "select c from Course c")
@Table(name = "Course")
public class Course {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name="name", nullable=false)
	private String name;

	public Course(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Course() {
		super();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
