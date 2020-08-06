package bean;

public class BeanPregunta {

    private int id;
    private String descripcion;

    public BeanPregunta(){}
    public BeanPregunta(int id, String descripcion){
        this.id = id;
        this.descripcion = descripcion;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    public int getId(){
        return this.id;
    }
    public String getDescripcion(){
        return this.descripcion;
    }

}
