package escurreplatos;

public class Lava extends Thread{
	//Productor
	
	EscurrePlatos escurridor;
	
	public Lava(EscurrePlatos escurridor) {
		this.escurridor = escurridor;
	
	}
	
	public void run() {
		int numPlatos = 1;
		while(true) {
			
			escurridor.meter(numPlatos);
			System.out.println("Se lava el plato " + numPlatos);
			numPlatos++;
			//escurridor.notify();
			
			
			try {
                sleep((int) (Math.random() * 3000));
            } catch (InterruptedException e) { 
            	System.err.println("adios");
            }
		}
		
	}

}
