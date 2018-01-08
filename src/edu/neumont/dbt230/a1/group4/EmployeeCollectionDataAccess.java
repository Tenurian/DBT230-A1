package edu.neumont.dbt230.a1.group4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import edu.neumont.dbt230.Employee;

public class EmployeeCollectionDataAccess {

	public HashMap<Integer, Employee> writeEmployeesToHashMap(String directoryName) {

		HashMap<Integer, Employee> allEmployees = new HashMap<>();

		File dir = new File(directoryName);

		for (File f : dir.listFiles()) {
			// System.out.println(f.getName());

			try (FileInputStream in = new FileInputStream(f); ObjectInputStream objectIn = new ObjectInputStream(in);) {

				Employee e = (Employee) objectIn.readObject();

				allEmployees.put(Integer.parseInt(f.getName().substring(0, f.getName().lastIndexOf('.'))), e);

			} catch (IOException | ClassNotFoundException x) {
				System.err.println(x);
			}
		}
		return allEmployees;

	}

	public void saveEmployeesHashMap(HashMap<Integer, Employee> employees, String location) {

		try (FileOutputStream fileOut = new FileOutputStream(location); ObjectOutputStream out = new ObjectOutputStream(fileOut);) {
			out.writeObject(employees);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
