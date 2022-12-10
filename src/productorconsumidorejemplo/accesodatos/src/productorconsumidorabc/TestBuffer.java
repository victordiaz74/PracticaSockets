package productorconsumidorabc;


public class TestBuffer {

	public static void main(String[] args) {

		Buffer buffer = new Buffer(10);
		
	    Productor p = new Productor(buffer);	
		Consumidor c = new Consumidor(buffer);
		
	    p.start();
		c.start();

		
	}

}
