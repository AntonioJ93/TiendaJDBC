/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.midominio.tiendajdbcweb.dao;

import com.midominio.tiendajdbcweb.dto.ArticuloCarritoDTO;
import com.midominio.tiendajdbcweb.modelo.ArticuloCarrito;
import java.util.List;

/** @author Antonio */
public interface CarritoDAO {

	boolean actualizar(int idCliente,int idArticulo, int cantidad);

	boolean alta(ArticuloCarrito carrito);

	ArticuloCarrito buscarArticuloCarrito(int idCliente, int idArticulo);

	boolean eliminarArticulo(int idCliente, int idArticulo);

	boolean eliminarTodo(int idCliente);

	List<ArticuloCarritoDTO> listar(int idCliente);
}
