package com.chenxuanplus.mapper;

import com.chenxuanplus.entity.TestEntity;
import com.chenxuanplus.entity.UserEntity;
import com.chenxuanplus.enums.UserSexEnum;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "testMapper")
public interface TestMapper {
	
	@Select("SELECT * FROM test")
	@Results({
		@Result(property = "id",  column = "id"),
		@Result(property = "team", column = "team"),
		@Result(property = "name", column = "name")
	})
	List<TestEntity> getAll();
	
	@Select("SELECT * FROM test WHERE id = #{id}")
	@Results({
		@Result(property = "team",  column = "team"),
		@Result(property = "name", column = "team")
	})
	TestEntity getOne(String id);

	@Insert("INSERT INTO test(id,team,name) VALUES(#{id}, #{team}, #{name})")
	void insert(TestEntity user);

	@Update("UPDATE test SET team=#{team},name=#{name} WHERE id =#{id}")
	void update(TestEntity user);

	@Delete("DELETE FROM test WHERE id =#{id}")
	void delete(Long id);

}