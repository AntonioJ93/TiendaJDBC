/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.midominio.tiendajdbcweb.facade;

import com.midominio.tiendajdbcweb.dto.*;
import com.midominio.tiendajdbcweb.service.*;
import com.midominio.tiendajdbcweb.excepciones.*;


import java.util.List;

/** @author Antonio */
public class Facade {

  private final ILoginService ls;
  private final IRegistroService rs;
  private final IArticuloService as;
  private final ICarritoService cs;
  private final ICompraService comSer;
  private final IInformeService infSer;

  public Facade() {
    ls = new LoginService();
    rs = new RegistroService();
    as = new ArticuloService();
    cs = new CarritoService();
    comSer = new CompraService();
    infSer = new InformeService();
  }

  public ClienteDTO login(String email, String pass)
      throws UsuarioNoEncontradoException, PassIncorrectaException {
    return ls.login(email, pass);
  }

  public ClienteDTO registrar(
      String nombre,
      String apell1,
      String apell2,
      String telefono,
      String email,
      String pass,
      String confPass)
      throws CamposRequeridosException, PassNoCoincidenteException, EmailRepetidoException {
    return rs.registrar(nombre, apell1, apell2, telefono, email, pass, confPass);
  }

  public List<ArticuloDTO> listarArticulos() {
    return as.listar();
  }

  public boolean agregarArticulo(int idCliente, int idArticulo, int cantidad) {
    return cs.altaProducto(idCliente, idArticulo, cantidad);
  }

  public boolean actualizarArticulo(int idCliente, int idArticulo, int cantidad) {
    return cs.actualizarProducto(idCliente, idArticulo, cantidad);
  }

  public List<ArticuloCarritoDTO> listarCarrito(int idCliente) {
    return cs.listarCarrito(idCliente);
  }

  public boolean eliminarArticuloCarrito(int idCliente, int idArticulo) {
    return cs.eliminarArticuloCarrito(idCliente, idArticulo);
  }

  public boolean vaciarCarrito(int idCliente) {
    return cs.vaciarCarrito(idCliente);
  }

  public boolean comprar(int id) throws CarritoVacioException, CompraException {
    return comSer.comprar(id);
  }

  public InformeDTO informeUltimoPedido(int idCliente) {
    return infSer.informeUltimoPedido(idCliente);
  }
}
