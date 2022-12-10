package practica3;

public class TestTuberia {
	public static void main(String[] args) {  
	    Tuberia tuberia = new Tuberia();
		
	    Productor p = new Productor(tuberia, "");	
		Consumidor c = new Consumidor(tuberia, 1);
		
	    p.start();
		c.start();

	  }//Main
}
