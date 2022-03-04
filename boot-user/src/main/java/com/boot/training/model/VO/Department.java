package com.boot.training.model.VO;

public class Department {
	private Long id;
	private String departmentName;
	private String departmentCode;
	
	
	public Department() {
		super();
	}


	public Department(Long id, String departmentName, String departmentCode) {
		super();
		this.id = id;
		this.departmentName = departmentName;
		this.departmentCode = departmentCode;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDepartmentName() {
		return departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


	public String getDepartmentCode() {
		return departmentCode;
	}


	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

}
