/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.midominio.tiendajdbcweb.service;

import com.midominio.tiendajdbcweb.dao.CarritoDAO;
import com.midominio.tiendajdbcweb.excepciones.CarritoVacioException;
import com.midominio.tiendajdbcweb.dao.CarritoDAOImpl;
import com.midominio.tiendajdbcweb.dao.PedidoDAO;
import com.midominio.tiendajdbcweb.dao.PedidoDAOImpl;
import com.midominio.tiendajdbcweb.dto.ArticuloCarritoDTO;
import com.midominio.tiendajdbcweb.excepciones.CompraException;
import java.util.List;

/**
 *
 * @author Antonio
 */
public class CompraService implements ICompraService {

    private final PedidoDAO pDAO;
    private final CarritoDAO cDAO;

    public CompraService() {
        pDAO = new PedidoDAOImpl();
        cDAO = new CarritoDAOImpl();
    }

    @Override
    public boolean comprar(int idCliente) throws CarritoVacioException, CompraException {

        List<ArticuloCarritoDTO> carritoCompleto = cDAO.listar(idCliente);
        if (!carritoCompleto.isEmpty()) {
            if(!pDAO.guardar(idCliente, carritoCompleto)){
                throw new CompraException("Error al comprar");
            }
            cDAO.eliminarTodo(idCliente);
            return true;
        }
        throw new CarritoVacioException("El carrito esta vacio");
    }

}
