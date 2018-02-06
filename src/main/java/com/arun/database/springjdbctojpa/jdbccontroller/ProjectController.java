package com.arun.database.springjdbctojpa.jdbccontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.arun.database.springjdbctojpa.jdbcBean.Course;
import com.arun.database.springjdbctojpa.jdbcdao.CourseDao;

@RestController
public class ProjectController {

	@Autowired
	private CourseDao courseDao;

	@GetMapping("/course/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable final long id) {
		Course course = courseDao.findById(id);
		return new ResponseEntity<Course>(course, HttpStatus.OK);
	}

	@PutMapping("/courses")
	public ResponseEntity<Course> insertCourseById(@RequestBody final Course course) {
		Course course1 = courseDao.save(course);
		return new ResponseEntity<Course>(course1, HttpStatus.OK);
	}

	@DeleteMapping("/deleteCourse/{id}")
	public ResponseEntity<String> deleteCourseId(@PathVariable final long id) {
		courseDao.deleteById(id);
		return new ResponseEntity<String>("Success", HttpStatus.GONE);
	}

	@GetMapping("/Courses")
	public ResponseEntity<List<Course>> getAllCourses() {
		List<Course> courses = courseDao.findAll();
		return new ResponseEntity<List<Course>>(courses, HttpStatus.OK);
	}
}
