/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.midominio.tiendajdbcweb.dao;

import com.midominio.tiendajdbcweb.dto.ArticuloCarritoDTO;
import java.sql.SQLException;
import java.util.List;

/** @author Antonio */
public interface DetallePedidoDAO {

	boolean insertar(int idPedido, List<ArticuloCarritoDTO> articulos) throws SQLException;
}
