package fr.diginamic.jdbc;

import fr.diginamic.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TestSelect {

    private static final String DB_URL;
    private static final String DB_USER;
    private static final String DB_PWD;
    static {
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        DB_URL = bundle.getString("db.url");
        DB_USER = bundle.getString("db.user");
        DB_PWD = bundle.getString("db.password");
    }



    public static ArrayList<Fournisseur> testSelect(){
    Connection connection = null;

                      try {
                          connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
                          ArrayList<Fournisseur> fournisseurs = new ArrayList<>();
                          Statement st = connection.createStatement();
                          ResultSet curseur = st.executeQuery("SELECT ID, NOM FROM FOURNISSEUR");

                          while (curseur.next()) {
                                 Integer id = curseur.getInt("ID");
                                 String nom = curseur.getString("NOM");

                                 Fournisseur fournisseur = new Fournisseur(id, nom);
                                 fournisseurs.add(fournisseur);
                              System.out.println(fournisseur.getId() + " " + fournisseur.getNom());
                         }

                   curseur.close();
                   st.close();
                   return fournisseurs;
               } catch (SQLException e) {
                   throw new RuntimeException("Attention : " + e.getMessage());
               } finally {
                   if (connection != null) {
                       try {
                           connection.close();
                       } catch (SQLException e) {
                           System.out.println("Attention : " + e.getMessage());
                       }
                   }
               }

    }

}
