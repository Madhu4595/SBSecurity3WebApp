package com.apdca.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.apdca.entity.OnlineUsers;
import com.apdca.entity.Roles;
import com.apdca.repository.OnlineUsersRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	 private OnlineUsersRepository onlineuserRepository;

	    public CustomUserDetailsService(OnlineUsersRepository onlineuserRepository) {
	        this.onlineuserRepository = onlineuserRepository;
	    }
	@Override
	public UserDetails loadUserByUsername(String reqloginnm) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		OnlineUsers onlineUser=onlineuserRepository.findByreqloginnm(reqloginnm);
		 if (onlineUser != null) {
	            return new org.springframework.security.core.userdetails.User(onlineUser.getReqloginnm(),
	            		onlineUser.getUser_pwd(),
	                    mapRolesToAuthorities(onlineUser.getRoles()));
	        }else{
	            throw new UsernameNotFoundException("Invalid username or password.");
	        }
		
	}
	private Collection < ? extends GrantedAuthority> mapRolesToAuthorities(List<Roles> roles) {
		
		Collection < ? extends GrantedAuthority> mapRoles = roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRolename()))
                
                .collect(Collectors.toList());
        return mapRoles;
	}

}
