package com.chenxuanplus.mapper;

import com.chenxuanplus.entity.TestEntity;
import com.chenxuanplus.entity.UserEntity;
import com.chenxuanplus.enums.UserSexEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMapperTest {

	@Autowired
	private TestMapper testMapper;

	@Test
	public void testInsert() throws Exception {
		TestEntity testEntity = new TestEntity();
		testEntity.setId("1");
		testEntity.setName("test");
		testEntity.setTeam("test");
		testMapper.insert(testEntity);
		Assert.assertEquals(1, testMapper.getAll().size());
	}

	@Test
	public void testQuery() throws Exception {
		List<TestEntity> testEntityList = testMapper.getAll();
		System.out.println(testEntityList.toString());
	}
	
	
	@Test
	public void testUpdate() throws Exception {
		TestEntity test = testMapper.getOne("1");
		System.out.println(test.toString());
		test.setTeam("test2");
		testMapper.update(test);
		Assert.assertTrue(("test2".equals(testMapper.getOne("1").getTeam())));
	}

}