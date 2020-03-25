package exercicio1;

import java.io.*;

/**
 * ConsultState
 * Autor: Gabriel David Sacca
 * Descricao: Classe java que possui algumas Threads de teste que ficam apenas
 * imprimindo que estao vivas, e uma Thread que fica consultando seus estados.
 */

class ListThreads extends Thread {
    BufferedReader buffRead;

    ListThreads() {

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10000);
                for (int i = 0; i < 100000; i++) {
                }
                System.out.println("Thread: " + Thread.currentThread().getName() + " alive yet...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class StateConsultingThread extends Thread {
    ListThreads[] Threads = new ListThreads[10];

    StateConsultingThread(final ListThreads[] Thread) {
        this.Threads = Thread;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                for(int i = 0; i < 10; i++){
                    System.out.println("observer the Thread: " + this.Threads[i].getName() + " is on state " + this.Threads[i].getState());
                }
                System.out.println("");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
     
}

public class ConsultState {

    public static void main(final String[] args) {
        final ListThreads[] t1 = new ListThreads[10];
        for (int i = 0; i < 10; i++) {
            t1[i] = new ListThreads();
            t1[i].start();
        }
        final StateConsultingThread consulting = new StateConsultingThread(t1);
        consulting.start();
    }
}