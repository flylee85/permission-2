package ones.quzhigang.permission.mapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;

import ones.quzhigang.permission.model.SysRoleUserModel;
import ones.quzhigang.permission.query.SysRoleUserQuery;

@Mapper
public interface  SysRoleUserMapper{
	

																																																																																																																				
	String columns="id,role_id,user_id,operator,operate_time,operate_ip";
	
	String insert="role_id,user_id,operator,operate_time,operate_ip";
																																																																																																												
	String property="#{id},#{roleId},#{userId},#{operator},#{operateTime},#{operateIp}";
	
	String insertProperty="#{roleId},#{userId},#{operator},#{operateTime},#{operateIp}";
																																																																																																																				
	String update="role_id=#{roleId},user_id=#{userId},operator=#{operator},operate_time=#{operateTime},operate_ip=#{operateIp}";
	
	@Select("select "+columns+" from tbl_sys_role_user where ID=#{id}")
	@ResultMap(value="ones.quzhigang.permission.mapper.SysRoleUserMapper.SysRoleUserModelMap")
	SysRoleUserModel getById(long id);
	
	@Insert("insert into tbl_sys_role_user ("+insert+") values ("+insertProperty+")")
	@Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
	long insert(SysRoleUserModel sysRoleUser);

	@Update("update tbl_sys_role_user set "+update+" where ID=#{id}")
	long update(SysRoleUserModel sysRoleUser);
	
	@Delete("delete from tbl_sys_role_user where 1 = 1 and ID=#{id} ")
	void delById(long id);

	@SelectProvider(type=ones.quzhigang.permission.provider.SysRoleUserProvider.class,method="fetchPageAdvance")
	@ResultMap(value="ones.quzhigang.permission.mapper.SysRoleUserMapper.SysRoleUserModelMap")
	List<SysRoleUserModel> fetchPageAdvance(SysRoleUserQuery query);
	
	@SelectProvider(type=ones.quzhigang.permission.provider.SysRoleUserProvider.class,method="fetchPageAdvanceCount")
	int fetchPageAdvanceCount(SysRoleUserQuery query);

	@Select("select role_id from tbl_sys_role_user where user_id=#{userId}")
	@ResultMap(value="ones.quzhigang.permission.mapper.SysRoleUserMapper.SysRoleUserRoleIdModelMap")
	List<Long> getRoleIdListByuser(@Param("userId") long userId);

	@Select("select user_id from tbl_sys_role_user where role_id=#{roleId}")
	@ResultMap(value="ones.quzhigang.permission.mapper.SysRoleUserMapper.SysRoleUserIdModelMap")
	List<Long> getUserIdByRoleId(long roleId);

	@Delete("delete from tbl_sys_role_user where 1 = 1 and role_id=#{roleId} ")
	void deleteByRoleId(@Param("roleId") long roleId);

	@UpdateProvider(type=ones.quzhigang.permission.provider.SysRoleUserProvider.class,method="batchInsert")
	void batchInsert(Map<String, List<SysRoleUserModel>> map);
}