/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.midominio.tiendajdbcweb.service;

import com.midominio.tiendajdbcweb.excepciones.CarritoVacioException;
import com.midominio.tiendajdbcweb.excepciones.CompraException;

/** @author Antonio */
public interface ICompraService {

	boolean comprar(int idCliente) throws CarritoVacioException, CompraException;
}
