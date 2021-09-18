/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.midominio.tiendajdbcweb.service;

import com.midominio.tiendajdbcweb.dto.ClienteDTO;
import com.midominio.tiendajdbcweb.excepciones.CamposRequeridosException;
import com.midominio.tiendajdbcweb.excepciones.EmailRepetidoException;
import com.midominio.tiendajdbcweb.excepciones.PassNoCoincidenteException;

/** @author Antonio */
public interface IRegistroService {

	ClienteDTO registrar(String nombre, String apell1, String apell2, String telefono, String email, String pass, String confPass) throws CamposRequeridosException, PassNoCoincidenteException, EmailRepetidoException;
}
