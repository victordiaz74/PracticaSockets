package practica4;

public class TestTuberia {
	
	public static void main(String[] args) {  
		
	    Tuberia tuberia = new Tuberia(6);
		
	    Productor p = new Productor(tuberia);	
		Consumidor c = new Consumidor(tuberia);
		
	    p.start();
		c.start();

	  }//Main
}
