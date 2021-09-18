/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.midominio.tiendajdbcweb.service;

import com.midominio.tiendajdbcweb.dto.ArticuloDTO;
import com.midominio.tiendajdbcweb.dto.ClienteDTO;
import com.midominio.tiendajdbcweb.dto.ClienteDTOInforme;
import com.midominio.tiendajdbcweb.modelo.Articulo;
import com.midominio.tiendajdbcweb.modelo.Cliente;

/** @author pryet */
public class RecursosService {

  public ClienteDTO clienteAclienteDTO(Cliente cliente) {
    return new ClienteDTO(cliente.getIdCliente(), cliente.getNombre());
  }

  public ClienteDTOInforme clienteAclienteDTOInforme(Cliente cliente) {
    return ClienteDTOInforme.builder()
        .id(cliente.getIdCliente())
        .nombre(cliente.getNombre())
        .apellido1(cliente.getApell1())
        .apellido2(cliente.getApell2())
        .telefono(cliente.getTelefono())
        .email(cliente.getEmail())
        .build();
  }

  public ArticuloDTO articuloAarticuloDTO(Articulo articulo) {
    return new ArticuloDTO(articulo.getIdArticulo(), articulo.getNombre(), articulo.getPrecio());
  }

  public Articulo articulodtoAarticulo(ArticuloDTO articuloDTO) {
    return new Articulo(articuloDTO.getId(), articuloDTO.getNombre(), articuloDTO.getPrecio());
  }
}
