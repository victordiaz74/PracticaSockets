package practica3;

import EjemploProductoresConsumidores.Cola;

public class Consumidor extends Thread{
	
	private Tuberia tuberia;
	private int n;
	
	public Consumidor(Tuberia tub, int n) {
		tuberia = tub;
	    this.n = n;
	}

    public void run() {
    	for(int i=0; i< 10; i++) {
            // Consume el valor si es posible
            char valor = tuberia.recoger();
            System.out.println("La letra recogida es: " + valor);
            try {
                
                sleep((int) (Math.random() * 2000));
            } catch (InterruptedException e) { }
        }
    }

}
