package fr.artisandeveloppeur;

import fr.artisandeveloppeur.bean.Employee;

import java.util.Collection;

/**
 * Regroupe les méthodes utilitaires des mails d'anniversaire
 */
public class BirthdayMailUtils {
	
	public static final String JOYEUX_ANNIVERSAIRE_TITLE = "Joyeux Anniversaire !";
	
	/**
	 * Traite une liste d'employé et envoi un email de bon anniversaire si besoin
	 */
	public static void sendBirthdayMail(Collection<Employee> employees) {
		for (Employee employee : employees) {
			if (employee.isMybirtday()) {
				sendEmail(employee);
			}
		}
	}
	
	/**
	 * BirthdayMailHelper, que fait votre sendmail() ?
	 * 	Envoie un mail de bon anniversaire à l'employé
	 */
	private static void sendEmail(Employee employee) {
			String body = "Bonjour " + employee.getFirstname() + ",\nJoyeux Anniversaire !\nA bientôt,";
			System.out.println("Sending email to : " + employee.getMail());
			System.out.println("Title: " + JOYEUX_ANNIVERSAIRE_TITLE);
			System.out.println("Body: Body\n" + body);
			System.out.println("-------------------------");
	}
}
