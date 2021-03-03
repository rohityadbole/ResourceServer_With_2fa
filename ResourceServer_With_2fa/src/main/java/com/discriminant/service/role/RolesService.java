package com.discriminant.service.role;

import java.util.List;

import com.discriminant.model.UserRole;

public interface RolesService {
	public List<UserRole> getListOfRoles();
	public void deleteRole(String role_id);
	public void updateRole(String role_id, UserRole role);
	public void createRole(UserRole role);

}
