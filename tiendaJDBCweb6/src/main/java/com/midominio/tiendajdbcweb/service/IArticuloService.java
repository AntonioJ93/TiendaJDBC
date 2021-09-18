/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.midominio.tiendajdbcweb.service;

import com.midominio.tiendajdbcweb.dto.ArticuloDTO;
import java.util.List;

/** @author Antonio */
public interface IArticuloService {

	List<ArticuloDTO> listar();
}
