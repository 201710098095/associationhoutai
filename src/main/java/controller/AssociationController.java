package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pojo.Association;
import service.IAssociationService;
import util.ResultHandler;

import java.util.List;

@RestController
public class AssociationController {
    @Autowired
    IAssociationService iAssociationService;
    @RequestMapping("listassocation")
    @ResponseBody
    public ResultHandler ListUser() {
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
}