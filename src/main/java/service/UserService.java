package service;

import java.util.List;

import mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;


import pojo.User;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	

	public List<User> ListUser(){
		return	userMapper.ListUser();
	}
	

}
