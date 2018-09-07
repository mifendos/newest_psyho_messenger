package ru.javafxchat.core.server;

import java.sql.*;

public abstract class AuthService {
    private Connection connection;
    private Statement stmt;

    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:main.db");
        stmt = connection.createStatement();
    }

    public String getNickByLoginAndPass(String login, String pass) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT nick FROM users WHERE login = '" + login + "' AND password = '" + pass + "';");
            while (rs.next()){
                return rs.getString("nick");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public abstract String getNick(String login, String pass);

    public abstract boolean login(String login, String pass);

    public abstract boolean contains(String userName);
}
