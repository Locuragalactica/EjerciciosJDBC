package servicios;

import persistencia.FamiliaDAO;

public class FamiliaServicios {

    private final FamiliaDAO fao = new FamiliaDAO();

    public void imprimirFamilia() throws Exception {
        System.out.println(fao.consultarFamilia());

    }

    public void imprimirConsultaA() throws Exception {
        System.out.println(fao.consultaA());
    }

    public void imprimirConsultaC() throws Exception {
        System.out.println(fao.consultaC());
    }
}
