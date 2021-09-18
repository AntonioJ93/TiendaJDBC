/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.midominio.tiendajdbcweb.dao;

import com.midominio.tiendajdbcweb.dto.ArticuloCarritoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Antonio
 */
public class PedidoDAOImpl implements PedidoDAO {

    private final Conexion c;

    public PedidoDAOImpl() {
        c = new Conexion();
    }

    private boolean insertarPedido(Connection con, int idCliente) throws SQLException {

        String consulta = "INSERT INTO pedido (id_cliente) VALUES( ? ) ";
        try (PreparedStatement st = con.prepareStatement(consulta)) {
            st.setInt(1, idCliente);

            st.executeUpdate();
        }
        return true;
    }

    @Override
    public int ultimoIdPedido(int idCliente) {

        int idPedido = -1;
        String consulta = "SELECT max(id_pedido) from pedido where id_cliente=?";
        try (Connection con = c.getConexion();
                PreparedStatement st = con.prepareStatement(consulta)) {

            st.setInt(1, idCliente);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                idPedido = rs.getInt(1);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return idPedido;
    }

    private int ultimoIdPedido(int idCliente, Connection con) {

        ResultSet rs = null;
        int idPedido = -1;
        String consulta = "SELECT max(id_pedido) from pedido where id_cliente=?";
        try (PreparedStatement st = con.prepareStatement(consulta)) {

            st.setInt(1, idCliente);

            rs = st.executeQuery();
            if (rs.next()) {
                idPedido = rs.getInt(1);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return idPedido;
    }

    @Override
    public boolean guardar(int idCliente, List<ArticuloCarritoDTO> articulos) {

        Connection con = null;

        try {
            con = c.getConexion();
            con.setAutoCommit(false);
            insertarPedido(con, idCliente);
            int idPedido = ultimoIdPedido(idCliente, con);
            DetallePedidoDAOImpl detalle = new DetallePedidoDAOImpl(con);
            detalle.insertar(idPedido, articulos);

            con.commit();
            con.close();

            return true;
        } catch (SQLException ex) {

            try {
                con.rollback();
                if (!con.isClosed()) {
                    con.close();
                }

            } catch (SQLException ex1) {
                Logger.getLogger(CarritoDAOImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }

        }
        return false;
    }

    private class DetallePedidoDAOImpl implements DetallePedidoDAO {

        private final Connection con;

        public DetallePedidoDAOImpl(Connection con) {
            this.con = con;
        }

        @Override
        public boolean insertar(int idPedido, List<ArticuloCarritoDTO> articulos) throws SQLException {

            String consulta
                    = "INSERT INTO detallepedido (id_pedido,id_articulo,cantidad,precio) VALUES(?,?,?,?)";
            try (PreparedStatement st = con.prepareStatement(consulta)) {
                for (ArticuloCarritoDTO articulo : articulos) {

                    st.setInt(1, idPedido);
                    st.setInt(2, articulo.getIdArticulo());
                    st.setInt(3, articulo.getCantidad());
                    st.setDouble(4, articulo.getPrecio());
                    st.executeUpdate();
                }
            }
            return true;
        }
    }
}
