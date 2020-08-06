package bean;

public class BeanGrupo {

    private int id_grupo;
    private String Token;
    private int Num_Alum;
    private int completado;
    private String grupo;
    private String cuatrimestre;
    private String carrera;
    private boolean estado;

    public BeanGrupo(){}

    public BeanGrupo(String token, int num_Alum, int completado, String grupo, String cuatrimestre, String carrera) {
        this.Token = token;
        this.Num_Alum = num_Alum;
        this.completado = completado;
        this.grupo = grupo;
        this.cuatrimestre = cuatrimestre;
        this.carrera = carrera;
    }

    public void setGrupo(String grupo){
        this.grupo = grupo;
    }

    public String getGrupo(){
        return this.grupo;
    }

    public int getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public int getNum_Alum() {
        return Num_Alum;
    }

    public void setNum_Alum(int num_Alum) {
        Num_Alum = num_Alum;
    }

    public int getCompletado() {
        return completado;
    }

    public void setCompletado(int completado) {
        this.completado = completado;
    }

    public String getCuatrimestre() {
        return cuatrimestre;
    }

    public void setCuatrimestre(String cuatrimestre) {
        this.cuatrimestre = cuatrimestre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public boolean getEstado(){
        return estado;
    }

    public void setEstado(boolean estado){
        this.estado = estado;
    }

}
