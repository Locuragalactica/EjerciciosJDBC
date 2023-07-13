package servicios;

import entidades.Fabricante;
import entidades.Producto;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import persistencia.FabricanteDAO;
import persistencia.ProductoDAO;

public class ProductoServicio {
//a) Lista el nombre de todos los productos que hay en la tabla producto.
//b) Lista los nombres y los precios de todos los productos de la tabla producto.
//c) Listar aquellos productos que su precio esté entre 120 y 202.
//d) Buscar y listar todos los Portátiles de la tabla producto.
//e) Listar el nombre y el precio del producto más barato.
//f) Ingresar un producto a la base de datos.
//g) Ingresar un fabricante a la base de datos
//h) Editar un producto con datos a elección.

    private ProductoDAO dao = new ProductoDAO();
    private FabricanteDAO fao = new FabricanteDAO();

    public void menu() throws Exception {
        Scanner leer = new Scanner(System.in);
        int rta;
        String rta2 = "";
        do {
            System.out.println("\u001B[41m ----------MENU----------");
            System.out.println("\u001B[41m");
            System.out.println("\u001B[41m1- Consultar Listado Completo de Productos");
            System.out.println("\u001B[41m2- Consultar Nombre y Precio de Productos");
            System.out.println("\u001B[41m3- Consultar Productos entre $120 y $202");
            System.out.println("\u001B[41m4- Consultar todas las Portatiles");
            System.out.println("\u001B[41m5- Producto más barato");
            System.out.println("\u001B[41m6- Ingresar un Producto Nuevo");
            System.out.println("\u001B[41m7- Consultar Fabricantes");
            System.out.println("\u001B[41m8- Editar Producto");
            System.out.println("\u001B[41m9- Salir");

            rta = leer.nextInt();
            if (rta == 9) {
                System.out.println("¿Esta seguro que desea salir? S/N");
                rta2 = leer.next();
                if (rta2.equals("s")) {
                    break;
                }
            }
            switch (rta) {
                case 1:
                    System.out.println("-------------------------------------");
                    System.out.println(dao.consultarProductos());

                    System.out.println("-------------------------------------");
                    break;
                case 2:
                    System.out.println("-------------------------------------");
                    System.out.println(dao.consultarNombrePrecio());
                    System.out.println("-------------------------------------");
                    break;
                case 3:
                    System.out.println("-------------------------------------");
                    System.out.println(dao.consultarPrecioEntre());
                    System.out.println("-------------------------------------");
                    break;
                case 4:
                    System.out.println("-------------------------------------");
                    System.out.println(dao.consultarPortatiles());
                    System.out.println("-------------------------------------");
                    break;
                case 5:
                    System.out.println("-------------------------------------");
                    System.out.println(dao.consultarMasBarato());
                    System.out.println("-------------------------------------");
                    break;
                case 6:
                    System.out.println("-------------------------------------");
                    Producto p1 = new Producto();
                    System.out.println("Ingrese el nombre del producto");
                    p1.setNombre(leer.next());
                    System.out.println("Ingrese el precio del producto");
                    p1.setPrecio(leer.nextInt());
                    System.out.println("Ingrese el nombre del Fabricante");
                    String marca = leer.next();
                    boolean presente = false;
                    List<Fabricante> fs = new ArrayList();
                    fs.addAll(fao.consultarFabricantes());

                    for (Fabricante aux : fs) {
                        if (aux.getNombre().equals(marca)) {
                            p1.setCodigo(aux.getCodigo());
                            presente = true;
                            break;
                        }
                    }
                    if (!presente) {
                        Fabricante f1 = new Fabricante();
                        f1.setNombre(marca);
                        fao.ingresarFabricante(f1);
                        fs.clear();
                        fs.addAll(fao.consultarFabricantes());
                        p1.setCodigoFabricante(fs.get(fs.size() - 1).getCodigo());
                    }
                    dao.ingresarProducto(p1);
                    System.out.println("-------------------------------------");
                    break;

                case 7:
                    System.out.println("-------------------------------------");
                    System.out.println(fao.consultarFabricantes());
                    System.out.println("-------------------------------------");
                    break;
                case 8:
                    System.out.println("-------------------------------------");
                    Producto p2 = new Producto();
                    System.out.println(dao.consultarProductos());
                    System.out.println(" ");
                    System.out.println("Seleccione el Codigo del Producto que desea modificar");
                    int codigo = leer.nextInt();
                    p2 = dao.consultarProductosPorID(codigo);
                    System.out.println(" ");
                    System.out.println("Su producto seleccionado es " + p2);
                    System.out.println("Ingrese el nuevo nombre del producto: ");
                    p2.setNombre(leer.next());
                    System.out.println("Ingrese el nuevo precio del producto: ");
                    p2.setPrecio(leer.nextInt());
                    System.out.println("Ingrese el nuevo codigo del fabricante del producto: ");
                    p2.setCodigoFabricante(leer.nextInt());
                    dao.modificarProducto(p2);
                    System.out.println(" ");
                    System.out.println("Producto Modificado");
                    System.out.println("-------------------------------------");
                    break;

            }

        } while (!rta2.equals("s"));

    }

}
