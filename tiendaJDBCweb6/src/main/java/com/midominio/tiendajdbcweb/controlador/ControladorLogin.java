/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.midominio.tiendajdbcweb.controlador;

import com.midominio.tiendajdbcweb.dto.ClienteDTO;
import com.midominio.tiendajdbcweb.excepciones.PassIncorrectaException;
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
 * @author Antonio
 */
@WebServlet(
        name = "controladorLogin",
        urlPatterns = {"/controladorLogin"})
public class ControladorLogin extends HttpServlet {

    private final Facade facade=new Facade();
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("correo");
        String pass = request.getParameter("pass");
        
        RequestDispatcher rd;
        ClienteDTO cDTOvista;
        try {
            cDTOvista = facade.login(email, pass);
            request.getSession().setAttribute("cliente", cDTOvista);
            rd=request.getRequestDispatcher("/preArticulos");
        } catch (UsuarioNoEncontradoException | PassIncorrectaException ex) {
            request.setAttribute("errorLogin", ex.getMessage());
            rd=request.getRequestDispatcher("/preLogin");

        }
        rd.forward(request, response);
        

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    } // </editor-fold>
}
