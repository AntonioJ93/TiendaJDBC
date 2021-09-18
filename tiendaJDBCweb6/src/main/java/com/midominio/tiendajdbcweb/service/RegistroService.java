/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.midominio.tiendajdbcweb.service;

import com.midominio.tiendajdbcweb.dao.ClienteDAO;
import com.midominio.tiendajdbcweb.excepciones.EmailRepetidoException;
import com.midominio.tiendajdbcweb.dao.ClienteDAOImpl;
import com.midominio.tiendajdbcweb.dto.ClienteDTO;
import com.midominio.tiendajdbcweb.excepciones.CamposRequeridosException;
import com.midominio.tiendajdbcweb.excepciones.PassNoCoincidenteException;
import com.midominio.tiendajdbcweb.modelo.Cliente;

/**
 *
 * @author Antonio
 */
public class RegistroService implements IRegistroService {

    private static final String EMAIL_ERROR = "El e-mail esta en uso";
    private static final String PASS_CONFIRM_ERROR = "El campo contraseña y confirmar contraseña no coincide";
    private final ClienteDAO cDAO;
    private final RecursosService rs;

    public RegistroService() {
        cDAO = new ClienteDAOImpl();
        rs = new RecursosService();
    }

    @Override
    public ClienteDTO registrar(String nombre, String apell1, String apell2, String telefono, String email, String pass, String confPass)
            throws CamposRequeridosException, PassNoCoincidenteException, EmailRepetidoException {
        comprobarRequeridos(nombre, apell1, email, pass, confPass, telefono);
        validarPass(pass, confPass);

        Cliente cliente = new Cliente(nombre, apell1, apell2, telefono, email, pass);
        if (!cDAO.alta(cliente)) {
            throw new EmailRepetidoException(EMAIL_ERROR);
        }

        //lo buscamos para tener el id
        return rs.clienteAclienteDTO(cDAO.buscarClienteEmail(email));

    }

    private boolean comprobarRequeridos(String nombre, String apell1, String email, String pass, String confPass, String tlf) throws CamposRequeridosException {
        String error = "";
        boolean nom = comprobarParametro(nombre);
        boolean ape1 = comprobarParametro(apell1);
        boolean ema = comprobarParametro(email);
        boolean contra = comprobarParametro(pass);
        boolean telefono = comprobarParametro(confPass);
        boolean confirma = comprobarParametro(tlf);
        if (nom && ape1 && ema && contra && confirma) {
            return true;
        }
        error += !nom ? "nombre " : "";
        error += !ape1 ? "primer apellido " : "";
        error += !ema ? "e-mail " : " ";
        error += !telefono ? "telefono " : "";
        error += !contra ? "contraseña " : "";
        error += !confirma ? "confirmar contraseña " : "";
        throw new CamposRequeridosException("Campo(s) requerido(s): " + error);
    }

    private boolean validarPass(String pass, String confPass) throws PassNoCoincidenteException {
        if (pass.equals(confPass)) {
            return true;
        }
        throw new PassNoCoincidenteException(PASS_CONFIRM_ERROR);
    }

    private boolean comprobarParametro(String param) {
        return param != null && !param.isEmpty();
    }

}
