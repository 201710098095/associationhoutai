package service;

import pojo.User;

import java.util.List;

public interface IUserService {
    public List<User> ListUser();

    public List<User> ListUserByUid(Long uid);

    public void updateUser( Long uid,String name, String college,String phone,String professional);
}
