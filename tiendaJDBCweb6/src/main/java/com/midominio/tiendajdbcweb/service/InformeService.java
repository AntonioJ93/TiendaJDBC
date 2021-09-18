/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.midominio.tiendajdbcweb.service;

import com.midominio.tiendajdbcweb.dao.ClienteDAO;
import com.midominio.tiendajdbcweb.dao.ClienteDAOImpl;
import com.midominio.tiendajdbcweb.dao.InformeDAO;
import com.midominio.tiendajdbcweb.dao.InformeDAOImpl;
import com.midominio.tiendajdbcweb.dao.PedidoDAO;
import com.midominio.tiendajdbcweb.dao.PedidoDAOImpl;
import com.midominio.tiendajdbcweb.dto.ArticuloInformeDTO;
import com.midominio.tiendajdbcweb.dto.InformeDTO;
import com.midominio.tiendajdbcweb.modelo.Cliente;
import java.util.List;

/** @author Antonio */
public class InformeService implements IInformeService {
  private final InformeDAO iDAO;
  private final ClienteDAO cDAO;
  private final PedidoDAO pDAO;
  private final RecursosService rs;

  public InformeService() {
    iDAO = new InformeDAOImpl();
    cDAO = new ClienteDAOImpl();
    pDAO = new PedidoDAOImpl();
    rs = new RecursosService();
  }

  @Override
  public InformeDTO informeUltimoPedido(int idCliente) {
    List<ArticuloInformeDTO> articulo =
        iDAO.listarInforme(idCliente, pDAO.ultimoIdPedido(idCliente));
    Cliente cliente = cDAO.buscarClienteId(idCliente);
    return new InformeDTO(articulo, rs.clienteAclienteDTOInforme(cliente));
  }
}
