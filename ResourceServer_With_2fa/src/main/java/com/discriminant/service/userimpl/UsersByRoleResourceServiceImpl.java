package com.discriminant.service.userimpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.discriminant.dao.user.UsersByRoleResourceDao;
import com.discriminant.service.user.UsersByRoleResourceService;

@Service
public class UsersByRoleResourceServiceImpl implements UsersByRoleResourceService {
	
	@Autowired
	UsersByRoleResourceDao usersByRoleResourceDao;

	@Override
	public Object viewUsersByRole(String role_id) {
		
		return usersByRoleResourceDao.viewUsersByRole(role_id);
	}

	@Override
	public void assignUsers2Role(String role_id, ArrayList<String> usersList) {
		usersByRoleResourceDao.assignUsers2Role(role_id, usersList);
		
	}

	@Override
	public String getRoleById(String role_id) {
		
		return usersByRoleResourceDao.getRoleById(role_id);
	}

	@Override
	public Integer checkIfUserIdExists(String user_id) {
		
		return usersByRoleResourceDao.checkIfUserIdExists(user_id);
	}

}
