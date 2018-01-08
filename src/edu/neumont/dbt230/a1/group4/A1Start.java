package edu.neumont.dbt230.a1.group4;

import java.util.HashMap;

import edu.neumont.dbt230.Employee;

public class A1Start {

	public static void main(String[] args) {
		
		System.out.println("Starting....");
		
		EmployeeTextFileDataAccess text = new EmployeeTextFileDataAccess();
//		
		//question 1
		System.out.println("Question 1:");
		text.q1_printEmployeesText("c:\\temp\\people\\simple\\");
//		
//		//question 2
		System.out.println();
		System.out.println("Question 2");
		text.q2_printEmployees("c:\\temp\\people\\simple\\");
		
		//question 3 ** remember to change the path to long serialized!
//		EmployeesSerializedDataAccess serialized = new EmployeesSerializedDataAccess();
//		serialized.q5a_printEmployeesText("c:\\temp\\people\\simple serialized\\");
		
//		EmployeeCollectionDataAccess collection = new EmployeeCollectionDataAccess();
//		HashMap<Integer, Employee> h = collection.writeEmployeesToHashMap("c:\\temp\\people\\simple serialized\\");
//		collection.saveEmployeesHashMap(h, "c:\\temp\\people\\empcollection.ser");
		
		System.out.println("Done.");
	}

}
