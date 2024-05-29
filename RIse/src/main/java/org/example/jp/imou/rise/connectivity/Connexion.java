package org.example.jp.imou.rise.connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connexion {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost/rise_db";
    static final String USER = "root";
    static final String PASS = "";

    public Connexion() {
    }

    public Connection getConnexion() throws SQLException {
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Pilote chargé");

            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost/rise_db", "root", "");
                System.out.println("Connexion établie");
            } catch (SQLException var3) {
                System.err.println("Connection Impossible");
                var3.printStackTrace();
            }
        } catch (ClassNotFoundException var4) {
            System.err.println("Impossible de charger le pilote");
            var4.printStackTrace();
        }

        return connection;
    }

    public static void main(String[] args) {
        Connexion con = new Connexion();

        try {
            con.getConnexion();
        } catch (SQLException var3) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, (String)null, var3);
        }

    }
}
