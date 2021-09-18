/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.midominio.tiendajdbcweb.dao;

import com.midominio.tiendajdbcweb.dto.ArticuloCarritoDTO;
import com.midominio.tiendajdbcweb.excepciones.CompraException;
import java.util.List;

/** @author Antonio */
public interface PedidoDAO {

	boolean guardar(int idCliente, List<ArticuloCarritoDTO> articulos);
	int ultimoIdPedido(int idCliente);
}
