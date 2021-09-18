/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.midominio.tiendajdbcweb.dto;

import java.io.Serializable;

/** @author pryet */
public class ArticuloDTO implements Serializable {
		private static final long serialVersionUID = 1L;
    private int id;
    private String nombre;
    private double precio;

    public ArticuloDTO(int id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public ArticuloDTO() {
    }


    public static ArticuloDTOBuilder builder() {
        return new ArticuloDTOBuilder();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    public String toString() {
        return "\nArticuloDTO{" + "nombre=" + nombre + ", precio=" + precio + '}';
    }

    public static class ArticuloDTOBuilder {

        private final ArticuloDTO aDTO;

        private ArticuloDTOBuilder() {
            aDTO = new ArticuloDTO();
        }

        public ArticuloDTOBuilder id(int id) {
            this.aDTO.id = id;
            return this;
        }

        public ArticuloDTOBuilder nombre(String nombre) {
            this.aDTO.nombre = nombre;
            return this;
        }

        public ArticuloDTOBuilder precio(double precio) {
            this.aDTO.precio = precio;
            return this;
        }

        public ArticuloDTO build() {
            return aDTO;
        }
    }

}
