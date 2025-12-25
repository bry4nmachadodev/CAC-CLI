package com.br.bry4n;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //declarações
        Menu menu = new Menu();
        GroqRequestIdioma groqAPI = new GroqRequestIdioma();
        ConversorCSV conversorCSV = new ConversorCSV();
        ConversorTXT conversorTXT = new ConversorTXT();
        Scanner scanner = new Scanner(System.in);

        String username = System.getProperty("user.name");
        int opcao;
        do {
            menu.exibirMenu(username);
            opcao = menu.capturarOpcao(scanner);

            switch (opcao) {
                case 1:
                    scanner.nextLine(); // limpar buffer
                    ConversorTXT.criarTXTViaMenu(scanner);
                    break;
                case 2:
                    scanner.nextLine(); // limpar buffer
                    ConversorCSV.criarCSVViaMenu(scanner);
                    break;
                case 3:
                    scanner.nextLine(); // limpar buffer
                    ConversorCSV.gerarDeckComIA(scanner, groqAPI);
                    break;
                case 4:
                    System.out.println("\nEncerrando programa... Até logo!\n");
                    break;
            }
        } while (opcao != 4);
        scanner.close();
    }
}
