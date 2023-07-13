
package tienda.entidades;


public class Fabricante {
    
    private int codigo;
    private String nombre;
    private String nacionalidad;

    public Fabricante() {
    }

    public Fabricante(int codigo, String nombre, String nacionalidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String toString() {
        return "Fabricante [" + "Codigo: " + codigo + ", Nombre: " + nombre + ", Nacionalidad: " + nacionalidad + ']';
    }

    
}
