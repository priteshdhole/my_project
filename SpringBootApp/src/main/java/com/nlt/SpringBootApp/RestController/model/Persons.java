package com.nlt.SpringBootApp.RestController.model;


public class Persons 
{
	private int id;
	private String name;
	private int age;
	private long phone;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	
	public Persons(int id, String name, int age, long phone) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.phone = phone;
	}
	public Persons()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString()
	{
		return "Persons [id=" + id + ", name=" + name + ", age=" + age + ", phone=" + phone + "]";
	}
	
	
	
	
}
