package com.apdca.service;

import java.util.List;

import com.apdca.dto.OnlineUsersDto;
import com.apdca.entity.OnlineUsers;

public interface UserService {
	OnlineUsers saveUser(OnlineUsersDto userDto);
	    OnlineUsers findUserByreqloginnm(String reqloginnm);
	    List<OnlineUsersDto> findAllUsers();
}
