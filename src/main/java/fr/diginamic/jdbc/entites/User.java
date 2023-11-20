package fr.diginamic.jdbc.entites;

public class User {
    private int id;
    private String login;
    private String pwd;

    public User(int id, String login, String pwd) {
        this.id = id;
        this.login = login;
        this.pwd = pwd;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
