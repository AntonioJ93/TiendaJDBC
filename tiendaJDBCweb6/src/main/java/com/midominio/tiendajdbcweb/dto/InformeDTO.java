/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.midominio.tiendajdbcweb.dto;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Antonio
 */
public class InformeDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    private List<ArticuloInformeDTO> lista;
    private ClienteDTOInforme cDTO;

    public InformeDTO(List<ArticuloInformeDTO> lista, ClienteDTOInforme cDTO) {
        this.lista = lista;
        this.cDTO = cDTO;
    }

    public List<ArticuloInformeDTO> getLista() {
        return lista;
    }

    public void setLista(List<ArticuloInformeDTO> lista) {
        this.lista = lista;
    }

    public ClienteDTOInforme getcDTO() {
        return cDTO;
    }

    public void setcDTO(ClienteDTOInforme cDTO) {
        this.cDTO = cDTO;
    }
    
    
}
