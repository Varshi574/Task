package com.tms.user.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tms.user.dto.ApiResponseDTO;
import com.tms.user.dto.ProjectDTO;
import com.tms.user.dto.UserDTO;
import com.tms.user.dto.UserLoginDTO;
import com.tms.user.entity.UserEntity;
import com.tms.user.exception.UserUidNotFoundException;
import com.tms.user.repository.UserRepository;

import feign.FeignException;
import jakarta.validation.Valid;
import jakarta.ws.rs.InternalServerErrorException;

@Service
public class UserServiceImp implements UserService {
	@Autowired
	private UserRepository usreRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ProjectClient projectClient;
	
	@Autowired
	private TaskClient taskClinet;
	
	@Autowired
    private PasswordEncoder passwordEncoder;



	@Override
	public UserDTO createUser(@Valid UserLoginDTO userloginDTO) 
	{
	    UserEntity userentity = modelMapper.map(userloginDTO, UserEntity.class);
	    
	    userentity.setUserName(userloginDTO.getUserName());
	    userentity.setEmail(userloginDTO.getEmail());
	    userentity.setPassword(passwordEncoder.encode(userloginDTO.getPassword()));
	    
	    userentity.setRole("user");
	    userentity.setProjectId(0L);
	    userentity.setTaskStatus("No Project");
	    userentity.setTaskId(0L);
	    
	    UserEntity savedentity;
	    
	    try 
	    {
	        savedentity = usreRepository.save(userentity);
	    } 
	    catch (Exception e) 
	    {
	        throw new InternalServerErrorException("An unexpected error occurred: " + e.getMessage());
	    }

	    return modelMapper.map(savedentity, UserDTO.class);
	}

	@Override
	public UserDTO getUserByUid(Long uid) 
	{
		UserEntity userentity;
		try
		{
			userentity  = usreRepository.findById(uid).orElseThrow(() -> new UserUidNotFoundException("UserID not Found"));
		}
		catch(DataAccessException e)
		{
	    	throw new InternalServerErrorException("A database error occurred while retrieving user data.");
        } 
		catch (Exception e)
	    {
            throw new InternalServerErrorException("An unexpected error occurred. Please try again later.");
	    }
		return modelMapper.map(userentity, UserDTO.class);
	}

	@Override
	public ApiResponseDTO getUserProjectByUid(Long id) 
	{
		UserEntity userentity;
		try 
		{
			userentity= usreRepository.findById(id).orElseThrow(() -> new UserUidNotFoundException("User Id Not Found"));
		}
		catch(DataAccessException e)
		{
	    	throw new InternalServerErrorException("A database error occurred while retrieving user data.");
        } 
		catch (Exception e) 
	    {
            throw new InternalServerErrorException("An unexpected error occurred. Please try again later.");
	    }
		
		UserDTO userdto = modelMapper.map(userentity, UserDTO.class);
		
		ProjectDTO projectdto;

		try 
		{
			projectdto = projectClient.getProjectByPid(userentity.getProjectId());
		} 
		catch (FeignException.NotFound e) 
		{
			throw new InternalServerErrorException("The requested project was not found.");
		} 
		catch (FeignException e) 
		{
			throw new InternalServerErrorException("A problem occurred while communicating with the external service. Please try again later.");
		} 
		catch (Exception e) 
		{
			throw new InternalServerErrorException("An unexpected error occurred while communicating with the external service. Please try again later.");
		}

		ApiResponseDTO apidto = new ApiResponseDTO(projectdto, userdto);

		return apidto;
	}

	@Override
	public List<UserDTO> getAllUserByUid() 
	{
		List<UserEntity> entitylist;
	    try
	    {
	    	entitylist = StreamSupport.stream(usreRepository.findAll().spliterator(), false).collect(Collectors.toList());
		    
	    }
	    catch(DataAccessException e)
	    {
	    	throw new InternalServerErrorException("A database error occurred while retrieving user data.");
        } 
	    catch (Exception e) 
	    {
            throw new InternalServerErrorException("An unexpected error occurred. Please try again later.");
	    }
	    List<UserDTO> dtolist = entitylist.stream().map(user -> modelMapper.map(user, UserDTO.class)).collect(Collectors.toList());
	    
	    return dtolist;
	}

