package com.br.bry4n;

import java.util.Scanner;

public class Menu {

    public void exibirMenu(String username) {
        System.out.print(" -- Seja bem vindo " + username + " --\n");
        System.out.print("| ----------------------------- |\n");
        System.out.print("| Opção 1 - Converter para .txt |\n");
        System.out.print("| Opção 2 - Converter para .csv |\n");
        System.out.print("| Opção 3 - Sair                |\n");
        System.out.print("| ----------------------------- |\n");
    }

    public int capturarOpcao(Scanner scanner) {
        System.out.print("Digite uma opção: ");
        return scanner.nextInt();
    }
}
