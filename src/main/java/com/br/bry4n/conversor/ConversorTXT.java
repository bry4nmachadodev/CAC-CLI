package com.br.bry4n.conversor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConversorTXT {

    public static List<String>  coletarTextoParaTXT(Scanner scanner) {
        List<String> linhas = new ArrayList<>();
        String continuar;

        do {
            System.out.println("\u001B[34m" + "BEM VINDO AO CONVERSOR .TXT" + "\u001B[0m");
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

    public static String escreverTXT(List<String> linhas, String nomeArquivo) {
        String areaDeTrabalho = System.getProperty("user.home") + File.separator + "Desktop";

        File pastaCacCli = new File(areaDeTrabalho, "cac-cli");
        if (!pastaCacCli.exists()) {
            pastaCacCli.mkdir();
        }

        File arquivoTXT = new File(pastaCacCli, nomeArquivo + ".txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoTXT))) {
            for (String linha : linhas) {
                writer.write(linha);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "Arquivo salvo em: " + arquivoTXT.getAbsolutePath();
    }

    public static void criarTXTViaMenu(Scanner scanner) {
        List<String> textos = coletarTextoParaTXT(scanner);
        escreverTXT(textos, "texto-convertido");
        System.out.println("Arquivo criado, olhe sua desktop!");
    }
}
