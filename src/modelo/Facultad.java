package modelo;

public class Facultad {

    private int idFacultad;
    private String nombre;
    private String estado;
    
    public Facultad() { }

    public Facultad(String nombre, String estado) {
        this.nombre = nombre;
        this.estado = estado;
    }

    public int getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(int idFacultad) {
        this.idFacultad = idFacultad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String toString() {
        return "Facultad nº " + idFacultad + "; " + "Nombre: " + nombre + ", Estado: " + estado + ".";
    }
}
