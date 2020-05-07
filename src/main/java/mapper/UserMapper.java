package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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
			"  `wxid` \n"+
			"FROM\n" +
			"  `association`.`person` \n" +
			"LIMIT 0, 1000 ;")
	public List<User> ListUser();

	@Select("SELECT \n" +
			"  `id`,\n" +
			"  `name`,\n" +
			"  `college`,\n" +
			"  `phone`,\n" +
			"  `professional` \n" +
			"  `wxid` \n"+
			"FROM\n" +
			"  `association`.`person` WHERE `id` = #{uid}")
	public List<User> ListUserByUid(@Param("uid") Long uid);

	@Update("UPDATE \n" +
			"  `association`.`person` \n" +
			"SET\n" +
			"  `name` = #{name},\n" +
			"  `college` = #{college},\n" +
			"  `phone` = #{phone},\n" +
			"  `professional` = #{professional} \n" +
			"WHERE `id` = #{uid} ;")
	public void updateUserInfo(@Param("uid") Long uid,@Param("name") String name,@Param("college") String college,@Param("phone") String phone,@Param("professional") String professional);

@Select("\n" +
		"SELECT \n" +
		"  `association`.`person`.`name`\n" +
		"FROM\n" +
		"  `association`.`sa` , `association`.`association` ,`association`.`person`\n" +
		"  WHERE `association`.`sa`.`aid`=`association`.`association`.`id` AND `association`.`person`.`id`=`association`.`sa`.`uid`\n" +
		"  AND `association`.`association`.`name`=#{name}\n" +
		"LIMIT 0, 1000 ;")
	public List<User> listUserByAssoName(@Param("name")String associationName);


}
