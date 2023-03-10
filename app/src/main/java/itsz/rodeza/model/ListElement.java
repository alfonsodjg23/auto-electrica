package itsz.rodeza.model;

public class ListElement {
    private String titulo;
    public String portada;
    public String cuidad;
    public String status;


    public ListElement(String titulo,String cuidad,String status,String portada) {
        this.titulo=titulo;
        this.portada=portada;
        this.cuidad = cuidad;
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }


    public String getCuidad() {
        return cuidad;
    }

    public void setCuidad(String cuidad) {
        this.cuidad = cuidad;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}