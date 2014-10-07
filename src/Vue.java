import javax.swing.*;

public class Vue extends JFrame{

	public Vue(Object[][] monTab){
		this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setTitle("Base de données");
	    this.setSize(500, 320);
	    
	    //Les titres des colonnes
		String  title[] = {"Nom", "Prenom"};
		JTable tableau = new JTable(monTab, title);
		
		//Nous ajoutons notre tableau à notre contentPane dans un scroll
		//Sinon les titres des colonnes ne s'afficheront pas !
	    this.getContentPane().add(new JScrollPane(tableau));
	}
}
