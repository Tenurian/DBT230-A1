package edu.neumont.dbt230.a1.group4;

import edu.neumont.dbt230.Employee;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;

public class Employees implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 979685993098037353L;
	private HashMap<Integer, Employee> employees = new HashMap<>();
	private HashMap<String, Integer> LastnameIndex = new HashMap<>();

	public Employees() {
	}
	
	public void start(String path) {
		
		File d = new File(path);
		
		try {
			for (File f : d.listFiles()) {
				
				String[] fname = f.getName().split("\\.");

				System.out.println(f.getName());
				System.out.println(Arrays.toString(fname));
				
				FileInputStream instream = new FileInputStream(f);
				ObjectInputStream reader = new ObjectInputStream(instream);
				Employee e = ((Employee) reader.readObject());				
				
				System.out.println(e.toString());
				
				this.add(e, Integer.parseInt(fname[0]));
	
				reader.close();
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}
	
	public void add(Employee e, int id) {
		employees.put(id, e);
		LastnameIndex.put(e.getLastName(), id);
	}
	
	public int getIdByLastname(String LastName) {
		return LastnameIndex.get(LastName.toUpperCase());
	}

	@Override
	public String toString() {
		return "Employees [employees=" + employees + "]";
	}

}
