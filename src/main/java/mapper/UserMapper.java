package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import pojo.User;

@Repository
public interface UserMapper {
	@Select("SELECT \n" +
			"  `id`,\n" +
			"  `name`,\n" +
			"  `college`,\n" +
			"  `phone`,\n" +
			"  `professional` \n" +
			"FROM\n" +
			"  `association`.`person` \n" +
			"LIMIT 0, 1000 ;")
	public List<User> ListUser();

}
