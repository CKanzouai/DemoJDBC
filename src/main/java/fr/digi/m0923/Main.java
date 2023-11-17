package fr.digi.m0923;

import fr.diginamic.jdbc.TestDelete;
import fr.diginamic.jdbc.TestInsertion;
import fr.diginamic.jdbc.TestSelect;
import fr.diginamic.jdbc.TestUpdate;
import fr.diginamic.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Main {

    /**
     *     private static final String DB_URL;
     *     private static final String DB_USER;
     *     private static final String DB_PWD;
     *
     *     static {
     *         ResourceBundle bundle = ResourceBundle.getBundle("db");
     *         DB_URL = bundle.getString("db.url");
     *         DB_USER = bundle.getString("db.user");
     *         DB_PWD = bundle.getString("db.password");
     *     }               Connection connection = null;
     *     try {
     *             connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
     *             System.out.println("Connexion à la base de données réussie!");
     *             System.out.println(connection);
     *             } catch (SQLException e) {
     *             throw new RuntimeException("Attention : " + e.getMessage());
     *         } finally {
     *             if (connection != null) {
     *                 try {
     *                     connection.close();
     *                 } catch (SQLException e) {
     *                     System.out.println("Attention : " + e.getMessage());
     *                 }
     *             }
     *         }
     */

    public static void main(String[] args) {


        System.out.println("Exercice 1 - TestInsertion");
        TestInsertion.testInsertion();
        System.out.println();

        System.out.println("Exercice 2 - TestUpdate");
        TestUpdate.testUpdate();
        System.out.println();

        System.out.println("Exercice 3 - TestDelete");
        TestDelete.testDelete();
        System.out.println();

        System.out.println("Exercice 4 - TestSelect");
        ArrayList<Fournisseur> fournisseurs = TestSelect.testSelect();
        for (Fournisseur fournisseur : fournisseurs) {
            System.out.println("ID: " + fournisseur.getId() + ", Nom: " + fournisseur.getNom());
        }




    }

    /**
     *  private static void creation() {
     *         Connection connection = null;
     *
     *         try {
     *             connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
     *
     *
     *             Statement st = connection.createStatement();
     *             int nb = st.executeUpdate("INSERT INTO FOURNISSEUR (NOM) VALUES ('DIGI')");
     *             System.out.println("Nombre d'éléments insérés : " + nb);
     *
     *             st.close();
     *         } catch (SQLException e) {
     *             throw new RuntimeException("Attention : " + e.getMessage());
     *         } finally {
     *             if (connection != null) {
     *                 try {
     *                     connection.close();
     *                 } catch (SQLException e) {
     *                     System.out.println("Attention : " + e.getMessage());
     *                 }
     *             }
     *         }
     *     }
     *
     *     private static void lecture() {
     *         Connection connection = null;
     *
     *         try {
     *             connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
     *
     *
     *             Statement st = connection.createStatement();
     *             ResultSet curseur = st.executeQuery("SELECT ID, NOM FROM FOURNISSEUR");
     *
     *             while (curseur.next()) {
     *                 Integer id = curseur.getInt("ID");
     *                 String nom = curseur.getString("NOM");
     *                 System.out.println(id + " " + nom);
     *             }
     *
     *             curseur.close();
     *             st.close();
     *         } catch (SQLException e) {
     *             throw new RuntimeException("Attention : " + e.getMessage());
     *         } finally {
     *             if (connection != null) {
     *                 try {
     *                     connection.close();
     *                 } catch (SQLException e) {
     *                     System.out.println("Attention : " + e.getMessage());
     *                 }
     *             }
     *         }
     *     }
     *     private static void miseAjour(){
     *         Connection connection = null;
     *         try {
     *             connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
     *
     *             Statement st = connection.createStatement();
     *             int up = st.executeUpdate("UPDATE FOURNISSEUR SET NOM='Intel' WHERE ID=1");
     *
     *             System.out.println("Nombre d'éléments modifiés : " + up);
     *
     *             st.close();
     *         } catch (SQLException e) {
     *             throw new RuntimeException("Attention : " + e.getMessage());
     *         } finally {
     *             if (connection != null) {
     *                 try {
     *                     connection.close();
     *                 } catch (SQLException e) {
     *                     System.out.println("Attention : " + e.getMessage());
     *                 }
     *             }
     *         }
     *
     *
     *     }
     *     private static void supprimer(){
     *         Connection connection = null;
     *         try {
     *             connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
     *
     *             Statement st = connection.createStatement();
     *             int up = st.executeUpdate("DELETE FROM FOURNISSEUR WHERE  ID=1");
     *
     *             System.out.println("Nombre d'éléments supprimés : " + up);
     *
     *             st.close();
     *         } catch (SQLException e) {
     *             throw new RuntimeException("Attention : " + e.getMessage());
     *         } finally {
     *             if (connection != null) {
     *                 try {
     *                     connection.close();
     *                 } catch (SQLException e) {
     *                     System.out.println("Attention : " + e.getMessage());
     *                 }
     *             }
     *         }
     *
     *
     *     }
     */



}
