package com.discriminant.service.user;

import java.util.ArrayList;

public interface UsersByRoleResourceService {
	
	public Object viewUsersByRole(String role_id);
	public void assignUsers2Role(String role_id, ArrayList<String> usersList);
	public String getRoleById(String role_id);
	public Integer checkIfUserIdExists(String user_id);


}
