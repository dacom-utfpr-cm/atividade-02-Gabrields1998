package exercicio3;

import java.util.*;

/**
 * PrimeNumbers
 * Autor: Gabriel David Sacca
 * Descricao: Classe que cria Threads para calcular numeros primos de 0 a 100000
 */

class PrimeNumbersThread extends Thread {
    Integer PosicaoIni;
    Integer PosicaoFim;

    PrimeNumbersThread(Integer posicaoIni, Integer posicaoFim) {
        this.PosicaoIni = posicaoIni;
        this.PosicaoFim = posicaoFim;
    }

    @Override
    public void run() {
        List<Integer> numeros = new ArrayList<Integer>();

        for(int i = this.PosicaoIni; i <= this.PosicaoFim; i++){
            numeros.add(i);
        }
        int contador;
		int numero = 0;
        for (Integer i : numeros) {
            contador = 0;
            for (int u = 1; u <= i; u++) {
                if (i % u == 0) {
                    contador++;
                    numero = u;
                }
            }
            
            if (contador == 2) {
                System.out.println("O Número: " + numero + " é primo.");  
            }
        }
    }
}

public class PrimeNumbers {

    public static void main(final String[] args) {
        for(int i = 0; i <= 100000; i+= 10){
            new PrimeNumbersThread(i, i+10).start();
        }
    }
}