/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.midominio.tiendajdbcweb.dao;

import com.midominio.tiendajdbcweb.modelo.Cliente;
import java.util.List;

/** @author Antonio */
public interface ClienteDAO {

	boolean alta(Cliente cliente);

	Cliente buscarClienteEmail(String email);

	Cliente buscarClienteId(int idCliente);

	List<Cliente> listar();
}
