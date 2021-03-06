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

    @RequestMapping("deletemember")
    @ResponseBody
    public ResultHandler deleteSa(@RequestParam ("assocaitionName") String associationName,@RequestParam("memberName") String memberName){
        ResultHandler resultHandler=new ResultHandler();
        userservice.deleteSa(associationName, memberName);
        resultHandler.setCode(200);
        return resultHandler;
    }

    @RequestMapping("ListUserByNickname")
    @ResponseBody
    public ResultHandler ListUserByNickname(@RequestParam("nickname")String nickname) {
        ResultHandler resultHandler = new ResultHandler();
        List<User> userList = userservice.ListUserByNickname(nickname);
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

    @RequestMapping("userjoin")
    @ResponseBody
    public ResultHandler insert(@RequestParam("uname") String uname,@RequestParam("aname")String aname ){
        ResultHandler resultHandler=new ResultHandler();
        //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //Date date=null;
        userservice.userjoin(uname, aname);
        resultHandler.setCode(200);

        return resultHandler;


    }
}
