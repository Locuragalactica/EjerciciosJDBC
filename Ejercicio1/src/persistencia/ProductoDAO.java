package persistencia;

import entidades.Producto;
import java.util.ArrayList;
import java.util.Collection;

public final class ProductoDAO extends DAO {
//a) Lista el nombre de todos los productos que hay en la tabla producto.
//b) Lista los nombres y los precios de todos los productos de la tabla producto.
//c) Listar aquellos productos que su precio esté entre 120 y 202.
//d) Buscar y listar todos los Portátiles de la tabla producto.
//e) Listar el nombre y el precio del producto más barato.
//f) Ingresar un producto a la base de datos.
//g) Ingresar un fabricante a la base de datos
//h) Editar un producto con datos a elección.

    public Collection<Producto> consultarProductos() throws Exception {

        try {
            String sql = "SELECT codigo, nombre, precio, codigo_fabricante FROM Producto ";

            consultarBase(sql);

            Producto producto = null;

            Collection<Producto> productos = new ArrayList();

            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getInt(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                productos.add(producto);
            }
            desconectarBase();
            return productos;

        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }

    }

    public Producto consultarProductosPorID(int id) throws Exception {

        try {
            String sql = "SELECT codigo, nombre, precio, codigo_fabricante FROM Producto WHERE codigo = " + id;

            consultarBase(sql);

            Producto producto = null;

            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getInt(3));
                producto.setCodigoFabricante(resultado.getInt(4));

            }
            desconectarBase();
            return producto;

        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }

    }

    public Collection<Producto> consultarNombrePrecio() throws Exception {

        try {
            String sql = "SELECT nombre, precio FROM Producto ";

            consultarBase(sql);

            Producto producto = null;

            Collection<Producto> productos = new ArrayList();

            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getInt(2));
                productos.add(producto);
            }
            desconectarBase();
            return productos;

        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }

    }

    public Collection<Producto> consultarPrecioEntre() throws Exception {

        try {
            String sql = "SELECT nombre, precio FROM Producto WHERE precio between 120 and 202 ";

            consultarBase(sql);

            Producto producto = null;

            Collection<Producto> productos = new ArrayList();

            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getInt(2));
                productos.add(producto);
            }
            desconectarBase();
            return productos;

        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }

    }

    public Collection<Producto> consultarPortatiles() throws Exception {

        try {
            String sql = "SELECT nombre, precio FROM Producto WHERE nombre like '%Portatíl%'";

            consultarBase(sql);

            Producto producto = null;

            Collection<Producto> productos = new ArrayList();

            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getInt(2));
                productos.add(producto);
            }
            desconectarBase();
            return productos;

        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }

    }

    public Collection<Producto> consultarMasBarato() throws Exception {

        try {
            String sql = "SELECT nombre, precio FROM Producto order by precio ASC LIMIT 1";

            consultarBase(sql);

            Producto producto = null;

            Collection<Producto> productos = new ArrayList();

            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getInt(2));
                productos.add(producto);
            }
            desconectarBase();
            return productos;

        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }

    }

    public void ingresarProducto(Producto producto) throws Exception {

        try {
            if (producto == null) {
                throw new Exception("Debe indicar el producto");
            }
            String sql = "INSERT INTO Producto (nombre, precio, codigo_fabricante) "
                    + "VALUES ( '" + producto.getNombre() + "' , '" + producto.getPrecio() + "' ," + producto.getCodigoFabricante() + " );";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }

    }

    public void modificarProducto(Producto producto) throws Exception {

        try {
            if (producto == null) {
                throw new Exception("Debe indicar el producto");
            }
            String sql = "UPDATE Producto SET nombre= '" + producto.getNombre() + "', precio= " + producto.getPrecio() + ", codigo_fabricante= " + producto.getCodigoFabricante() + " WHERE codigo = " + producto.getCodigo();
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }

    }
}
