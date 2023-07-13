package servicios;

import persistencia.CasaDAO;

public class CasaServicios {

    private final CasaDAO cao = new CasaDAO();

    public void imprimirCasa() throws Exception {
        System.out.println(cao.consultarCasa());

    }

    public void imprimirConsultaB() throws Exception {
        System.out.println(cao.consultaB());
    }

    public void imprimirConsultaD() throws Exception {
        System.out.println(cao.consultaD());
    }
}
