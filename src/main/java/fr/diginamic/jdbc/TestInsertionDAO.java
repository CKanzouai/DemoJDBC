package fr.diginamic.jdbc;

import fr.diginamic.jdbc.dal.FournisseurDAO;
import fr.diginamic.jdbc.dal.jdbc.FournisseurDAOJDBC;
import fr.diginamic.jdbc.entites.Fournisseur;

import java.sql.SQLException;

public class TestInsertionDAO {
    public static void main(String[] args) {


        try {
            FournisseurDAO dao = new FournisseurDAOJDBC();
            Fournisseur nouveauFournisseur = new Fournisseur("Intel");
            dao.insert(nouveauFournisseur);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Fournisseur inséré avec succès !");
        }
}

