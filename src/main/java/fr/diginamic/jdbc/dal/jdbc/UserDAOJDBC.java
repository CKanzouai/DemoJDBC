package fr.diginamic.jdbc.dal.jdbc;
import fr.digi.m0923.jdbc.dal.UserDAO;
import fr.digi.m0923.jdbc.entites.Utilisateur;
import fr.diginamic.jdbc.entites.User;

import java.sql.*;
import static fr.digi.m0923.jdbc.dal.jdbc.FournisseurDAOJDBC.*;
public class UserDAOJDBC {






        private static final String LOGIN_QUERY = "SELECT ID, LOGIN, MDP FROM UTILISATEUR WHERE LOGIN = '%s' AND MDP = '%s'";
        private static final String SECURED_LOGIN_QUERY = "SELECT ID, LOGIN, MDP FROM UTILISATEUR WHERE LOGIN = ? AND MDP = ?";
        @Override
        public Utilisateur authentification(String login, String password) throws Exception {

            Utilisateur utilisateur = null;
            try (Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
                 Statement st = cnx.createStatement();
                 ResultSet rs = st.executeQuery(String.format(LOGIN_QUERY,login, password))) {

                System.err.println(String.format(LOGIN_QUERY,login, password));
                if (rs.next()) {
                    int id = rs.getInt("ID");
                    String loginDB = rs.getString("LOGIN");
                    String mdp = rs.getString("MDP");
                    utilisateur = new Utilisateur(id, loginDB, mdp);
                }
            }

            return utilisateur;
        }

        @Override
        public Utilisateur authentificationSecurisee(String login, String password) throws Exception {
            Utilisateur utilisateur = null;
            try (Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
                 PreparedStatement pst = cnx.prepareStatement(SECURED_LOGIN_QUERY)) {

                pst.setString(1, login);
                pst.setString(2, password);
                try(ResultSet rs = pst.executeQuery()) {
                    System.err.println(pst);
                    if (rs.next()) {
                        int id = rs.getInt("ID");
                        String loginDB = rs.getString("LOGIN");
                        String mdp = rs.getString("MDP");
                        utilisateur = new User(id, loginDB, mdp);
                    }
                }
            }

            return utilisateur;
        }
    }
}
