package com.discriminant.dao.permission;

import java.util.List;

import com.discriminant.model.Permission;

public interface PermissionResourceDao {
	public List<Permission> getListOfPermissions();
	public void deletePermission(String Permission_id);
	public void updatePermission(String Permission_id, Permission Permission);
	public void createPermission(Permission Permission);

}
