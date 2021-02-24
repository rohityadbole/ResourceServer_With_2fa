package com.resourceserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.resourceserver.config.AccessTokenMapper;
import com.resourceserver.dao.permissionimpl.PermissionResourceDaoImpl;
import com.resourceserver.dao.permissionimpl.PermissionsByRoleResourceDaoImpl;
import com.resourceserver.model.Permission;
import com.resourceserver.service.permission.PermissionResourceService;
import com.resourceserver.service.permission.PermissionsByRoleResourceService;

@RestController
public class PermissionResource {

	@Autowired
	PermissionResourceService permissionResourceService;
	@Autowired
	PermissionsByRoleResourceService permissionsByRoleResourceService;
	
	@PreAuthorize("hasAnyRole('view_permission')")
	@RequestMapping(value="/permissions", method=RequestMethod.GET)
	public ResponseEntity<Object> getListOfPermissions() {
		AccessTokenMapper accessTokenMapper = (AccessTokenMapper) 
				((OAuth2AuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails()).getDecodedDetails();
		System.out.println("accessTokenMapper.getFirst_name()::"+accessTokenMapper.getFirst_name());
		System.out.println("accessTokenMapper.getLast_name()::"+accessTokenMapper.getLast_name());
		System.out.println("accessTokenMapper.getMobile()::"+accessTokenMapper.getMobile());
		System.out.println("accessTokenMapper.getUser_type()::"+accessTokenMapper.getUser_type());
		return new ResponseEntity<Object>(permissionResourceService.getListOfPermissions(), HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyRole('view_permission_by_role')")
	@RequestMapping(value = "/roles/{id}/permission", method = RequestMethod.GET)
	public ResponseEntity<Object> viewUsersByRole(@PathVariable("id") String permission_id) {
		return new ResponseEntity<>(permissionsByRoleResourceService.getViewPermissionsByRole(permission_id), HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyRole('delete_permission')")
	@RequestMapping(value = "/permissions/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteUser(@PathVariable("id") String permission_id) {
		
		permissionResourceService.deletePermission(permission_id);
		return new ResponseEntity<Object>("Role deleted successfully", HttpStatus.OK);
	}

	@PreAuthorize("hasAnyRole('edit_permission')")
	@RequestMapping(value = "/permissions/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateUser(@PathVariable("id") String permission_id, @RequestBody Permission Permission) {
		permissionResourceService.updatePermission(permission_id, Permission);
		return new ResponseEntity<Object>("Role updated successfully", HttpStatus.OK);
	}

	@PreAuthorize("hasAnyRole('create_permission')")
	@RequestMapping(value = "/permissions", method = RequestMethod.POST)
	public ResponseEntity<Object> createUser(@RequestBody Permission Permission) {
		permissionResourceService.createPermission(Permission);
		return new ResponseEntity<Object>("Role created successfully", HttpStatus.OK);
	}
}
