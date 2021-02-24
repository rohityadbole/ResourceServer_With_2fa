package com.resourceserver.service.permissionimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resourceserver.dao.permission.PermissionsByRoleResourceDao;
import com.resourceserver.service.permission.PermissionsByRoleResourceService;

@Service("permissionsByRoleResourceService")
public class PermissionsByRoleResourceServiceImpl implements PermissionsByRoleResourceService {

	@Autowired
	PermissionsByRoleResourceDao permissionsByRoleResourceDao;
	@Override
	public List<String> getViewPermissionsByRole(String role_id) {
		
		return permissionsByRoleResourceDao.getViewPermissionsByRole(role_id);
	}

	@Override
	public void assignPermissions2Role(String role_id, List<String> permissionsList) {
		permissionsByRoleResourceDao.assignPermissions2Role(role_id, permissionsList);
		
	}

}
