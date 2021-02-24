package com.resourceserver.dao.userimpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.resourceserver.dao.user.UsersByRoleResourceDao;
import com.resourceserver.model.UserModel;

@Repository
public class UsersByRoleResourceDaoImpl implements UsersByRoleResourceDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public Object viewUsersByRole(String role_id) {

		Collection<Map<String, Object>> rows3 = jdbcTemplate.queryForList(
				"select u.id,u.first_name, u.last_name, u.email_id, u.country, u.user_type, u.mobile from `user` u "
						+ "inner join `assign_user_to_role` role_u on u.id=role_u.user_id " + "where role_u.role_id=?",
				new Object[] { role_id });
		List<UserModel> usersList = new ArrayList<>();
		rows3.stream().map((row) -> {
			UserModel user = new UserModel();
			user.setCountry((String) row.get("country"));
			user.setEmail_id((String) row.get("email_id"));
			user.setFirst_name((String) row.get("first_name"));
			user.setId(String.valueOf(row.get("id")));
			user.setLast_name((String) row.get("last_name"));
			user.setMobile((String) row.get("mobile"));
			user.setUser_type((String) row.get("user_type"));
			return user;
		}).forEach((ss3) -> {
			usersList.add(ss3);
		});
		return usersList;

	}

	public void assignUsers2Role(String role_id, ArrayList<String> usersList) { 	
		//jdbcTemplate.update("delete from `assign_user_to_role` where role_id=?", new Object[] {role_id});
		for(String userid:usersList) {
			String role_name=getRoleById(role_id);
			if(checkIfUserIdExists(userid)==0)
			{
				jdbcTemplate.update(
						"insert into `assign_user_to_role` (user_id, role_id) values "
								+ "(?,?)",
						new Object[] {userid,role_id});
			}else {
			jdbcTemplate.update("update `assign_user_to_role` set role_id='"+role_id+"' where user_id=?", new Object[]{userid});
			jdbcTemplate.update("update `user` set user_type='"+role_name+"' where id=?", new Object[]{userid});
			}
		}
	}
	
	public String getRoleById(String role_id) {	
		return jdbcTemplate.queryForObject("select role_name from `role` where id=?",new Object[] { role_id },String.class);

	}
	
	public Integer checkIfUserIdExists(String user_id) {

		Integer count = jdbcTemplate.queryForObject(
				"select count(id) from `assign_user_to_role` where user_id=?",
				new Object[] { user_id }, Integer.class);
		
		return count;

	}
}