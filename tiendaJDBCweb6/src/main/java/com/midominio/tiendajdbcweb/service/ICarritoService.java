/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.midominio.tiendajdbcweb.service;

import com.midominio.tiendajdbcweb.dto.ArticuloCarritoDTO;
import java.util.List;

/** @author Antonio */
public interface ICarritoService {

	boolean actualizarProducto(int idCliente, int idArticulo, int cantidad);

	boolean altaProducto(int idCliente, int idArticulo, int cantidad);

	boolean eliminarArticuloCarrito(int idCliente, int idArticulo);

	List<ArticuloCarritoDTO> listarCarrito(int idCliente);

	boolean vaciarCarrito(int idCliente);
}
