package fr.diginamic.jdbc;

import fr.diginamic.jdbc.dal.FournisseurDAO;
import fr.diginamic.jdbc.dal.jdbc.FournisseurDAOJDBC;
import fr.diginamic.jdbc.entites.Fournisseur;

public class TestDeleteDAO {
    public static void main(String[] args) {
        try {
            FournisseurDAO dao = new FournisseurDAOJDBC();

            Fournisseur fournisseur = new Fournisseur("NAMI");
            boolean success = dao.delete(fournisseur);
            if (success) {
                System.out.println("Fournisseur supprimé avec succès !");
            } else {
                System.out.println("Erreur lors de la suppression du fournisseur.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
