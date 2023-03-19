package com.apdca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apdca.entity.Roles;

public interface RolesRepository extends JpaRepository<Roles, Integer>{
	Roles findByrolename(String rolename);

}
