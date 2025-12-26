package com.br.bry4n.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GroqConversaoHtml {

    public List<String[]> requestAoGroq(List<String[]> deckSemCor) {

        StringBuilder promptBuilder = new StringBuilder();

        promptBuilder.append("""
        Você receberá pares de frases separadas por ponto e vírgula (;).
        NÃO explique nada.
        NÃO adicione texto extra.
        Gere UMA linha por par.

        REGRAS:
        - Ambas as frases DEVEM estar totalmente envolvidas por HTML <span>
        - A palavra no idioma estrangeiro e seu significado em português DEVEM ter a MESMA cor
        - NÃO use vírgula (,)
        - Use APENAS ponto e vírgula (;) para separar os idiomas
        - NÃO use aspas
        - Mantenha pontuação fora dos spans

        EXEMPLO DE SAÍDA:
        <span style='color:red'>Как</span> <span style='color:blue'>дела́</span>?;<span style='color:red'>Como</span> <span style='color:blue'>vai</span>?

        FRASES:
        """);

        for (String[] linha : deckSemCor) {
            promptBuilder.append(linha[0])
                    .append(";")
                    .append(linha[1])
                    .append("\n");
        }

        String resposta;
        try {
            resposta = GroqAPI.chamarGroq(promptBuilder.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<String[]> deckComCor = new ArrayList<>();

        for (String linha : resposta.split("\n")) {
            linha = linha.trim();

            // ignora lixo
            if (linha.isEmpty()) continue;
            if (!linha.contains(";")) continue;

            String[] partes = linha.split(";", 2);

            // garante 2 colunas
            if (partes.length != 2) continue;

            deckComCor.add(new String[] {
                    partes[0].trim(),
                    partes[1].trim()
            });
        }

        return deckComCor;
    }
}
