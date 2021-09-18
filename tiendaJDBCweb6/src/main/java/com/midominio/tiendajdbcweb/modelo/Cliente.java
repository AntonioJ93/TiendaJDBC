/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.midominio.tiendajdbcweb.modelo;

import java.io.Serializable;

/**
 * @author pryet
 */
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    private int idCliente;
    private String nombre;
    private String apell1;
    private String apell2;
    private String telefono;
    private String email;
    private final String pass;

    public Cliente(int idCliente, String nombre, String apell1, String apell2, String telefono, String email, String pass) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apell1 = apell1;
        this.apell2 = apell2;
        this.telefono = telefono;
        this.email = email;
        this.pass = pass;
    }

    public Cliente(String nombre, String apell1, String apell2, String telefono, String email, String pass) {
        this.nombre = nombre;
        this.apell1 = apell1;
        this.apell2 = apell2;
        this.telefono = telefono;
        this.email = email;
        this.pass = pass;
    }

    public Cliente(String nombre, String apell1, String email, String pass) {
        this.nombre = nombre;
        this.apell1 = apell1;
        this.email = email;
        this.pass = pass;
    }

    public static ClienteBuilder builder(String nombre, String apell1, String email, String pass) {
        return new ClienteBuilder(nombre, apell1, email, pass);
    }

    public String getPass() {
        return pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getApell1() {
        return apell1;
    }

    public void setApell1(String apell1) {
        this.apell1 = apell1;
    }

    public String getApell2() {
        return apell2;
    }

    public void setApell2(String apell2) {
        this.apell2 = apell2;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.idCliente;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        return this.idCliente == other.idCliente;
    }

    @Override
    public String toString() {
        return "Cliente{"
                + "idCliente="
                + idCliente
                + ", nombre="
                + nombre
                + ", apell1="
                + apell1
                + ", apell2="
                + apell2
                + ", telefono="
                + telefono
                + ", email="
                + email
                + ", pass="
                + pass
                + '}';
    }

    public static class ClienteBuilder {

        private final Cliente cliente;

        private ClienteBuilder(String nombre, String apell1, String email, String pass) {
            cliente = new Cliente(nombre, apell1, email, pass);
        }

        public ClienteBuilder telefono(String telefono) {
            cliente.telefono = telefono;
            return this;
        }

        public ClienteBuilder apell2(String apell2) {
            cliente.apell2 = apell2;
            return this;
        }

        public Cliente build() {
            return cliente;
        }
    }
}
