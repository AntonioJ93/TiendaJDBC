/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.midominio.tiendajdbcweb.dao;

import com.midominio.tiendajdbcweb.dto.ArticuloCarritoDTO;
import com.midominio.tiendajdbcweb.modelo.ArticuloCarrito;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Antonio
 */
public class CarritoDAOImpl implements CarritoDAO {

    private final Conexion c;

    public CarritoDAOImpl() {
        c = new Conexion();
    }

    @Override
    public boolean alta(ArticuloCarrito carrito) {

        String consulta
                = "INSERT INTO carrito (id_cliente , id_articulo , cantidad) " + "VALUES(?,?,?)";
        try (Connection con = c.getConexion();
                PreparedStatement st = con.prepareStatement(consulta)) {

            st.setInt(1, carrito.getIdCliente());
            st.setInt(2, carrito.getIdArticulo());
            st.setInt(3, carrito.getCantidad());

            st.executeUpdate();

        } catch (SQLException ex) {
            return false;

        }
        return true;
    }

    @Override
    public boolean eliminarTodo(int idCliente) {

        String consulta = "DELETE FROM carrito WHERE id_cliente = ?";
        try (Connection con = c.getConexion();
                PreparedStatement st = con.prepareStatement(consulta)) {

            st.setInt(1, idCliente);

            st.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();

            return false;
        }
        return true;
    }

    @Override
    public ArticuloCarrito buscarArticuloCarrito(int idCliente, int idArticulo) {

        String consulta
                = "SELECT id_cliente , id_articulo , cantidad  FROM carrito WHERE id_cliente= ? and id_articulo= ?";
        ArticuloCarrito carrito = null;
        try (Connection con = c.getConexion();
                PreparedStatement st = con.prepareStatement(consulta)) {

            st.setInt(2, idArticulo);
            st.setInt(1, idCliente);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                carrito = new ArticuloCarrito(rs.getInt(1), rs.getInt(2), rs.getInt(3));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return carrito;
    }

    @Override
    public boolean actualizar(int idCliente, int idArticulo, int cantidad) {

        String consulta = "UPDATE carrito SET cantidad=? WHERE id_cliente=? AND id_articulo=? ";
        try (Connection con = c.getConexion();
                PreparedStatement st = con.prepareStatement(consulta)) {

            st.setInt(3, idArticulo);
            st.setInt(2, idCliente);
            st.setInt(1, cantidad);
            st.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();

            return false;
        }
        return true;
    }

    @Override
    public List<ArticuloCarritoDTO> listar(int idCliente) {

        String consulta
                = "SELECT articulo.id_articulo, articulo.nombre, precio, cantidad "
                + " FROM carrito join articulo ON carrito.id_articulo= articulo.id_articulo "
                + " JOIN cliente ON cliente.id_cliente=carrito.id_cliente "
                + " WHERE cliente.id_cliente=?";
        List<ArticuloCarritoDTO> lista = new ArrayList<>();
        try (Connection con = c.getConexion();
                PreparedStatement st = con.prepareStatement(consulta)) {

            st.setInt(1, idCliente);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                lista.add(
                        new ArticuloCarritoDTO(rs.getInt(1), rs.getNString(2), rs.getDouble(3), rs.getInt(4)));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;
    }

    @Override
    public boolean eliminarArticulo(int idCliente, int idArticulo) {

        String consulta = "DELETE FROM carrito WHERE id_cliente = ? AND id_articulo= ? ";
        try (Connection con = c.getConexion();
                PreparedStatement st = con.prepareStatement(consulta)) {

            st.setInt(1, idCliente);
            st.setInt(2, idArticulo);
            st.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();

            return false;
        }

        return true;
    }
}
