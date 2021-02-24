package com.resourceserver.service.user;

import java.util.List;

import com.resourceserver.model.UserModel;

public interface UserResourceService {
	public List<UserModel> getListOfUsers();
	public void deleteUser(String user_id);
	public void updateUser(String user_id, UserModel userModel);
	public void createUser(UserModel userModel);
	public boolean isSuperAdmin(String id);
}
