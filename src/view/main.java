package view;

import java.util.concurrent.Semaphore;

import controller.SaquesDepositos;

public class main {
public static void main(String[] args) {
		
		int permissoes = 1;
		Semaphore semaforo1 = new Semaphore(permissoes);
		Semaphore semaforo2= new Semaphore(permissoes);
		for (int i = 1; i <= 20; i++) {
			
		Thread t = new SaquesDepositos (semaforo1, semaforo2);
		 t.start();
	}

}
}
