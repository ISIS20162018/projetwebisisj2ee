/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppliPackage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Fabien
 */
public class Client {
    
    protected String 
            code,
            societe,
            contact,
            fonction,
            adresse,
            ville,
            region,
            code_postal,
            pays,
            telephone,
            fax;
    private Database db;

    public Client() {
        
        //Connexion à la db
        this.db = new Database("isisuser", "isispassword", "org.apache.derby.jdbc.ClientDriver", "jdbc:derby://localhost:1527/javawebisis");
        
    }

    public Client(String code, String societe, String contact, String fonction, String adresse, String ville, String region, String code_postal, String pays, String telephone, String fax) {
        this.code = code;
        this.societe = societe;
        this.contact = contact;
        this.fonction = fonction;
        this.adresse = adresse;
        this.ville = ville;
        this.region = region;
        this.code_postal = code_postal;
        this.pays = pays;
        this.telephone = telephone;
        this.fax = fax;
        
        this.db = new Database("isisuser", "isispassword", "org.apache.derby.jdbc.ClientDriver", "jdbc:derby://localhost:1527/javawebisis");
        
    }
    
    public ArrayList<Client> fetchAll() throws SQLException{
     
       ResultSet rs = this.db.exec("SELECT * FROM CLIENT ORDER BY CONTACT DESC");
       ArrayList<Client> clients = new ArrayList();
       
       while(rs.next()){
            String code = rs.getString("CODE");
            String societe = rs.getString("SOCIETE");
            String contact = rs.getString("CONTACT");
            String fonction = rs.getString("FONCTION");
            String adresse = rs.getString("ADRESSE");
            String ville = rs.getString("VILLE");
            String region = rs.getString("REGION");
            String code_postal = rs.getString("CODE_POSTAL");
            String pays = rs.getString("PAYS");
            String telephone = rs.getString("TELEPHONE");
            String fax = rs.getString("FAX");
            
            //On créé le client de la double
            Client client = new Client();
            client.setCode(code);
            client.setSociete(societe);
            client.setContact(contact);
            client.setFonction(fonction);
            client.setAdresse(adresse);
            client.setVille(ville);
            client.setRegion(region);
            client.setCode_postal(code_postal);
            client.setPays(pays);
            client.setTelephone(telephone);
            client.setFax(fax);
            client.db = null;
            
            //J'ajoute à la liste
            clients.add(client);
        }
       
        return clients;
    }
    
    

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSociete() {
        return societe;
    }

    public void setSociete(String societe) {
        this.societe = societe;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(String code_postal) {
        this.code_postal = code_postal;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
    
    
    
}
