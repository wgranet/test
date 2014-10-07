import java.sql.*;


public class Model {
	static Connection connexion = null; 
	static Statement st;
	
	public static void connect(){

		try {
			Class.forName("com.mysql.jdbc.Driver") ;
			connexion = DriverManager.getConnection("jdbc:mysql://localhost/Gens", "root", "");
			System.out.println("Connexion à la base établie \n");
			st = connexion.createStatement();
		}
		catch(ClassNotFoundException erreur) {
			System.out.println("Driver non chargé !" + erreur);
		}
		catch(SQLException erreur) {
			System.out.println("La connexion a échouée !" + erreur);
		}
	}
	
	public static void insert(Personne unPerso){
		
		try {
		String nom = unPerso.getNom();
		String prenom = unPerso.getPrenom();
		st.executeUpdate("INSERT INTO contact VALUES ('"+ nom +"', '"+ prenom +"')");
		}
		catch (SQLException e) {
			System.out.println("Erreur lors de l'insertion \n");
		}
	}
	public static Object[][] select(){
		
		String nom;
		String prenom;
		int i = 0;
		Object[][] monTab = new  Object[10][10]; 
		
		try {
			// Pour accéder à chacune des lignes du résultat de la requête :
			ResultSet rs = st.executeQuery("SELECT * FROM contact ORDER BY NOM");
			while (rs.next()) {
				nom = rs.getString("nom");
				prenom = rs.getString("prenom");
				monTab[i][0] = nom;
				monTab[i][1] = prenom;
				
				i++;
			}
			return monTab;
		}
		catch (SQLException e) {
			System.out.println("Erreur lors de la sélection \n");
		}
		return monTab;
	}
	
	public static void disconnect(){
		try{
		connexion.close(); // Fermeture de la connexion
		}
		catch (SQLException erreur){
			System.out.println("Erreur fermeture BDD \n");
		}
	}
}
