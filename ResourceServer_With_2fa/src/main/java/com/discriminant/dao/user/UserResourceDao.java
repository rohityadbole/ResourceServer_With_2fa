package com.discriminant.dao.user;

import java.util.List;

import com.discriminant.model.UserModel;

public interface UserResourceDao {
	public List<UserModel> getListOfUsers();
	public void deleteUser(String user_id);
	public void updateUser(String user_id, UserModel userModel);
	public void createUser(UserModel userModel);
	public boolean isSuperAdmin(String id);

}
