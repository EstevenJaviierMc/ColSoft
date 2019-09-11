
package modelo;

public class ProgramaAcademico {
    private int idprogramaacademico;
    private String nombreprograma;
    private Facultad idfacultad;
    private String estado;

    public ProgramaAcademico(){
    
    }
    public ProgramaAcademico(String nombre,Facultad f,String estado){
        
        this.nombreprograma=nombre;
        this.idfacultad=f;
        this.estado=estado;
    }

    public ProgramaAcademico(String toString, String trim, String trim0, String trim1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return idprogramaacademico;
    }

    public void setId(int id) {
        this.idprogramaacademico = id;
    }

    public String getNombreprograma() {
        return nombreprograma;
    }

    public void setNombreprograma(String nombreprograma) {
        this.nombreprograma = nombreprograma;
    }

    public Facultad getIdfacultad() {
        return idfacultad;
    }

    public void setIdfacultad(Facultad idfacultad) {
        this.idfacultad = idfacultad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
