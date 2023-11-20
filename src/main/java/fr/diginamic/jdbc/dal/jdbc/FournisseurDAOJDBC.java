package fr.diginamic.jdbc.dal.jdbc;

import fr.diginamic.jdbc.dal.FournisseurDAO;
import fr.diginamic.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class FournisseurDAOJDBC implements FournisseurDAO {
    public static final String DB_URL;
    public static final String DB_USER;
    public static final String DB_PWD;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        DB_URL = bundle.getString("db.url");
        DB_USER = bundle.getString("db.user");
        DB_PWD = bundle.getString("db.password");
    }

    private static final String EXTRAIRE_QUERY = "SELECT ID,NOM FROM FOURNISSEUR";

    @Override
    public List<Fournisseur> extraire() throws SQLException {

        List<Fournisseur> fournisseurs = new ArrayList<>();


        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
             Statement st = connection.createStatement();
             ResultSet curseur = st.executeQuery("SELECT ID, NOM FROM FOURNISSEUR")) {

            while (curseur.next()) {
                int id = curseur.getInt("ID");
                String nom = curseur.getString("NOM");
                Fournisseur fournisseur = new Fournisseur(id, nom);
                fournisseurs.add(fournisseur);
                System.out.println(fournisseur.getId() + " " + fournisseur.getNom());
            }
        }

        return fournisseurs;

    }

    @Override
    public void insert(Fournisseur fournisseur) throws SQLException {

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
             Statement st = connection.createStatement()) {
            String nom = fournisseur.getNom();
            st.executeUpdate("INSERT INTO FOURNISSEUR (NOM) VALUES ('" + nom + "')");

        }
    }

    @Override
    public int update(String ancienNom, String nouveauNom) throws SQLException {

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
             Statement st = connection.createStatement()) {

            int nb = st.executeUpdate("UPDATE FOURNISSEUR SET NOM='" + nouveauNom + "' WHERE NOM='" + ancienNom + "'");


            System.out.println("Nombre d'éléments modifiés : " + nb);


        }
        return 0;
    }

    @Override
    public boolean delete(Fournisseur fournisseur) throws SQLException {

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
             Statement st = connection.createStatement()) {
            String nom = fournisseur.getNom();
            int up = st.executeUpdate("DELETE FROM FOURNISSEUR WHERE nom='" + nom + "'");
            System.out.println("Nombre d'éléments supprimés : " + up);


        }
        return false;

    }
}