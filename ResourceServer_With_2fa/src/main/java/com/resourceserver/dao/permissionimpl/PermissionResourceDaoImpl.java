package com.resourceserver.dao.permissionimpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.resourceserver.dao.permission.PermissionResourceDao;
import com.resourceserver.model.Permission;

@Repository("permissionResourceDao")
public class PermissionResourceDaoImpl implements PermissionResourceDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Permission> getListOfPermissions() {
		Collection<Map<String, Object>> rows3 = jdbcTemplate.queryForList("select * from permission");
		List<Permission> permissionsList = new ArrayList<>();
		rows3.stream().map((row) -> {
			Permission p = new Permission();
			p.setPermission_name((String)row.get("permission_name"));
			p.setId(String.valueOf(row.get("id")));
			return p;
		}).forEach((ss3) -> {
			permissionsList.add(ss3);
		});
		return permissionsList;
	}
	
	public void deletePermission(String Permission_id) {
		jdbcTemplate.update("delete from permission where id=?", new Object[] { Permission_id });
	}

	public void updatePermission(String Permission_id, Permission Permission) {
		jdbcTemplate.update("update permission set permission_name=? where id=?", new Object[] { Permission.getPermission_name(), Permission_id });
	}

	public void createPermission(Permission Permission) {
		jdbcTemplate.update("insert into permission (permission_name) values (?)", new Object[] { Permission.getPermission_name() });
	}
}