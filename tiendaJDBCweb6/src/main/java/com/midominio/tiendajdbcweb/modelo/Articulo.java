/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.midominio.tiendajdbcweb.modelo;

import java.io.Serializable;

/**
 *
 * @author pryet
 */
public class Articulo implements Serializable{
    private static final long serialVersionUID = 1L;
    private final int idArticulo;
    private String nombre;
    private double precio;

    public Articulo(int idArticulo, String nombre, double precio) {
        this.idArticulo = idArticulo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idArticulo;
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
        final Articulo other = (Articulo) obj;
        return this.idArticulo == other.idArticulo;
    }

    @Override
    public String toString() {
        return "\nArticulo{" + "idArticulo=" + idArticulo + ", nombre=" + nombre + ", precio=" + precio + '}';
    }
    
    
}
