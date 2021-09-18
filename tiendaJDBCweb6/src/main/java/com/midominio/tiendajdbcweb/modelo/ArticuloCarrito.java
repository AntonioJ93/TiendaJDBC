/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.midominio.tiendajdbcweb.modelo;

import java.io.Serializable;

/**
 *
 * @author Antonio
 */

/*////////////////////////////////////////////////////////
            tabla carrito

///////////////////////////////////////////////////////*/
public class ArticuloCarrito implements Serializable{
    private static final long serialVersionUID = 1L;
    private int idCliente;
    private int idArticulo;
    private int cantidad;

    public ArticuloCarrito(int idCliente, int idArticulo, int cantidad) {
        this.idCliente = idCliente;
        this.idArticulo = idArticulo;
        this.cantidad = cantidad;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + this.idCliente;
        hash = 61 * hash + this.idArticulo;
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
        final ArticuloCarrito other = (ArticuloCarrito) obj;
        if (this.idCliente != other.idCliente) {
            return false;
        }
        return this.idArticulo == other.idArticulo;
    }

    @Override
    public String toString() {
        return "Carrito{" + "idCliente=" + idCliente + ", idArticulo=" + idArticulo + ", cantidad=" + cantidad + '}';
    }
    
    
}
