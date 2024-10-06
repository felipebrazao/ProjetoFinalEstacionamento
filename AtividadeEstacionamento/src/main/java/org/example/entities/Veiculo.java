package org.example.entities;
import java.time.LocalDateTime;

public class Veiculo {

    private String placa;
    private String modelo;
    private LocalDateTime horaEntrada;

    public Veiculo(){
    }

    public Veiculo(String placa, String modelo) {
        this.placa = placa;
        this.modelo = modelo;
        this.horaEntrada = LocalDateTime.now();
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }
}
