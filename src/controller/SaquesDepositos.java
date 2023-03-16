package controller;
import java.util.concurrent.Semaphore;

public class SaquesDepositos extends Thread {
	
		private Semaphore semaforo1;
		private Semaphore semaforo2;
		int codigo;
		double saldo;
		double valor;

		public SaquesDepositos(Semaphore semaforo1, Semaphore semaforo2) {
			
			this.semaforo1 = semaforo1 ;
		    this.semaforo2 = semaforo2 ;
			
		}

		@Override
		public void run() {
			
			 // seção critica
			 try {
				 
				     semaforo1.acquire();
					 saque();
					 semaforo2.acquire();
					 deposito();
			  
			 }catch (Exception e) {
				 e.printStackTrace();
			 }finally {
				 semaforo1.release();
				 semaforo2.release();
				//fim da seção critica
			 } 
			 
	}



			private void deposito() {
				codigo = (int) (Math.random()*1001);
				 saldo =  (Math.random()*1001);
				 valor =  (Math.random()*1001);
				
				System.out.println(" Codigo da conta = "+ codigo);
				System.out.printf(" Saldo da conta =%.2f",saldo);
				System.out.println("                                ");
				System.out.printf(" Valor a ser transacionado =%.2f",valor);
				System.out.println("                                ");
				 System.out.printf(" Valor depositado =%.2f",valor);
				 System.out.println("                                ");
				 System.out.println("--------------------------");
		}

			private void saque() {
				codigo = (int) (Math.random()*5001);
				 saldo = (int) (Math.random()*2001);
				 valor = (int) (Math.random()*2001);
				
				System.out.println(" Codigo da conta = "+ codigo);
				System.out.printf(" Saldo da conta =%.2f",saldo);
			    System.out.println("                                ");
				System.out.printf(" Valor a ser transacionado =%.2f",valor);
				System.out.println("                                ");
					 System.out.printf(" Valor sacado =%.2f",valor);
					 System.out.println("                                ");
					 System.out.println("--------------------------");
		}		
}
