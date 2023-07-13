
package tienda;

import tienda.servicios.FabricanteServicio;
import tienda.servicios.ProductoServicio;


public class Tienda {


    public static void main(String[] args) {
        
        ProductoServicio productoService = new ProductoServicio();
        FabricanteServicio fabricanteService = new FabricanteServicio();
    
        
        try {
            //Imprimo los productos por nombre            
            /*productoService.imprimirProductosPorNombre();
            
            productoService.imprimirProductosPorNombreYPrecio();
            
            productoService.imprimirProductosPorRangoPrecio();
            
            productoService.imprimirProductosPortatil();
            
            productoService.imprimirProductosNombreYPrecioBarato();
            
            productoService.crearProducto("TV Led", 200.0, 4);
            
            productoService.eliminarProducto("TV Led");
            
            productoService.imprimirProductosPorNombreYPrecio();
            
            productoService.modificarProductoPorPrecio("TV Led", 200.0, 250.0);
            
            productoService.imprimirProductosPorNombreYPrecio();
            
            fabricanteService.imprimirFabricantesPorNombre();*/
            
            productoService.menu();
   
        } catch (Exception e) {           
            e.printStackTrace();
            System.out.println("Error del sistema por \n" + e.getMessage());
            
        }
        
    }
    
}
