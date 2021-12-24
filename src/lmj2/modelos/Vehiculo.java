package lmj2.modelos;


public class Vehiculo {
    
    private String placa;
    private String marca;
    private int cc_usuario;

    public Vehiculo() {
    }

    public Vehiculo(String placa, String marca, int cc_usuario) {
        this.placa = placa;
        this.marca = marca;
        this.cc_usuario = cc_usuario;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCc_usuario() {
        return cc_usuario;
    }

    public void setCc_usuario(int cc_usuario) {
        this.cc_usuario = cc_usuario;
    }
    
    
    
}