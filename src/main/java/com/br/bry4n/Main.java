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
                    scanner.nextLine();
                    System.out.println("\n=== Conversor CSV ===");
                    System.out.println("1 - Modo Guiado (pergunta frente e verso)");
                    System.out.println("2 - Modo Livre (colar tudo separado por ;)");
                    System.out.print("Escolha o modo: ");
                    int modoCSV = scanner.nextInt();
                    scanner.nextLine(); // limpar buffer

                    List<String[]> frasesOrganizadas;

                    if (modoCSV == 1) {
                        frasesOrganizadas = conversorCSV.coletarFrasesParaCSV(scanner);
                    } else if (modoCSV == 2) {
                        frasesOrganizadas = conversorCSV.coletarFrasesLivre(scanner);
                    } else {
                        System.out.println("Opção inválida!");
                        break;
                    }

                    conversorCSV.escreverCSV(frasesOrganizadas, "deck-convertido");
                    System.out.println("Arquivo criado, olhe sua desktop!\n\n");
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
