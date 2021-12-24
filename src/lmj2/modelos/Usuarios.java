/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lmj2.modelos;

/**
 *
 * @author johns
 */
public class Usuarios {
    
    private int cedula;
    private String nombres;
    private String fijo;
    private String movil;

    public Usuarios() {
    }

    public Usuarios(int cedula, String nombres, String fijo, String movil) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.fijo = fijo;
        this.movil = movil;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getFijo() {
        return fijo;
    }

    public void setFijo(String fijo) {
        this.fijo = fijo;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }
    
    
}
