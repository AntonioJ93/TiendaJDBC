/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.midominio.tiendajdbcweb.service;

import com.midominio.tiendajdbcweb.dto.ClienteDTO;
import com.midominio.tiendajdbcweb.excepciones.PassIncorrectaException;
import com.midominio.tiendajdbcweb.excepciones.UsuarioNoEncontradoException;

/** @author Antonio */
public interface ILoginService {

	ClienteDTO login(String email, String pass) throws UsuarioNoEncontradoException, PassIncorrectaException;
}
