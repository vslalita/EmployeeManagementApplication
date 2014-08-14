package com.employee;

import java.util.ArrayList;
import java.util.Iterator;

public class CompanyGUI implements CompanyGUIAggregate{
   ArrayList<Employee> emplList;
   
	CompanyGUI(ArrayList<Employee> emplList){
		this.emplList=emplList;
	}
	
	public Iterator<Employee> getIteratorInstance(){
		return new IteratorImpl();
	}
	
	//Class for implementing Iterator
	public class IteratorImpl implements Iterator<Employee>{
		int pointer=0;
	    
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			if((pointer)>(emplList.size()-1)){
				return false;
			}
			return true;
		}

		@Override
		public Employee next() {
			// TODO Auto-generated method stub
			if(hasNext()){
				System.out.println(emplList.size());
				Employee emp=emplList.get(pointer);
				pointer=pointer+1;
				return emp;
			}
			return null;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			emplList.remove(pointer);
			pointer=pointer-1;
		}

	}
}
