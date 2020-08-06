package bean;

public class BeanPeriodo {

    private int id;
    private String Fecha_inicio;
    private String Fecha_fin;
    private int Estado;
    private String nombre;

    public BeanPeriodo(){}

    public BeanPeriodo(int id, String fecha_inicio, String fecha_fin, int estado, String nombre) {
        this.id = id;
        Fecha_inicio = fecha_inicio;
        Fecha_fin = fecha_fin;
        Estado = estado;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha_inicio() {
        return Fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        Fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return Fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        Fecha_fin = fecha_fin;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int estado) {
        Estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
