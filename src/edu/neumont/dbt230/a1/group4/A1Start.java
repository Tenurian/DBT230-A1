package edu.neumont.dbt230.a1.group4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import edu.neumont.dbt230.Employee;

public class A1Start {
	
	public static final java.util.Scanner scan = new java.util.Scanner(System.in);

	static long lStartTime, lEndTime, output;
	
	public static void main(String[] args) {
		
		//this is just for writing the hashfile... only needs to run once		
		EmployeeTextFileDataAccess text = new EmployeeTextFileDataAccess();
//		
		//question 1
		System.out.println("Question 1:");
		text.q1_printEmployeesText("c:\\temp\\people\\simple\\");
//		//question 2
		System.out.println("Press [Enter] to start Question 2.");
        while(scan.nextLine() == null);
        long lStartTime = System.nanoTime();
		text.q2_printEmployees("c:\\temp\\people\\long\\");
		long lEndTime = System.nanoTime();
        long output = lEndTime - lStartTime;
        System.out.println("Elapsed time in milliseconds: " + output / 1000000);
        System.out.println("Press [ENTER] to start Question 3.");
        while(scan.nextLine() == null);
		//question 3 ** remember to change the path to long serialized!
		//start
        lStartTime = System.nanoTime();
		EmployeesSerializedDataAccess serialized = new EmployeesSerializedDataAccess();
		serialized.q5a_printEmployeesText("c:\\temp\\people\\long serialized\\");
		//end
        lEndTime = System.nanoTime();
		//time elapsed
        output = lEndTime - lStartTime;
        System.out.println("Elapsed time in milliseconds: " + output / 1000000);
		EmployeeCollectionDataAccess collection = new EmployeeCollectionDataAccess();
		HashMap<Integer, Employee> h = collection.writeEmployeesToHashMap("c:\\temp\\people\\simple serialized\\");
		collection.saveEmployeesHashMap(h, "c:\\temp\\people\\empcollection.ser");
		
		System.out.println("Press [Enter] to write the HashFile");
        while(scan.nextLine() == null);
		lStartTime = System.nanoTime();

		File HashFile = new File("c:\\temp\\hashfile.bin");
		Employees hashList = new Employees();
		hashList.start("c:\\temp\\people\\long serialized\\");
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(HashFile));
			oos.writeObject(hashList);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		lEndTime = System.nanoTime();
        output = lEndTime - lStartTime;
        System.out.println("Elapsed time in milliseconds: " + output / 1000000);

		System.out.println("Press [Enter] to Read the HashFile");
        while(scan.nextLine() == null);
		
		try {
			lStartTime = System.nanoTime();
			File file = new File("c:\\temp\\hashfile.bin");
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			Employees e = (Employees) ois.readObject();
			
			System.out.println(e.toString());
			
			lEndTime = System.nanoTime();
	        output = lEndTime - lStartTime;
	        System.out.println("Elapsed time in milliseconds: " + output / 1000000);
	        
	        System.out.println("Laurie Martin's ID:\t"+e.getIdByLastname("Martin"));
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Press [Enter] to read the large serialized employees");
        while(scan.nextLine() == null);
		
		lStartTime = System.nanoTime();
		
		LargeEmployeeRetriever LER = new LargeEmployeeRetriever();
		
		LER.q14_printLargeEmployees("c:\\temp\\people\\large serialized\\");
		lEndTime = System.nanoTime();
        output = lEndTime - lStartTime;
        System.out.println("Elapsed time in milliseconds: " + output / 1000000);

		System.out.println("Done.");
	}

}
