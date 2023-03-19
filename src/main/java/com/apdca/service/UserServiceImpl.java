package com.apdca.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.apdca.dto.OnlineUsersDto;
import com.apdca.entity.OnlineUsers;
import com.apdca.entity.Roles;
import com.apdca.repository.OnlineUsersRepository;
import com.apdca.repository.RolesRepository;

import jakarta.transaction.Transactional;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private OnlineUsersRepository onlineUserRepository;
	@Autowired
	private RolesRepository rolesRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

//	public UserServiceImpl(OnlineUsersRepository onlineUserRepository, RolesRepository rolesRepository,
//			PasswordEncoder passwordEncoder) {
//		this.onlineUserRepository = onlineUserRepository;
//		this.rolesRepository = rolesRepository;
//		this.passwordEncoder = passwordEncoder;
//	}

	@Override
	@Transactional
	@Modifying
	public OnlineUsers saveUser(OnlineUsersDto userDto) {
		OnlineUsers onlineUsers=new OnlineUsers();
		try {
		
		onlineUsers.setFirm_nm(userDto.getFirm_nm());
		onlineUsers.setFirm_no(userDto.getFirm_no());
		onlineUsers.setUser_nm(userDto.getUser_nm());
		onlineUsers.setReqloginnm(userDto.getReqloginnm());
		onlineUsers.setUser_pwd(passwordEncoder.encode(userDto.getUser_pwd()));
		onlineUsers.setEmail_id(userDto.getReqloginnm());
		onlineUsers.setMobile_no(userDto.getMobile_no());
		onlineUsers.setAddress(userDto.getAddress());
		onlineUsers.setArea(userDto.getArea());
		onlineUsers.setPincode(userDto.getPincode());
		onlineUsers.setDob(userDto.getDob());
		Roles role = rolesRepository.findByrolename("User");
		System.out.println("arrays"+Arrays.asList(role));
	    onlineUsers.setRoles(Arrays.asList(role));
	    onlineUsers.setRole_id(14);
	    System.out.println("in service implementation");
	    onlineUserRepository.save(onlineUsers);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return onlineUsers;
	}

	
	@Override
	public OnlineUsers findUserByreqloginnm(String reqloginnm) {
		// TODO Auto-generated method stub
		 return onlineUserRepository.findByreqloginnm(reqloginnm);
	}

	@Override
	public List<OnlineUsersDto> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
