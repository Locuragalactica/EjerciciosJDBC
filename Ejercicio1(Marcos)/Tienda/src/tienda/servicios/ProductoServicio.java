/*
Realizar un menú en Java a través del cual se permita elegir qué consulta se desea realizar.
Las consultas a realizar sobre la BD son las siguientes:
a) Lista el nombre de todos los productos que hay en la tabla producto.
b) Lista los nombres y los precios de todos los productos de la tabla producto.
c) Listar aquellos productos que su precio esté entre 120 y 202.
d) Buscar y listar todos los Portátiles de la tabla producto.
e) Listar el nombre y el precio del producto más barato.
f) Ingresar un producto a la base de datos.
g) Ingresar un fabricante a la base de datos
h) Editar un producto con datos a elección.
*/

package tienda.servicios;

import java.util.Collection;
import java.util.Scanner;
import tienda.entidades.Producto;
import tienda.persistencia.ProductoDAO;

public class ProductoServicio {
    
    private ProductoDAO dao;
    
    FabricanteServicio fabServ = new FabricanteServicio();

    public ProductoServicio() {
        this.dao = new ProductoDAO();
    }
    
    public Collection<Producto> listarTodosProductos() throws Exception {

        try {

            Collection<Producto> productos = dao.listarProductos();

            return productos;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirProductosPorNombre() throws Exception {

        try {

            //Listamos los usuarios
            Collection<Producto> productos = listarTodosProductos();

            //Imprimimos los usuarios
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                System.out.println("PRODUCTOS POR NOMBRE: ");
                System.out.println("--------------------");
                for (Producto p : productos) {
                    System.out.println(p.getNombre());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void imprimirProductosPorNombreYPrecio() throws Exception {

        try {

            //Listamos los usuarios
            Collection<Producto> productos = listarTodosProductos();

            //Imprimimos los usuarios
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                System.out.println("PRODUCTOS POR NOMBRE Y PRECIO: ");
                System.out.println("-----------------------------");
                for (Producto p : productos) {
                    System.out.println(p.getNombre() + "  -  " + p.getPrecio());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    //////////////////
    
    public Collection<Producto> listarTodosProductosPorRangoPrecio() throws Exception {

        try {

            Collection<Producto> productos = dao.buscarProductoPorRangoPrecio();

            return productos;
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    
    public void imprimirProductosPorRangoPrecio() throws Exception {

        try {

            //Listamos los usuarios
            Collection<Producto> productos = listarTodosProductosPorRangoPrecio();

            //Imprimimos los usuarios
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                System.out.println("PRODUCTOS POR NOMBRE Y PRECIO (120 - 202): ");
                System.out.println("-----------------------------");
                for (Producto p : productos) {
                    System.out.println(p.getNombre() + "  -  " + p.getPrecio());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    ////////////////////
    
    public Collection<Producto> listarProductosPortatil() throws Exception {

        try {

            Collection<Producto> productos = dao.buscarProductoPortatil();

            return productos;
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    
    public void imprimirProductosPortatil() throws Exception {

        try {

            //Listamos los usuarios
            Collection<Producto> productos = listarProductosPortatil();

            //Imprimimos los usuarios
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                System.out.println("PRODUCTOS PORTATIL: ");
                System.out.println("-----------------------------");
                for (Producto p : productos) {
                    System.out.println(p.getNombre());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    /////////////////
    
    public Collection<Producto> listarProductosNombreYPrecioBarato() throws Exception {

        try {

            Collection<Producto> productos = dao.buscarProductoPorNombreYPrecioBarato();

            return productos;
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    
    public void imprimirProductosNombreYPrecioBarato() throws Exception {

        try {

            //Listamos los usuarios
            Collection<Producto> productos = listarProductosNombreYPrecioBarato();

            //Imprimimos los usuarios
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                System.out.println("PRODUCTOS NOMBRE Y PRECIO MAS BARATO: ");
                System.out.println("--------------------------------");
                for (Producto p : productos) {
                    System.out.println(p.getNombre() + " " + p.getPrecio());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    ////////////////////
    
    public void crearProducto(String nombre, Double precio, Integer codigoFabricante) throws Exception {
        
        try {
            //Validamos
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre del producto");
            }           
            if (precio == null) {
                throw new Exception("Debe indicar el precio del producto");
            }
            if (codigoFabricante == null) {
                throw new Exception("Debe indicar el codigo del fabricante");
            }
        
            //Creamos el producto
            Producto producto = new Producto();
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCodigoFabricante(codigoFabricante);
            dao.guardarProducto(producto);
                                     
        } catch (Exception e) {
            throw e;
        }
               
    }
    
    public void eliminarProducto(String nombre) throws Exception {

        try {

            //Validamos 
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre del producto");
            }

            dao.eliminarProducto(nombre);
        } catch (Exception e) {
            throw e;
        }
    }
    
    //////////////////////
    
    public Producto buscarProductoPorNombre(String nombre) throws Exception {
        
        try {
            //Validamos
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre del producto");
            }
            
            Producto producto = dao.buscarProductoPorNombre(nombre);
            
            return producto;
            
        } catch (Exception e) {
            throw e;
        }
         
    }
    
    
    public void modificarProductoPorPrecio(String nombre, Double precioActual, Double precioNuevo) throws Exception {

        try {

            //Validamos
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre del producto");
            }

            if (precioActual == null) {
                throw new Exception("Debe indicar el precio actual");
            }

            if (precioNuevo == null) {
                throw new Exception("Debe indicar el precio nuevo");
            }

            //Buscamos
            Producto producto = buscarProductoPorNombre(nombre);


            //Modificamos
            producto.setPrecio(precioNuevo);

            dao.modificarProducto(producto);
        } catch (Exception e) {
            throw e;
        }
    }
    
    /////////////
    
    private Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public void menu() throws Exception {
        System.out.println("");
        System.out.println("----- MENU -----");
        System.out.println("Seleccione una opcion: ");
        System.out.println("1. Imprimir productos por nombre");
        System.out.println("2. Imprimir productos por nombre y precio");
        System.out.println("3. Imprimir productos por rango de precio (120/202)");
        System.out.println("4. Imprimir productos portatiles");
        System.out.println("5. Imprimir productos por nombre y precio mas barato");
        System.out.println("6. Crear producto: TV Led, 200.0, 4");
        System.out.println("7. Eliminar producto: TV Led");
        System.out.println("8. Modificar producto por precio: TV Led, 250.0, 4");
        System.out.println("9. Imprimir fabricante por nombre");
        System.out.println("10. Crear fabricante");
        System.out.println("11. Eliminar fabricante");
        System.out.println("12. Salir del programa");
        System.out.print("Opcion: ");       
        String opc = leer.next();
        System.out.println("");
        switch (opc) {
            case "1":
                imprimirProductosPorNombre();             
                menu();
                break;
            case "2":
                imprimirProductosPorNombreYPrecio();
                menu();
                break;
            case "3":
                imprimirProductosPorRangoPrecio();
                menu();
                break;
            case "4":
                imprimirProductosPortatil();
                menu();
                break;
            case "5":
                imprimirProductosNombreYPrecioBarato();
                menu();
                break;
            case "6":
                crearProducto("TV Led", 200.0, 4);
                menu();
                break;
            case "7":
                eliminarProducto("TV Led");
                menu();
                break;
            case "8":
                modificarProductoPorPrecio("TV Led", 200.0, 250.0);
                menu();
                break;
            case "9":
                fabServ.imprimirFabricantesPorNombre();
                menu();
                break;
            case "10":
                fabServ.crearFabricante();
                menu();
                break;
            case "11":
                fabServ.eliminarFabricante();
                menu();
                break;
            case "12":
                System.out.println("Ejecuci�n finalizada");
                break;
            default:
                System.out.println("Opcion no v�lida");
                ;
                menu();
        } 

    }

    
}
