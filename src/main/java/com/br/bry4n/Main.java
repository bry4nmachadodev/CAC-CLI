package com.br.bry4n;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //declarações
        Menu menu = new Menu();
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
                    scanner.nextLine();
                    List<String> textos = conversorTXT.coletarTextoParaTXT(scanner);  // ← chama do conversorTXT
                    conversorTXT.escreverTXT(textos, "texto-convertido");  // ← também aqui
                    System.out.println("Arquivo criado, olhe sua desktop!");
                    break;
                case 2:
                    scanner.nextLine();
                    List<String[]> frasesOrganizadas = conversorCSV.coletarFrasesParaCSV(scanner);  // ← chama do conversorCSV
                    conversorCSV.escreverCSV(frasesOrganizadas, "deck-convertido");
                    System.out.println("Arquivo criado, olhe sua desktop!\n\n");
                    break;
                case 3:
                    break;
            }
        } while (opcao != 3);
        scanner.close();
    }
}
