package bean;

import java.text.DecimalFormat;

public class BeanReporte {

   private BeanPeriodo periodo;
   private BeanDocente docente;
   private double promedio;
   private int num_preguntas;
   private int num_alumnos;

    public BeanPeriodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(BeanPeriodo periodo) {
        this.periodo = periodo;
    }

    public BeanDocente getDocente() {
        return docente;
    }

    public void setDocente(BeanDocente docente) {
        this.docente = docente;
    }

    public double getPromedio() {
        DecimalFormat formateador = new DecimalFormat("####.##");
        return Double.parseDouble(formateador.format(promedio));
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public int getNum_preguntas() {
        return num_preguntas;
    }

    public void setNum_preguntas(int num_preguntas) {
        this.num_preguntas = num_preguntas;
    }

    public int getNum_alumnos() {
        return num_alumnos;
    }

    public void setNum_alumnos(int num_alumnos) {
        this.num_alumnos = num_alumnos;
    }
}
