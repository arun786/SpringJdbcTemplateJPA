package com.arun.database.springjdbctojpa.jdbcdao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.arun.database.springjdbctojpa.jdbcBean.Course;

@Repository
@Transactional
public class CourseDao {

	@Autowired
	EntityManager entityManager;

	public Course findById(Long id) {
		return entityManager.find(Course.class, id);
	}

	public Course save(Course course) {
		return entityManager.merge(course);
	}

	public void deleteById(Long id) {
		Course course = entityManager.find(Course.class, id);
		entityManager.remove(course);
	}

	public List<Course> findAll() {
		return entityManager.createNamedQuery("find_all_courses", Course.class).getResultList();
	}
	
	public List<Course> findAllWithPartial(String parameter){
		return null;
	}
}
