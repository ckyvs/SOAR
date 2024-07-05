package com.capstone.soar.domain.projections.employee_admin;

public class AdminEmployeeView {
	private Long id;

	private String email;

	private String name;

	private String password;
	
	private String role;

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return " [email=" + email + ", name=" + name + ", role=" + role + "]";
	}
	
	
}
