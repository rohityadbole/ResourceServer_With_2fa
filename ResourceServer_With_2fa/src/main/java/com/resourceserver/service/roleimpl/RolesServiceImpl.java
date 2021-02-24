package com.resourceserver.service.roleimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resourceserver.dao.role.RolesDao;
import com.resourceserver.model.UserRole;
import com.resourceserver.service.role.RolesService;

@Service
public class RolesServiceImpl implements RolesService{
	
	@Autowired
	RolesDao rolesDao;

	@Override
	public List<UserRole> getListOfRoles() {
		
		return rolesDao.getListOfRoles();
	}

	@Override
	public void deleteRole(String role_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateRole(String role_id, UserRole role) {
		rolesDao.updateRole(role_id, role);
		
	}

	@Override
	public void createRole(UserRole role) {
		rolesDao.createRole(role);
		
	}

}
