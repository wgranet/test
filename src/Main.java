import java.util.Scanner;


public class Main { // Controleur

	public static void main(String[] args){
		
		Model.connect();
		
		/*Scanner sc = new Scanner(System.in);
		String nom;
		String prenom;
		System.out.println("Entrez un nom");
		nom = sc.nextLine();
		System.out.println("Entrez un prenom");
		prenom = sc.nextLine();
		Personne unPerso = new Personne(nom, prenom);
		sc.close();
		
		
		Model.insert(unPerso);*/
		Vue uneVue = new Vue(Model.select()); // Vue = la Fenetre
		uneVue.setVisible(true);	
		Model.disconnect();
	}
}
