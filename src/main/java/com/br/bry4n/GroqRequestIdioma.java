package com.br.bry4n;

import java.io.IOException;

public class GroqRequestIdioma {

    public String requestAoGroq(String idioma, String nivel, String numeroFrases){
        String prompt = "Monte pra mim um deck com " + numeroFrases + " estilo chunks com as palavras mais necessárias e utéis baseadas no nível " + nivel + "do idioma: " + idioma;
        String resposta = null;
        try {
            resposta = GroqAPI.chamarGroq(prompt);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(resposta);
        return resposta;
    }

}
