package edu.neumont.dbt230.a1.group4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import edu.neumont.dbt230.Employee;

public class EmployeesSerializedDataAccess {

	public void q5a_printEmployeesText(String path) {

		File d = new File(path);
		for (File f : d.listFiles()) {
			try {

				FileInputStream instream = new FileInputStream(f);
				ObjectInputStream reader = new ObjectInputStream(instream);
				Employee e = ((Employee) reader.readObject());

				System.out.println(e.toString());

				reader.close();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
