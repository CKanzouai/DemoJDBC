package fr.diginamic.jdbc.dal;

import fr.diginamic.jdbc.entites.Fournisseur;

import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public interface FournisseurDAO {


        List<Fournisseur> extraire() throws SQLException;

        void insert(Fournisseur fournisseur) throws SQLException;
        int update(String ancienNom, String nouveauNom) throws SQLException;
        boolean delete(Fournisseur fournisseur) throws SQLException;

}
