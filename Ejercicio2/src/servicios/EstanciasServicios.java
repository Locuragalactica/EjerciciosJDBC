package servicios;

import persistencia.EstanciaDAO;

public class EstanciasServicios {

    EstanciaDAO eao = new EstanciaDAO();

    public void imprimirEstancia() throws Exception {
        System.out.println(eao.consultarEstancia());

    }
}
