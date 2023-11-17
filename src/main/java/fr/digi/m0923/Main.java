package fr.digi.m0923;
import java.sql.*;
import java.util.ResourceBundle;

public class Main {

       // System.out.println("Hello world!");
        private static final String  DB_URL;
        private static final String DB_USER;
        private static final String DB_PWD;

        static {
            System.out.println("block static");
            ResourceBundle bundle = ResourceBundle.getBundle("db");
            DB_URL = bundle.getString("db.url");
            DB_USER = bundle.getString("db.user");
            DB_PWD = bundle.getString("db.password");
        }
    public static void main(String[] args) {

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
            System.out.println("connexion a la BD réussite!");
            System.out.println(connection);

        } catch (SQLException e) {
            throw new RuntimeException("Attention" +e.getMessage());
        } finally {
            if (null != connection){
                try {
                    connection.close();
                }catch (SQLException e){
                    System.out.println("Attention : " + e.getMessage());
                }
            }
        }



    }
}