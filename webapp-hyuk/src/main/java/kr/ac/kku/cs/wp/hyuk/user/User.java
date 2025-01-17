package kr.ac.kku.cs.wp.hyuk.user;

import java.util.List;

public class User {

	private String photoSRC = null;
	private String name = null;
	private String email = null;
	private List<String> roles = null;
	private String id = null;
	private String password = null;
	private String status = null;
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhotoSRC() {
		return photoSRC;
	}

	public void setPhotoSRC(String photoSRC) {
		this.photoSRC = photoSRC;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
