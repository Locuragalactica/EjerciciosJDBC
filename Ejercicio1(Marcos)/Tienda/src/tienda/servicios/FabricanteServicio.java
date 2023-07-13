
package tienda.servicios;

import java.util.Collection;
import java.util.Scanner;
import tienda.entidades.Fabricante;
import tienda.persistencia.FabricanteDAO;


public class FabricanteServicio {
    
    private FabricanteDAO dao;

    public FabricanteServicio() {
        this.dao = new FabricanteDAO();
    }
    
    
    public Collection<Fabricante> listarTodosFabricantes() throws Exception {

        try {

            Collection<Fabricante> fabricantes = dao.listarFabricantes();

            return fabricantes;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirFabricantesPorNombre() throws Exception {

        try {

            //Listamos los usuarios
            Collection<Fabricante> fabricantes = listarTodosFabricantes();

            //Imprimimos los usuarios
            if (fabricantes.isEmpty()) {
                throw new Exception("No existen fabricantes para imprimir");
            } else {
                System.out.println("FABRICANTES POR NOMBRE: ");
                System.out.println("----------------------");
                for (Fabricante f : fabricantes) {
                    System.out.println(f.getNombre());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    ////////////////////
    
    public void crearFabricante() throws Exception {
        
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingresar los datos del fabricante");
        System.out.print("Nombre: ");
        String nombre = leer.next();
        System.out.print("Nacionalidad: ");
        String nacionalidad = leer.next();
        
        try {
            //Validamos
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre del fabricante");
            }           
            if (nacionalidad == null) {
                throw new Exception("Debe indicar la nacionalidad del fabricante");
            }          
        
            //Creamos el producto
            Fabricante fabricante = new Fabricante();
            fabricante.setNombre(nombre);
            fabricante.setNacionalidad(nacionalidad);           
            dao.guardarFabricante(fabricante);
                                     
        } catch (Exception e) {
            throw e;
        }
               
    }
    
    public void eliminarFabricante() throws Exception {
        
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese el nombre del fabricante a eliminar");
        System.out.print("Nombre: ");
        String nombre = leer.next();

        try {

            //Validamos 
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre del fabricante");
            }

            dao.eliminarFabricante(nombre);
        } catch (Exception e) {
            throw e;
        }
    }
    
}
