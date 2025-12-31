package com.br.bry4n.main;

import com.br.bry4n.api.GroqConversaoHtml;
import com.br.bry4n.api.GroqRequestIdioma;
import com.br.bry4n.conversor.ConversorCSV;
import com.br.bry4n.conversor.ConversorTXT;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //declarações
        Menu menu = new Menu();
        GroqRequestIdioma groqAPI = new GroqRequestIdioma();
        GroqConversaoHtml groqConversaoHtml = new GroqConversaoHtml();
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
                    scanner.nextLine(); //limpar buffer
                    ConversorCSV.criarCSVViaMenuComHtml(scanner, groqConversaoHtml);
                    break;
                case 5:
                    System.out.println("\nEncerrando programa... Até logo!\n");
                    break;
            }
        } while (opcao != 5);
        scanner.close();
    }
}
