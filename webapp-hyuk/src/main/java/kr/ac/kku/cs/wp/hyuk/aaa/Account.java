package kr.ac.kku.cs.wp.hyuk.aaa;

import java.io.Serializable;
import java.util.List;

public class Account implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;
	private String role;
	private List<String> roles;
	private String name;
	private String email;
	public void setId(String id2) {
		// TODO Auto-generated method stub
		
	}
	public void setName(String name2) {
		// TODO Auto-generated method stub
		
	}
	public void setRoles(List<String> roles2) {
		// TODO Auto-generated method stub
		
	}
	public void setEmail(String email2) {
		// TODO Auto-generated method stub
		
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getId() {
		return id;
	}
	public List<String> getRoles() {
		return roles;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}


	
}