	@Override
	public List<ApiResponseDTO> getAllUserProject() 
	{
		List<UserEntity> entitylist;
		try
		{
			entitylist= StreamSupport.stream(usreRepository.findAll().spliterator(), false)
					.collect(Collectors.toList());
		}
		catch(DataAccessException e)
	    {
	    	throw new InternalServerErrorException("A database error occurred while retrieving user data.");
        } 
	    catch (Exception e) 
	    {
            throw new InternalServerErrorException("An unexpected error occurred. Please try again later.");
	    }

		List<UserDTO> dtolist = entitylist.stream().map(user -> modelMapper.map(user, UserDTO.class))
				.collect(Collectors.toList());

		List<ApiResponseDTO> apilist = dtolist.stream().map(userdto -> 
		{
			ProjectDTO projectdto;
			try 
			{
				projectdto = projectClient.getProjectByPid(userdto.getProjectId());
			} 
			catch (FeignException.NotFound e) 
			{
				throw new InternalServerErrorException("The requested project was not found.");
			} 
			catch (FeignException e) 
			{
				throw new InternalServerErrorException("A problem occurred while communicating with the external service. Please try again later.");
			} 
			catch (Exception e) 
			{
				throw new InternalServerErrorException("An unexpected error occurred while communicating with the external service. Please try again later.");
			}
			
			return new ApiResponseDTO(projectdto, userdto);
		}).collect(Collectors.toList());
		return apilist;
	}

	@Override
	public void deleteUser(Long id) 
	{
		UserEntity userentity; 
		
		try
		{
			userentity = usreRepository.findById(id).orElseThrow(() -> new UserUidNotFoundException("User Id Not Found"));
		}
		
		catch(DataAccessException e)
	    {
	    	throw new InternalServerErrorException("A database error occurred while retrieving user data.");
        } 
	    catch (Exception e) 
	    {
            throw new InternalServerErrorException("An unexpected error occurred. Please try again later.");
	    }
		
		usreRepository.delete(userentity);
	}

	@Override
	public UserDTO updateUser(Long uid, UserLoginDTO userdto) 
	{
		
		UserEntity userentity; 
		
		try
		{
			userentity = usreRepository.findById(uid).orElseThrow(() -> new UserUidNotFoundException("User Id Not Found"));
		}
		
		catch(DataAccessException e)
	    {
	    	throw new InternalServerErrorException("A database error occurred while retrieving user data.");
        } 
	    catch (Exception e) 
	    {
            throw new InternalServerErrorException("An unexpected error occurred. Please try again later.");
	    }
		userentity.setUserName(userdto.getUserName());
		userentity.setPassword(passwordEncoder.encode(userdto.getPassword()));
		userentity.setEmail(userdto.getEmail());
		
		userentity.setProjectId(userentity.getProjectId());
		userentity.setTaskStatus(userentity.getTaskStatus());
		userentity.setTaskId(userentity.getTaskId());
		userentity.setRole(userentity.getRole());
		UserEntity saveduser = usreRepository.save(userentity);

		return modelMapper.map(saveduser, UserDTO.class);
	}

	@Override
	public void updateTid(Long userId, Long taskId, Long projectId,String taskStatus) 
	{
		UserEntity userentity; 
		
		try
		{
			userentity =  usreRepository.findById(userId).orElseThrow(() -> new UserUidNotFoundException("User Id Not Found"));
		}
		
		catch(DataAccessException e)
	    {
	    	throw new InternalServerErrorException("A database error occurred while retrieving user data.");
        } 
	    catch (Exception e) 
	    {
            throw new InternalServerErrorException("An unexpected error occurred. Please try again later.");
	    }
		
		
		userentity.setTaskId(taskId);
		userentity.setProjectId(projectId);
		userentity.setTaskStatus(taskStatus);
		usreRepository.save(userentity);
		
	}

	
	@Override
	public void updateTstatus(Long uid, UserDTO userdto) 
	{
		UserEntity userentity = usreRepository.findById(uid).orElseThrow(()->new UserUidNotFoundException("Id not found"));
		userentity.setTaskStatus(userdto.getTaskStatus());
		usreRepository.save(userentity);
		taskClinet.updateTaskStatus(uid, userentity.getProjectId(), userentity.getTaskId(), userentity.getTaskStatus());
	}

	@Override
	public List<UserDTO> getUserByPid(Long projectId) 
	{
		List<UserEntity> userentity = usreRepository.findAllByProjectId(projectId);
		return userentity.stream().map(entity->modelMapper.map(entity,UserDTO.class)).collect(Collectors.toList());
	}

	@Override
	public UserDTO getUserByEmail(String email) {
		UserEntity userentity = usreRepository.findByEmail(email)
				.orElseThrow(() -> new UserUidNotFoundException("Email Not Found"));
		return modelMapper.map(userentity, UserDTO.class);
	}
}


