package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import pojo.User;

@Repository
public interface UserMapper {
	@Select("SELECT \r\n" + 
			"  `userName`,\r\n" + 
			"  `passWord` \r\n" + 
			"FROM\r\n" + 
			"  `test`.`user` WHERE `userName`='001' AND `passWord`='131';")
	public List<User> ListUser();

}