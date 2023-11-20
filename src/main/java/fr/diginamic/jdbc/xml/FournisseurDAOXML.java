package fr.diginamic.jdbc.xml;

import fr.diginamic.jdbc.dal.FournisseurDAO;
import fr.diginamic.jdbc.entites.Fournisseur;

import java.util.List;

public class FournisseurDAOXML implements FournisseurDAO {

    @Override
    public List<Fournisseur> extraire() {
        return null;
    }

    @Override
    public void insert(Fournisseur fournisseur) {

    }

    @Override
    public int update(String ancienNom, String nouveauNom) {
        return 0;
    }

    @Override
    public boolean delete(Fournisseur fournisseur) {
        return false;
    }
}
