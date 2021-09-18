/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.midominio.tiendajdbcweb.controlador;

import com.midominio.tiendajdbcweb.dto.ClienteDTO;
import com.midominio.tiendajdbcweb.excepciones.CamposRequeridosException;
import com.midominio.tiendajdbcweb.excepciones.EmailRepetidoException;
import com.midominio.tiendajdbcweb.excepciones.PassIncorrectaException;
import com.midominio.tiendajdbcweb.excepciones.PassNoCoincidenteException;
import com.midominio.tiendajdbcweb.excepciones.UsuarioNoEncontradoException;
import com.midominio.tiendajdbcweb.facade.Facade;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Antonio
 */
@WebServlet(name = "ControladorRegistro", urlPatterns = {"/controladorRegistro"})
public class ControladorRegistro extends HttpServlet {

    private final Facade facade=new Facade();
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre = request.getParameter("nombre");
        String apell1 = request.getParameter("apell1");
        String apell2 = request.getParameter("apell2");
        String telefono = request.getParameter("tlf");
        String email = request.getParameter("correo");
        String pass = request.getParameter("pass");
        String confPass = request.getParameter("confPass");
        
        
        RequestDispatcher rd;
        ClienteDTO cDTOvista;
        
        try {
            facade.registrar(nombre,apell1,apell2,telefono,email,pass, confPass);
            cDTOvista = facade.login(email, pass);
            request.getSession().setAttribute("cliente", cDTOvista);
            rd=request.getRequestDispatcher("/preArticulos");
        } catch (CamposRequeridosException |PassNoCoincidenteException | EmailRepetidoException | PassIncorrectaException | UsuarioNoEncontradoException ex) {
            rd=request.getRequestDispatcher("/preRegistro");
            request.setAttribute("nombre", nombre);
            request.setAttribute("apell1", apell1);
            request.setAttribute("apell2", apell2);
            request.setAttribute("telefono", telefono);
            request.setAttribute("email", email);
            request.setAttribute("errorRegistro", ex.getMessage());
        } 
        rd.forward(request, response);
        
        
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
