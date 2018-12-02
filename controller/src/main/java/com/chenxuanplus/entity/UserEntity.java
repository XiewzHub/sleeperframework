package com.chenxuanplus.entity;

import java.io.Serializable;

import com.chenxuanplus.enums.UserSexEnum;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "用户ID不能为空!")
	private Long id;
	private String userName;
	private String passWord;
	private UserSexEnum userSex;
	private String nickName;

	public UserEntity() {
		super();
	}

	public UserEntity(String userName, String passWord, UserSexEnum userSex) {
		super();
		this.passWord = passWord;
		this.userName = userName;
		this.userSex = userSex;
	}

}