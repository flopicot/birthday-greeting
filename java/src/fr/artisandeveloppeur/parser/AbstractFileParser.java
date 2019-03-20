package fr.artisandeveloppeur.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;

public abstract class AbstractFileParser<T> implements FileParser<T> {
	
	private Path dataFile;
	
	AbstractFileParser(Path dataFile) {
		this.dataFile = dataFile;
	}
	
	/**
	 * Open file, call retrieveEmployeeFromLine() to retrieve object from each line and return the object list
	 */
	public Collection<T> retrieveData() throws IOException {
		Collection<T> objectList = new ArrayList<>();
		System.out.println("Read file starded.");
		try (FileReader fileReader =  new FileReader(dataFile.toFile());
				 BufferedReader bufferedReader = new BufferedReader(fileReader)) {
			String line;
			boolean firstLine = true;
			while((line = bufferedReader.readLine()) != null) {
				if (!firstLine) {
					try {
						objectList.add(retrieveEmployeeFromLine(line));
					} catch (ParseException | IllegalArgumentException e) {
						System.out.println(e.getMessage()+" : Unable to read object from line: "+line);
					}
				} else {
					firstLine = false;
				}
			}
		}
		System.out.println("Read file done.");
		return objectList;
	}
	
	abstract T retrieveEmployeeFromLine(String line) throws ParseException, IllegalArgumentException;
}
