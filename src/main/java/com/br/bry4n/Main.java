package com.br.bry4n;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //declarações
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
    }
}
