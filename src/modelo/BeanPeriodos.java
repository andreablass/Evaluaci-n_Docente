package modelo;

public class BeanPeriodos {
    int Id;
    float Anio;
    String Nombre;


    public BeanPeriodos() {

    }
    public BeanPeriodos(int Id,float Anio, String Nombre) {
        this.Id = Id;
        this.Anio = Anio;
        this.Nombre = Nombre;

    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
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

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }


}