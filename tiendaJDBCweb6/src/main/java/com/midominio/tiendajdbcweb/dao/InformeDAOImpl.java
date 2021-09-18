/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.midominio.tiendajdbcweb.dao;

import com.midominio.tiendajdbcweb.dto.ArticuloInformeDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/** @author Antonio */
public class InformeDAOImpl implements InformeDAO {

  private final Conexion c;

  public InformeDAOImpl() {
    c = new Conexion();
  }

  @Override
  public List<ArticuloInformeDTO> listarInforme(int idCliente, int idPedido) {

    String consulta =
          "SELECT articulo.nombre, detallepedido.precio, cantidad, pedido.fecha_pedido "
              + "FROM pedido join detallepedido ON pedido.id_pedido= detallepedido.id_pedido "
              + "JOIN articulo ON detallepedido.id_articulo= articulo.id_articulo "
              + "WHERE pedido.id_cliente=? and pedido.id_pedido=?;";
    List<ArticuloInformeDTO> lista = new ArrayList<>();
    try (Connection con = c.getConexion();
                PreparedStatement st = con.prepareStatement(consulta)) {

      st.setInt(1, idCliente);
      st.setInt(2, idPedido);
      ResultSet rs = st.executeQuery();
      while (rs.next()) {
        lista.add(
            new ArticuloInformeDTO(
                rs.getInt(3), rs.getNString(1), rs.getDouble(2), rs.getTimestamp(4).toString()));
      }

    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return lista;
  }
}
