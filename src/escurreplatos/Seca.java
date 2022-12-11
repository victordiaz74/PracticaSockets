package escurreplatos;

public class Seca extends Thread{
	//Consumidor
	
	EscurrePlatos escurridor;
	
	public Seca(EscurrePlatos escurridor) {
		this.escurridor = escurridor;
	
	}
	
	public void run() {
		int numPlatosSecados = 0;
		while(true) {
			numPlatosSecados = escurridor.sacar();
			System.out.println("Se seca el plato " + numPlatosSecados);
			
			try {
                sleep((int) (Math.random() * 3000));
            } catch (InterruptedException e) { 
            	System.err.println("adios");
            }
			
			
		}
	}

}
