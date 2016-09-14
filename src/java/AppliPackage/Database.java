/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppliPackage;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fabien
 */
public class Database {

    /**
     * Classe de gestion de la base de données
     */
    private String user, password, driver, host, status;
    private int port;
    private Connection co;

    /**
     * Constructor
     *
     * @param user
     * @param password
     * @param driver
     * @param host
     */
    public Database(String user, String password, String driver, String host) {
        this.user = user;
        this.password = password;
        this.host = host;
        this.driver = driver;

        try {
            Class.forName(this.getDriver());
            this.setStatus("Pilote chargé");
        } catch (ClassNotFoundException cnfe) {
            this.setStatus("ERREUR : Driver manquant.");
        }
    }

    public Connection connection() {
        try {
            this.co = DriverManager.getConnection(this.host, this.user, this.password);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.co;
    }
    
    public ResultSet exec(String query) throws SQLException{
        ResultSet rs = null;
        try{
            Statement st = this.connection().createStatement();
            rs = st.executeQuery(query);
            
        } catch(SQLException e){
            
        } 
        return rs;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

}
