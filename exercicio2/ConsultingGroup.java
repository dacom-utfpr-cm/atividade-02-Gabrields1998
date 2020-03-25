package exercicio2;

import java.io.*;

/**
 * ConsultingGroup
 * Autor: Gabriel David Sacca
 * Descricao: Esta classe fica testando o grupo que foi criado para saber
 * o nome do grupo, quantas Threads ha nele e qual o valor de prioridade maximo 
 * deste grupo.
 */

class ThreadTest extends Thread {
    BufferedReader buffRead;

    ThreadTest(ThreadGroup group, String name){
        super(group, name);
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Thread: " + Thread.currentThread().getName() + " alive yet...");

                Thread.sleep(50000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class ConsultingGroupThread extends Thread {
    ThreadGroup Group;

    ConsultingGroupThread(ThreadGroup group) {
        this.Group = group;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Group: " + this.Group.getName());
                System.out.println("Are still " + this.Group.activeCount() + " alives");
                System.out.println("with this max priority: " + this.Group.getMaxPriority());

                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ConsultingGroup {

    public static void main(final String[] args) {
        final ThreadGroup group = new ThreadGroup("GroupThreads");
        for (int i = 0; i < 10; i++) {
            new ThreadTest(group , "Thread" + i).start();
        }
        new ConsultingGroupThread(group).start();
        // final StateConsultingThread consulting = new StateConsultingThread(t1);
        // consulting.start();
    }
}