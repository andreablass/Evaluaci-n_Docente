package modelo;

public class BeanPeriodos {
    int id;
    float Anio;
    String Nombre;


    public BeanPeriodos() {

    }
    public BeanPeriodos(int id,float Anio, String Nombre) {
        this.id = id;
        this.Anio = Anio;
        this.Nombre = Nombre;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getAnio() {
        return Anio;
    }

    public void setAnio(float Anio) {
        this.Anio = Anio;
    }

    public String getNombre() {
        return Nombre   ;
    }

    public void setNombre(String Nombre) { this.Nombre = Nombre; }

}