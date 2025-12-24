package com.br.bry4n;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //declarações
        Menu menu = new Menu();
        OpenCSV openCSV = new OpenCSV();
        Scanner scanner = new Scanner(System.in);
        String username = System.getProperty("user.name");

        int opcao;
        do {
            menu.exibirMenu(username);
            opcao = menu.capturarOpcao(scanner);

            switch (opcao) {
                case 1:
                    scanner.nextLine();
                    List<String> textos = coletarTextoParaTXT(scanner);
                    openCSV.escreverTXT(textos, "texto-convertido");
                    System.out.println("Arquivo criado, olhe sua desktop!");
                    break;
                case 2:
                    //limpar o buffer
                    scanner.nextLine();
                    List<String[]> frasesOrganizadas = coletarFrasesParaCSV(scanner);
                    openCSV.escreverCSV(frasesOrganizadas, "deck-convertido");
                    System.out.println("Arquivo criado, olhe sua desktop!\n\n");
                    break;
                case 3:
                    break;
            }
        } while (opcao != 3);
        scanner.close();
    }

    //declaração de métodos

    //método1
    public static List<String> coletarTextoParaTXT(Scanner scanner){
        List<String> linhas = new ArrayList<>();
        String continuar;

        do {
            System.out.println("\u001B[34m"+ "BEM VINDO AO CONVERSOR .TXT" + "\u001B[0m");
            System.out.println("\n=== Escreva seu texto ===");
            System.out.print("Digite o texto: ");
            String texto = scanner.nextLine().trim();

            if (!texto.isEmpty()) {
                linhas.add(texto);
                System.out.println("Texto adicionado com sucesso!");
            } else {
                System.out.println("O texto não pode estar vazio!");
            }

            do {
                System.out.print("\nDeseja adicionar mais texto? (s/n): ");
                continuar = scanner.nextLine().trim().toLowerCase();
            } while (!continuar.equals("s") && !continuar.equals("n"));

        } while (continuar.equals("s"));

        return linhas;
    }

    //método2
    public static List<String[]> coletarFrasesParaCSV(Scanner scanner){
        List<String[]> listaDeFrases = new ArrayList<>();
        String continuar;

        do {
            System.out.println("\u001B[31m"+ "BEM VINDO AO CONVERSOR .CSV" + "\u001B[0m");
            System.out.println("\n=== Nova Frase ===");
            System.out.print("Digite a FRENTE da frase: ");
            String frente = scanner.nextLine().trim();

            System.out.print("Digite o VERSO da frase: ");
            String verso = scanner.nextLine().trim();

            if (!frente.isEmpty() && !verso.isEmpty()) {
                listaDeFrases.add(new String[]{frente, verso});
                System.out.println("Frase adicionada com sucesso!");
            } else {
                System.out.println("Frente e verso não podem estar vazios!");
            }

            do {
                System.out.print("\nDeseja adicionar outra frase? (s/n): ");
                continuar = scanner.nextLine().trim().toLowerCase();
            } while (!continuar.equals("s") && !continuar.equals("n"));

        } while (continuar.equals("s"));

        return listaDeFrases;
    }
}
