package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pojo.User;
import service.UserService;
import util.ResultHandler;

import java.util.List;


@RestController
public class test {
    @Autowired
    UserService userservice;

    @RequestMapping("/hello")
    public String hello() {
        return "hello world";
    }

    @RequestMapping("/ListUser")
    @ResponseBody
    public ResultHandler ListUser() {
        ResultHandler resultHandler=new ResultHandler();
        List<User> userList=userservice.ListUser();
        if(userList.size()>0&&userList!=null){
            resultHandler.setCode(200);
            resultHandler.setMsg("获取成功");
            resultHandler.setData(userList);
        }else{
            resultHandler.setCode(400);
            resultHandler.setMsg("获取失败");
        }
        return resultHandler;
    }
}
