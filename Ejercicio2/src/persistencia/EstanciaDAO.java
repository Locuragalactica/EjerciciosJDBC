package persistencia;

import entidades.Estancia;
import entidades.Familia;
import java.util.ArrayList;
import java.util.Collection;

public class EstanciaDAO extends DAO {

    public Collection<Estancia> consultarEstancia() throws Exception {

        try {
            String sql = "SELECT id_estancia, id_cliente, id_casa, nombre_huesped, fecha_desde, fecha_hasta FROM estancias ";
            consultarBase(sql);
            Estancia estancia = null;
            Collection<Estancia> estancias = new ArrayList();

            while (resultado.next()) {
                estancia = new Estancia();

                estancias.add(estancia);
            }
            desconectarBase();
            return estancias;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }

    }

    public Collection<Estancia> consultaE() throws Exception {
        try {
            String sql = "SELECT id_estancia, id_cliente, id_casa FROM estancias ";
            consultarBase(sql);
            Estancia estancia = null;
            Collection<Estancia> estancias = new ArrayList();

            while (resultado.next()) {
                estancia = new Estancia();
                estancia.setId_estancia(resultado.getInt(1));

                estancias.add(estancia);
            }
            desconectarBase();
            return estancias;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }
}
