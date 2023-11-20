package fr.diginamic.jdbc.dal.jdbc;


import fr.diginamic.jdbc.dal.FournisseurDAO;
import fr.diginamic.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FournisseurDAOJDBCSecurise implements FournisseurDAO {
    public static final String DB_URL;
    public static final String DB_USER;
    public static final String DB_PWD;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        DB_URL = bundle.getString("db.url");
        DB_USER = bundle.getString("db.user");
        DB_PWD = bundle.getString("db.password");
    }

    private static final String EXTRAIRE_QUERY = "SELECT ID, NOM FROM FOURNISSEUR";
    private Connection connection;

    @Override
    public List<Fournisseur> extraire() throws SQLException {
        List<Fournisseur> fournisseurs = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
             Statement st = connection.createStatement();
             ResultSet curseur = st.executeQuery(EXTRAIRE_QUERY)) {

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
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO FOURNISSEUR (NOM) VALUES (?)")) {

            preparedStatement.setString(1, fournisseur.getNom());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public int update(String ancienNom, String nouveauNom) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE FOURNISSEUR SET NOM=? WHERE NOM=?")) {

            preparedStatement.setString(1, nouveauNom);
            preparedStatement.setString(2, ancienNom);
            return preparedStatement.executeUpdate();
        }
    }

    @Override
    public boolean delete(Fournisseur fournisseur) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM FOURNISSEUR WHERE NOM = ?")) {

            preparedStatement.setString(1, fournisseur.getNom());
            int nombreLignesAffectees = preparedStatement.executeUpdate();
            return nombreLignesAffectees > 0;
        }
    }
}
