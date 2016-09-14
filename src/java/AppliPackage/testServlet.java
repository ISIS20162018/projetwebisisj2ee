/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppliPackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Import de la classe db pour tester
 */
import AppliPackage.Database;
import AppliPackage.Client;
import java.sql.*;
import java.util.ArrayList;
import com.google.gson.Gson;

/**
 *
 * @author Fabien
 */
public class testServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //Je vais instancier ma db !
        Database db = new Database("isisuser", "isispassword", "org.apache.derby.jdbc.ClientDriver", "jdbc:derby://localhost:1527/javawebisis");

        Client clientManager = new Client();
        Gson gson = new Gson();
        String json = "[";
        try {
            ArrayList<Client> listeClients = clientManager.fetchAll();
            for (int i = 0; i < listeClients.size(); i++) {
                if (i == listeClients.size() - 1) {
                    json += gson.toJson(listeClients.get(i));
                } else {
                    json += gson.toJson(listeClients.get(i)) + ",";
                }
            }
        } catch (SQLException e) {

        }
        json += "]";
        response.setContentType("application/json");
        // Get the printwriter object from response to write the required json object to the output stream      
        PrintWriter out = response.getWriter();
        // Assuming your json object is **jsonObject**, perform the following, it will return your json object  
        out.print(json);
        out.flush();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
