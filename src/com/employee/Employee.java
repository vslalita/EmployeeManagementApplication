package com.employee;

import java.util.ArrayList;

public class Employee {
   String name;
   int id;
   String email;
   double hourlySalary;
   int hoursWorked;
   double benefits;
   ArrayList<Integer> projectDurationList=new ArrayList<Integer>();
   SalaryStrategy ss;
   
   public Employee( String name,
   int id,
   String email,
   double hourlySalary,
   int hoursWorked,
   double benefits,
   ArrayList<Integer> projectDurationList){
	   
	   this.name=name;
	   this.id=id;
	   this.email=email;
	   this.hourlySalary=hourlySalary;
	   this.hoursWorked=hoursWorked;
	   this.benefits=benefits;
	   this.projectDurationList=projectDurationList;
	   
   }
   
   public void setSalaryStrategy(SalaryStrategy ss){
	   this.ss=ss;
   }
   
   public void addProjectDurationList(int duration){
	   projectDurationList.add(duration);
   }
   
   public double calculateSalary(){
	   return ss.calculate(this);
   }
	
}
