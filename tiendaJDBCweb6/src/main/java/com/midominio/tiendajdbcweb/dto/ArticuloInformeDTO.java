/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.midominio.tiendajdbcweb.dto;

import java.io.Serializable;


/** @author Antonio */
public class ArticuloInformeDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private int cantidad;
    private String nombre;
    private double precio;
    private String fecha;

    public ArticuloInformeDTO(int cantidad, String nombre, double precio, String fecha) {
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.precio = precio;
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

   

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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
    
    
}
