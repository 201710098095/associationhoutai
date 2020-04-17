package service.impl;

import mapper.AssociationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Association;
import service.IAssociationService;

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


}
