package com.br.bry4n;

import com.opencsv.CSVWriter;
import com.opencsv.CSVWriterBuilder;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Path;
import java.util.List;

public class OpenCSV {
    public String escreverCSV(List<String[]> frases, String nomeArquivo) {
        String areaDeTrabalho = System.getProperty("user.home") + File.separator + "Desktop";

        File pastaCacCli = new File(areaDeTrabalho, "cac-cli");
        if (!pastaCacCli.exists()) {
            pastaCacCli.mkdir();
        }

        File arquivoCSV = new File(pastaCacCli, nomeArquivo + ".csv");
        Path caminhoCompleto = arquivoCSV.toPath();

        // 2. Usar CSVWriter para escrever cada String[] da lista

        try (CSVWriter writer = new CSVWriter(new FileWriter(path.toString()))) {
            writer.writeAll(frases);
        }

        return "Ok";
    }
}
