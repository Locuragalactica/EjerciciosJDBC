package persistencia;

import entidades.Familia;
import java.util.ArrayList;
import java.util.Collection;

public class FamiliaDAO extends DAO {

    public Collection<Familia> consultarFamilia() throws Exception {

        try {
            String sql = "SELECT nombre, edad_minima, edad_maxima, num_hijos, email FROM Familias ";
            consultarBase(sql);
            Familia familia = null;
            Collection<Familia> familias = new ArrayList();

            while (resultado.next()) {
                familia = new Familia();
                familia.setNombre(resultado.getString(1));
                familia.setEdad_minima(resultado.getInt(2));
                familia.setEdad_maxima(resultado.getInt(3));
                familia.setNum_hijos(resultado.getInt(4));
                familia.setEmail(resultado.getString(5));
                familias.add(familia);
            }
            desconectarBase();
            return familias;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }

    }

    public Collection<Familia> consultaA() throws Exception {

        try {
            String sql = "SELECT nombre,edad_maxima, num_hijos FROM Familias WHERE num_hijos >= 3 AND edad_maxima < 10";
            consultarBase(sql);
            Familia familia = null;
            Collection<Familia> familias = new ArrayList();

            while (resultado.next()) {
                familia = new Familia();
                familia.setNombre(resultado.getString(1));
                familia.setEdad_maxima(resultado.getInt(2));
                familia.setNum_hijos(resultado.getInt(3));
                familias.add(familia);
            }
            desconectarBase();
            return familias;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }

    }

    public Collection<Familia> consultaC() throws Exception {

        try {
            String sql = "SELECT nombre, email FROM Familias WHERE email LIKE '%Hotmail%';";
            consultarBase(sql);
            Familia familia = null;
            Collection<Familia> familias = new ArrayList();

            while (resultado.next()) {
                familia = new Familia();
                familia.setNombre(resultado.getString(1));
                familia.setEmail(resultado.getString(2));
                familias.add(familia);
            }
            desconectarBase();
            return familias;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }

    }

}
