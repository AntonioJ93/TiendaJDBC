/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.midominio.tiendajdbcweb.service;

import com.midominio.tiendajdbcweb.dao.CarritoDAO;
import com.midominio.tiendajdbcweb.dao.CarritoDAOImpl;
import com.midominio.tiendajdbcweb.dto.ArticuloCarritoDTO;
import com.midominio.tiendajdbcweb.modelo.ArticuloCarrito;
import java.util.List;

/**
 * @author Antonio
 */
public class CarritoService implements ICarritoService {

    private final CarritoDAO cDAO;

    public CarritoService() {
        cDAO = new CarritoDAOImpl();
    }

    @Override
    public boolean altaProducto(int idCliente, int idArticulo, int cantidad) {
        ArticuloCarrito carrito = new ArticuloCarrito(idCliente, idArticulo, cantidad);

        if (!cDAO.alta(carrito)) {
            ArticuloCarrito carritoExistente = cDAO.buscarArticuloCarrito(idCliente, idArticulo);
            cDAO.actualizar(idCliente, idArticulo, cantidad + carritoExistente.getCantidad());
        }
        return true;
    }

    @Override
    public List<ArticuloCarritoDTO> listarCarrito(int idCliente) {

        return cDAO.listar(idCliente);
    }

    @Override
    public boolean eliminarArticuloCarrito(int idCliente, int idArticulo) {

        return cDAO.eliminarArticulo(idCliente, idArticulo);
    }

    @Override
    public boolean vaciarCarrito(int idCliente) {

        return cDAO.eliminarTodo(idCliente);
    }

    @Override
    public boolean actualizarProducto(int idCliente, int idArticulo, int cantidad) {
        return cDAO.actualizar(idCliente, idArticulo, cantidad);
    }
}
