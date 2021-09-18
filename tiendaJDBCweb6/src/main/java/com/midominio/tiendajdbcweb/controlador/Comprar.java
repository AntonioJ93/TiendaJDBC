/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.midominio.tiendajdbcweb.controlador;

import com.midominio.tiendajdbcweb.dto.ClienteDTO;
import com.midominio.tiendajdbcweb.excepciones.CarritoVacioException;
import com.midominio.tiendajdbcweb.excepciones.CompraException;
import com.midominio.tiendajdbcweb.facade.Facade;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** @author Antonio */
@WebServlet(
    name = "Comprar",
    urlPatterns = {"/comprar"})
public class Comprar extends HttpServlet {

  private final Facade facade = new Facade();
  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ClienteDTO cliente = (ClienteDTO) request.getSession().getAttribute("cliente");
    RequestDispatcher rd;

    try {
      facade.comprar(cliente.getId()); 
      rd = request.getRequestDispatcher("./generarInforme");
    } catch (CarritoVacioException | CompraException ex) {
      request.setAttribute("msgCompra", ex.getMessage());
      rd = request.getRequestDispatcher("./verCarrito");
    }
    rd.forward(request, response);
  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the
  // left to edit the code.">
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
  } // </editor-fold>
}