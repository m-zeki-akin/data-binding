package com.mavendemo.databinding;

import java.io.File;
import java.io.FileNotFoundException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {

		try {

			// Create object mapper
			ObjectMapper mapper = new ObjectMapper();

			// Read json file and convert to POJO
			Student student = mapper.readValue(new File("src/main/resources/data/student-sample.json"), Student.class);

			System.out.println("First name: " + student.getFirstName());
			System.out.println("Last name: " + student.getLastName());
			System.out.println("Active Status: " + student.isActive());
			
			System.out.println("Country: " + student.getAddress().getCountry());
			System.out.println("City: " + student.getAddress().getCity());
			System.out.println("District: " + student.getAddress().getDistrict());
			System.out.println("Street: " + student.getAddress().getStreet());
			
			System.out.println("Languages: ");
			for (String tmpstr : student.getLanguages()) {
				System.out.println("\t" + tmpstr);
			}

		} catch (FileNotFoundException e) {
			System.out.println(
					"File: " + new File("src/main/resources/data/student-sample.json").getAbsolutePath() + "not found");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
