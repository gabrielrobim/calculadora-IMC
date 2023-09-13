package app;

import entidade.DadosUsuario;
import entidade.Metodos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<DadosUsuario> list = new ArrayList<>();
        Metodos met = new Metodos();

        while (true) {
            System.out.print("Digite o nome do usuário ou 'sair' para encerrar programa: ");
            String nome = sc.nextLine();

            if (nome.equalsIgnoreCase("sair")) {
                break;
            }

            System.out.print("Digite o peso do usuário: ");
            double peso = sc.nextDouble();
            sc.nextLine();

            System.out.print("Digite a altura do usuário: ");
            double altura = sc.nextDouble();
            sc.nextLine();
            double resultado = met.calc(peso, altura);
            String classificacao = met.classificarIMC(resultado);

            DadosUsuario usuario = new DadosUsuario(nome, altura, peso);
            System.out.println("Nome: " + usuario.getNome() + "\nAltura: " + usuario.getAltura() +
                    "\nPeso: " + usuario.getPeso() + "\nIMC: " + resultado + "\nClassificação IMC: " + classificacao);
            list.add(usuario);
        }
        System.out.println("Testes realizados: " + list.size());

        int abaixoDoPeso = 0;
        int totalSaudaveis = 0;
        int totalObesos = 0;

        for (DadosUsuario usuario : list) {
            double resultado = met.calc(usuario.getPeso(), usuario.getAltura());
            String classificacao = met.classificarIMC(resultado);

            if (resultado <= 18.5) {
                abaixoDoPeso++;
            } else if (resultado < 24.9) {
                totalSaudaveis++;
            } else {
                totalObesos++;
            }
        }
        int totalTestesRealizados = list.size();
        double percentualAbaixo = (double) abaixoDoPeso / totalTestesRealizados * 100;
        double percentualSaudaveis = (double) totalSaudaveis / totalTestesRealizados * 100;
        double percentualObesos = (double) totalObesos / totalTestesRealizados * 100;
        System.out.println("Abaixo do peso: " + abaixoDoPeso + "(" + percentualAbaixo + "%" +")");
        System.out.println("Saudaveis: " + totalSaudaveis + "(" + percentualSaudaveis + "%" +")");
        System.out.println("Obesos: " + totalObesos + "(" + percentualObesos + "%" +")");
    }
}