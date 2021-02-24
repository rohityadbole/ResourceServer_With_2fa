package com.resourceserver.dao.role;

import java.util.List;

import com.resourceserver.model.UserRole;

public interface RolesDao {
	public List<UserRole> getListOfRoles();
	public void deleteRole(String role_id);
	public void updateRole(String role_id, UserRole role);
	public void createRole(UserRole role);

}
