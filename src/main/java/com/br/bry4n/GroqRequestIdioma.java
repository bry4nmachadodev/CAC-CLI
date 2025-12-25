package com.br.bry4n;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GroqRequestIdioma {

    public List<String[]> requestAoGroq(String idioma, String nivel, String numeroFrases){
        String prompt = "Me de " + numeroFrases + " frases pra adicionar no anki do nível " + nivel + " do idioma: " + idioma + " . Me de somente as frases, não precisa cumprimentar nem nada." + " Juntamente as frases colocque a tradução dela pra eu adicionar no verso no anki. Exemplo: palavranoidioma;tradução";
        String resposta = null;
        try {
            resposta = GroqAPI.chamarGroq(prompt);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<String[]> deck = new ArrayList<>();
        for (String linha : resposta.split("\n")) {
            deck.add(linha.split(";")); // cada linha vira [frente, verso]
        }

        return deck;
    }

}
// Me de 2 frass pra adicionar no anki do nível A1 do idioma: russo . Me de somente [...]