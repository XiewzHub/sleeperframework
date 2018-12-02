package com.chenxuanplus.web;

import java.util.List;

import com.chenxuanplus.entity.UserEntity;
import com.chenxuanplus.mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @Author chenxuan
 * @Description 测试Ctroller
 * @Date 3:48 PM 2018/12/2
 * @Param
 * @return
 **/
@RestController
@RequestMapping("/sleeper/testUser")
@Api(value = "测试Controller", description = "UserTest")
@Slf4j
public class UserController {
	
	@Autowired
	private UserMapper userMapper;

    @ApiOperation(value = "查询所有用户", notes = "用户查询接口", produces = "application/json", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping("/getUsers")
	public List<UserEntity> getUsers() {
		List<UserEntity> users=userMapper.getAll();
		return users;
	}
    @ApiOperation(value = "根据ID查询用户", notes = "用户查询接口", produces = "application/json", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping("/getUser")
    public UserEntity getUser(Long id) {
    	UserEntity user=userMapper.getOne(id);
        return user;
    }
    @ApiOperation(value = "新增用户", notes = "用户新增接口", produces = "application/json", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping("/save")
    public void save(UserEntity user) {
    	userMapper.insert(user);
    }

    @ApiOperation(value = "更新用户", notes = "用户更新接口", produces = "application/json", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping("/update")
    public void update(UserEntity user) {
    	userMapper.update(user);
    }

    @ApiOperation(value = "删除用户", notes = "根据用户ID删除用户信息", produces = "application/json", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping("/delete")
    public void delete(@PathVariable("id") Long id) {
    	userMapper.delete(id);
    }
    
    
}