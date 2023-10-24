package application;

import entities.Worker;

import java.util.Locale;

import static application.Util.*;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        // Segue dicas para melhor leitura do código !!!
        // Oque tiver sem \\ ao final são sugestões sobre oque escrever para testar o progama
        // Comentários que iniciarem com // e acabarem com \\ são descricões sobre os métodos a seguir

        // Lembrando que claro voce pode digitar oque quiser, desde que atenda os
        // requisitos do programa, oque há em comentários são apenas conselhos \\


        // Método que pede informacões sobre um usuário e o cria em Worker \\
        System.out.println("========================");
        System.out.println("Método userInfo");
        System.out.println("========================");
        Worker cnpjoto = userInfo();
        // Departament: Design
        // Name: Alex
        // Level: mid_level
        // BaseSalary: 1200.00
        System.out.println("========================");


        System.out.println("Método contractsInfo");
        System.out.println("========================");
        contractsInfo(cnpjoto);
        // Contracts to add: 3
        // Contract 1:
        // Date: 20/08/2018
        // Value Per Hour: 50.00
        // Duration: 20
        // Contract 2:
        // Date: 13/06/2018
        // Value Per Hour: 30.00
        // Duration: 18
        // Contract 3:
        // Date: 25/08/2018
        // Value Per Hour: 80.00
        // Duration: 10
        System.out.println("========================");

        System.out.println("Método calcByThe");
        System.out.println("========================");
        calcByThe(cnpjoto);
        // Enter monthh and year: 08/2018
        System.out.println("========================");


    }
}