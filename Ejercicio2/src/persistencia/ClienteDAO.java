package persistencia;

import entidades.Cliente;
import entidades.Familia;
import java.util.ArrayList;
import java.util.Collection;

public class ClienteDAO extends DAO {

    public Collection<Cliente> consultarCliente() throws Exception {

        try {

            String sql = "SELECT id_cliente, nombre, calle, numero, codigo_postal, ciudad, pais, email FROM clientes ";
            consultarBase(sql);
            Cliente cliente = null;
            Collection<Cliente> clientes = new ArrayList();

            while (resultado.next()) {
                cliente.setId_cliente(resultado.getInt(1));
                cliente.setNombre(resultado.getString(2));
                cliente.setCalle(resultado.getString(3));
                cliente.setNumero(resultado.getInt(4));
                cliente.setCodigo_postal(resultado.getInt(5));
                clientes.add(cliente);
            }
            desconectarBase();
            return clientes;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }

    }

    public Cliente buscarClientePorId(int id_cliente) throws Exception {
        try {
            String sql = "SELECT * FROM Clientes WHERE id_cliente = " + id_cliente + "";
            consultarBase(sql);
            Cliente cliente = null;
            while (resultado.next()) {
                cliente = new Cliente();
                cliente.setId_cliente(resultado.getInt(1));
                cliente.setNombre(resultado.getString(2));
                cliente.setCalle(resultado.getString(3));
                cliente.setNumero(resultado.getInt(4));
                cliente.setCodigo_postal(resultado.getInt(5));
                cliente.setCiudad(resultado.getString(6));
                cliente.setPais(resultado.getString(7));
            }
            desconectarBase();
            return cliente;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
}
