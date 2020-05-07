package service.impl;

import mapper.AssociationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Association;
import service.IAssociationService;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
@Service
public class AssociationServiceImpl implements IAssociationService {
    @Autowired
    AssociationMapper associationMapper;

    @Override
    public List<Association> listAssociations() {
        return associationMapper.ListAssociation();
    }

    @Override
    public List<Association> listAssociationByName(String name) {
        return associationMapper.ListAssociationByName(name);
    }

    @Override
    public List<Association> ListAssociationByUserName(String name) {
        return associationMapper.ListAssociationByUserName(name);
    }

    @Override
    public void deletemember(Long uid, Integer aid) {
        associationMapper.delete(uid,aid);
    }

    @Override
    public void addAssociation(String name, String chargePersons, String phone, String data, String type, String msg, String image, String activity, String recruit, String sponsor, String other) {
        associationMapper.insert(name,chargePersons,phone,data,type,msg,image,activity,recruit,sponsor,other);
    }

    @Override
    public void update(String name, String chargePersons, String phone, String data, String type, String msg, String image, String activity, String recruit, String sponsor, String other) {
        associationMapper.update(name, chargePersons, phone, data, type, msg, image, activity, recruit, sponsor, other);
    }


}
