package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pojo.User;
import service.impl.UserServiceImpl;
import util.ResultHandler;

import java.util.List;


@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserServiceImpl userservice;

    @RequestMapping("/ListUser")
    @ResponseBody
    public ResultHandler ListUser() {
        ResultHandler resultHandler = new ResultHandler();
        List<User> userList = userservice.ListUser();
        if (userList.size() > 0 && userList != null) {
            resultHandler.setCode(200);
            resultHandler.setMsg("获取成功");
            resultHandler.setData(userList);
        } else {
            resultHandler.setCode(400);
            resultHandler.setMsg("获取失败");
        }
        return resultHandler;
    }

    @RequestMapping("updateuser")
    @ResponseBody
    public ResultHandler updateUserInfo(@RequestParam("uid") Long id, @RequestParam("name") String name, @RequestParam("college") String college, @RequestParam("phone") String phone, @RequestParam("professional") String professional) {
        ResultHandler resultHandler = new ResultHandler();
        userservice.updateUser(id, name, college, phone, professional);
        List list = userservice.ListUserByUid(id);
        resultHandler.setCode(200);
        resultHandler.setData(list);
        return resultHandler;
    }

    @RequestMapping("associtionname")
    @ResponseBody
    public ResultHandler ListUserByAssocitionName(@RequestParam("name")String name) {
        ResultHandler resultHandler = new ResultHandler();
        List<User> userList = userservice.listUserByAssoName(name);
        if (userList.size() > 0 && userList != null) {
            resultHandler.setCode(200);
            resultHandler.setMsg("获取成功");
            resultHandler.setData(userList);
        } else {
            resultHandler.setCode(400);
            resultHandler.setMsg("获取失败");
        }
        return resultHandler;
    }
}
