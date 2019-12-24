package com.example.demo.entity;

//创建实体对象
public class Employee {
    private int employees_id;
    private String employees_name;
    private String job;
	private String password;

    public int getEmployees_id() {
        return employees_id;
    }

    public void setEmployees_id(int employees_id) {
        this.employees_id = employees_id;
    }

    public String getEmployees_name() {
        return employees_name;
    }

    public void setEmployees_name(String employees_name) {
        this.employees_name = employees_name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
