package persistencia;

import entidades.Casa;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

public class CasaDAO extends DAO {

    public Collection<Casa> consultarCasa() throws Exception {

        try {
            String sql = "SELECT id_casa, calle, numero, codigo_postal, ciudad, pais,fecha_desde, fecha_hasta, tiempo_minimo, tiempo_maximo, precio_habitacion, tipo_vivienda  FROM casas ";
            consultarBase(sql);
            Casa casa = null;
            Collection<Casa> casas = new ArrayList();

            while (resultado.next()) {
                casa = new Casa();
                casa.setId_casa(resultado.getInt(1));
                casa.setCalle(resultado.getString(2));
                casa.setNumero(resultado.getInt(3));
                casa.setCodigo_postal(resultado.getInt(4));
                casa.setCiudad(resultado.getString(5));
                casa.setPais(resultado.getString(6));
                casa.setFecha_desde(resultado.getDate(7));
                casa.setFecha_hasta(resultado.getDate(8));
                casa.setTiempo_minimo(resultado.getInt(9));
                casa.setTiempo_maximo(resultado.getInt(10));
                casa.setPrecio_habitacion(resultado.getDouble(11));
                casa.setTipo_vivienda(resultado.getString(12));
                casas.add(casa);
            }
            desconectarBase();
            return casas;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }

    }

    public Collection<Casa> consultaB() throws Exception {

        try {
            String sql = "SELECT id_casa, calle, pais, numero,fecha_desde, fecha_hasta FROM casas WHERE fecha_desde >= '2020-08-01' AND fecha_hasta <= '2020-08-31' AND pais LIKE 'Reino Unido'";
            consultarBase(sql);
            Casa casa = null;
            Collection<Casa> casas = new ArrayList();

            while (resultado.next()) {
                casa = new Casa();
                casa.setId_casa(resultado.getInt(1));
                casa.setCalle(resultado.getString(2));
                casa.setPais(resultado.getString(3));
                casa.setNumero(resultado.getInt(4));
                casa.setFecha_desde(resultado.getDate(5));
                casa.setFecha_hasta(resultado.getDate(6));
                casas.add(casa);
            }
            desconectarBase();
            return casas;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }

    }

    public Collection<Casa> consultaD() throws Exception {

        try {
            Scanner leer = new Scanner(System.in).useDelimiter("\n");
            System.out.println("Ingrese las casas disponibles");
            System.out.println("Ingrese la fecha en formato: AAAA-MM-DD");
            String fechaIngresada = leer.next();
            System.out.println("Cantidad de dias");
            int dias = leer.nextInt();
            DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaInicio = formatoFecha.parse(fechaIngresada);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fechaInicio);
            calendar.add(Calendar.DAY_OF_YEAR, dias);
            Date fechaFinal = calendar.getTime();
            java.sql.Date fechaFinalsql = new java.sql.Date(fechaFinal.getTime());

            String sql = "SELECT id_casa, fecha_desde, fecha_hasta, tiempo_minimo, tiempo_maximo "
                    + "FROM casas "
                    + "WHERE fecha_desde <= '" + fechaIngresada + "'"
                    + "AND fecha_hasta >= '" + fechaFinalsql + "'"
                    + "AND tiempo_minimo <='" + dias + "'"
                    + "AND tiempo_maximo >='" + dias + "'";
            consultarBase(sql);
            Casa casa = null;
            Collection<Casa> casas = new ArrayList();

            while (resultado.next()) {
                casa = new Casa();
                casa.setId_casa(resultado.getInt(1));
                casa.setFecha_desde(resultado.getDate(2));
                casa.setFecha_hasta(resultado.getDate(3));
                casa.setTiempo_minimo(resultado.getInt(4));
                casa.setTiempo_maximo(resultado.getInt(5));
                casas.add(casa);
            }
            desconectarBase();
            return casas;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }

    }
}
