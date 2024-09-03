package com.tms.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tms.user.entity.UserEntity;
import com.tms.user.repository.UserRepository;

@Service
public class MyUserDetailsService  implements UserDetailsService
{
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		Optional<UserEntity> user = userRepository.findByEmail(username);
		
		return user.map(MyUserDetails :: new)
				.orElseThrow(() -> new UsernameNotFoundException("user not found"));
	 
	}	 
}
