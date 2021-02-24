package com.resourceserver.service.userimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resourceserver.dao.user.UserResourceDao;
import com.resourceserver.model.UserModel;
import com.resourceserver.service.user.UserResourceService;

@Service
public class UserResourceServiceImpl implements UserResourceService {
	
	@Autowired
	UserResourceDao userResourceDao;

	@Override
	public List<UserModel> getListOfUsers() {
		
		return userResourceDao.getListOfUsers();
	}

	@Override
	public void deleteUser(String user_id) {
		userResourceDao.deleteUser(user_id);
		
	}

	@Override
	public void updateUser(String user_id, UserModel userModel) {
		userResourceDao.updateUser(user_id, userModel);
		
	}

	@Override
	public void createUser(UserModel userModel) {
		userResourceDao.createUser(userModel);
		
	}

	@Override
	public boolean isSuperAdmin(String id) {
		
		return userResourceDao.isSuperAdmin(id);
	}

}
