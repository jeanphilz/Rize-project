package org.example.jp.imou.rise.model;

import org.example.jp.imou.rise.connectivity.Connexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class User {

    private int userId;
    private String email;
    private String username;
    private String password;
    private String phone;
    private String status;
    private String country;

    public User() {

    }

    public User(int userId, String email, String username, String password, String phone, String status, String country) {
        this.userId = userId;
        this.email = email;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.status = status;
        this.country = country;
    }

    public User(String email, String username, String password, String phone, String status, String country) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.status = status;
        this.country = country;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", status='" + status + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    //DAO
    private Connection con = null;
    private PreparedStatement statement = null;

    public void User() {
        try {
            con = new Connexion().getConnexion();
        } catch (Exception ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createUser(String email, String username, String password, String phone, String status, String country) {
        try {
            statement = con.prepareStatement("INSERT INTO users(email, username, password, phone, status, country) VALUES (?, ?, ?, ?, ?, ?)");
            statement.setString(1, email);
            statement.setString(2, username);
            statement.setString(3, password);
            statement.setString(4, phone);
            statement.setString(5, status);
            statement.setString(6, country);

            try {
                statement.execute();
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateUser(int userId, String email, String username, String password, String phone, String status, String country) {
        try {
            statement = con.prepareStatement("UPDATE users SET email = ?, username = ?, password = ?, phone = ?, status = ?, country = ? WHERE user_id = ?");
            statement.setString(1, email);
            statement.setString(2, username);
            statement.setString(3, password);
            statement.setString(4, phone);
            statement.setString(5, status);
            statement.setString(6, country);
            statement.setInt(7, userId);

            try {
                statement.execute();
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteUser(int userId) {
        try {
            statement = con.prepareStatement("DELETE FROM users WHERE user_id = ?");
            statement.setInt(1, userId);
            try {
                statement.execute();
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getUserById(int userId) {
        try {
            statement = con.prepareStatement("SELECT * FROM users WHERE user_id = ?");
            statement.setInt(1, userId);
            try {
                statement.execute();
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getAllUsers() {
        try {
            statement = con.prepareStatement("SELECT * FROM users");
            try {
                statement.execute();
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getUserByUsername(String username) {
        try {
            statement = con.prepareStatement("SELECT * FROM users WHERE username = ?");
            statement.setString(1, username);
            try {
                statement.execute();
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getUserByEmail(String email) {
        try {
            statement = con.prepareStatement("SELECT * FROM users WHERE email = ?");
            statement.setString(1, email);
            try {
                statement.execute();
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getUserByPhone(String phone) {
        try {
            statement = con.prepareStatement("SELECT * FROM users WHERE phone = ?");
            statement.setString(1, phone);
            try {
                statement.execute();
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
