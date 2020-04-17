package service;

import pojo.Association;

import java.util.List;

public interface IAssociationService {
    public List<Association> listAssociations();
    public List<Association> listAssociationByName(String name);
    public List<Association> ListAssociationByUserName(String name);
    public void deletemember(Long uid,Integer aid);
}
