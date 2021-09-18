/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.midominio.tiendajdbcweb.dao;

import com.midominio.tiendajdbcweb.modelo.Articulo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 * @author pryet
 */
public class ArticuloDAOImpl implements ArticuloDAO {

    private final Conexion c;

    public ArticuloDAOImpl() {
        c = new Conexion();
    }

    @Override
    public boolean alta(Articulo articulo) {
        String sql = "INSERT INTO articulo (nombre,precio) VALUES(?,?)";
        try (Connection con = c.getConexion();
                PreparedStatement st = con.prepareStatement(sql)) {

            st.setNString(1, articulo.getNombre());
            st.setDouble(2, articulo.getPrecio());
            st.executeUpdate();

            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<Articulo> listar() {

        ResultSet rs = null;
        List<Articulo> lista = new LinkedList<>();
        try (Connection con = c.getConexion();
                Statement st = con.createStatement()) {

            rs = st.executeQuery("SELECT id_articulo, nombre, precio FROM articulo");
            while (rs.next()) {

                lista.add(new Articulo(rs.getInt(1), rs.getNString(2), rs.getDouble(3)));
            }
            rs.close();

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return lista;
    }
}
