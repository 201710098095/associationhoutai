package service.impl;

import java.util.List;

import mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;


import pojo.User;
import service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserMapper userMapper;
	

	public List<User> ListUser(){
		return	userMapper.ListUser();
	}

    @Override
    public List<User> ListUserByUid(Long uid) {
        return userMapper.ListUserByUid(uid);
    }

    @Override
    public void updateUser(Long uid, String name, String college, String phone, String professional) {
        userMapper.updateUserInfo(uid,name,college,phone,professional);
    }

    @Override
    public List<User> listUserByAssoName(String associationName) {
        return userMapper.listUserByAssoName(associationName);
    }

    @Override
    public void deleteSa(String associationName, String memberName) {
        userMapper.deleteSa(associationName, memberName);
    }

    @Override
    public List<User> ListUserByNickname(String nickname) {
        return userMapper.ListUserByNickname(nickname);
    }

    @Override
    public void userjoin(String uname, String aname) {
        userMapper.userjoin(uname, aname);
    }


}
