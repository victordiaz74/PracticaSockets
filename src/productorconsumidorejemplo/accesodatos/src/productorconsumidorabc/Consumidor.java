package productorconsumidorabc;

public class Consumidor extends Thread {
	
	private Buffer b;

	public Consumidor(Buffer buffer) {
		this.b = buffer;
		
	}
	
	public void run() {
		while(true) {
			char c = b.consume();
			System.out.println("Consume la letra: " + c);
			
			try {
                sleep((int) (Math.random() * 3000));
            } catch (InterruptedException e) { 
            	System.err.println("adios");
            }
		}
	}

}
