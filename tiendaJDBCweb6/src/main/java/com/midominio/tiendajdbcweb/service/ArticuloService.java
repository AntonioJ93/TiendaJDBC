/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.midominio.tiendajdbcweb.service;

import com.midominio.tiendajdbcweb.dao.ArticuloDAO;
import com.midominio.tiendajdbcweb.dao.ArticuloDAOImpl;
import com.midominio.tiendajdbcweb.dto.ArticuloDTO;
import com.midominio.tiendajdbcweb.modelo.Articulo;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Antonio
 */
public class ArticuloService implements IArticuloService {

    private final RecursosService rs;

    public ArticuloService() {
        this.rs = new RecursosService();
    }

    @Override
    public List<ArticuloDTO> listar() {
        ArticuloDAO aDAO = new ArticuloDAOImpl();
        List<Articulo> lista = aDAO.listar();
        List<ArticuloDTO> listaDTO = new ArrayList<>();
        lista.forEach(articulo ->  listaDTO.add(rs.articuloAarticuloDTO(articulo)));
        
        return listaDTO;
    }
}
