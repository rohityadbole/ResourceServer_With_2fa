package com.resourceserver.service.permission;

import java.util.List;

public interface PermissionsByRoleResourceService {
	public List<String> getViewPermissionsByRole(String role_id);
	public void assignPermissions2Role(String role_id, List<String> permissionsList);

}
