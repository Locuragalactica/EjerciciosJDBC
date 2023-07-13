package persistencia;

import entidades.Fabricante;
import entidades.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

public class FabricanteDAO extends DAO {
//a) Lista el nombre de todos los productos que hay en la tabla producto.
//b) Lista los nombres y los precios de todos los productos de la tabla producto.
//c) Listar aquellos productos que su precio esté entre 120 y 202.
//d) Buscar y listar todos los Portátiles de la tabla producto.
//e) Listar el nombre y el precio del producto más barato.
//f) Ingresar un producto a la base de datos.
//g) Ingresar un fabricante a la base de datos
//h) Editar un producto con datos a elección.

    public Collection<Fabricante> consultarFabricantes() throws Exception {

        try {
            String sql = "SELECT codigo, nombre FROM Fabricante ";

            consultarBase(sql);

            Fabricante fabricante = null;

            Collection<Fabricante> fabricantes = new ArrayList();

            while (resultado.next()) {
                fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));
                fabricantes.add(fabricante);
            }
            desconectarBase();
            return fabricantes;

        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }

    }

    public Integer averiguarFabricantes(String nombre) throws Exception {

        try {
            String sql = "SELECT codigo, nombre FROM Fabricante WHERE nombre = " + nombre + ";";

            consultarBase(sql);
            Fabricante fabricante = new Fabricante();

            while (resultado.next()) {

                if (fabricante.getNombre().equals(nombre)) {
                    fabricante.setNombre(resultado.getString(2));
                    fabricante.setCodigo(resultado.getInt(1));
                }

            }
            desconectarBase();
            return fabricante.getCodigo();

        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }

    }

    public void ingresarFabricante(Fabricante fabricante) throws Exception {

        try {
            if (fabricante == null) {
                throw new Exception("Debe indicar el fabricante");
            }
            String sql = "INSERT INTO Fabricante (nombre) "
                    + "VALUES ('" + fabricante.getNombre() + "');";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            desconectarBase();
        }

    }
}
