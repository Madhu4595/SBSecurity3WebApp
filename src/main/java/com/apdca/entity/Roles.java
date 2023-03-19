package com.apdca.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="fdca_roles")
public class Roles {
	
	 @GeneratedValue(strategy = GenerationType.SEQUENCE)
	 @Id
	private int role_uid;
	private String rolename;
	private String roleid;
	private String rolelevel;
	private String desiglevel;
	private String report_level;
	private String status;
	@ManyToMany(mappedBy="roles")
	private List<OnlineUsers> onlineUsers;
	public int getRole_uid() {
		return role_uid;
	}
	public void setRole_uid(int role_uid) {
		this.role_uid = role_uid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String getRoleid() {
		return roleid;
	}
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	public String getRolelevel() {
		return rolelevel;
	}
	public void setRolelevel(String rolelevel) {
		this.rolelevel = rolelevel;
	}
	public String getDesiglevel() {
		return desiglevel;
	}
	public void setDesiglevel(String desiglevel) {
		this.desiglevel = desiglevel;
	}
	public String getReport_level() {
		return report_level;
	}
	public void setReport_level(String report_level) {
		this.report_level = report_level;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<OnlineUsers> getOnlineUsers() {
		return onlineUsers;
	}
	public void setOnlineUsers(List<OnlineUsers> onlineUsers) {
		this.onlineUsers = onlineUsers;
	}

}
