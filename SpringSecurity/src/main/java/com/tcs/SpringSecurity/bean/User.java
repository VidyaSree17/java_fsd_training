package com.tcs.SpringSecurity.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
public class User implements UserDetails{

	@Id
	private String username;
	
	@Column
	private String password;
	
	@Column
	private String details;
	
	private String cpassword;
	
	@Column(name="group_permission")
	private String groupPermission;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		String[] userPermissions=getGroupPermission().split(",");
		List<GrantedAuthority> list=new ArrayList<>();
		Stream.of(userPermissions).forEach(x->{
			list.add(new SimpleGrantedAuthority("ADMIN"));
		});
		
		return list;
	}
	
}
