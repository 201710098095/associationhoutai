package mapper;

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
}
