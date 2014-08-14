package com.employee;

import java.util.ArrayList;
import java.util.Collections;

//Algorithm2 for calculating salary
public class HourlyProjectSalaryStrategy implements SalaryStrategy{

	@Override
	public double calculate(Employee e) {
		// TODO Auto-generated method stub
		ArrayList<Integer> projectsDuration=e.projectDurationList;
		Collections.sort(projectsDuration);
		return (e.hourlySalary*e.hoursWorked)+(50*projectsDuration.get(0));
	}
}
