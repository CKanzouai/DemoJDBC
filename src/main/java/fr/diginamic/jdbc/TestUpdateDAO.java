package fr.diginamic.jdbc;

import fr.diginamic.jdbc.dal.FournisseurDAO;
import fr.diginamic.jdbc.dal.jdbc.FournisseurDAOJDBCSecurise;

public class TestUpdateDAO {
    public static void main(String[] args) {
        try {
            FournisseurDAO dao = new FournisseurDAOJDBCSecurise();
            int nb = dao.update("Intel", "Centre");
            System.out.println("nombe d'elt modifiés est : " + nb);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
