
package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Fabricante;

public final class FabricanteDAO extends DAO{
    
    public Collection<Fabricante> listarFabricantes() throws Exception {
        
        try {
            String sql = "SELECT nombre, nacionalidad FROM Fabricante ";
            
            consultarBase(sql);
            
            Fabricante fabricante = null;
            
            Collection<Fabricante> fabricantes = new ArrayList();
            
            while (resultado.next()) {                
                fabricante = new Fabricante();
                fabricante.setNombre(resultado.getString(1));
                fabricante.setNacionalidad(resultado.getString(2));               
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
    
    public void guardarFabricante(Fabricante fabricante) throws Exception {
        
        try {
            if (fabricante == null) {
                throw new Exception("Debe indicar un fabricante");
            }
            
            String sql = "INSERT INTO fabricante (nombre, nacionalidad)"
                    + "VALUES ( '" + fabricante.getNombre() + "' , '" + fabricante.getNacionalidad()+ "' );";
            
            insertarModificarEliminar(sql);
            
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public void eliminarFabricante(String nombre) throws Exception {
        
        try {
            
            String sql = "DELETE FROM fabricante WHERE nombre = '" + nombre + "'";
            
            insertarModificarEliminar(sql);
            
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    
    
}
