package service;

import org.apache.ibatis.annotations.Param;
import pojo.Association;

import javax.xml.crypto.Data;
import java.util.List;

public interface IAssociationService {
    public List<Association> listAssociations();
    public List<Association> listAssociationByName(String name);
    public List<Association> ListAssociationByUserName(String name);
    public void deletemember(Long uid,Integer aid);
    public void addAssociation(Integer id, String name,String chargePersons,String phone,  Data data,  String type,  String msg, String image, String activity,  String recruit,  String sponsor,  String other);
}
