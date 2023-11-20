package fr.diginamic.jdbc;

import fr.diginamic.jdbc.dal.FournisseurDAO;
import fr.diginamic.jdbc.dal.jdbc.FournisseurDAOJDBC;
import fr.diginamic.jdbc.entites.Fournisseur;

import java.util.List;

public class TestSelectDAO {
    public static void main(String[] args) {
        try {
            FournisseurDAO dao = new FournisseurDAOJDBC();
            List<Fournisseur> fournisseurs = dao.extraire();
            for (Fournisseur fournisseur : fournisseurs){
                //System.out.println(fournisseur.toString());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}





