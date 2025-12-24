package com.br.bry4n;

import jdk.internal.joptsimple.internal.Strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //declarações
        OpenCSV openCSV = new OpenCSV();
        Scanner scanner = new Scanner(System.in);
        String username = System.getProperty("user.name");
        System.out.println(username);

        System.out.print(" -- Seja bem vindo " + username + " --\n");
        System.out.print("| ----------------------------- |\n");
        System.out.print("| Opção 1 - Converter para .txt |\n");
        System.out.print("| Opção 2 - Converter para .csv |\n");
        System.out.print("| Opção 3 - Sair                |\n");
        System.out.print("| ----------------------------- |\n");

        System.out.print("Digite uma opção: ");
        int opcao = scanner.nextInt();

        switch (opcao){
            case 1:
                break;
            case 2:
                //limpar o buffer
                scanner.nextLine();
                List<String []> frasesOrganizadas = coletarFrasesParaCSV(scanner);
                openCSV.escreverCSV(frasesOrganizadas,"deck-convertido");
                break;
            case 3:
                break;
        }
    }

    //declaração de método
    public static List<String[]> coletarFrasesParaCSV(Scanner scanner){
        System.out.println("\u001B[31m"+ "CONVERSOR .CSV" + "\u001B[0m");

        List<String[]> listaDeFrases = new ArrayList<>();
        String continuar;

        do {
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
