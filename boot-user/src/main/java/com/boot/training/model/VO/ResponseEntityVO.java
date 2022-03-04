package com.boot.training.model.VO;

import com.boot.training.model.RestUser;

public class ResponseEntityVO {

	private RestUser user;
	private Department department;
	
	public ResponseEntityVO() {
		super();
	}
	public ResponseEntityVO(RestUser user, Department department) {
		super();
		this.user = user;
		this.department = department;
	}
	public RestUser getUser() {
		return user;
	}
	public void setUser(RestUser user) {
		this.user = user;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
}
