/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.midominio.tiendajdbcweb.dto;

import java.io.Serializable;

/** @author Antonio */
public class ClienteDTOInforme implements Serializable {
  private static final long serialVersionUID = 1L;
  private int id;
  private String nombre;
  private String apell1;
  private String apell2;
  private String telefono;
  private String email;

  public static ClienteDTOInformeBuilder builder() {
    return new ClienteDTOInformeBuilder();
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public static class ClienteDTOInformeBuilder {

    private final ClienteDTOInforme cDTO;

    private ClienteDTOInformeBuilder() {
      cDTO = new ClienteDTOInforme();
    }

    public ClienteDTOInformeBuilder id(int id) {
      cDTO.id = id;
      return this;
    }

    public ClienteDTOInformeBuilder email(String email) {
      cDTO.email = email;
      return this;
    }

    public ClienteDTOInformeBuilder nombre(String nombre) {
      cDTO.nombre = nombre;
      return this;
    }

    public ClienteDTOInformeBuilder apellido1(String apellido) {
      cDTO.apell1 = apellido;
      return this;
    }

    public ClienteDTOInformeBuilder apellido2(String apellido) {
      cDTO.apell2 = apellido;
      return this;
    }

    public ClienteDTOInformeBuilder telefono(String telefono) {
      cDTO.telefono = telefono;
      return this;
    }

    public ClienteDTOInforme build() {
      return cDTO;
    }
  }
}
