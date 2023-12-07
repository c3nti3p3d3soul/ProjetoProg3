package Modelos;

import java.util.Random;

public class Rastreamento {
    private static String[] cidades = {"São Paulo", "Rio De Janeiro", "Brasilia", "Salvador", "Palmas"};
    
    public static String obterNomeCidade(String abreviacao) {
        for (String cidade : cidades) {
            if (cidade.startsWith(cidade)) {
                return cidade;
            }
        }
        return null; // Retornar null se a abreviação não for encontrada
    }
    

    public static String[] gerarInformacoesRastreamento(String codigoRastreio) {
        // Simula a obtenção da cidade atual e do destino com base no código de rastreio
        String cidadeAtual = codigoRastreio.substring(0, 3).toUpperCase();
        String destino = codigoRastreio.substring(3, 6).toUpperCase();

        return new String[]{codigoRastreio, cidadeAtual, destino};
    }

    public static String gerarCodigoRastreamento() {
        Random random = new Random();
        StringBuilder codigo = new StringBuilder();
        
        // Seleciona uma cidade aleatória
        String cidade = cidades[random.nextInt(cidades.length)];
        codigo.append(cidade.substring(0, 3).toUpperCase());
        
        // Adiciona letras baseadas na cidade selecionada
        for (int i = 0; i < 3; i++) {
            char letra = cidade.charAt(random.nextInt(cidade.length()));
            codigo.append(letra);
        }
        
        // Adiciona um número aleatório ao código
        int numeroAleatorio = 10000 + random.nextInt(90000); // Gera um número aleatório de 10000 a 99999
        codigo.append(numeroAleatorio);
        
        return codigo.toString();
    }
}
