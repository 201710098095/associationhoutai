package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pojo.Association;
import service.IAssociationService;
import util.ResultHandler;

import java.util.List;

@RestController
@RequestMapping("association")
public class AssociationController {
    @Autowired
    IAssociationService iAssociationService;
    @RequestMapping("listassocation")
    @ResponseBody
    public ResultHandler ListAssociation() {
        ResultHandler resultHandler=new ResultHandler();
        List<Association> associtionsList=iAssociationService.listAssociations();
        if(associtionsList.size()>0&&associtionsList!=null){
            resultHandler.setCode(200);
            resultHandler.setMsg("获取成功");
            resultHandler.setData(associtionsList);
        }else{
            resultHandler.setCode(400);
            resultHandler.setMsg("获取失败");
        }
        return resultHandler;
    }

    @RequestMapping("name")
    @ResponseBody
    public ResultHandler ListAssociationByName(@RequestParam("name")String name) {
        ResultHandler resultHandler=new ResultHandler();
        List<Association> associtionsList=iAssociationService.listAssociationByName(name);
        if(associtionsList.size()>0&&associtionsList!=null){
            resultHandler.setCode(200);
            resultHandler.setMsg("获取成功");
            resultHandler.setData(associtionsList);
        }else{
            resultHandler.setCode(400);
            resultHandler.setMsg("获取失败");
        }
        return resultHandler;
    }

    @RequestMapping("userid")
    @ResponseBody
    public ResultHandler ListAssociationByUserId(@RequestParam("id")String name) {
        ResultHandler resultHandler=new ResultHandler();
        List<Association> associtionsList=iAssociationService.ListAssociationByUserName(name);
        if(associtionsList.size()>0&&associtionsList!=null){
            resultHandler.setCode(200);
            resultHandler.setMsg("获取成功");
            resultHandler.setData(associtionsList);
        }else{
            resultHandler.setCode(400);
            resultHandler.setMsg("获取失败");
        }
        return resultHandler;
    }


    @RequestMapping("userexit")
    @ResponseBody
    public ResultHandler deleteMember(@RequestParam("uid")Long uid,@RequestParam("aid")Integer aid) {
        ResultHandler resultHandler=new ResultHandler();
        iAssociationService.deletemember(uid,aid);
        List<Association> associtionsList=iAssociationService.ListAssociationByUserName(String.valueOf(uid));
        if(associtionsList.size()>0&&associtionsList!=null){
            resultHandler.setCode(200);
            resultHandler.setMsg("删除成功");
            resultHandler.setData(associtionsList);
        }
        return resultHandler;
    }
}
