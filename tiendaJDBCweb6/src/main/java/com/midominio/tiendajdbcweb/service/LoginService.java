
package com.midominio.tiendajdbcweb.service;

import com.midominio.tiendajdbcweb.dao.ClienteDAO;
import com.midominio.tiendajdbcweb.dao.ClienteDAOImpl;
import com.midominio.tiendajdbcweb.dto.ClienteDTO;
import com.midominio.tiendajdbcweb.excepciones.PassIncorrectaException;
import com.midominio.tiendajdbcweb.excepciones.UsuarioNoEncontradoException;
import com.midominio.tiendajdbcweb.modelo.Cliente;

public class LoginService implements ILoginService {
    private final RecursosService rs;
    private final ClienteDAO cDAO;
    private static final String EMAIL_ERROR="Email incorrecto";
    private static final String PASS_ERROR="La contraseña es incorrecta";

	public LoginService() {
		cDAO = new ClienteDAOImpl();
		rs=new RecursosService();
	}
	@Override
    public ClienteDTO login(String email, String pass) throws UsuarioNoEncontradoException, PassIncorrectaException { 
        Cliente cliente = cDAO.buscarClienteEmail(email);
        return rs.clienteAclienteDTO(validarLogin(cliente, pass));

    }

    private Cliente validarLogin(Cliente cliente, String pass) throws PassIncorrectaException, UsuarioNoEncontradoException{
        if (cliente != null) {
            //email ok

            if (cliente.getPass().equals(pass)) {
                //pass ok
                return cliente;
            }else{
                throw new PassIncorrectaException(PASS_ERROR);
            }

        }else{
            throw new UsuarioNoEncontradoException(EMAIL_ERROR);
        }
    }
}
