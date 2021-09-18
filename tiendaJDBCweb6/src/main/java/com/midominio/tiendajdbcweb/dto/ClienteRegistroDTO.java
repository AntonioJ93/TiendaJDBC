/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.midominio.tiendajdbcweb.dto;

import java.io.Serializable;

/** @author Antonio */
public class ClienteRegistroDTO implements Serializable {
  private static final long serialVersionUID = 1L;
  private int id;
  private String nombre;
  private String apell1;
  private String apell2;
  private String telefono;
  private String email;
  private String pass;
  private String confirPass;
 

  public static ClienteRegistroDTOBuilder builder() {
    return new ClienteRegistroDTOBuilder();
  }

  public String getConfirPass() {
    return confirPass;
  }

  public void setConfirPass(String confirPass) {
    this.confirPass = confirPass;
  }

  public String getPass() {
    return pass;
  }

  public void setPass(String pass) {
    this.pass = pass;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
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

  public static class ClienteRegistroDTOBuilder {

    private final ClienteRegistroDTO cDTO;

    private ClienteRegistroDTOBuilder() {
      cDTO = new ClienteRegistroDTO();
    }

    public ClienteRegistroDTOBuilder id(int id) {
      this.cDTO.id = id;
      return this;
    }

    public ClienteRegistroDTOBuilder email(String email) {
      this.cDTO.email = email;
      return this;
    }

    public ClienteRegistroDTOBuilder pass(String pass) {
      this.cDTO.pass = pass;
      return this;
    }

    public ClienteRegistroDTOBuilder confirPass(String confirPass) {
      this.cDTO.confirPass = confirPass;
      return this;
    }

    public ClienteRegistroDTOBuilder nombre(String nombre) {
      this.cDTO.nombre = nombre;
      return this;
    }

    public ClienteRegistroDTOBuilder apellido1(String apellido) {
      this.cDTO.apell1 = apellido;
      return this;
    }

    public ClienteRegistroDTOBuilder apellido2(String apellido) {
      this.cDTO.apell2 = apellido;
      return this;
    }

    public ClienteRegistroDTOBuilder telefono(String telefono) {
      this.cDTO.telefono = telefono;
      return this;
    }

    public ClienteRegistroDTO build() {
      return cDTO;
    }
  }
}
