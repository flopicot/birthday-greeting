package fr.artisandeveloppeur;

import fr.artisandeveloppeur.parser.EmployeeFileParser;

import java.io.IOException;
import java.nio.file.Paths;

public class Main {
    
    public static final String FILE_NAME = "./employees.txt";
    
    /**
     * Main, que fait votre méthode main ?
     *  Récupère les empolyés et traite leur anniversaire
     */
    public static void main(String[] args) {
        try {
            System.out.println("Batch job started.");
            EmployeeFileParser employeeFileParser = new EmployeeFileParser(Paths.get(".",FILE_NAME));
            BirthdayMailHelper.sendBirthdayMail(employeeFileParser.retrieveData());
            System.out.println("Batch job done.");
        } catch (IOException ex) {
            System.out.println("Unable to open file '" + FILE_NAME + "'");
        }
    }
    
}
