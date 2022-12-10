package practica3;

public class Productor extends Thread{

	private Tuberia tuberia;
	private String abecedario = "ABCDEFGHIJKLMNÑOPQRSTUVWYZ";
	
	public Productor(Tuberia tub, String abc) {
		tuberia = tub;
		this.abecedario = abc;
	}
	
	public void run() {
		for(int i=0; i< 10; i++) {
	            // Obtenemos una letra al azar
	            char c = abecedario.charAt((int) (Math.random() * abecedario.length()));
	            // Ponemos un valor en la tuberia
	            tuberia.poner(c);
	            System.out.println("soy el PRODUCTOR " + c);
	            try {
	                
	                sleep((int) (Math.random() * 2000));
	            } catch (InterruptedException e) { }
	     }
    }
}
