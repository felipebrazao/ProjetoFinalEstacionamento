package org.example.app;
import org.example.entities.Estacionamento;
import org.example.entities.ExportJson;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Estacionamento estac = new Estacionamento();
        Scanner sc = new Scanner(System.in);

        System.out.println("Bem-vindo ao Sistema de Estacionamento!");
        System.out.print("Escolha uma opção: \n"
                + "1. Cadastrar Veículo\n"
                + "2. Registrar Saída de Veículo\n"
                + "3. Listar Veículos Estacionados\n"
                + "4. Exportar Veículos para JSON\n"
                + "5. Sair\n");

        int opcao = sc.nextInt();
        sc.nextLine();

        while (opcao != 5) {
            if (opcao == 1) {
                System.out.print("Digite a placa do veículo: ");
                String placa = sc.nextLine();
                System.out.print("Digite o modelo do veículo: ");
                String modelo = sc.nextLine();
                estac.cadastrarVeiculo(placa, modelo);

            } else if (opcao == 2) {
                System.out.print("Digite a placa do veículo para registrar saída: ");
                String placaSaida = sc.nextLine();
                estac.registrarSaida(placaSaida);

            } else if (opcao == 3) {
                estac.listarVeiculosEstacionados();

            } else if (opcao == 4) {

                ExportJson.exportarParaJSON(estac.getVeiculos());

            } else {
                System.out.println("Opção inválida!");
            }

            System.out.print("\nEscolha uma nova opção: \n"
                    + "1. Cadastrar Veículo\n"
                    + "2. Registrar Saída de Veículo\n"
                    + "3. Listar Veículos Estacionados\n"
                    + "4. Exportar Veículos para JSON\n"
                    + "5. Sair\n");

            opcao = sc.nextInt();
            sc.nextLine();
        }

        System.out.println("Saindo do sistema...");
        sc.close();
    }
}
