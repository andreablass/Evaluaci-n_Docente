package modelo;

public class BeanDocente {
    String id_Matricula;
    String nombre;
    String apellidoP;
    String apellidoM;


    public BeanDocente() {

    }
    public BeanDocente(String id_Matricula,String nombre, String apellidoP, String apellidoM) {
        this.id_Matricula = id_Matricula;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellidoP;
    }

    public void setApellido1(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellido2() {
        return apellidoM;
    }
    public void setApellido2(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getId_Matricula() {
        return id_Matricula;
    }

    public void setId_Matricula(String id_Matricula) {
        this.id_Matricula = id_Matricula;
    }

}
