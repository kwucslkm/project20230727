package com.icia.ex.dto;

public class ExDTO {
	private String name;
	private int age;
	private String mobile;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "ExDTO [name=" + name + ", age=" + age + ", mobile=" + mobile + "]";
	}

	
		
	
		
	
}
