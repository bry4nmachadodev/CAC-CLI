package com.br.bry4n.conversor;

import junit.framework.TestCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestesCAC extends TestCase {

    private static String desktopPath;
    private static File pastaCacCli;

    @Test
    void deveEscreverCSVCorretamente() {
        List<String[]> frases = new ArrayList<>();
        frases.add(new String[]{"Capital do Brasil", "Brasília"});
        frases.add(new String[]{"Maior país", "Rússia"});

        String resultado = ConversorCSV.escreverCSV(frases, "teste");

        assertTrue(resultado.contains("teste.csv"));
        assertTrue(new File(resultado.split(": ")[1]).exists());
    }

    @Test
    @DisplayName("Deve retornar caminho completo do arquivo")
    void deveRetornarCaminhoCompleto() {
        // Arrange
        List<String> linhas = Arrays.asList("Teste");

        // Act
        String resultado = ConversorTXT.escreverTXT(linhas, "teste-caminho");

        // Assert
        assertTrue(resultado.startsWith("Arquivo salvo em:"));
        assertTrue(resultado.contains("Desktop"));
        assertTrue(resultado.contains("cac-cli"));
        assertTrue(resultado.endsWith("teste-caminho.txt"));
    }

}