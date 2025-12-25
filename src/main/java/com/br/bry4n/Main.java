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
                    List<String> textos = conversorTXT.coletarTextoParaTXT(scanner);  // ← chama do conversorTXT
                    conversorTXT.escreverTXT(textos, "texto-convertido");  // ← também aqui
                    System.out.println("Arquivo criado, olhe sua desktop!");
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
                    scanner.nextLine(); //limpar buffer
                    System.out.println("\n=== Bem-Vindo a IA generativa===");
                    System.out.print("Qual será o idioma do deck gerado? ");
                    String idioma = scanner.nextLine();
                    System.out.print("Qual seu nível no idioma? (A0 - C2) ");
                    String nivel = scanner.nextLine();
                    System.out.print("Quantas frases você quer? ");
                    String numeroFrases = scanner.nextLine();
                    List<String[]> deckMontado = groqAPI.requestAoGroq(idioma, nivel, numeroFrases);
                    conversorCSV.escreverCSV(deckMontado, "deck-anki" + idioma);
                    System.out.println("Arquivo criado, olhe sua desktop!\n\n");
                    break;
                case 4:
                    System.out.println("\nEncerrando programa... Até logo!\n");
                    break;
            }
        } while (opcao != 4);
        scanner.close();
    }
}
