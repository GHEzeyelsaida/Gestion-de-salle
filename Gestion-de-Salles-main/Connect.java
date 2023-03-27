

import java.sql.Connection;
import java.sql.DriverManager;
public class Connect {
    

    // data informations
    String BDD = "centre_formation";
    String url = "jdbc:mysql://localhost:3306/" + BDD;
    String user = "root";
    String passwd = "";
    Connection conn; 
    public Connect() {  
    
     // L'essaie de connexion à la base de donées
     try { // chargement de driver
       Class.forName("com.mysql.jdbc.Driver"); 
       //recuperation de données
        conn = DriverManager.getConnection(url, user, passwd);
       System.out.println("Connecté a database");
   } catch (Exception e){
       e.printStackTrace();
       System.out.println("Error connection");
       System.exit(0);
   }
}
Connection gConnection(){ return conn;}
}