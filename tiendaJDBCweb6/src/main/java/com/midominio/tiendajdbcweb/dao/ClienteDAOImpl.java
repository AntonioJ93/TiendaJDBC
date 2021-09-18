/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.midominio.tiendajdbcweb.dao;

import com.midominio.tiendajdbcweb.modelo.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author pryet
 */
public class ClienteDAOImpl implements ClienteDAO {

    private final Conexion c;

    public ClienteDAOImpl() {
        c = new Conexion();
    }

    @Override
    public boolean alta(Cliente cliente) {

        String consulta
                = "INSERT INTO cliente (nombre,primer_apellido,segundo_apellido,telefono1, email, pass) "
                + "VALUES(?,?,?,?,?,?)";
        try (Connection con = c.getConexion();
                PreparedStatement st = con.prepareStatement(consulta)) {

            st.setNString(1, cliente.getNombre());
            st.setNString(2, cliente.getApell1());
            st.setNString(3, cliente.getApell2());
            st.setNString(4, cliente.getTelefono());
            st.setNString(5, cliente.getEmail());
            st.setNString(6, cliente.getPass());
            st.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<Cliente> listar() {
        String consulta = "SELECT * FROM cliente";
        List<Cliente> lista = new LinkedList<>();
        try (Connection con = c.getConexion();
                PreparedStatement st = con.prepareStatement(consulta)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                lista.add(
                        new Cliente(
                                rs.getInt(1),
                                rs.getNString(2),
                                rs.getNString(3),
                                rs.getNString(4),
                                rs.getNString(5),
                                rs.getNString(6),
                                rs.getNString(7)));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return lista;
    }

    @Override
    public Cliente buscarClienteEmail(String email) {

        Cliente cliente = null;
        String consulta
                    = "SELECT id_cliente, nombre, primer_apellido, segundo_apellido, telefono1, email, pass "
                    + " FROM cliente WHERE email=? ";
         try (Connection con = c.getConexion();
                PreparedStatement st = con.prepareStatement(consulta)) {

            st.setNString(1, email);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                cliente
                        = new Cliente(
                                rs.getInt(1),
                                rs.getNString(2),
                                rs.getNString(3),
                                rs.getNString(4),
                                rs.getNString(5),
                                rs.getNString(6),
                                rs.getNString(7));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return cliente;
    }

    @Override
    public Cliente buscarClienteId(int idCliente) {

        Cliente cliente = null;
         String consulta
                    = "SELECT id_cliente, nombre, primer_apellido, segundo_apellido, telefono1, email, pass"
                    + " FROM cliente WHERE id_cliente=? ";
        try (Connection con = c.getConexion();
                PreparedStatement st = con.prepareStatement(consulta)) {

            st.setInt(1, idCliente);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                cliente
                        = new Cliente(
                                rs.getInt(1),
                                rs.getNString(2),
                                rs.getNString(3),
                                rs.getNString(4),
                                rs.getNString(5),
                                rs.getNString(6),
                                rs.getNString(7));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return cliente;
    }
}
