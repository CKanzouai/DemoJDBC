package fr.diginamic.jdbc;

import fr.diginamic.jdbc.dal.FournisseurDAO;
import fr.diginamic.jdbc.dal.jdbc.FournisseurDAOJDBC;

public class TestUpdateDAO {
    public static void main(String[] args) {
        try {
            FournisseurDAO dao = new FournisseurDAOJDBC();
            int nb = dao.update("NAMIC", "NAMI");
            System.out.println("nombe d'elt modifiés est : " + nb);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
