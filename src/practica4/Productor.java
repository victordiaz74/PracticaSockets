package practica4;

import java.util.Random;

public class Productor extends Thread{

	private Tuberia tuberia;
	
	public Productor(Tuberia tub) {
		tuberia = tub;
	}
	
	public void run() {
		for(int i=0; i< 10; i++) {
            // Obtenemos una letra al azar
			Random random = new Random();
            char c = (char) (random.nextInt(26) + 'a');
            tuberia.poner(c);
            System.out.println("soy el PRODUCTOR " + c);
            try {
                sleep((int) (Math.random() * 2000));
            } catch (InterruptedException e) { 
            	System.err.println("adios");
            }
	     }
    }
}
