package com.br.bry4n;

import com.opencsv.CSVWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OpenCSV {
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

    public String escreverTextoTXT(List<String[]> frases, String nomeArquivo){
        String areaDeTrabalho = System.getProperty("user.home") + File.separator + "Desktop";

        File pastaCacCli = new File(areaDeTrabalho, "cac-cli");
        if (!pastaCacCli.exists()) {
            pastaCacCli.mkdir();
        }

        File arquivoTXT = new File(pastaCacCli, nomeArquivo + ".txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoTXT))) {
            for (String[] frase : frases) {
                writer.write("Frente: " + frase[0]);
                writer.newLine();
                writer.write("Verso: " + frase[1]);
                writer.newLine();
                writer.write("---");
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "Arquivo salvo em: " + arquivoTXT.getAbsolutePath();
    }
}
