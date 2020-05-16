package mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import pojo.Association;

import javax.xml.crypto.Data;
import java.util.Date;
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
            "                     DISTINCT `association`.`sa`.`uid`,\n" +
            "                     `association`.`sa`.`aid`,\n" +
            "                         `association`.`association`.*\n" +
            "                       FROM\n" +
            "                `association`.`sa` ,`association`.`association`\n" +
            "            WHERE `uid`=#{id} AND `association`.`sa`.`aid`=`association`.`association`.`id`       \n" +
            "            LIMIT 0, 1000 ;")
    public List<Association> ListAssociationByUserName(@Param("id") String id);

    @Delete("DELETE \n" +
            "FROM\n" +
            "  `association`.`sa` \n" +
            "WHERE `uid` = #{uid} \n" +
            "  AND `aid` = #{aid} ;")
    void delete(@Param("uid") Long uid, @Param("aid") Integer aid);

    @Insert("insert into `association`.`association` (\n" +
            "  \n" +

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
            "  `other`\n" +
            ") \n" +
            "values\n" +
            "  (\n" +
            "    \n" +
            "    #{name},\n" +
            "    #{chargePersons},\n" +
            "    #{phone},\n" +
            "    #{date},\n" +
            "    #{type},\n" +
            "    #{msg},\n" +
            "    #{image},\n" +
            "    #{activity},\n" +
            "    #{recruit},\n" +
            "    #{sponsor},\n" +
            "    #{other}\n" +
            "  ) ;")
    void insert(@Param("name") String name, @Param("chargePersons") String chargePersons, @Param("phone") String phone, @Param("date") String data, @Param("type") String type, @Param("msg") String msg, @Param("image") String image, @Param("activity") String activity, @Param("recruit") String recruit, @Param("sponsor") String sponsor, @Param("other") String other);


    @Update("UPDATE \n" +
            "  `association`.`association` \n" +
            "SET\n" +
            "  `name` = #{name},\n" +
            "  `chargePersons` =#{chargePersons},\n" +
            "  `phone` = #{phone},\n" +
            "  `date` = #{date},\n" +
            "  `type` = #{type},\n" +
            "  `msg` = #{msg},\n" +
            "  `image` = #{image},\n" +
            "  `activity` = #{activity},\n" +
            "  `recruit` = #{recruit},\n" +
            "  `sponsor` = #{sponsor},\n" +
            "  `other` = #{other} \n" +
            "WHERE `chargePersons` = #{chargePersons} ;\n" +
            "\n")
    void update(@Param("name") String name, @Param("chargePersons") String chargePersons, @Param("phone") String phone, @Param("date") String data, @Param("type") String type, @Param("msg") String msg, @Param("image") String image, @Param("activity") String activity, @Param("recruit") String recruit, @Param("sponsor") String sponsor, @Param("other") String other);

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
            "  WHERE `association`.`chargePersons`=#{chaegePresons}\n" +
            "LIMIT 0, 1000 ;\n" +
            "\n")
    public List<Association> ListAssociationByCharge(@Param("chaegePresons") String chaegePresons);

    @Update("")
    void submit();
}



