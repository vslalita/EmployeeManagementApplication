package com.employee;
//Algorithm1 for calculating salary
public class HourlyBenefitSalary implements SalaryStrategy{

	@Override
	public double calculate(Employee e) {
		// TODO Auto-generated method stub
		return (e.hourlySalary*e.hoursWorked)+e.benefits;
	}
}
