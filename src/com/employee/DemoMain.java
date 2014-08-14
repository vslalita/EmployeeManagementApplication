package com.employee;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.*;

//import statements
//Check if window closes automatically. Otherwise add suitable code
@SuppressWarnings("serial")
class EmployeeFrame extends JFrame {

	String salary;
	JLabel Calculated = new JLabel("Calculated Salary Based on Benefits");
	JPanel listPane = new JPanel();
	JTextField ename;
	JTextField eemail;
	JTextField ehrlySalary;
	JTextField ehrsWorked;
	JTextField ebenefits;
	JLabel Calculated2 = new JLabel("Calculated Salary based on ProjectList Duration");
	JTextField eProjectDuration;
	JLabel eProjectDurationLabel = new JLabel("Add ProjectDuration");
	ArrayList<JTextField> textfields=new ArrayList<JTextField>();

	public void displayForm(){
		listPane.setLayout(new BoxLayout(listPane, BoxLayout.PAGE_AXIS));


		this.setSize(100, 100);
		JLabel enameLabel = new JLabel("Name:"); 
		ename=new JTextField(10); 
		JLabel ehrlySalaryLabel = new JLabel("Hourly Salary:");
		ehrlySalary=new JTextField(10);
		JLabel eemailLabel = new JLabel("E-Mail:");
		eemail=new JTextField(20);
		JLabel ehrsWorkedLabel = new JLabel("Hours Worked:");
		ehrsWorked=new JTextField(10); 
		JLabel ebenefitsLabel = new JLabel("Benefits:");
		ebenefits=new JTextField(10); 
		eProjectDuration=new JTextField(10);

		JButton but=new JButton(); but.setText("Calculate Salary"); 
		JButton addButton=new JButton(); but.setText("AddProjectDuration"); 

		listPane.add(enameLabel);
		listPane.add(ename);
		listPane.add(eemailLabel);
		listPane.add(eemail);
		listPane.add(ehrlySalaryLabel);
		listPane.add(ehrlySalary);
		listPane.add(ehrsWorkedLabel);
		listPane.add(ehrsWorked);
		listPane.add(ebenefitsLabel);
		listPane.add(ebenefits); 
		listPane.add(eProjectDurationLabel);
		listPane.add(eProjectDuration);
		listPane.add(addButton);
		listPane.add(but);
		listPane.add(Calculated);
		listPane.add(Calculated2);


		addButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JTextField eProjectDuration=new JTextField(10);
				listPane.add(eProjectDuration);
			}

		});	

		but.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
//				Employee emp=new Employee(ename.getText(),Integer.valueOf(ehrlySalary.getText()),eemail.getText(),Integer.valueOf(ehrlySalary.getText()),Integer.valueOf(ehrsWorked.getText()),Integer.valueOf(ebenefits.getText()));
//				emp.setSalaryStrategy(new HourlyBenefitSalary());
//				salary=String.valueOf(emp.calculateSalary());
//				Calculated.setText("Calculated Salary based on Benefits: "+salary);
//				emp.setSalaryStrategy(new HourlyProjectSalaryStrategy());
//				salary=String.valueOf(emp.calculateSalary());
//				Calculated2.setText("Calculated Salary based on Project Duration: "+salary);
			}
		});

		add(listPane);
		setLayout(new FlowLayout());
		setSize(400,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}



public class DemoMain{
	
	public Employee createEmployee(){
		System.out.println("Enter Name:");
		Scanner sc = new Scanner(System.in);
		String name= sc.nextLine();
		System.out.println("Enter Email:");
		String email=sc.nextLine();
		System.out.println("Enter Hours:");
		int hours=sc.nextInt();
		System.out.println("Enter hourly Salary:");
		double hrlySalary=sc.nextDouble();
		System.out.println("Enter Benefits:");
		double benefits=sc.nextDouble();
		System.out.println("Enter Project Duration:");
		ArrayList<Integer> projDurationList=new ArrayList<Integer>();
		projDurationList.add(sc.nextInt());
		sc.nextLine();
		System.out.println("Add another Project Duration:");
		while(sc.nextLine().equals("y")){
			System.out.println("Enter Project Duration:");
			projDurationList.add(sc.nextInt());
			System.out.println("Add another Project Duration:");
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
			while(emplListIterator.hasNext()){
				Employee emp=emplListIterator.next();
				System.out.println(emp.name);
			}
		}
		
	}
	
	public static void main(String args[]){
		new DemoMain().createCompany();
		
	}
}
