package com.practice.DesignPattern;

 class BuilderDesignPattern {
	
	private int id;
	private String name;
	private int salary;
	private String company;
	
	public BuilderDesignPattern(Builder builder) {
		this.id = builder.getId();
		this.name = builder.getName();
		this.salary = builder.getSalary();
		this.company = builder.getCompany();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getSalary() {
		return salary;
	}

	public String getCompany() {
		return company;
	}

	public String toString() {
		return "BuilderDesignPattern [id=" + id + ", name=" + name + ", salary=" + salary + ", company=" + company
				+ "]";
	}

}

class Builder{
	private int id;
	private String name;
	private int salary;
	private String company;
	public int getId() {
		return id;
	}
	public Builder setId(int id) {
		this.id = id;
		return this;
	}
	public String getName() {
		return name;
	}
	public Builder setName(String name) {
		this.name = name;
		return this;
	}
	public int getSalary() {
		return salary;
	}
	public Builder setSalary(int salary) {
		this.salary = salary;
		return this;
	}
	public String getCompany() {
		return company;
	}
	public Builder setCompany(String company) {
		this.company = company;
		return this;
	}
	
	public BuilderDesignPattern build()
	{
		return new BuilderDesignPattern(this);
	}
}


public class Driver{
	
	public static void main(String args[])
	{
		BuilderDesignPattern b1 = new Builder().setName("Thejas").setCompany("Rakuteen").setSalary(1900000).build();
		
		System.out.println("id: "+b1.getId() + ",  name: "+b1.getName() + ",  company: "+b1.getCompany() + ",  salary: "+b1.getSalary());
	}

	
}

