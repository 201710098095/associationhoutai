package mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import pojo.Association;

import java.util.List;

@Repository
public interface AssociationMapper {
    @Select("SELECT \n" +
            "  `id`,\n" +
            "  `name`,\n" +
            "  `chargePersons`,\n" +
            "  `phone`,\n" +
            "  `date`,\n" +
            "  `type`,\n" +
            "  `msg`,\n" +
            "  `image`,\n" +
            "  `activity`,\n" +
            "  `recruit`,\n" +
            "  `sponsor`,\n" +
            "  `other` \n" +
            "FROM\n" +
            "  `association`.`association` \n" +
            "LIMIT 0, 1000 ;")
    public List<Association> ListAssociation();

    @Select("SELECT \n" +
            "  `id`,\n" +
            "  `name`,\n" +
            "  `chargePersons`,\n" +
            "  `phone`,\n" +
            "  `date`,\n" +
            "  `type`,\n" +
            "  `msg`,\n" +
            "  `image`,\n" +
            "  `activity`,\n" +
            "  `recruit`,\n" +
            "  `sponsor`,\n" +
            "  `other` \n" +
            "FROM\n" +
            "  `association`.`association` \n" +
            "WHERE `name`=#{name}\n" +
            "LIMIT 0, 1000 ;")
    public List<Association> ListAssociationByName(@Param("name") String name);

    @Select("SELECT \n" +
            "         DISTINCT `association`.`sa`.`uid`,\n" +
            "         `association`.`sa`.`aid`,\n" +
            "             `association`.`association`.`name`\n" +
            "            FROM\n" +
            "             `association`.`sa` ,`association`.`association`\n" +
            "            WHERE `uid`=201710098566 AND `association`.`sa`.`aid`=`association`.`association`.`id`\n" +
            "            LIMIT 0, 1000 ;")
    public List<Association> ListAssociationByUserName(@Param("id") String id);

    @Delete("DELETE \n" +
            "FROM\n" +
            "  `association`.`sa` \n" +
            "WHERE `uid` = #{uid} \n" +
            "  AND `aid` = #{aid} ;")
    void delete(@Param("uid")Long uid,@Param("aid") Integer aid);
}
