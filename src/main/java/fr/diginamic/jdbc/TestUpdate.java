package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestUpdate {


    private static final String DB_URL;
    private static final String DB_USER;
    private static final String DB_PWD;
    static {
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        DB_URL = bundle.getString("db.url");
        DB_USER = bundle.getString("db.user");
        DB_PWD = bundle.getString("db.password");
    }




    public static void testUpdate(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);

            Statement st = connection.createStatement();
            int up = st.executeUpdate("UPDATE FOURNISSEUR SET NOM='LA MAISON DES PEINTURE' WHERE NOM='LA MAISON DE LA PEINTURE'");

            System.out.println("Nombre d'éléments modifiés : " + up);

            st.close();
        } catch (SQLException e) {
            throw new RuntimeException("Attention : " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Attention : " + e.getMessage());
                }
            }
        }


    }
}
