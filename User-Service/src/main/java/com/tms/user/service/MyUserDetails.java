package com.tms.user.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.tms.user.entity.UserEntity;

@SuppressWarnings("serial")
public class MyUserDetails implements UserDetails
{
	private String name;
	private String password;
	private List<GrantedAuthority> authorities;

	public MyUserDetails(UserEntity user) 
	{
		name = user.getEmail();
		password = user.getPassword();
		authorities = Arrays.stream(user.getRole().split(",")).map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}

	public MyUserDetails() {
		super();
	}

	public MyUserDetails(String name, String password, List<GrantedAuthority> authorities) {
		super();
		this.name = name;
		this.password = password;
		this.authorities = authorities;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthorities(List<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {

		return name;
	}
}
