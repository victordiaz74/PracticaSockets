package productorconsumidorabc;

public class Productor extends Thread{

	Buffer b;
	String abecedario = "abcdefghijklmnopqrstuvxyz";
	
	public Productor(Buffer buffer) {
		
		this.b = buffer;
	
	}
	
	public void run() {
		
		while(true) {
			char c = abecedario.charAt((int) (Math.random() * abecedario.length()));
			b.produce(c);
			System.out.println("Producida la letra: " + c);
			
		
			try {
                sleep((int) (Math.random() * 3000));
            } catch (InterruptedException e) { 
            	System.err.println("adios");
            }
		
		}
		
		
		
	}

}
