/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.midominio.tiendajdbcweb.dao;

import com.midominio.tiendajdbcweb.modelo.Articulo;
import java.util.List;

/** @author Antonio */
public interface ArticuloDAO {

	boolean alta(Articulo articulo);

	List<Articulo> listar();
}
