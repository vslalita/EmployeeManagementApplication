package com.employee;

import java.util.*;

public class DemoMain{
	
	public Employee createEmployee(){
		System.out.println("Enter Employee Name:");
		Scanner sc = new Scanner(System.in);
		String name= sc.nextLine();
		System.out.println("Enter Employee Email:");
		String email=sc.nextLine();
		System.out.println("Enter Employee Hours:");
		int hours=sc.nextInt();
		System.out.println("Enter Employee hourly Salary:");
		double hrlySalary=sc.nextDouble();
		System.out.println("Enter Employee Benefits:");
		double benefits=sc.nextDouble();
		System.out.println("Enter Employee Project Duration:");
		ArrayList<Integer> projDurationList=new ArrayList<Integer>();
		projDurationList.add(sc.nextInt());
		sc.nextLine();
		System.out.println("Add another Project Duration:");
		while(sc.nextLine().equals("y")){
			System.out.println("Enter Project Duration:");
			projDurationList.add(sc.nextInt());
			System.out.println("Add another Project Duration?(y/n)");
			sc.nextLine();
		}
		
		Employee emp=new Employee(name,2,email,hrlySalary,hours,benefits,projDurationList);
		//projDurationList.add(sc.nextInt());
		//new EmployeeFrame().displayForm();
		
		emp.setSalaryStrategy(new HourlyBenefitSalary());
		double salary=emp.calculateSalary();
		System.out.println("Calculated Salary based on Benefits: "+salary);
		emp.setSalaryStrategy(new HourlyProjectSalaryStrategy());
		salary=emp.calculateSalary();
		System.out.println("Calculated Salary based on Project Duration: "+salary);
		return emp;
	}
	
	public void createCompany(){
		System.out.println("Enter Company Name:");
		Scanner sc = new Scanner(System.in);
		String companyName=sc.nextLine();
		System.out.println("Enter Phone:");
		int companyPhone=sc.nextInt();
		Company company=new Company(companyName,companyPhone);
		System.out.println("Add Employee?(y/n)");
		sc.nextLine();
		while(sc.nextLine().equals("y")){
			company.addEmployee(createEmployee());
			System.out.println("Add another Employee?(y/n)");
			
		}
		
		System.out.println("View Employee Names?(y/n)");
		
		if(sc.nextLine().equals("y")){
			CompanyGUI compGUI=new CompanyGUI(company.getEmployees());
			Iterator<Employee> emplListIterator=compGUI.getIteratorInstance();
			System.out.println("Printing from Demo Main");
			while(emplListIterator.hasNext()){
				Employee emp=emplListIterator.next();
				System.out.println("Employee:"+emp.getName());
			}
			System.out.println("Printing from CompanyGUI");
			compGUI.displayEmployessDetails();
		}
		
	}
	
	public static void main(String args[]){
		new DemoMain().createCompany();
		
	}
}
