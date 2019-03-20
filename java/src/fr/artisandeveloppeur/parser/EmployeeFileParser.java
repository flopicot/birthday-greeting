package fr.artisandeveloppeur.parser;

import fr.artisandeveloppeur.bean.Employee;

import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmployeeFileParser extends AbstractFileParser<Employee> {
	
	private static final String PARSE_DATE_FORMAT = "dd/MM/yyyy";
	
	public EmployeeFileParser(Path dataFile) {
		super(dataFile);
	}
	
	/**
	 * Retrieve employee from data line
	 */
	Employee retrieveEmployeeFromLine(String line) throws ParseException, IllegalArgumentException {
		String[] tokens = line.split(",");
		for (int i = 0; i < tokens.length; i++) {
			tokens[i] = tokens[i].trim();
		}
		if (tokens.length == 4 ) {
			SimpleDateFormat dateFormat = new SimpleDateFormat(PARSE_DATE_FORMAT);
			Date birthday = dateFormat.parse(tokens[2]);
			Employee employee = new Employee(tokens[0], tokens[1], birthday, tokens[3]);
			return employee;
		} else {
			throw new IllegalArgumentException("Invalid file format");
		}
	}
}
