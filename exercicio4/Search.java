package exercicio4;

import java.util.Scanner;

/**
 * Search
 * Autor: Gabriel David Sacca
 * Descricao: Classe java para encontrar um numero inteiro e sua posicao em um array.
 */

class SearchThread extends Thread {
    Integer[] vetor;
    Integer ini;
    Integer end;
    Integer val;

    SearchThread(Integer[] vetor, Integer ini, Integer end, Integer val) {
        this.vetor = vetor;
        this.ini = ini;
        this.end = end;
        this.val = val;
    }

    @Override
    public void run() {
        for (int i = this.ini; i <= this.end; i++) {
            if(this.vetor[i] == this.val){
                System.out.println("valor " + this.val + " encontrado na posicao " + i + " pela Thread" + Thread.currentThread().getName());
            }
        }
    }
}

public class Search {

    public static void main(final String[] args) {
        Integer[] vetor = {0, 2, 3, 4, 5, 6, 1, 2, 5, 3, 10, 11, 20, 30, 2, 10, 60, 21, 25};
        
        Scanner scanner = new Scanner(System.in); 

        System.out.println("informe o valor procurado: ");
        Integer value = scanner.nextInt();
        System.out.println("informe o numero de Threads: ");
        Integer numThreads = scanner.nextInt();

        scanner.close();

        Integer tamVet = vetor.length;
        Integer vetDivide = tamVet / numThreads;
        Integer vetRes = tamVet % numThreads;
        Integer ini = 0;
        Integer end = vetDivide;

        for (int i = 0; i < numThreads; i++) {
            new SearchThread(vetor, ini, end, value).start();
            ini = end + 1;
            if(end + vetDivide == tamVet - vetRes){
                end += vetDivide + vetRes - 1;
            } else {
                end += vetDivide;
            }
        }
    }
}