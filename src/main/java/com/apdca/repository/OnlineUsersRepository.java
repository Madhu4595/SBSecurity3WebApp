package com.apdca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apdca.entity.OnlineUsers;

@Repository
public interface OnlineUsersRepository extends JpaRepository<OnlineUsers, Long>{
	
	OnlineUsers findByreqloginnm(String reqloginnm);

}
