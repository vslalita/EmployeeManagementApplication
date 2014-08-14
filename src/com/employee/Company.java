package com.employee;

import java.util.ArrayList;

public class Company {
   
	private String companyName;
	private int companyPhone;
    private ArrayList<Employee> emplList=new ArrayList<Employee>();
    
    Company(String companyName,int companyPhone){
    	this.companyName=companyName;
    	this.companyPhone=companyPhone;
    }
    
    public void addEmployee(Employee emp){
    	emplList.add(emp);
    }
    
    public ArrayList<Employee> getEmployees(){
    	return emplList;
    }
}
