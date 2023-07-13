
package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Producto;

public final class ProductoDAO extends DAO {
    
    public Collection<Producto> listarProductos() throws Exception {
        
        try {
            String sql = "SELECT nombre, precio, codigo_fabricante FROM Producto ";
            
            consultarBase(sql);
            
            Producto producto = null;
            
            Collection<Producto> productos = new ArrayList();
            
            while (resultado.next()) {                
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getInt(2));
                producto.setCodigoFabricante(resultado.getInt(3));
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
    
    public Collection<Producto> buscarProductoPorRangoPrecio() throws Exception {
        
        try {
            String sql = "SELECT nombre, precio, codigo_fabricante FROM Producto"
                    + " WHERE precio BETWEEN 120 AND 202";
            
            consultarBase(sql);
            
            Producto producto = null;
            
            Collection<Producto> productos = new ArrayList();
            
            while (resultado.next()) {                
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getInt(2));
                producto.setCodigoFabricante(resultado.getInt(3));
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
    
    
    public Collection<Producto> buscarProductoPortatil() throws Exception {
        
        try {
            String sql = "SELECT nombre, precio, codigo_fabricante FROM Producto"
                    + " WHERE nombre like '%Portatil%'";
            
            consultarBase(sql);
            
            Producto producto = null;
            
            Collection<Producto> productos = new ArrayList();
            
            while (resultado.next()) {                
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getInt(2));
                producto.setCodigoFabricante(resultado.getInt(3));
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
    
    
    public Collection<Producto> buscarProductoPorNombreYPrecioBarato() throws Exception {
        
        try {
            String sql = "SELECT nombre, precio, codigo_fabricante FROM Producto"
                    + " ORDER BY precio ASC LIMIT 1";
            
            consultarBase(sql);
            
            Producto producto = null;
            
            Collection<Producto> productos = new ArrayList();
            
            while (resultado.next()) {                
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getInt(2));
                producto.setCodigoFabricante(resultado.getInt(3));
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
    
    ////////////
    
    public void guardarProducto(Producto producto) throws Exception {
        
        try {
            if (producto == null) {
                throw new Exception("Debe indicar un producto");
            }
            
            String sql = "INSERT INTO Producto (nombre, precio, codigo_fabricante)"
                    + "VALUES ( '" + producto.getNombre() + "' , '" + producto.getPrecio() + "' , " + producto.getCodigoFabricante() + " );";
            
            insertarModificarEliminar(sql);
            
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public void eliminarProducto(String nombre) throws Exception {
        
        try {
            
            String sql = "DELETE FROM Producto WHERE nombre = '" + nombre + "'";
            
            insertarModificarEliminar(sql);
            
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    ////////////
    
    public void modificarProducto(Producto producto) throws Exception {
        
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el producto que desea modificar");
            }
            
            String sql = "UPDATE Producto SET "
                    + "precio = '" + producto.getPrecio() + "' WHERE nombre = '" + producto.getNombre()+ "'";
            
            insertarModificarEliminar(sql);
            
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public Producto buscarProductoPorNombre(String nombre) throws Exception {
        
        try {
            String sql = "SELECT nombre, precio FROM Producto"
                    + " WHERE nombre = '" + nombre + "'";
            
            consultarBase(sql);
            
            Producto producto = null;
            
            while (resultado.next()) {                
                producto = new Producto();
                //usuario.setId(resultado.getInt("id"));               
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getInt(2));               
            }
            desconectarBase();
            return producto;
            
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
  
    }
    
    
    
}
