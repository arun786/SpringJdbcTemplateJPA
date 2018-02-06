package com.arun.database.springjdbctojpa.jdbcdao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseDaoTest {
	
	@Autowired
	public CourseDao courseDao;

	@Test
	@DirtiesContext
	public void test_deleteById() {
		courseDao.deleteById(3L);
		Assert.assertNull(courseDao.findById(3L));
		
	}
}
