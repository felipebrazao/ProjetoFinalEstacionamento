package org.example.entities;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Estacionamento {
    private ArrayList<Veiculo> veiculos = new ArrayList<>();
    private static final double TARIFA_POR_HORA = 10.0;

    public List<Veiculo> getVeiculos() {
        return new ArrayList<>(veiculos);
    }

    public Estacionamento() {
    }

    public void cadastrarVeiculo(String placa, String modelo) {
        if (veiculos.size() < 50) {
            veiculos.add(new Veiculo(placa, modelo));
            System.out.println("Veículo cadastrado com sucesso!");
        } else {
            System.out.println("Estacionamento cheio!");
        }
    }

    public void registrarSaida(String placa) {
        Veiculo veiculo = buscarVeiculo(placa);
        if (veiculo != null) {
            LocalDateTime agora = LocalDateTime.now();
            Duration duracao = Duration.between(veiculo.getHoraEntrada(), agora);
            long horas = duracao.toHours();
            double valorCobrado = (horas + 1) * TARIFA_POR_HORA;
            veiculos.remove(veiculo);
            System.out.println("Veículo saiu. Tempo de permanência: " + horas + " horas. Valor cobrado: R$ " + valorCobrado);
        } else {
            System.out.println("Veículo não encontrado!");
        }
    }


    public void listarVeiculosEstacionados() {
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo estacionado.");
        } else {
            for (Veiculo veiculo : veiculos) {
                System.out.println("Placa: " + veiculo.getPlaca() + ", Modelo: " + veiculo.getModelo() + ", Entrada: " + veiculo.getHoraEntrada());
            }
        }
    }

    public Veiculo buscarVeiculo(String placa) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo;
            }
        }
        return null;
    }
}
