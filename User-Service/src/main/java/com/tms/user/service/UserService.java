package com.tms.user.service;

import java.util.List;

import com.tms.user.dto.ApiResponseDTO;
import com.tms.user.dto.UserDTO;
import com.tms.user.dto.UserLoginDTO;

import jakarta.validation.Valid;

public interface UserService 
{
	public UserDTO createUser(@Valid UserLoginDTO userloginDTO);

	
	public UserDTO updateUser(Long userId,UserLoginDTO userDTO);		// to update user at a particular uid
	public void updateTid(Long userId, Long taskId,Long projectId,String taskStatus);	// admin will set pid and tid in user
	public void updateTstatus(Long userId,UserDTO userDTO);	// to update tstatus

	public UserDTO getUserByUid(Long userId);					// get only user with out project
	public List<UserDTO> getAllUserByUid();					// get all users with out project
	public List<ApiResponseDTO> getAllUserProject();		// get all users with projects
	public ApiResponseDTO getUserProjectByUid(Long userId);		// get user with his project
	public List<UserDTO>getUserByPid(Long projectId);					// to get user by pid
	public UserDTO getUserByEmail(String email);			// to get user by email
	
	public void deleteUser(Long userId);						
	
}
