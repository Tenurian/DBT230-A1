package edu.neumont.dbt230.a1.group4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import edu.neumont.dbt230.LargeEmployee;

public class LargeEmployeeRetriever {
	
	public void q14_printLargeEmployees(String path) {
		File d = new File(path);
		for (File f : d.listFiles()) {
			try {

				FileInputStream instream = new FileInputStream(f);
				ObjectInputStream reader = new ObjectInputStream(instream);
				LargeEmployee e = ((LargeEmployee) reader.readObject());

				System.out.println(e.toString());

				reader.close();

			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
