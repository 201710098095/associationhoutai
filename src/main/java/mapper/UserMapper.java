package mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;
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
			"  `nickname` \n"+
			"FROM\n" +
			"  `association`.`person` \n" +
			"LIMIT 0, 1000 ;")
	public List<User> ListUser();

	@Select("SELECT \n" +
			"  `id`,\n" +
			"  `name`,\n" +
			"  `college`,\n" +
			"  `phone`,\n" +
			"  `professional`,\n" +
			"  `nickname` \n" +
			"FROM\n" +
			"  `association`.`person` \n" +
			"WHERE `association`.`person`.`nickname`= #{nickname}" +
			"LIMIT 0, 1000 ;\n" +
			"\n")
	public List<User> ListUserByNickname(@Param("nickname")String nickname);

	@Select("SELECT \n" +
			"  `id`,\n" +
			"  `name`,\n" +
			"  `college`,\n" +
			"  `phone`,\n" +
			"  `professional` \n" +
			"  `nickname` \n"+
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


@Delete("DELETE \n" +
		"FROM\n" +
		"  `association`.`sa` USING `association`.`sa`,`association`.`association`,`association`.`person` \n" +
		"WHERE `association`.`sa`.`aid`=`association`.`association`.`id`\n" +
		"AND `association`.`sa`.`uid`=`association`.`person`.`id`\n" +
		"AND `association`.`person`.`name` = #{memberName} \n" +
		"  AND `association`.`association`.`name`=#{assocaitionName};")
	public void deleteSa(@Param("assocaitionName") String associationName,@Param("memberName") String memberName);

@Insert("INSERT INTO `association`.`sa` (`uid`, `aid`) \n" +
		"VALUES\n" +
		"  ((SELECT \n" +
		"  `association`.`person`.`id`\n" +
		"FROM\n" +
		"  `association`.`person`\n" +
		"  WHERE `association`.`person`.`name`=#{uname}), (SELECT \n" +
		"  `association`.`association`.`id`\n" +
		"FROM\n" +
		"  `association`.`association`\n" +
		"  WHERE `association`.`association`.`name`=#{aname})) ;")
	public void userjoin(@Param("uname")String uname,@Param("aname")String aname);
}
