package edu.neumont.dbt230.a1.group4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Scanner;

import edu.neumont.dbt230.Employee;

public class EmployeeTextFileDataAccess {

	public void q1_printEmployeesText(String path) {

		Scanner in;
		File d = new File(path);
		for (File f : d.listFiles()) {
			try {
				in = new Scanner(f);
				System.out.println(in.nextLine());
				in.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void q2_printEmployees(String path) {

		File dir = new File(path);

		for (File f : dir.listFiles()) {
			// System.out.println(f.getName());

			Charset charset = Charset.forName("US-ASCII");

			try (BufferedReader reader = Files.newBufferedReader(f.toPath(), charset)) {
				String line = null;
				while ((line = reader.readLine()) != null) {
					// System.out.println(line);
					String[] lineMembers = line.split(",");
					// System.out.println(lineMembers.length);

					Employee e = new Employee(Integer.parseInt(lineMembers[0].trim()), lineMembers[1], lineMembers[2], Integer.parseInt(lineMembers[3].trim()));
					System.out.println(e.toString());
				}
			} catch (IOException x) {
				System.err.println(x);
			}
		}

	}
}
