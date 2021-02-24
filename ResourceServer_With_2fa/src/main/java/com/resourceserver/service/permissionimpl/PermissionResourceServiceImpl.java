package com.resourceserver.service.permissionimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resourceserver.dao.permission.PermissionResourceDao;
import com.resourceserver.model.Permission;
import com.resourceserver.service.permission.PermissionResourceService;

@Service("permissionResourceService")
public class PermissionResourceServiceImpl implements PermissionResourceService {
	
	@Autowired
	PermissionResourceDao permissionResourceDao;

	@Override
	public List<Permission> getListOfPermissions() {
		
		return permissionResourceDao.getListOfPermissions();
	}

	@Override
	public void deletePermission(String Permission_id) {
		permissionResourceDao.deletePermission(Permission_id);
		
	}

	@Override
	public void updatePermission(String Permission_id, Permission Permission) {
		permissionResourceDao.updatePermission(Permission_id, Permission);
		
	}

	@Override
	public void createPermission(Permission Permission) {
		permissionResourceDao.createPermission(Permission);
		
	}

}
