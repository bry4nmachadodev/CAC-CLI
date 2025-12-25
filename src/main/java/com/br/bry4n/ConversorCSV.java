package com.br.bry4n;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConversorCSV {
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

    public String escreverCSV(List<String[]> frases, String nomeArquivo) {
        String areaDeTrabalho = System.getProperty("user.home") + File.separator + "Desktop";

        File pastaCacCli = new File(areaDeTrabalho, "cac-cli");
        if (!pastaCacCli.exists()) {
            pastaCacCli.mkdir();
        }

        File arquivoCSV = new File(pastaCacCli, nomeArquivo + ".csv");

        try (CSVWriter writer = new CSVWriter(new FileWriter(arquivoCSV))) {
            writer.writeAll(frases);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "Arquivo salvo em: " + arquivoCSV.getAbsolutePath();
    }

    public List<String[]> coletarFrasesLivre(Scanner scanner) {
        List<String[]> listaDeFrases = new ArrayList<>();

        System.out.println("\u001B[31m" + "BEM VINDO AO CONVERSOR .CSV - MODO LIVRE" + "\u001B[0m");
        System.out.println("\nCole suas frases separadas por ponto e vírgula (;)");
        System.out.println("Exemplo: Frente1;Verso1;Frente2;Verso2;Frente3;Verso3");
        System.out.println("\nDigite o texto:");

        String input = scanner.nextLine();
        String[] partes = input.split(";");

        if (partes.length % 2 != 0) {
            System.out.println("⚠ Atenção: Número ímpar de elementos! Última frase sem verso será ignorada.");
        }

        for (int i = 0; i < partes.length - 1; i += 2) {
            String frente = partes[i].trim();
            String verso = partes[i + 1].trim();

            if (!frente.isEmpty() && !verso.isEmpty()) {
                listaDeFrases.add(new String[]{frente, verso});
            }
        }

        System.out.println("✓ " + listaDeFrases.size() + " frases adicionadas com sucesso!");

        return listaDeFrases;
    }

}
