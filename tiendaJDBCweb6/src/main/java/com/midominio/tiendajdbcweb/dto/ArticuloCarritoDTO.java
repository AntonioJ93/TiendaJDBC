/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.midominio.tiendajdbcweb.dto;

import java.io.Serializable;

/** @author pryet */
public class ArticuloCarritoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private int idArticulo;
    private String nombreArticulo;
    private double precio;
    private int cantidad;

    public ArticuloCarritoDTO(int idArticulo, String nombreArticulo, double precio, int cantidad) {
        this.idArticulo = idArticulo;
        this.nombreArticulo = nombreArticulo;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    
    
}
