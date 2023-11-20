package fr.diginamic.jdbc;

import fr.diginamic.jdbc.dal.FournisseurDAO;
import fr.diginamic.jdbc.dal.jdbc.FournisseurDAOJDBCSecurise;
import fr.diginamic.jdbc.entites.Fournisseur;

import java.sql.SQLException;

public class TestInsertionDAO {
    public static void main(String[] args) {


        try {
            FournisseurDAO dao = new FournisseurDAOJDBCSecurise();
            Fournisseur nouveauFournisseur = new Fournisseur("Centre");
            dao.insert(nouveauFournisseur);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Fournisseur inséré avec succès !");
        }
}

